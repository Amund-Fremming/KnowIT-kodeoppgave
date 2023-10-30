package washit.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import washit.backend.AppEnum.ReservationStatus;
import washit.backend.AppEnum.WashingMachineStatus;
import washit.backend.exception.ReservationNotFoundException;
import washit.backend.exception.WaitEntryNotFoundException;
import washit.backend.exception.WashingMacineNotFoundException;
import washit.backend.exception.WashingProgramNotFoundException;
import washit.backend.model.Reservation;
import washit.backend.model.WaitEntry;
import washit.backend.model.WashingMachine;
import washit.backend.model.WashingProgram;
import washit.backend.repository.ReservationRepository;
import washit.backend.repository.WaitEntryRepository;
import washit.backend.repository.WashingMachineRepository;
import washit.backend.repository.WashingProgramRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WasheryService {

    @Autowired
    private WashingMachineRepository machineRepo;

    @Autowired
    private WashingProgramRepository programRepo;

    @Autowired
    private ReservationRepository reservationRepo;

    @Autowired
    private WaitEntryRepository waitRepo;

    public Reservation createReservationForProgram(Integer programId, Integer machineId, String username, LocalDateTime startTime) throws WashingProgramNotFoundException, WashingMacineNotFoundException {
        WashingProgram program = programRepo.findById(programId)
                .orElseThrow(() -> new WashingProgramNotFoundException("Program with id "+programId+" was not found"));

        WashingMachine machine = machineRepo.findById(machineId)
                .orElseThrow(() -> new WashingMacineNotFoundException("Machine with id "+machineId+" was not found"));

        LocalDateTime endTime = startTime.plusMinutes(1);
        if(program.getMinutes() == 90) {
            endTime = startTime.plusMinutes(1).plusSeconds(30);
        } else if(program.getMinutes() == 60) {
            endTime = startTime.plusMinutes(1);
        } else if(program.getMinutes() == 20) {
            endTime = startTime.plusSeconds(20);
        }

        Reservation reservation = new Reservation(machine, username, startTime, endTime);
        machine.getReservations().add(reservation);
        machineRepo.save(machine);

        reservationRepo.save(reservation);
        return reservation;
    }

    public Reservation cancelReservation(Integer reservationid) throws ReservationNotFoundException {
        Reservation reservation = reservationRepo.findById(reservationid)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation with id "+reservationid+" was not found"));

        reservation.setStatus(ReservationStatus.CANCELLED);
        reservationRepo.save(reservation);
        return reservation;
    }

    public WaitEntry addUserToWaitlist(String username, Integer programId) throws Exception, WashingProgramNotFoundException {
        WashingProgram program = null;

        try {
            program = programRepo.findById(programId)
                    .orElseThrow(() -> new WashingProgramNotFoundException("Program with id "+programId+" was not found"));
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }


        WaitEntry waitEntry = new WaitEntry(program, username);
        waitRepo.save(waitEntry);
        return waitEntry;
    }

    public List<WaitEntry> getWaitlist() {
        return waitRepo.findAll();
    }

    public WaitEntry removeUserFromWaitlist(Integer waitEntryId) throws WaitEntryNotFoundException {
        WaitEntry waitEntry = waitRepo.findById(waitEntryId)
                .orElseThrow(() -> new WaitEntryNotFoundException("WaitEntry with id "+waitEntryId+" was not found"));

        waitRepo.delete(waitEntry);
        return waitEntry;
    }

    public List<WaitEntry> getWaitlistForProgram(Integer programId) throws Exception, WashingProgramNotFoundException {
        List<WaitEntry> waitlist = waitRepo.findAll();

        return waitlist.stream()
                .filter(entry -> entry.getWashingProgram().getWashingprogramid() == programId)
                .toList();
    }

    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    public List<WashingMachine> getAllWashingMachines() {
        return machineRepo.findAll();
    }

    public List<WashingMachine> updateMachineStatus() {
        List<WashingMachine> machines = machineRepo.findAll();

        for (WashingMachine machine : machines) {
            Reservation currentReservation = reservationRepo.findByUsername(machine.getUserofmachine());
            LocalDateTime now = LocalDateTime.now();

            if (currentReservation != null) {
                if (currentReservation.getEndtime().isBefore(now)) {
                    currentReservation.setStatus(ReservationStatus.COMPLETED);
                    reservationRepo.save(currentReservation);

                    Reservation nextReservation = reservationRepo.findTopByWashingMachineAndStarttimeAfterOrderByStarttime(machine, currentReservation.getEndtime());

                    if (nextReservation != null && nextReservation.getStarttime().isBefore(now) && nextReservation.getEndtime().isAfter(now)) {
                        machine.setStatus(WashingMachineStatus.IN_USE);
                        machine.setUserofmachine(nextReservation.getUsername());
                    } else {
                        machine.setStatus(WashingMachineStatus.AVAILABLE);
                        machine.setUserofmachine(null);
                    }
                }

                else {
                    machine.setStatus(WashingMachineStatus.IN_USE);
                }
                machineRepo.save(machine);
            }

            else {
                Reservation upcomingReservation = reservationRepo.findTopByWashingMachineAndStarttimeAfterOrderByStarttime(machine, now);
                if (upcomingReservation != null && upcomingReservation.getStarttime().isBefore(now.plusMinutes(1))) {
                    machine.setStatus(WashingMachineStatus.IN_USE);
                    machine.setUserofmachine(upcomingReservation.getUsername());
                    machineRepo.save(machine);
                }
            }
        }

        return machineRepo.findAll();
    }

    public List<LocalDateTime> findAvailableReservationsForProgram(Integer programid) {
        // TODO
        /*
        hent alle reservasjoner
        lag en liste med alle tids intervaller som er mulig å reservere
        loop over alle tids intervaller
            Fjern intervaller om de ingår i reservasjoner

         returner listen med starttider til intervallene
         */
        return null;
    }

    public WaitEntry alertUserFromWaitlist() {
        // TODO

        /*
        Denne blir kalt på hver gang maskinene oppdateres, slik at det mulig er ledig maskin for noen

        Hent venteliste
        Loop over liste
            for hver bruker, kall på findAvailableReservationsForProgram for å finne om ledig
            Hvis ledig for denne brukeren
                Send alert til frontend
                Fjern bruker fra ventelisten
            Hvis ikke ledig for denne brukeren
                Fortsett videre i listen

         Hvis ikke ledig for noen returnern null

         */

        return null;
    }
}

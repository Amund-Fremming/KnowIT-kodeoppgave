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
import java.util.Map;

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

    public List<WashingMachine> getAllAvailableMachines() {
        List<WashingMachine> machines = machineRepo.findAll();
        return machines
                .stream()
                .filter(machine -> machine.getStatus() == WashingMachineStatus.AVAILABLE)
                .toList();
    }

    public WashingMachine getMachineById(long id) throws WashingMacineNotFoundException {
        WashingMachine machine = machineRepo.findById(id)
                .orElseThrow(() -> new WashingMacineNotFoundException("Machine with id "+id+" does not exist"));

        return machine;
    }

    public List<WashingProgram> getAllPrograms() {
        return programRepo.findAll();
    }

    public WashingProgram getProgramById(long id) throws WashingProgramNotFoundException {
        WashingProgram program =  programRepo.findById(id)
                .orElseThrow(() -> new WashingProgramNotFoundException("Program with id "+id+" does not exist!"));

        return program;
    }

    /**
     * Finds available machines based on you wash
     */
    public WashingMachine getAvailableMachineForProgram(long washingProgramId) {
        return null;
    }

    public Reservation createReservationForProgram(long programId, long machineId, String username, LocalDateTime startTime) throws WashingProgramNotFoundException, WashingMacineNotFoundException {
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
        reservationRepo.save(reservation);
        return reservation;
    }

    public Reservation cancelReservation(long reservationid) throws ReservationNotFoundException {
        Reservation reservation = reservationRepo.findById(reservationid)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation with id "+reservationid+" was not found"));

        reservation.setStatus(ReservationStatus.CANCELLED);
        return reservation;
    }

    public List<Reservation> getAllReservationsForUser(String username) {
        List<Reservation> reservations = reservationRepo.findAll();
        return reservations.stream()
                .filter(res -> res.getUsername().equals(username))
                .toList();
    }

    public List<LocalDateTime> getAvailableTimeSlots() {
        // TODO
        return null;
    }

    public Reservation createFutureReservation(long washingProgramId, String username, LocalDateTime futureStartTime) {


        Reservation reservation = new Reservation();
    }

    // Integer represents the minutes available
    public Map<WashingMachine, Integer> findAvailableMachinesForCurrentHour() {
        return null;
    }

    public WaitEntry addUserToWaitlist(String username, long programId) throws Exception {
        return null;
    }

    public WaitEntry removeUserFromWaitlist(long waitEntryId) throws WaitEntryNotFoundException {
        return null;
    }

    public List<WaitEntry> getWaitlistForProgram(long programId) throws Exception {
        return null;
    }

}

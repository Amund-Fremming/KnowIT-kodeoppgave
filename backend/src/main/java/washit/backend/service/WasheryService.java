package washit.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return null;
    }

    public WashingMachine getMachineById(long id) throws WashingMacineNotFoundException {
        return null;
    }

    public List<WashingProgram> getAllPrograms() {
        return null;
    }

    public WashingProgram getProgramById(long id) throws WashingProgramNotFoundException {
        return null;
    }

    public WashingMachine getAvailableMachineForProgram(WashingProgram program) {
        return null;
    }

    public Reservation createReservationForProgram(WashingProgram program, String username, LocalDateTime starttime) {
        return null;
    }

    public Reservation cancelReservation(long reservationid) throws ReservationNotFoundException {
        return null;
    }

    public List<Reservation> getAllReservationsForUser(String username) {
        return null;
    }

    public List<LocalDateTime> getAvailableTimeSlots() {
        return null;
    }

    public Reservation createFutureReservation(WashingProgram washingProgram, String username, LocalDateTime futureStartTime) {
        return null;
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

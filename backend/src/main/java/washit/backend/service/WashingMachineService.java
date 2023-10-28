package washit.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import washit.backend.repository.ReservationRepository;
import washit.backend.repository.WashingMachineRepository;
import washit.backend.repository.WashingProgramRepository;

@Service
public class WashingMachineService {

    @Autowired
    private WashingMachineRepository machineRepo;

    @Autowired
    private ReservationRepository reservationRepo;

    @Autowired
    private WashingProgramRepository programRepo;

    // Kan kanskje brukes for reservasjoner/ventelsite/vaskemaskin
    public void useWashingMachine() {

    }

    public boolean isThereReservation() {
        return false;
    }

    public void useWashingMachineByReservation() {

    }

    public void useWashingMachineFromReservation() {

    }

}

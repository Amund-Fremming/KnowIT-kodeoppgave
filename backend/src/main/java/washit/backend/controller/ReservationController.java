package washit.backend.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import washit.backend.model.Reservation;
import washit.backend.model.WashingMachine;
import washit.backend.service.WasheryService;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api/reservation")
@RestController
@CrossOrigin(
        origins = {"http://localhost:5173","http://localhost:8080"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE},
        allowedHeaders = {"Content-Type", "Authorization"}
)
public class ReservationController {

    @Autowired
    private WasheryService service;

    @GetMapping("/reservations")
    public ResponseEntity<Object> getAllReservations() {
        List<Reservation> reservations;

        try {
            reservations = service.getAllReservations();
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    /**
     * Method for creating a reservation now
     * If no machines are available and no waitlist check for any unused time after a prorgam so the user can wash too
     * If no machines are available and there is a waitlist, return a prompt for jumping on the waitlist and dont make res
     */
    @PostMapping("/create-now")
    public ResponseEntity<Object> createReservationNow(@RequestParam String username, @RequestParam long programId, @RequestParam LocalDateTime startTime) {
        Reservation reservation;

        try {
            /*
                Her må jeg sjekke om det finnes noen maskiner som er tiligjengelige, hvis ingen er tilgejngelige
                må jeg bruke metoder som prøver å finne ledige smutthull og dermed bruke disse tidene for denne reservasjonen
             */

            reservation = service.createReservationForProgram(programId, machineId, username, startTime);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    /**
     * Method for creating a reservation later
     * return false if the time crashes with all other reservations
     * return true if available
     */
    @PostMapping("/create-later")
    public ResponseEntity<Object> createReservationLater(@RequestParam String username, @RequestParam long programId, @RequestParam LocalDateTime startTime) {
        Reservation reservation;


        try {

            /*
                Her må jeg hente alle reservasjoner som finnes, og sjekke at det er mulig å ta en maskin
                I tidspuinktet personen vil
             */

            reservation = service.createFutureReservation(programId, machineId, username, startTime);
        } catch(Exception e) {

        }

        return new ResponseEntity<>(null);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Object> deleteReservation(@PathVariable(name="id") long id) {
        Reservation reservation;

        try {
            reservation = service.cancelReservation(id);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

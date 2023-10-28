package washit.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import washit.backend.service.WasheryService;

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
        // TODO

        return new ResponseEntity<>(null);
    }

    /**
     * Method for creating a reservation now
     * If no machines are available and no waitlist check for any unused time after a prorgam so the user can wash too
     * If no machines are available and there is a waitlist, return a prompt for jumping on the waitlist and dont make res
     */
    @PostMapping("/create-now")
    public ResponseEntity<Object> createReservationNow() {
        // TODO

        return new ResponseEntity<>(null);
    }

    /**
     * Method for creating a reservation later
     * return false if the time crashes with all other reservations
     * return true if available
     */
    @PostMapping("/create-later")
    public ResponseEntity<Object> createReservationLater() {
        // TODO

        return new ResponseEntity<>(null);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> deleteReservation() {
        // TODO

        return new ResponseEntity<>(null);
    }

}

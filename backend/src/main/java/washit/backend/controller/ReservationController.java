package washit.backend.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import washit.backend.DTO.ReservationDTO;
import washit.backend.model.Reservation;
import washit.backend.model.WashingMachine;
import washit.backend.service.WasheryService;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api/reservation")
@RestController
@CrossOrigin(
        origins = {"http://localhost:5173","http://localhost:8080"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS},
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

    @PostMapping("/create")
    public ResponseEntity<Object> createReservations(@RequestBody ReservationDTO dto) {
        Reservation res;

        try {

            res = service.createReservationForProgram(dto.getProgramId(), dto.getMachineId(), dto.getUsername(), dto.getStarttime());

        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Object> deleteReservation(@PathVariable(name="id") Integer id) {
        Reservation reservation;

        System.out.println(id);

        try {
            reservation = service.cancelReservation(id);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}

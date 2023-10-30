package washit.backend.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import washit.backend.model.Reservation;
import washit.backend.model.WashingMachine;
import washit.backend.service.WasheryService;

import java.util.List;

@RequestMapping("/api/machine")
@RestController
@CrossOrigin(
        origins = {"http://localhost:5173","http://localhost:8080"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE},
        allowedHeaders = {"Content-Type", "Authorization"}
)
public class WashingMachineController {

    @Autowired
    private WasheryService service;

    @GetMapping("/washingmachines")
    public ResponseEntity<Object> getAllWashingMachines() {
        List<WashingMachine> machines;

        try {
            machines = service.getAllWashingMachines();
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(machines, HttpStatus.OK);
    }

    @GetMapping("updatedmachines")
    public ResponseEntity<Object> updateMachinesAndReturnUpdatedData() {
        List<WashingMachine> machines;

        try {
            machines = service.updateMachineStatus();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(machines, HttpStatus.OK);
    }
}

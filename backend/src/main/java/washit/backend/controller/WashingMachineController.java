package washit.backend.controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/machine")
@RestController
@CrossOrigin(
        origins = {"http://localhost:5173","http://localhost:8080"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE},
        allowedHeaders = {"Content-Type", "Authorization"}
)
public class WashingMachineController {

    @GetMapping("/washingmachines")
    public ResponseEntity<Object> getAllWashingMachines() {
        // TODO

        return new ResponseEntity<>(null);
    }

    @GetMapping("/machines-with-time-left")
    public ResponseEntity<Object> getWashingMachinesWithTimeLeft() {
        // TODO

        return new ResponseEntity<>(null);
    }

    /**
     * Called after every 10 mins
     * Used to see if a program on a machine is done and the machine is made available to others now
     */
    @GetMapping()
    public ResponseEntity<Object> toggleMachinesStatusesIfProgramDone() {
        // TODO
        // return all machines
        return new ResponseEntity<>(null);
    }
}

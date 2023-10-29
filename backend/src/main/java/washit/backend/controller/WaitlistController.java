package washit.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import washit.backend.service.WasheryService;

@RequestMapping("/api/waitlist")
@RestController
@CrossOrigin(
        origins = {"http://localhost:5173","http://localhost:8080"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE},
        allowedHeaders = {"Content-Type", "Authorization"}
)
public class WaitlistController {

    @Autowired
    private WasheryService service;

    @GetMapping("/getall")
    public ResponseEntity<Object> getWaitlist() {


        try {

        } catch (Exception e) {

        }

        return new ResponseEntity<>(null);
    }

    @PostMapping("/remove")
    public ResponseEntity<Object> removeFromWaitlist() {
        // TODO

        return new ResponseEntity<>(null);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addToWaitlist() {
        // TODO

        return new ResponseEntity<>(null);
    }

}

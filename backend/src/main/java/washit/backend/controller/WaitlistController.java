package washit.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import washit.backend.model.WaitEntry;
import washit.backend.service.WasheryService;

import java.util.List;

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

    @GetMapping("/getnext")
    public ResponseEntity<Object> searchForWaitlistAlert() {
        WaitEntry entry;
        try {

            entry = service.alertUserFromWaitlist();

        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        return new ResponseEntity<>(entry, HttpStatus.OK);
    }

    @PostMapping("/remove/{username}")
    public ResponseEntity<Object> removeFromWaitlist(@RequestParam Integer waitEntryId) {
        WaitEntry entry;

        try {
            entry = service.removeUserFromWaitlist(waitEntryId);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(null);
    }

    @PostMapping("/add/{username}/{programid}")
    public ResponseEntity<Object> addToWaitlist(@PathVariable(name="username") String username, @PathVariable(name="programid") Integer programid) {
        WaitEntry entry;

        try {
            entry = service.addUserToWaitlist(username, programid);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(entry, HttpStatus.OK);
    }

}

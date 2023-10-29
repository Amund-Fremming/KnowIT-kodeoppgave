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

    @GetMapping("/getall")
    public ResponseEntity<Object> getWaitlist() {
        List<WaitEntry> waitlist;

        try {
            waitlist = service.getWaitlist();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(waitlist, HttpStatus.OK);
    }

    @GetMapping("/getnext")
    public ResponseEntity<Object> searchForWaitlistAlert() {
        WaitEntry entry;
        // TODO
        try {

            /*
                Henter en person fra ventelisten om det er ledig maskin
                eller om det finens smutthul man kan bruke
                varsler med brukernavn
                sletter entry i databasem
             */

        } catch(Exception e) {

        }
        return null;
    }

    @PostMapping("/remove")
    public ResponseEntity<Object> removeFromWaitlist(@RequestParam long waitEntryId) {
        WaitEntry entry;

        try {
            entry = service.removeUserFromWaitlist(waitEntryId);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(null);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addToWaitlist(@RequestParam String username, @RequestParam long programId) {
        WaitEntry entry;

        try {
            entry = service.addUserToWaitlist(username, programId);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(entry, HttpStatus.OK);
    }

}

package washit.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import washit.backend.model.WaitEntry;
import washit.backend.model.WashingProgram;
import washit.backend.repository.WaitEntryRepository;
import washit.backend.repository.WashingProgramRepository;

@Service
public class WaitEntryService {

    @Autowired
    private WaitEntryRepository weRepo;

    @Autowired
    private WashingProgramRepository programRepo;

    /**
     * This method creates a new entry in the waitEntry table, and returns the id for the waitEntry,
     * that the user need to keep if the user wants to edit the entry
     * @param washingProgramId
     * @param username
     * @return
     */
    public Integer addToWaitList(int washingProgramId, String username) {
        return null;
    }

    public WaitEntry removeFromWaitList(String username) {
        return null;
    }

    public WashingProgram updateWashingProgram(int washingProgramId, String username) {
        return null;
    }

    public boolean isThereWaitingQueue(int washingMachineId) {
        return false;
    }

}

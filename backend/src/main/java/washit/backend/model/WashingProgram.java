/**
 * Using Lomboks @Data for getters og setters
 * Using Lomboks @NoArgsConstructor for default constructor
 */
package washit.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import washit.backend.AppEnum.WashType;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "washingprogram")
@NoArgsConstructor
public class WashingProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long washingprogramid;

    @Enumerated(EnumType.STRING)
    private WashType washType;

    private int temperature;
    private int minutes;

    @OneToMany(mappedBy = "washingProgram")
    private List<WashingMachine> washingMachines;

    @OneToMany(mappedBy = "washingProgram")
    private List<WaitEntry> waitEntries;

    public WashingProgram(WashType washType, int temperature, int minutes) {
        this.washType = washType;
        this.temperature = temperature;
        this.minutes = minutes;
        washingMachines = new ArrayList<>();
        waitEntries = new ArrayList<>();
    }

    public void addWashingMachine(WashingMachine washingMachine) {
        washingMachines.add(washingMachine);
        washingMachine.setWashingProgram(this);
    }

    public void deleteWashingMachine(WashingMachine washingMachine) {
        washingMachines.remove(washingMachine);
        washingMachine.setWashingProgram(null);
    }

    public void addWaitEntry(WaitEntry waitEntry) {
        waitEntries.add(waitEntry);
        waitEntry.setWashingProgram(this);
    }

    public void delete(WaitEntry waitEntry) {
        waitEntries.remove(waitEntry);
        waitEntry.setWashingProgram(null);
    }
}

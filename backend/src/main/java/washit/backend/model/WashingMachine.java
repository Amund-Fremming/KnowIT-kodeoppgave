/**
 * Using Lomboks @Data for getters og setters
 * Using Lomboks @NoArgsConstructor for default constructor
 */
package washit.backend.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import washit.backend.AppEnum.WashingMachineStatus;

import java.util.List;

@Data
@Entity
@Table(name = "washingmachine")
@NoArgsConstructor
public class WashingMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long washingmachineid;

    @Enumerated(EnumType.STRING)
    private WashingMachineStatus status;

    private String brukernavn;

    @OneToOne
    @JoinColumn(name="washingprogramid")
    private WashingProgram washingProgram;

    @OneToMany(mappedBy = "washingMachine")
    private List<Reservation> reservations;

}

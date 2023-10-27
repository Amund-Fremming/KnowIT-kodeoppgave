/**
 * Using Lomboks @Data for getters og setters
 */
package washit.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import washit.backend.AppEnum.WashingMachineStatus;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "washingmachine")
public class WashingMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long washingmachineid;

    @Enumerated(EnumType.STRING)
    private WashingMachineStatus status;

    private String userOfMachine;

    @ManyToOne
    @JoinColumn(name="washingprogramid")
    private WashingProgram washingProgram;

    @OneToMany(mappedBy = "washingMachine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;

    public WashingMachine() {
        this.status = WashingMachineStatus.AVAILABLE;
        this.userOfMachine = "";
        this.washingProgram = null;
        this.reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.setWashingMachine(this);
    }

    public void deleteReservation(Reservation reservation) {
        reservations.remove(reservation);
        reservation.setWashingMachine(null);
    }
}

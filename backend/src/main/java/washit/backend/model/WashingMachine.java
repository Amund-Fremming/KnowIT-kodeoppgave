/**
 * Using Lomboks @Data for getters og setters
 */
package washit.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Integer washingmachineid;

    @Enumerated(EnumType.STRING)
    private WashingMachineStatus status;

    private String userofmachine;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="washingprogramid")
    private WashingProgram washingProgram;

    @JsonManagedReference
    @OneToMany(mappedBy = "washingMachine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;

    public WashingMachine() {
        this.status = WashingMachineStatus.AVAILABLE;
        this.userofmachine = null;
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

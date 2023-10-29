/**
 * Using Lomboks @Data for getters og setters
 * Using Lomboks @NoArgsConstructor for default constructor
 *
 */
package washit.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import washit.backend.AppEnum.ReservationStatus;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "reservation")
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservationid;

    @ManyToOne
    @JoinColumn(name="washingmachineid")
    private WashingMachine washingMachine;

    private String username;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    private LocalDateTime starttime;
    private LocalDateTime endtime;

    public Reservation(WashingMachine washingMachine, String username, LocalDateTime startTime, LocalDateTime endTime) {
        this.washingMachine = washingMachine;
        this.username = username;
        this.status = ReservationStatus.PENDING;
        this.starttime = startTime;
        this.endtime = endTime;

    }
}

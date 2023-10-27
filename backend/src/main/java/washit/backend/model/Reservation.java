/**
 * Using Lomboks @Data for getters og setters
 * Using Lomboks @NoArgsConstructor for default constructor
 */
package washit.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import washit.backend.AppEnum.WashingMachineStatus;

@Data
@Entity
@Table(name = "reservation")
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservationid;



}

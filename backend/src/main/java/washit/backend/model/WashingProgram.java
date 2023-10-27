/**
 * Using Lomboks @Data for getters og setters
 * Using Lomboks @NoArgsConstructor for default constructor
 */
package washit.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "washingprogram")
@NoArgsConstructor
public class WashingProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

}

/**
 * Using Lomboks @Data for getters og setters
 * Using Lomboks @NoArgsConstructor for default constructor
 */
package washit.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "waitentry")
@NoArgsConstructor
public class WaitEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer waitentryid;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="washingprogramid")
    private WashingProgram washingProgram;

    private String username;
    private LocalDateTime timeadded;

    public WaitEntry(WashingProgram washingProgram, String username) {
        this.washingProgram = washingProgram;
        this.username = username;
        this.timeadded = LocalDateTime.now();
    }
}

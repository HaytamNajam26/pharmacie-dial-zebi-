package pharmacymanagment.pharmacy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "alert")
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private AlertType type;

    private String message;

    // Option 1: Rename the field
    @Column(name = "`read`")
    private boolean isRead;

    // OR Option 2: Keep the field name but escape the column name
    /*
    @Column(name = "`read`") 
    private boolean read;
    */

    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    public enum AlertType {
        LOW_STOCK, EXPIRATION
    }

    // Constructors
    public Alert() {
        this.createdAt = LocalDateTime.now();
        this.isRead = false; // Update this line if you renamed the field
    }
}
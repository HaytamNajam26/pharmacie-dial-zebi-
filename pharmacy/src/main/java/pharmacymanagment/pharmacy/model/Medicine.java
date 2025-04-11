package pharmacymanagment.pharmacy.model;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    private String dosage;
    private String manufacturer;
    private Double price;
    private Integer stockQuantity;
    private LocalDate expirationDate;
    private Integer alertThreshold; // Minimum quantity 
    private Integer expiryAlertDays; // Days before expiry 
    
 
    
    public boolean isLowOnStock() {
        return stockQuantity <= alertThreshold;
    }
    
    public boolean isNearExpiry() {
        if (expirationDate == null) return false;
        LocalDate alertDate = LocalDate.now().plusDays(expiryAlertDays);
        return expirationDate.isBefore(alertDate);
    }
}
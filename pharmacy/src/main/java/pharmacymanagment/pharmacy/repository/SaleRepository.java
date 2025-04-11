package pharmacymanagment.pharmacy.repository;

import pharmacymanagment.pharmacy.model.Sale;
import pharmacymanagment.pharmacy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    
    List<Sale> findBySeller(User seller);
    
    List<Sale> findBySellerAndSaleDateBetween(User seller, LocalDateTime startDate, LocalDateTime endDate);
    
    List<Sale> findBySaleDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    
    List<Sale> findByCustomerNameContainingIgnoreCase(String customerName);
    
    Optional<Sale> findByReceiptNumber(String receiptNumber);
}

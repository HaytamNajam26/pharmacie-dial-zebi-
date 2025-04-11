package pharmacymanagment.pharmacy.repository;

import pharmacymanagment.pharmacy.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    
    List<Medicine> findByNameContainingIgnoreCase(String name);
    
    @Query("SELECT m FROM Medicine m WHERE m.stockQuantity <= m.alertThreshold")
    List<Medicine> findLowStockMedicines();
    
    @Query("SELECT m FROM Medicine m WHERE m.expirationDate <= :expiryThreshold")
    List<Medicine> findMedicinesNearExpiry(LocalDate expiryThreshold);
}


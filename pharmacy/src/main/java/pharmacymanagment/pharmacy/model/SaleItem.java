package pharmacymanagment.pharmacy.model;
import jakarta.persistence.*;

@Entity
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;
    
    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;
    
    private Integer quantity;
    
    private Double price; // Price at the time of sale
    
    // Constructors
    public SaleItem() {}
    
    public SaleItem(Sale sale, Medicine medicine, Integer quantity, Double price) {
        this.sale = sale;
        this.medicine = medicine;
        this.quantity = quantity;
        this.price = price;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Sale getSale() {
        return sale;
    }
    
    public void setSale(Sale sale) {
        this.sale = sale;
    }
    
    public Medicine getMedicine() {
        return medicine;
    }
    
    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public Double getSubtotal() {
        return price * quantity;
    }
}

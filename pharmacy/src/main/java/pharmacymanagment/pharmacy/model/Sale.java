package pharmacymanagment.pharmacy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime saleDate;

    private String customerName;

    private String customerContact;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User seller;

    private Double totalAmount;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleItem> items = new ArrayList<>();

    // Receipt information
    private String receiptNumber;

    // Constructors
    public Sale() {
        this.saleDate = LocalDateTime.now();
    }

    public Sale(String customerName, String customerContact, User seller) {
        this.saleDate = LocalDateTime.now();
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.seller = seller;
        this.totalAmount = 0.0;
        this.generateReceiptNumber();
    }

    // Methods
    private void generateReceiptNumber() {
        // Generate a unique receipt number based on timestamp
        this.receiptNumber = "RCP-" + System.currentTimeMillis();
    }

    public void addItem(Medicine medicine, int quantity, double price) {
        SaleItem item = new SaleItem(this, medicine, quantity, price);
        items.add(item);
        updateTotalAmount();
    }

    public void updateTotalAmount() {
        this.totalAmount = items.stream()
                .mapToDouble(item -> item.getQuantity() * item.getPrice())
                .sum();
    }

    public void setItems(List<SaleItem> items) {
        this.items = items;
        updateTotalAmount();
    }
}

package ecom.mobile.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date createTime;
    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL
    )
    private List<ItemOrder> itemOrders;
    private String address;
    private String phoneNumber;
    private String email;
    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Shipment shipment;
    @ManyToOne
    @JoinColumn(name = "pay_id")
    private Payment payment;

}

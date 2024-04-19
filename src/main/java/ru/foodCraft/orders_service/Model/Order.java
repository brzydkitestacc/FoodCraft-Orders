package ru.foodCraft.orders_service.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@RequiredArgsConstructor
@Table(name="orders")
@Builder
@AllArgsConstructor
//@NoArgsConstructor

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "chief_id")
    private long chiefId;

    @OneToMany(mappedBy = "orderId")
    private List<Meal> meals;

    @Column(name = "total_price")
    private double totalPrice;



}

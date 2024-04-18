package ru.foodCraft.orders_service.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Entity
@Data
@RequiredArgsConstructor
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "chief_id")
    private long chiefId;

    //@Column(name = "m")
    //private List<Meal> meals;

    @Column(name = "total_price")
    private double totalPrice;


}

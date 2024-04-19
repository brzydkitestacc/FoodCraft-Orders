package ru.foodCraft.orders_service.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@RequiredArgsConstructor
@Table(name="meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "meal_name")
    private String mealName;

    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private Order orderId;

    @Column(name = "meal_nutritional")
    private double mealNutritional;

    @Column(name = "meal_weight")
    private double mealWeight;

    @Column(name = "chief_id")
    private long chiefId;

    @Column(name = "price")
    private double price;


}

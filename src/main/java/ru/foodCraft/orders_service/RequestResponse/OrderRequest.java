package ru.foodCraft.orders_service.RequestResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.foodCraft.orders_service.Model.Meal;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OrderRequest {
    private long customerId;
    private long chiefId;
    private double totalPrice;
    private List<Meal> meals;


}

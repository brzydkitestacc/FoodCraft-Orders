package ru.foodCraft.orders_service.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.foodCraft.orders_service.Model.Meal;
import ru.foodCraft.orders_service.Model.Order;
import ru.foodCraft.orders_service.Repository.MealsRepository;
import ru.foodCraft.orders_service.Repository.OrdersRepository;
import ru.foodCraft.orders_service.RequestResponse.OrderRequest;
import ru.foodCraft.orders_service.RequestResponse.OrderResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class OrdersService {
    private final OrdersRepository ordersRepo;
    private final MealsRepository mealsRepo;


    public OrderResponse orderCreate(OrderRequest request) {

        var newOrder = Order.builder()
                .customerId(request.getCustomerId())
                .chiefId(request.getChiefId())
                .build();


        double totalPrice = 0.0;
        List<Meal> meals = request.getMeals();
        if (meals != null && !meals.isEmpty()) {
            for (Meal meal : meals) {
                totalPrice += meal.getPrice();
            }
        }
        newOrder.setTotalPrice(totalPrice);


        newOrder = ordersRepo.save(newOrder);


        if (meals != null && !meals.isEmpty()) {
            for (Meal meal : meals) {
                meal.setOrderId(newOrder);
                mealsRepo.save(meal);
            }
        }

        return OrderResponse.builder()
                .totalPrice(totalPrice)
                .build();
    }


    public OrderResponse updateOrder(OrderRequest request) {
        Optional<Order> optionalExistingOrder = ordersRepo.findOrderById(request.getOrderId());

        if (optionalExistingOrder.isPresent()) {
            Order existingOrder = optionalExistingOrder.get();
            List<Meal> mealsToUpdate = request.getMeals();
            double totalPrice = 0.0;


            List<Meal> oldMeals = existingOrder.getMeals();
            for (Meal oldMeal : oldMeals) {
                mealsRepo.delete(oldMeal);
            }


            for (Meal meal : mealsToUpdate) {
                meal.setOrderId(existingOrder);
                mealsRepo.save(meal);
                totalPrice += meal.getPrice();
            }


            existingOrder.setMeals(mealsToUpdate);


            existingOrder.setTotalPrice(totalPrice);


            ordersRepo.save(existingOrder);


            return OrderResponse.builder()
                    .totalPrice(totalPrice)
                    .build();
        } else {

            return OrderResponse.builder().build();
        }
    }






    public OrderResponse deleteOrder(OrderRequest request) {
        Optional<Order> optionalExistingOrder = ordersRepo.findOrderById(request.getOrderId());
        System.out.println(request.getCustomerId());
        if (optionalExistingOrder.isPresent()) {
            Order existingOrder = optionalExistingOrder.get();
            List<Meal> meals = existingOrder.getMeals();

            if (meals != null && !meals.isEmpty()) {
                for (Meal meal : meals) {
                    mealsRepo.delete(meal);
                }
            }

            ordersRepo.delete(existingOrder);

            return OrderResponse.builder()
                    .totalPrice(existingOrder.getTotalPrice())
                    .build();
        } else {
            return OrderResponse.builder()
                    .build();
        }
    }


}


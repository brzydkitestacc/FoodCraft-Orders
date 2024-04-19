package ru.foodCraft.orders_service.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.foodCraft.orders_service.Model.Order;
import ru.foodCraft.orders_service.Repository.OrdersRepository;
import ru.foodCraft.orders_service.RequestResponse.OrderRequest;
import ru.foodCraft.orders_service.RequestResponse.OrderResponse;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class OrdersService {
    private final OrdersRepository ordersRepo;


    public OrderResponse orderCreate(OrderRequest request) {

        var newOrder = Order.builder()
                .customerId(request.getCustomerId())
                .chiefId(request.getChiefId())
                .totalPrice(request.getTotalPrice())
                .build();


        ordersRepo.save(newOrder);


        return OrderResponse.builder()
                .totalPrice(request.getTotalPrice())
                .build();
    }

    public OrderResponse updateOrder(OrderRequest request) {
        Optional<Order> optionalExistingOrder = ordersRepo.findOrderById(request.getCustomerId());

        Order existingOrder = optionalExistingOrder.get();
        existingOrder.setCustomerId(request.getCustomerId());
        existingOrder.setChiefId(request.getChiefId());
        existingOrder.setTotalPrice(request.getTotalPrice());
        ordersRepo.save(existingOrder);
        OrderResponse response = new OrderResponse();

        return OrderResponse.builder()
                .totalPrice(request.getTotalPrice())
                .build();
    }


    public OrderResponse deleteOrder(OrderRequest request) {

        Optional<Order> orderOptional = ordersRepo.findByAll(
                request.getCustomerId(), request.getChiefId(), request.getTotalPrice());

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            ordersRepo.delete(order);
            return OrderResponse.builder()

                    .build();
        } else {
            return OrderResponse.builder()

                    .build();
        }
    }


}
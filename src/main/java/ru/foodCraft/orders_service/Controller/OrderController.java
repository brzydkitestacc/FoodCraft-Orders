package ru.foodCraft.orders_service.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.foodCraft.orders_service.RequestResponse.OrderRequest;
import ru.foodCraft.orders_service.RequestResponse.OrderResponse;
import ru.foodCraft.orders_service.Service.OrdersService;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor

public class OrderController {
    private final OrdersService ordService;

    @PostMapping("/create")
    public ResponseEntity<OrderResponse> createOrder(
            @RequestBody OrderRequest request){
        return ResponseEntity.ok(ordService.orderCreate(request));
    }

    @PostMapping("/update")
    public ResponseEntity<OrderResponse> updateOrder(
            @RequestBody OrderRequest request){
        return ResponseEntity.ok(ordService.updateOrder(request));
    }

    @PostMapping("/delete")
    public ResponseEntity<OrderResponse> deleteOrder(
            @RequestBody OrderRequest request){
        return ResponseEntity.ok(ordService.deleteOrder(request));
    }



}

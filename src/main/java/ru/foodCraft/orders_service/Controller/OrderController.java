package ru.foodCraft.orders_service.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.foodCraft.orders_service.Service.OrdersService;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor

public class OrderController {
    private final OrdersService ordService;

    @PostMapping
    public ResponseEntity

}

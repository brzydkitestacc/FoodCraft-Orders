package ru.foodCraft.orders_service.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.foodCraft.orders_service.Repository.OrdersRepository;

@Service
@RequiredArgsConstructor

public class OrdersService {
    private final OrdersRepository ordersRepo;
    


}

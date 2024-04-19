package ru.foodCraft.orders_service.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.foodCraft.orders_service.Model.Meal;
import ru.foodCraft.orders_service.Model.Order;

import java.util.Optional;

@Repository
public interface MealsRepository extends JpaRepository<Meal, Long> {
    Optional<Meal> findOrderById(Long id);
}



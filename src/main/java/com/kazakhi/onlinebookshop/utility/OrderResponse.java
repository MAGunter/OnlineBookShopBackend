package com.kazakhi.onlinebookshop.utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long id; // Уникальный идентификатор заказа
    private Long userId; // Идентификатор пользователя, оформившего заказ
    private List<OrderItemResponse> items; // Список товаров в заказе
    private String status; // Статус заказа (e.g., "PENDING", "COMPLETED")
    private Double totalAmount; // Общая сумма заказа
    private String createdAt; // Дата и время создания заказа
}


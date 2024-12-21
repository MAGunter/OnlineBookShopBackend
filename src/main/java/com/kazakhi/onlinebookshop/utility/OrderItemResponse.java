package com.kazakhi.onlinebookshop.utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponse {
    private Long bookId; // Идентификатор книги
    private String bookTitle; // Название книги
    private Integer quantity; // Количество
    private Double price; // Цена за единицу
    private Double totalPrice; // Общая цена за товар (quantity * price)
}

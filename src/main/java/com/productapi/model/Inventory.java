package com.productapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    String productId;
    String prodName;
    String uOM;
    Double availQty;
    LocalDate availDate;
}

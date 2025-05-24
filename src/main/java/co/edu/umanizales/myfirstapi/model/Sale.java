package co.edu.umanizales.myfirstapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Locale;

@Getter
@Setter
@AllArgsConstructor

public class Sale{

    private Store store;
    private Seller seller;
    private Locale date;
    private int quantity;
    private double price;
    private List<Product> products;

}

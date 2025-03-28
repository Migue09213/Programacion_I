package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Sale;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sale")

public class SaleController {

    @GetMapping
    public Sale getSales(){

        Sale sale1 = new Sale("000001", "Papel Higienico", (float)112.99, "Papel Higienico Triple Hoja");

        return sale1;
    }
}

package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Location;
import co.edu.umanizales.myfirstapi.model.Store;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //es para que el sistema espere el tipo de pedido
@RequestMapping(path = "/store") //para brindarle una ruta nombre
public class StoreController {

    @GetMapping
    public Store getStore(){

        Location manizales = new Location("17001", "Manizales");

        Store StoreA = new Store ("0001", "MercaSeguro", manizales, "Kr. 23 #35 - 24a");

        return StoreA;
    }
}

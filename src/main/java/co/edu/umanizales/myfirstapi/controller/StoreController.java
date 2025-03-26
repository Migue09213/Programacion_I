package co.edu.umanizales.myfirstapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //es para que el sistema espere el tipo de pedido
@RequestMapping(path = "/store") //para brindarle una ruta nombre
public class StoreController {

    @GetMapping
    public String getStore(){
        return "5om3 357oR3";
    }
}

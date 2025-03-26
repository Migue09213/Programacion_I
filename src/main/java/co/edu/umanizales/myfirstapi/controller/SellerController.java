package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Seller;
import co.edu.umanizales.myfirstapi.model.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/seller")

public class SellerController {
    @GetMapping
    public String getSeller(){

        //Instanciar 5 Sellers

        Seller CarlosLoaiza = new Seller("102342195", "Carlos", "Loaiza", new Location("170001", "Manizales"),"Male", "34");

        Seller FernandoGonzalez = new Seller("1049832950", "Fernando", "Gonzalez", new Location("91001", "Leticia"), "Male", "20");

        Seller RicardoTepes = new Seller("ASCII3241", "Ricardo", "Tepes", new Location("05001", "Madellin"),"Male", "40");

        Seller JoaquinPerez = new Seller("B54213340", "Joaquin", "Perez", new Location("76001", "Cali"),"Male", "50");

        Seller BrunoDiaz = new Seller("A4439127", "Bruno", "Diaz", new Location("11001", "Bogota, D.C."),"Male", "55");

        return "sell successful";
    }
}

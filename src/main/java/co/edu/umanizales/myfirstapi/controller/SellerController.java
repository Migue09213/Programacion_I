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
    public Seller getSeller(){

        Location manizales = new Location("17001", "Manizales");
        Location leticia = new Location("91007", "Leticia");
        Location medellin = new Location("05001", "Medellin");
        Location cali = new Location("76001", "Cali");
        Location bogota = new Location("11001", "Bogota, D.C.");

        Seller CarlosLoaiza = new Seller("102342195", "Carlos", "Loaiza", manizales,"Male", (byte) 21);
        Seller FernandoGonzalez = new Seller("1049832950", "Fernando", "Gonzalez", leticia, "Male", (byte) 20);
        Seller RicardoTepes = new Seller("ASCII3241", "Ricardo", "Tepes", medellin,"Male", (byte) 40);
        Seller JoaquinPerez = new Seller("B54213340", "Joaquin", "Perez", cali,"Male", (byte) 50);
        Seller BrunoDiaz = new Seller("A4439127", "Bruno", "Diaz", bogota,"Male", (byte) 52);

        return CarlosLoaiza;

    }
}

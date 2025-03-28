package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Seller;
import co.edu.umanizales.myfirstapi.model.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/seller")

public class SellerController {
    @GetMapping
    public List<Seller> getSeller(){
        List<Seller> sellers = new ArrayList<>();

        Location manizales = new Location("17001", "Manizales");
        Location pereira = new Location("66001", "Pereira");
        Location bogota = new Location("11001", "Bogota, D.C.");

        sellers.add(new Seller("102342195", "Carlos", "Loaiza", manizales,"Male", (byte) 21));
        sellers.add(new Seller("1049832950", "Fernando", "Gonzalez", pereira, "Male", (byte) 20));
        sellers.add(new Seller("ASCII3241", "Ricardo", "Tepes", bogota,"Male", (byte) 40));
        sellers.add(new Seller("B54213340", "Joaquin", "Perez", manizales,"Male", (byte) 50));
        sellers.add(new Seller("A4439127", "Bruno", "Diaz", bogota,"Male", (byte) 52));

        return sellers;

    }
}

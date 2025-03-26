package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/location")

public class LocationController {

    @GetMapping
    public String getLocation(){
        Location manizales = new Location("170001", "Manizales");

        return "Krakovia";
    }
}

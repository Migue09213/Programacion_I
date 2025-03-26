package co.edu.umanizales.myfirstapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Seller {

    private String identification;
    private String name;
    private String lastName;
    private Location city;
    private String gender;
    private String age;

    public Seller(String identification, String name, String lastName, Location city, String gender, String age) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.gender = gender;
        this.age = age;
    }
}

package co.edu.umanizales.myfirstapi.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Location extends Parameter {

    public Location(String code, String description) {
        this.code = code;
        this.description = description;
    }
}



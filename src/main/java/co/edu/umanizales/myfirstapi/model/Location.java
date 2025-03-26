package co.edu.umanizales.myfirstapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Location {
    private String code;
    private String description;

    public Location(String code, String description) {
        this.code = code;
        this.description = description;
    }
}

package co.edu.umanizales.myfirstapi.model;


import lombok.Getter;
import lombok.Setter;

import java.io.InputStream;

@Getter
@Setter

public class Location {

    private String code;
    private String name;

    public Location(String code, String name) {
        this.code = code;
        this.name = name;
    }
}



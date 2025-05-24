package co.edu.umanizales.myfirstapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Seller {

    private String sellerID;
    private String sellerName;
    private String sellerLastName;
    private Location city;
    private String sellerGender;
    private byte sellerAge;


}

package co.edu.umanizales.myfirstapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Seller {

    private String sellerID;
    private String sellerName;
    private String SellerLastName;
    private Location city;
    private String SellerGender;
    private byte SellerAge;

    public Seller(String sellerID, String sellerName, String sellerLastName, Location city, String sellerGender, byte sellerAge) {
        this.sellerID = sellerID;
        this.sellerName = sellerName;
        this.SellerLastName = sellerLastName;
        this.city = city;
        this.SellerGender = sellerGender;
        this.SellerAge = sellerAge;
    }
}

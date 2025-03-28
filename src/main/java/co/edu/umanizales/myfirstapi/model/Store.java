package co.edu.umanizales.myfirstapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Store {
    private String storeCode;
    private String storeName;
    private Location city;
    private String address;

    public Store(String storeCode, String storeName, Location city, String address) {
        this.storeCode = storeCode;
        this.storeName = storeName;
        this.city = city;
        this.address = address;
    }
}

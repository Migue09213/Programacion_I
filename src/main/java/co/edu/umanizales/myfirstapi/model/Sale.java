package co.edu.umanizales.myfirstapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Sale {

    private String saleCode;
    private String saleProductName;
    private float salePrice;
    private String saleDescription;

    public Sale(String saleCode, String saleProductName, float salePrice, String saleDescription) {
        this.saleCode = saleCode;
        this.saleProductName = saleProductName;
        this.salePrice = salePrice;
        this.saleDescription = saleDescription;
    }
}

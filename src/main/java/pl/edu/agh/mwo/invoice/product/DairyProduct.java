package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class DairyProduct extends Product {
    public DairyProduct(String name, BigDecimal price) {

        super(name, price, Taxes.REDUCED_VAT);
    }
}

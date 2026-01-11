package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
    private final String name;

    private final BigDecimal price;

    private final BigDecimal taxPercent;

    protected Product(String name, BigDecimal price, BigDecimal tax) {
        if (name == null || name.isEmpty() ) {
            throw new IllegalArgumentException("Product namer can not be null!");
        }
        this.name = name;

        if (price == null || price.signum() == -1) {
            throw new IllegalArgumentException("Price can not be null!");
        }
        this.price = price;

        this.taxPercent = tax;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTaxPercent() {
        return taxPercent;
    }

    public BigDecimal getPriceWithTax() {
        BigDecimal tax = price.multiply(taxPercent);
        return price.add(tax);
    }
}

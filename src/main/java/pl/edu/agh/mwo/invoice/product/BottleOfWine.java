package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class BottleOfWine extends Product {

    private static final BigDecimal EXCISE_DUTY =
            new BigDecimal("5.56");

    public BottleOfWine(String name, BigDecimal price) {
        super(name, price, new BigDecimal("0.23"));
    }

    @Override
    public BigDecimal getExciseDuty() {
        return EXCISE_DUTY;
    }
}

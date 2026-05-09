package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class FuelCanister extends Product {

    private static final BigDecimal EXCISE_DUTY =
            new BigDecimal("5.56");

    public FuelCanister(String name, BigDecimal price) {
        super(name, price, Taxes.FUEL_VAT);
    }

    @Override
    public BigDecimal getExciseDuty() {
        return EXCISE_DUTY;
    }
}
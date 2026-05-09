package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public final class Taxes {

    public static final BigDecimal STANDARD_VAT =
            new BigDecimal("0.23");

    public static final BigDecimal REDUCED_VAT =
            new BigDecimal("0.08");

    public static final BigDecimal FUEL_VAT =
            BigDecimal.ZERO;

    private Taxes() {
    }
}
package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Map<Product, Integer> products = new HashMap<>();

    private static int nextNumber = 1;

    private final int number;

    public Invoice() {
        this.number = nextNumber++;
    }

    public int getNumber() {
        return number;
    }

    public void addProduct(Product product) {
        // TODO: implement
        this.addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        // TODO: implement
        if (product == null) {
            throw new IllegalArgumentException();
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException();
        }
        if (this.products.containsKey(product)) {

            Integer currentQuantity = this.products.get(product);

            this.products.put(product, currentQuantity + quantity);

        } else {

            this.products.put(product, quantity);
        }
    }

    public BigDecimal getNetValue() {
        BigDecimal value = BigDecimal.ZERO;

        for (Product product : this.products.keySet()) {
            Integer quantity = this.products.get(product);
            BigDecimal price = product.getPrice();
            price = price.multiply(BigDecimal.valueOf(quantity));
            value = value.add(price);
        }

        return value;
    }

    public BigDecimal getTax() {
        BigDecimal value = getTotal();
        value = value.subtract(getNetValue());

        return value;
    }

    public BigDecimal getTotal() {
        BigDecimal value = BigDecimal.ZERO;

        for (Product product : this.products.keySet()) {
            Integer quantity = this.products.get(product);
            BigDecimal price = product.getPriceWithTax();
            price = price.multiply(BigDecimal.valueOf(quantity));
            value = value.add(price);
        }

        return value;
    }

    public String getInvoiceAsString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Numer faktury: ")
                .append(number)
                .append("\n\n");

        for (Product product : this.products.keySet()) {

            Integer quantity = this.products.get(product);

            builder.append(product.getName())
                    .append(" | ")
                    .append(quantity)
                    .append(" szt. | ")
                    .append(product.getPrice())
                    .append("\n");
        }

        builder.append("\nLiczba pozycji: ")
                .append(this.products.size());

        return builder.toString();
    }
}

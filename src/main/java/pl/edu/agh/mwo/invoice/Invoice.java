package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Map<Product, Integer> products = new HashMap<>();

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
        this.products.put(product, quantity);
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
}

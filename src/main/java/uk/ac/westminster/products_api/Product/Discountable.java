package uk.ac.westminster.products_api.Product;

public interface Discountable {

    void applyDiscount(double rate);

    double getDiscountedPrice();
}
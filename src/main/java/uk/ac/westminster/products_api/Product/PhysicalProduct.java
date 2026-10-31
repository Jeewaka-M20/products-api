package uk.ac.westminster.products_api.Product;

//Physical Product IS-A product that has to be shipped, packed and shipped.
public class PhysicalProduct extends Product implements Discountable{
    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct(double weightKg, String dimensions) {
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    @Override
    public String getSummary() {
        return "Physical: " + getName()
                + " | Weight: " + weightKg + " kg";
    }

    @Override
    public void applyDiscount(double rate) {

        double capped = Math.min(rate, 0.20);

        this.discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}

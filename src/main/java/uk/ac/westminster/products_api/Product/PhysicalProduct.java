package uk.ac.westminster.products_api.Product;

//Physical Product IS-A product that has to be shipped, packed and shipped.
public class PhysicalProduct extends Product {
    private double weightKg;
    private String dimensions;

    public PhysicalProduct(double weightKg, String dimensions) {
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }
}

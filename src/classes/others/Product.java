package classes.others;

public class Product implements Comparable<Product>{
    private String name, description, supplier;
    
    public Product(String name, String description, String supplier){
        this.name = name;
        this.description = description;
        this.supplier = supplier;
    }

    @Override
    public int compareTo(Product other) {
        if (this.name.compareTo(other.getName()) < 0)
            return -1;
        else if (this.name.compareTo(other.getName()) > 0)
            return 1;
        else
            return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
}

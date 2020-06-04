package classes.others;

public class Product implements Comparable<Product>{
    private String name;
    private long id, quantity;
    
    public Product(){
        
    }

    @Override
    public int compareTo(Product other) {
        return 0;
    }
}

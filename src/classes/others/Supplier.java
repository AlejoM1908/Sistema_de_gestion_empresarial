package classes.others;

public class Supplier implements Comparable<Supplier>{
    private String name, address;
    private int telephone;
    
    public Supplier(String name, String address, int telephone){
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }
    
    @Override
    public int compareTo(Supplier other) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    
}

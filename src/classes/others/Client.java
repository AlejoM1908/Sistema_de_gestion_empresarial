package classes.others;

public class Client implements Comparable<Client>{
    private String name, lastname, type;
    private int telephone;
    
    public Client(String name, String lastname, int telephone, String type){
        this.name = name;
        this.lastname = lastname;
        this.telephone = telephone;
        this.type = type;
    }
    
    @Override
    public int compareTo(Client other) {
        if (this.name.compareTo(other.getName()) < 0)
            return -1;
        else if (this.name.compareTo(other.getName()) > 0)
            return 1;
        else
            return 0;
    }

    /**
     * 
     * @return 
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return 
     */
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * 
     * @return 
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return 
     */
    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    
}

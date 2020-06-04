package classes.others;

public class Client implements Comparable<Client>{
    private long id;
    private String name;
    
    public Client(){
        
    }
    
    @Override
    public int compareTo(Client other) {
        return 0;
    }
    
}

package classes.others;

public class User implements Comparable<User> {
    private int id;
    private String user, password, email;

    User(int id, String user, String password, String email){
        this.id = id;
        this.user = user;
        this.password = password;
        this.email = email;
    }

    @Override
    public int compareTo(User other) {
        if (this.id < other.getId()) return -1;
        else if (this.id > other.getId()) return 1;
        else return 0;
    }

    public void Encrypt(){
        
    }

    public int getId(){
        return this.id;
    }
}
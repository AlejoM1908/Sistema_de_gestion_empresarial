package classes.others;

public class User implements Comparable<User> {
    private int id;
    private String nickname, password, email, type;

    public User(int id, String nickname, String password, String email, String type) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.type = type;
    }

    @Override
    public int compareTo(User other) {
        if (this.id < other.getId())
            return -1;
        else if (this.id > other.getId())
            return 1;
        else
            return 0;
    }

    public void Encrypt() {

    }

    public int getId() {
        return this.id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }
}
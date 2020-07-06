package classes.others;

public class User implements Comparable<User> {
    private String nickname, password, email, type;

    public User(String nickname, String password, String email, String type) {
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.type = type;
    }

    public User(String nickname, String password){
        this.nickname = nickname;
        this.password = password;
    }

    @Override
    public int compareTo(User other) {
        if (this.nickname.compareTo(other.getNickname()) < 0)
            return -1;
        else if (this.nickname.compareTo(other.getNickname()) > 0)
            return 1;
        else
            return 0;
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
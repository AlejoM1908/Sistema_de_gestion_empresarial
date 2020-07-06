package classes.others;

public class UserType implements Comparable<UserType> {
    private String typeName;
    private boolean inventory,in_add,in_update;


    @Override
    public int compareTo(UserType other) {
        if (this.typeName.compareTo(other.getTypeName()) < 0)
            return -1;
        else if (this.typeName.compareTo(other.getTypeName()) > 0)
            return 1;
        else
            return 0;
    }
    
    public String getTypeName(){
        return typeName;
    }
}
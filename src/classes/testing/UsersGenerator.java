package classes.testing;

import  java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;
import java.io.IOException;

public class UsersGenerator {
    
    public static String nuevonickname() {
    int leftLimit = 97;
    int rightLimit = 122; 
    int targetStringLength = 4;
    Random random = new Random();
 
    String generatedString = random.ints(leftLimit, rightLimit + 1)
      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
      .limit(targetStringLength)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();
     //System.out.println(generatedString);
     return generatedString;
}
    
    public static String nuevacontraseña() {
    int leftLimit = 48; 
    int rightLimit = 57; 
    int targetStringLength = 4;
    Random random = new Random();
 
    String generatedString = random.ints(leftLimit, rightLimit + 1)
      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
      .limit(targetStringLength)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();
     //System.out.println(generatedString);
     return generatedString;
}
    public static String nuevocorreo() {
    int leftLimit = 97;
    int rightLimit = 122; 
    int targetStringLength = 4;
    Random random = new Random();
 
    String generatedString = random.ints(leftLimit, rightLimit + 1)
      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
      .limit(targetStringLength)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();
     //System.out.println(generatedString);
     return generatedString;
}
    
    public static void main(String[] args) {
           //   {"Type":"Master","Email":"root@root.user.com","Nickname":"Master","Password":"login"},
           //File file = new File("base100.txt");
            
                 
            
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/json_files/Users.json"))) {
            long numberOfUsers = 0;

            bufferedWriter.write("[");  
            bufferedWriter.write("{\"Type\":\"Master\",\"Email\":\"root@root.user.com\",\"Nickname\":\"Root\",\"Password\":\"root\"},");

            for(int i = 0 ; i<numberOfUsers ; i++ ){
                bufferedWriter.write("{\"Type\":\"None\",\"Email\":\""+nuevocorreo()+"@user.com\",\"Nickname\":\""+nuevonickname()+"\",\"Password\":\""+nuevacontraseña()+"\"},");
            } 

            bufferedWriter.write("{\"Type\":\"Master\",\"Email\":\"master@root.user.com\",\"Nickname\":\"Master\",\"Password\":\"login\"}");
            bufferedWriter.write("]"); 
        } 
        catch (IOException e) {
        // Exception handling
        }      
                
       //escribe.close();
           
    }
       
}

    
    


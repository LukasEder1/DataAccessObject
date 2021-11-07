import java.io.FileNotFoundException;
import java.util.ArrayList;


/* What makes this design pattern useful
The ability to store data in different formats, while keeping an abstract defintion
of a possible Application.
 */

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        UserServiceCSV us = new UserServiceCSV();
        User user1 = new User("Lukas", "Eder", "LukasEder");
        User user2 = new User("Max", "Mustermann", "Max123");
        us.save(user1);
        us.save(user2);
        // converto to UserServiceList
        UserServiceList us1 = us.convertToServiceList();
        //System.out.println(us.findAllUsers());
        System.out.print(us.findUserByUserName("LukasEder").getName());
    }
}

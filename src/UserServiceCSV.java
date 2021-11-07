import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class UserServiceCSV {

    public User save(User user) {
        try {
            FileWriter fw = new FileWriter("users.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            ArrayList<User> userList = findAllUsers();
            String username = user.getUsername();
            Boolean userExists = false;
            for (int i=0; i < userList.size(); i++){
                if (userList.get(i).getUsername().equals(username)){
                    userExists = true;
                }
            }
            if (!userExists) {
                pw.write(user.getName() + "," + user.getSurname() + "," + user.getUsername() + ",\n");
                pw.flush();
                pw.close();
            }
            else {
                System.out.println("User already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public ArrayList<User> findAllUsers() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("users.csv"));
        sc.useDelimiter(",");
        ArrayList<String> listOfFileInput = new ArrayList<String>();
        ArrayList<User> listOfUsers = new ArrayList<User>();
        while (sc.hasNext())  //returns a boolean value
        {
            listOfFileInput.add(sc.next());  //find and returns the next complete token from this scanner
        }
        sc.close();

        for (int i = 0; i < (listOfFileInput.size() / 3); i++) {
            listOfUsers.add(new User(listOfFileInput.get((3*i)), listOfFileInput.get(1 + (3*i)), listOfFileInput.get(2 + (3*i))));

        }
        return listOfUsers;

    }
    public User findUserByUserName(String username) throws FileNotFoundException {
        ArrayList<User> userList = findAllUsers();
        for (int i=0; i < userList.size(); i++){
            if (userList.get(i).getUsername().equals(username)){
                return userList.get(i);
            }
        }
        return null;
    }


    public UserServiceList convertToServiceList() throws FileNotFoundException {
        ArrayList<User> userList = findAllUsers();
        UserServiceList newUserService = new UserServiceList();
        for (int i = 0; i < userList.size(); i++) {
            newUserService.save(userList.get(i));
        }
        return newUserService;

    }


}

import java.io.FileNotFoundException;
import java.util.*;

public class UserServiceList {
    private ArrayList<User> userList = new ArrayList<>();
    public User save(User user){
        userList.add(user);
        return user;
    }
    public ArrayList<User> findAllUsers(){
        return userList;
    }

    public User findUserByUserName(String username){
        for (int i=0; i < userList.size(); i++){
            if (userList.get(i).getUsername() == username){
                return userList.get(i);
            }
        }
        return null;
    }

    public UserServiceCSV convertToServiceList() throws FileNotFoundException {
        ArrayList<User> userList = findAllUsers();
        UserServiceCSV newUserService = new UserServiceCSV();
        for (int i = 0; i < userList.size(); i++) {
            newUserService.save(userList.get(i));
        }
        return newUserService;

    }

}

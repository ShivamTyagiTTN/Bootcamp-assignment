package com.example.restfulwebservices2.user;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class UserService {

    private static List<User> userList = new ArrayList<>();
    private static int userCount = 3;

    static {
        userList.add(new User(1, "Shivam", 23));
        userList.add(new User(2, "Sumit", 24));
        userList.add(new User(3, "Ashu", 26));
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserById(int id) {
        for(User user: userList)
        {
            if(user.getId() == id)
                return user;
        }
        return null;
    }

    public void addUser(User user) {
        user.setId(++userCount);
        userList.add(user);
    }
    public User deleteUser(int id){

        Iterator<User> iterator = userList.iterator();

        while (iterator.hasNext()){
            User user = iterator.next();
            if( user.getId()==id ){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}

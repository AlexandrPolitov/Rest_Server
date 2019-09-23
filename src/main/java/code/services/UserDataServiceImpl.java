package code.services;

import java.util.List;
import code.models.User;
import java.util.ArrayList;
import code.database.dao.UserDAO;
import code.models.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDataServiceImpl implements UserDataService{


    private final UserDAO userdao;

    @Autowired
    public UserDataServiceImpl(UserDAO userdao) {
        this.userdao = userdao;
    }


    @Override
    public List<UserInfo> getAllUsers() {
        List<UserInfo> userInfos = new ArrayList<>();
        List<User> users = userdao.getAllUsers();
        for (User user: users) {
            UserInfo tmp = new UserInfo(user.getId(), user.getName());
            userInfos.add(tmp);
        }
        return userInfos;
    }

    @Override
    public User authUser(String name, String password) {
        List<User> users = userdao.getAllUsers();
        for(User user : users)
            if (name.equals(user.getName()) &&
                    password.equals(user.getPassword()))
                return user;
        return new User(-1, "null", "null", "null");

    }

    @Override
    public User getUserById(Integer id) {
        List<User> users = userdao.getAllUsers();
        for (User user : users)
            if (user.getId() == id) {
                user.setPassword("null");
                return user;
            }
        return new User(-1, "null","null","null");
    }

    @Override
    public User insertUser(String name, String password, String email) {
        List<User> users = userdao.getAllUsers();
        for(User user : users)
            if (user.getName().equals(name))
                return new User(-1, "null", "null", "null");
        userdao.insertUser(name, password, email);
        users = userdao.getAllUsers();
        for(User user : users) {
            if( user.getName().equals(name) && user.getPassword().equals(password))
                return user;
        }
        return new User(-1, "null", "null", "null");
    }

    @Override
    public void updateUser(Integer id, String name, String password, String email) {

    }

    @Override
    public void deleteUserById(Integer id) {

    }
}

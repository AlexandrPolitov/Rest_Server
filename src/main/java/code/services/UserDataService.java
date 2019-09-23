package code.services;

import code.models.User;
import code.models.UserInfo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserDataService {

    List<UserInfo> getAllUsers();
    Integer checkMail(String email);
    User authUser(String name, String password);
    User getUserById(Integer id);
    User insertUser(String name, String password, String email);
    void updateUser(Integer id, String name, String password, String email);
    void deleteUserById(Integer id);
}

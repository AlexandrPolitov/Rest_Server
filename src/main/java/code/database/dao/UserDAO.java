package code.database.dao;

import code.models.User;
import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void insertUser(String name, String password, String email);
    void updateUser(Integer id, String name, String password, String email);
    void deleteUserById(Integer id);
}

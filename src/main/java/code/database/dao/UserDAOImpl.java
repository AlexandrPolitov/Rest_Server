package code.database.dao;

import java.util.List;
import code.models.User;
import code.database.mapper.UserMapper;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Component
public class UserDAOImpl implements UserDAO {

    private static final String SQL_GET_USERS =
            "select * from users";

    private static final String SQL_INSERT_USER =
            "insert into users (name, password, email)" +
                    " values (:name, :password, :email)";

    private static final String SQL_UPDATE_USER =
            "update users set name = :name, password = :password, " +
                    "email = :email where id = :id";

    private static final String SQL_DELETE_USER =
            "delete from users where id = :id";

    private final UserMapper userMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl( UserMapper userMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.userMapper = userMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(
                SQL_GET_USERS,
                userMapper);
    }

    @Override
    public void insertUser(String name, String password, String email) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);
        params.addValue("password", password);
        params.addValue("email", email);

        jdbcTemplate.update(SQL_INSERT_USER, params);
    }

    @Override
    public void updateUser(Integer id, String name,
                           String password, String email) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        params.addValue("name", name);
        params.addValue("password", password);
        params.addValue("email", email);

        jdbcTemplate.update(SQL_UPDATE_USER, params);
    }

    @Override
    public void deleteUserById(Integer id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        jdbcTemplate.update(SQL_DELETE_USER, params);
    }

}

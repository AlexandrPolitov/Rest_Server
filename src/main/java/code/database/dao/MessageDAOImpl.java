package code.database.dao;

import code.models.Message;
import code.database.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class MessageDAOImpl implements MessageDAO {

    private final MessageMapper messageMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MessageDAOImpl( MessageMapper messageMapper,
                        NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.messageMapper = messageMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Message> getMessage(Integer user_id, Integer dialogue_id) {
        return null;
    }
}

package code.database.dao;

import code.models.Message;

import java.util.List;

public interface MessageDAO {
    List<Message> getMessage(Integer user_id, Integer dialogue_id);
}

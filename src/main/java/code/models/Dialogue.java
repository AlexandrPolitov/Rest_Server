package code.models;

import java.util.ArrayList;

public class Dialogue {

    private Integer id;
    private String name;
    private ArrayList<Integer> usersId;

    public Dialogue(Integer id, String name, ArrayList<Integer> usersId) {
        super();
        this.id = id;
        this.name = name;
        this.usersId = usersId;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Integer> getUsersId() {
        return usersId;
    }
    public void addUser(Integer id) {
        usersId.add(id);
    }

    @Override
    public String toString() {
        return id + " " + name +
                " - " + usersId ;
    }
}

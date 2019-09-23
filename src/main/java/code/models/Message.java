package code.models;

import java.time.LocalTime;

public class Message {

    private String name;
    private String text;
    private Integer id;
    private Integer userId;
    private Integer dialogueId;
    private LocalTime time;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDialogueId() {
        return dialogueId;
    }
    public void setDialogueId(Integer dialogueId) {
        this.dialogueId = dialogueId;
    }

    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String toString() {
        return time.toString() + " " + name + ": " + text;
    }
}
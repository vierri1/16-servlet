package ru.innopolis.stc13.pojo;

public class User {
    private int id;
    private String name;
    private String hashPassword;
    private int role;

    public User() {
    }

    public User(int id, String name, String hashPassword, int role) {
        this.id = id;
        this.name = name;
        this.hashPassword = hashPassword;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hashPassword='" + hashPassword + '\'' +
                ", role=" + role +
                '}';
    }
}

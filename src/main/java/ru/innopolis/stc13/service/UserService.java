package ru.innopolis.stc13.service;

public interface UserService {
    int getRole(String login);
    boolean checkAuth(String login, String password);
}

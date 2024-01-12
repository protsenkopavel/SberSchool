package ru.sber.school.reflection.myproxy;

public class UserDataServiceImpl implements UserDataService{
    @Override
    public String findAllByRole(String userRole) {
        return "some params from: " + userRole;
    }
}

package ru.sber.school.reflection.myproxy;

public interface UserDataService {
    @Metric
    String findAllByRole(String userRole);
}

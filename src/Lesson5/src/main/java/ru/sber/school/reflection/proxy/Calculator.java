package ru.sber.school.reflection.proxy;

public interface Calculator {
    @Cache
    int calc(int arg);
}

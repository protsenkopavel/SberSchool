package ru.sber.school.reflection.proxy;

public class CalculatorImpl implements Calculator {
    @Override
    public int calc(int number) {
        System.out.println("Вызван calc:" + number);
        if (number < 0)
            throw new IllegalArgumentException("Не сегодня");
        else if (number <= 1)
            return 1;
        else
            return number * calc(number - 1);
    }
}

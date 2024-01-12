package ru.sber.school.reflection.proxy;

import ru.sber.school.reflection.myproxy.Metric;

public interface Calculator {
    /**
     * Расчет факториала числа.
     * @param number
     */
    @Metric
    int calc (int number);
}

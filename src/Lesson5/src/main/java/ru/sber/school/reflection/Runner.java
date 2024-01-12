package ru.sber.school.reflection;

import ru.sber.school.reflection.myproxy.CachingPerformanceProxy;
import ru.sber.school.reflection.myproxy.UserDataService;
import ru.sber.school.reflection.myproxy.UserDataServiceImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Runner {
    public static void main(String[] args) {
        task5();
    }

    public static void task2(Class<?> aClass) {
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println("Наименование метода: " + method.getName());
            System.out.println("Модификатор доступа: " + method.getModifiers());
            System.out.println("Возвращаемое значение: " + method.getReturnType());
            Class<?> [] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("Параметр метода: " + parameterType.getName());
            }
        }

        if (aClass.getSuperclass() != null)
            task2(aClass.getSuperclass());
    }

    public static void task3(Class<?> aClass) {
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get") || method.getName().startsWith("is"))
                System.out.println("Геттер: " + method.getName());
            if (method.getName().startsWith("set"))
                System.out.println("Сеттер: " + method.getName());
        }
    }

    public static void task4(Class<?> aClass) throws IllegalAccessException {
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            if (field.getType() == String.class) {
                field.setAccessible(true);
                String value = (String) field.get(null);
                if (field.getName().equals(value))
                    System.out.println("Наименование поля соответствует значению поля.");
            }
        }
    }

    public static void task5() {
        UserDataService userDataService = new UserDataServiceImpl();
        UserDataService cachedData = CachingPerformanceProxy.createProxy(userDataService);
        System.out.println(cachedData.findAllByRole("ADMIN"));
    }
}



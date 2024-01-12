package ru.sber.school.reflection.myproxy;

import ru.sber.school.reflection.proxy.Cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

public class CachingPerformanceProxy implements InvocationHandler {
    private final Map<Object, Object> cache = new HashMap<>();
    private final Object target;

    public CachingPerformanceProxy(Object target) {
        this.target = target;
    }

    public static UserDataService createProxy(UserDataService target) {
        return (UserDataService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new CachingPerformanceProxy(target)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Cache.class)) {
            String key = (String) args[0];

            if (cache.containsKey(key)) {
                return cache.get(key);
            }

            String result = (String) method.invoke(target, args);
            cache.put(key, result);

            return result;
        } else if (method.isAnnotationPresent(Metric.class)) {
            long start = System.currentTimeMillis();
            String key = (String) args[0];

            if (cache.containsKey(key)) {
                return cache.get(key);
            }

            String result = (String) method.invoke(target, args);
            cache.put(key, result);
            System.out.println("Время работы метода: " + (System.currentTimeMillis() - start) + " миллисекунд");
            return result;
        } else {
            return method.invoke(target, args);
        }
    }
}

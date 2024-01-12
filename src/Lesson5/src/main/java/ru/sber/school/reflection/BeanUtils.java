package ru.sber.school.reflection;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {
        Pattern getterPattern = Pattern.compile("^(get|is)(.+)$"),
                setterPattern = Pattern.compile("^set(.+)$");

        Map<String, Method> setters = new HashMap<>();
        for (Method setter : to.getClass().getDeclaredMethods()) {
            Matcher setterMatcher = setterPattern.matcher(setter.getName());
            if (!setterMatcher.find())
                continue;

            String name = setterMatcher.group(1);
            setters.put(name, setter);
        }

        for (Method getter : from.getClass().getDeclaredMethods()) {
            Matcher getterMatcher = getterPattern.matcher(getter.getName());
            if (!getterMatcher.find())
                continue;

            String name = getterMatcher.group(2);

            Method setter = setters.get(name);
            if (setter == null) continue;

            Class<?> param = setter.getParameters()[0].getType();
            Class<?> returnType = getter.getReturnType();
            if (!param.isAssignableFrom(returnType))
                continue;

            try {
                setter.invoke(to, getter.invoke(from));
            } catch (InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

package Lesson3;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T>{
    private final Map<T, Integer> map;

    public CountMapImpl() {
        map = new HashMap<>();
    }

    @Override
    public void add(T t) {
        map.put(t, map.getOrDefault(t, 0) + 1);
    }

    @Override
    public int getCount(T t) {
        return map.getOrDefault(t, 0);
    }

    @Override
    public int remove(T t) {
        int count = getCount(t);
        map.remove(t);
        return count;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        Map<T, Integer> souceMap = source.toMap();
        map.putAll(souceMap);
    }

    @Override
    public Map<T, Integer> toMap() {
        return new HashMap<>(map);
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.putAll(map);
    }
}

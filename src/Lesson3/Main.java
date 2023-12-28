package Lesson3;
public class Main {
    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        int count = map.getCount(5); // 2
        int count2 = map.getCount(6); // 1
        int count3 = map.getCount(10); // 3

        System.out.println(count);
        System.out.println(count2);
        System.out.println(count3);
    }
}

package Lesson1;

class Child extends Parent {
    static {
        System.out.println("Lesson1.Child:static 1");
    }

    {
        System.out.println("Lesson1.Child:instance 1");
    }

    static {
        System.out.println("Lesson1.Child:static 2");
    }

    public Child() {
        System.out.println("Lesson1.Child:constructor");
    }

    public Child(String name) {
        super(name);
        System.out.println("Lesson1.Child:name-constructor");
    }

    {
        System.out.println("Lesson1.Child:instance 2");
    }
}
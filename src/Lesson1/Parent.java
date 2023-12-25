package Lesson1;

abstract class Parent {
    private String name;

    static {
        System.out.println("Lesson1.Parent:static 1");
    }

    {
        System.out.println("Lesson1.Parent:instance 1");
    }

    static {
        System.out.println("Lesson1.Parent:static 2");
    }

    public Parent() {
        System.out.println("Lesson1.Parent:constructor");
    }

    {
        System.out.println("Lesson1.Parent:instance 2");
    }

    public Parent(String name) {
        this.name = name;
        System.out.println("Lesson1.Parent:name-constructor");
    }
}
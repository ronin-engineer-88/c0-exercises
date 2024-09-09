package _09_ClassDesign_and_WrapperClass.Inheritance;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("Hello");
        builder.append("World");
        System.out.println(builder);
        System.out.println("Capacity of StringBuilder: " + builder.capacity());
        builder.append(" everyonne!");
        builder.insert(7, " everyone,");
        builder.replace(0, 7, "Welcome");
        builder.delete(6, 15);

        System.out.println("StringBuilder result: " + builder.toString());
    }
}

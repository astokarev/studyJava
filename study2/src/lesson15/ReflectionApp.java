package lesson15;


import java.lang.reflect.Field;

public class ReflectionApp {
    public static void main(String[] args) {
        try {
            ClassWithPrivateField obj = new ClassWithPrivateField(10);
            obj.info();
            Field privateField = ClassWithPrivateField.class.getDeclaredField("field");
            privateField.setAccessible(true);
            System.out.println("get: " + privateField.get(obj));
            privateField.set(obj, 1000);
            obj.info();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

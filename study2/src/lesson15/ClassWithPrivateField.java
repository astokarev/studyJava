package lesson15;

public class ClassWithPrivateField {
    private int field;

    public ClassWithPrivateField(int field) {
        this.field = field;
    }

    public void info() {
        System.out.println("field: " + field);
    }
}

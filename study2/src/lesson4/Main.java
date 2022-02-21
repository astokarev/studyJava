package lesson4;

public class Main {
    public static void main(String[] args) {
        Phonebook book1 = new Phonebook();
        book1.add("Иванов","12345675");
        book1.add("Петров","12643267");
        book1.add("Пекуш","12353242");
        book1.add("Кекуш","12235625");
        book1.add("Пекуш","24657643");
        book1.add("Бибис","83254353");
        System.out.println(book1.get("Пекуш"));
        book1.printAll();
    }
}

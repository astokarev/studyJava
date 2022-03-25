package lesson11;

import java.io.*;

public class SerializableDemoApp {
    private static class Book implements Serializable{
        private String title;

        public Book(String title){
            this.title = title;
        }
    }

    private static class Student implements Serializable{
        private int id;
        private String name;
        private int score;
        private Book book;

        public Student(int id, String name, int score){
            System.out.println("Student class constructor");
            this.id = id;
            this.name = name;
            this.score = score;
        }

        public void info(){
            System.out.println(id+" "+ name + " "+ score);
        }
    }

    public static void main(String[] args) {
        Student studentOneOut = new Student(1, "Sasha", 80);
        Student studentTwoOut = new Student(2, "Belka", 20);
        Book jungleBook = new Book("Jungle book");
        studentOneOut.book = jungleBook;
        studentTwoOut.book = jungleBook;

        try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("students.ser"))){
            objOut.writeObject(studentOneOut);
            objOut.writeObject(studentTwoOut);
        }catch (IOException e){
            e.printStackTrace();
        }

        Student studentOneIn = null;
        Student studentTwoIn = null;
        try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("students.ser"))){
            studentOneIn = (Student) objIn.readObject();
            studentTwoIn = (Student) objIn.readObject();
            studentOneIn.info();
            studentTwoIn.info();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(studentOneIn.book);
        System.out.println(studentTwoIn.book);
    }
}

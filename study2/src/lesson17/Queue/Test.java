package lesson17.Queue;

public class Test {
    public static void main(String[] args) {
        AnimalQueue queue = new AnimalQueue();
        Cat cat1 = new Cat("cat1");
        Dog dog1 = new Dog("dog1");
        Cat cat2 = new Cat("cat2");
        Dog dog2 = new Dog("dog2");
        Cat cat3 = new Cat("cat3");
        Dog dog3 = new Dog("dog3");
        Cat cat4 = new Cat("cat4");
        Dog dog4 = new Dog("dog4");
        queue.write(dog4);
        queue.write(cat1);
        queue.write(dog1);
        queue.write(cat2);
        queue.write(dog2);
        queue.write(cat3);
        queue.write(dog3);
        queue.write(cat4);

        System.out.println(queue.giveAway().name);
        System.out.println(queue.giveAwayCat().name);
        System.out.println(queue.giveAwayDog().name);
    }
}

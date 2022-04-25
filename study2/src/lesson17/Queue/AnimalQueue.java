package lesson17.Queue;

import java.util.LinkedList;

public class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;

    public void write(Animal a) {
        a.setOrder(order);
        order++;

        if (a instanceof Dog) dogs.addLast((Dog) a);
        else if (a instanceof Cat) cats.addLast((Cat) a);
    }

    public Animal giveAway() {
        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dogs.size() == 0) {
            return giveAwayCat();
        } else if (cats.size() == 0) return giveAwayDog();

        if(dog.isOlderThan(cat)){
            return giveAwayDog();
        } else return giveAwayCat();
    }

    public Cat giveAwayCat() {
        return cats.poll();
    }

    public Dog giveAwayDog() {
        return dogs.poll();
    }

}

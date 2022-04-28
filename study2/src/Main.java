public class Main {
    public static void main(String[] args) {

        Loser[] losers = new Loser[3];
        losers[0] = new Cat();
        losers[1] = new Human();
        losers[2] = new Robot();

        Obstacle[] obstacles = new Obstacle[2];
        obstacles[0] = new Wall();
        obstacles[1] = new Treadmill();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++){
                System.out.println( obstacles[j].pass(losers[i]));
            }
        }
    }
}

public class Robot implements Loser {
    private int jumpHeight = 50;
    private int runLenght = 10000;
    public String run(int i){
        if (i<runLenght)
            return "Робот бежит";
        else return "Робот сдох";
    };
    public String jump(int i){
        if (i<jumpHeight)
            return "Робот прыгает";
        else return "Робот разился";
    };
}

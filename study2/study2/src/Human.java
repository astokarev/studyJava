public class Human implements Loser {
    private int jumpHeight = 100;
    private int runLenght = 5000;
    public String run(int i){
        if (i<runLenght)
            return "Хуман бежит";
        else return "Хуман сдох";
    };
    public String jump(int i){
        if (i<jumpHeight)
            return "Хуман прыгает";
        else return "Хуман разился";
    };
}

public class Cat implements Loser {
    private int jumpHeight = 200;
    private int runLenght = 3000;
    public String run(int i){
        if (i<runLenght)
        return "Кот бежит";
        else return "Кот сдох";
    };
    public String jump(int i){
        if (i<jumpHeight)
            return "Кот прыгает";
        else return "Кот разился";
    };

}

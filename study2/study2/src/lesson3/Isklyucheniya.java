package lesson3;

import static java.lang.Integer.parseInt;

public class Isklyucheniya {

    public static String[][] generateArray() {
        int size = 4;
        String[][] arr = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = "1";
            }
        }
        return arr;
    }

    public static void main(String[] args) throws MyArraySizeException {
        String[][] arr2 = Isklyucheniya.generateArray();
        int sum = 0;

        if (arr2.length == 4 || arr2[0].length == 4) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    try {
                        int temp = Integer.parseInt(arr2[i][j]);
                        sum += temp;
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(" wrong data!" + i + " " + j);
                    }
                }
            }
            System.out.println(sum);
        } else throw new MyArraySizeException(" wrong array size!");

    }


}


class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(String message) {
        super(message);
    }
}


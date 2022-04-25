package lesson16;

public class Spaces {
    static String replaceSpaces(char[] input, int length){
        int spaceCount = 0;
        int newLength;
        String output;
        for(int i = 0; i<length; i++){
            if(input[i] == ' '){
                spaceCount++;
            }
        }
        newLength = length + spaceCount*3;
        char[] newInputArr = new char[newLength];
        newInputArr[newLength-1] = '\0';
        for (int i = length-1; i>= 0; i--){
            if(input[i] == ' '){
                newInputArr[newLength - 1] = '0';
                newInputArr[newLength - 2] = '2';
                newInputArr[newLength - 3] = '%';
            } else{
                newInputArr[newLength - 1] = input[i];
            }
        }
        output = newInputArr.toString();
        return output;
    }

    public static void main(String[] args) {
        String input = "Hello beutyfull world";
        input = replaceSpaces(input.toCharArray(), input.length());
        System.out.println(input);
    }
}

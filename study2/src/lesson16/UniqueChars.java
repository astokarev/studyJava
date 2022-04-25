package lesson16;

public class UniqueChars {
    static boolean hasUnique(String input){
        for(int i = 0; i<input.length(); i++){
            for (int j = 1; j<input.length();){
                if ((input.charAt(j) == input.charAt(i))&&(i !=j)) return false;
                else j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasUnique("inpunt"));
    }
}

package lesson16;

public class Palindrome {
    static boolean isPalindrome(String input){
        int[] table = buildCharTable(input);
        return checksym(table);
    }
    static boolean checksym(int[] table){
        boolean found = false;
        for (int count: table){
            if (count % 2 == 1){
                if(found){
                    return false;
                }
                found = true;
            }
        }
        return true;
    }
    static int getCharNumber(Character c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int A = Character.getNumericValue('A');
        int Z = Character.getNumericValue('a');

        int val = Character.getNumericValue(c);
        if(a<= val && val <= z){
            return val - a;
        } else if (A<=val && val<=Z){
            return val-A;
        }
        return -1;
    }

    static int[] buildCharTable(String input){
        int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
        for (char c: input.toCharArray()){
            int x = getCharNumber(c);
            if(x!=-1){
                table[x]++;
            }
        }
        return table;
    }

    public static void main(String[] args) {
        String text = "taco cat";
        System.out.println(isPalindrome(text));
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Words {
    public static void main(String[] args) {
        ArrayList<String> wordsList = new ArrayList<>();
        wordsList.add("У");
        wordsList.add("попа");
        wordsList.add("была");
        wordsList.add("собака");
        wordsList.add("он");
        wordsList.add("её");
        wordsList.add("любил");
        wordsList.add("собака");
        wordsList.add("он");
        wordsList.add("кусок");
        wordsList.add("мяса");
        wordsList.add("он");
        wordsList.add("её");
        wordsList.add("убил");

        //HashSet<String> unique = new HashSet<>();
        Iterator<String> iterator = wordsList.iterator();
        HashMap<String, Integer> repetative = new HashMap<>();
        for (String s : wordsList) {
            //int j = 1;
//            if (unique.contains(s)) {
//                j++;
//                repetative.put(s, j);
//            } else unique.add(s);
            if(repetative.containsKey(s)){
                int j = repetative.get(s);
                repetative.put(s, ++j);
            } else {
                repetative.put(s, 1);
            }
        }
        //System.out.println(unique);
        System.out.println(repetative);
    }
}

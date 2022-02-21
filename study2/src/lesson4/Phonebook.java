package lesson4;

import java.util.*;

public class Phonebook {
    private HashMap<String, String> phoneList = new HashMap<>();

    public void add(String name, String number) {
        phoneList.put(number, name);
    }

    public ArrayList get(String name) {
        ArrayList result = new ArrayList();
        List<String> keys = new ArrayList<>(phoneList.keySet());
        for (int i = 0; i < keys.size(); i++) {
            if (phoneList.get(keys.get(i)) == name) {
                result.add(keys.get(i));
            }
        }
        return result;
    }

    public void printAll() {
        Set<Map.Entry<String, String>> set = phoneList.entrySet();
        for (Map.Entry<String, String> me : set) {
            //System.out.println(me.getKey() + ": " + me.getValue());
            System.out.println(me.getValue() + ": " + get(me.getValue()));
        }
    }
}

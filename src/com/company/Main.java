package com.company;

import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String[]> dictionary = new HashMap<>();

        dictionary.put("деревня", new String[]{"Село", "аыйл", "кишлак", "аул"});
        dictionary.put("красивый", new String[]{"приятное", "симпотичное", "обоятельное"});
        dictionary.put("дом", new String[]{"жилище", "квартира", "шалаш", "логово"});
        dictionary.put("программист", new String[]{"хакер", "девелопер", "айтишник", "гик"});

        Map<String, String[]> bigDictionary = new HashMap<>();
        Set<String> keys = dictionary.keySet();
        Iterator<String> iter = keys.iterator();
        while (iter.hasNext()) {
            String k = iter.next();
            String[] v = dictionary.get(k);
            bigDictionary.put(k, v);
            for (int i = 0; i <v.length ; i++) {
                String bigKey = v[i];
                List <String> listValue = new ArrayList<>(v.length);
                listValue.addAll(Arrays.asList(v));
                listValue.set(i, k);
                String[] bigValue = new String[listValue.size()];
                listValue.toArray(bigValue);
                bigDictionary.put(bigKey, bigValue);
            }
        }
        for (Map.Entry<String, String[]> item: bigDictionary.entrySet()){
            System.out.println(item.getKey()+ " : " + Arrays.toString(item.getValue()));
        }


        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите слово из словаря");
            String word = sc.next();
            String[] synonym = dictionary.get(word);
            Random r = new Random();
            if (synonym != null) {
                int x = r.nextInt(synonym.length);
                System.out.println(synonym[x]);
            } else
                System.out.println("Такого слова в словаре нет");
        }
    }
}

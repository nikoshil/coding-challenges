package misc.collections.maps;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class _HashMap {

    public static void main(String[] args) {

        //  Map<K, V>
        Map<Integer, String> hashMap = new HashMap<>();

        System.out.println(hashMap.isEmpty());
        hashMap.put(1, "CCC");
        hashMap.put(5, "BBB");
        hashMap.put(4, "AAA");
        hashMap.put(2, "FFF");
        hashMap.put(3, "DDD");
        hashMap.put(6, "EEE");
        System.out.println(hashMap.isEmpty());

        System.out.println(hashMap);
        System.out.println(hashMap.size());

        System.out.println(hashMap.get(3));
        System.out.println(hashMap.get(2));

        System.out.println(hashMap.containsKey(3));
        System.out.println(hashMap.containsKey(9));

        System.out.println(hashMap.containsValue("CCC"));
        System.out.println(hashMap.containsValue("ZZZ"));

        // if the specific key entry exists its value will be overwritten:
        hashMap.put(3, "XXX");
        hashMap.put(9, "ZZZ");
        System.out.println(hashMap);
        // replace will execute only if the specific key entry exists:
        hashMap.replace(9, "YYY");
        hashMap.replace(8, "WWW");
        System.out.println(hashMap);
        // avoids data overwriting:
        hashMap.putIfAbsent(9, "RRR");
        hashMap.putIfAbsent(7, "RRR");
        System.out.println(hashMap);
        // remove an entry
        System.out.println(hashMap.remove(3, "XXX"));
        System.out.println(hashMap.remove(2));
        System.out.println(hashMap.remove(8));
        System.out.println(hashMap);

        System.out.println(hashMap.isEmpty());
        hashMap.clear();
        System.out.println(hashMap);
        System.out.println(hashMap.isEmpty());

        System.out.println();

        Map<Integer, Integer> data = new HashMap<>();
        data.put(1, 10);
        // .computeIfAbsent()
        data.computeIfAbsent(1, (key) -> key + 1);
        data.computeIfAbsent(2, (key) -> key + 2);
        System.out.println(data);
        // .computeIfPresent()
        System.out.println(data.computeIfPresent(1, (key, val) -> val + 1)); // print 11, MAP = (1: 11)
        System.out.println(data.computeIfPresent(3, (key, val) -> val + 1)); // null
        System.out.println(data.computeIfPresent(1, (key, val) -> null)); // remove key 1
        System.out.println(data.containsKey(1));  // false
        System.out.println(data);
        // .compute()
        // will throw a NullPointerException if the called entry is absent
        try {
            data.compute(2, (key, val) -> val + 1);
            data.compute(1, (key, val) -> null); // remove key 1
            data.compute(1, (key, val) -> val + 1); // print 11, MAP = (1: 11)
        } catch (NullPointerException e) {
            System.out.println("NullPointerException!");
        }
        System.out.println(data);  // false

        System.out.println();

        Map<Integer, String> elements = new HashMap<>();
        elements.put(1, "A");
        elements.put(2, "A");
        elements.put(3, "B");
        elements.put(4, "C");
        elements.put(5, "D");
        elements.put(6, "E");
        elements.put(7, "E");
        elements.put(8, "E");
        elements.put(9, "E");
        System.out.println(elements.keySet());
        System.out.println(elements.entrySet());
        System.out.println(elements.values());
        System.out.println(elements.getOrDefault(9, "ABC"));
        System.out.println(elements.getOrDefault(10, "XYZ"));

        System.out.println();

        // .merge()
        // If the specified key isn't already associated with a value, or the value is null, it associates the key with
        // the given value. Otherwise, it replaces the value with the results of the given remapping function.
        // If the result of the remapping function is null, it removes the result.
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1, "L");
        map1.put(2, "M");
        map1.put(3, "N");
        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1, "B");
        map2.put(2, "G");
        map2.put(3, "R");
        System.out.println("HashMap1: " + map1);
        System.out.println("HashMap2: " + map2);
        map2.forEach((key, value) -> map1.merge(key, value, (v1, v2) -> v1.equalsIgnoreCase(v2) ? v1 : v1 + ", " + v2));
        System.out.println("New HashMap: " + map1);
        // .putAll()
        // copies all the elements from one map into another
        map1.putAll(map2);
        System.out.println(map1.equals(map2));
        // .replaceAll()
        // replace values by applying a function onto them
        map1.replaceAll((key, oldValue)
                -> oldValue + " " + oldValue + " " + oldValue);
        System.out.println(map1.equals(map2));

        System.out.println();

        iterateUsingEntrySet(elements);
        iterateUsingKeySetAndForeach(elements);
        iterateUsingValues(elements);
        iterateUsingIteratorAndEntry(elements);
        iterateUsingIteratorAndValues(elements);
        iterateUsingLambda(elements);
        iterateUsingValuesAndLambda(elements);
        iterateUsingStreamAPI(elements);

        // AbstractMap abstract class - provides a base class for implementing custom map-like data structures
        AbstractMap<Integer, String> abstractMap = new HashMap<>();

    }

    public static void iterateUsingEntrySet(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
        }
        System.out.println();
    }

    public static void iterateUsingKeySetAndForeach(Map<Integer, String> map) {
        for (Integer key : map.keySet()) {
            System.out.print(key + ":" + map.get(key) + " ");
        }
        System.out.println();
    }

    public static void iterateUsingValues(Map<Integer, String> map) {
        for (String value : map.values()) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void iterateUsingIteratorAndEntry(Map<Integer, String> map) {
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
        }
        System.out.println();
    }

    public static void iterateUsingIteratorAndValues(Map<Integer, String> map) {
        Iterator<String> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void iterateUsingLambda(Map<Integer, String> map) {
        map.forEach((k, v) -> System.out.print((k + ":" + v) + " "));
        System.out.println();
    }

    public static void iterateUsingValuesAndLambda(Map<Integer, String> map) {
        map.values().forEach(v -> System.out.print((v) + " "));
        System.out.println();
    }

    public static void iterateUsingStreamAPI(Map<Integer, String> map) {
        map.entrySet().stream()
                .limit(100)
                .forEach(e -> System.out.print(e.getKey() + ":" + e.getValue() + " "));
        System.out.println();
    }

}

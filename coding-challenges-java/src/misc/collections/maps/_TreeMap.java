package misc.collections.maps;

import java.util.*;

public class _TreeMap {

    public static void main(String[] args) {

        // Map interface
        Map<Integer, String> treeMap = new TreeMap<>();

        // SortedMap interface
        SortedMap<Integer, String> sortedMap = new TreeMap<>();

        // NavigableMap interface
        NavigableMap<Integer, String> navigableMap = new TreeMap<>();

        // SortedMap
        // Provides a total ordering of its elements (elements can be traversed in sorted order of keys).
        // The elements in a SortedMap are stored in order determined by the natural order of the keys, which must
        // implement the java.lang.Comparable interface, or by a Comparator passed to the SortedMap’s constructor.
        System.out.println("*** SortedMap ***");
        sortedMap.put(8, "AAA");
        sortedMap.put(5, "BBB");
        sortedMap.put(7, "CCC");
        sortedMap.put(2, "DDD");
        sortedMap.put(4, "EEE");
        sortedMap.put(6, "FFF");
        sortedMap.put(1, "GGG");
        sortedMap.put(9, "HHH");
        sortedMap.put(3, "III");

        System.out.println("sorted by the natural order of keys:");
        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
            System.out.print(entry + " ");
        }

        System.out.println(".headMap(4)");
        for (Map.Entry<Integer, String> entry : sortedMap.headMap(4).entrySet()) {
            System.out.print(entry + " ");
        }

        System.out.println(".subMap(4, 6)");
        for (Map.Entry<Integer, String> entry : sortedMap.subMap(4, 6).entrySet()) {
            System.out.print(entry + " ");
        }

        System.out.println(".tailMap(6)");
        for (Map.Entry<Integer, String> entry : sortedMap.tailMap(6).entrySet()) {
            System.out.print(entry + " ");
        }

        // Custom sorting:
        TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(3, "val");
        map.put(2, "val");
        map.put(1, "val");
        map.put(5, "val");
        map.put(4, "val");
        System.out.println(map.keySet());

        System.out.println();
        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());

        // NavigableMap
        // An extension of SortedMap providing convenient navigation methods like lowerKey(), floorKey(), ceilingKey() and higherKey().
        // It also provides ways to create a sub-map from the existing headMap(), tailMap(), subMap().
        System.out.println("*** NavigableMap ***");

        navigableMap.put(8, "888");
        navigableMap.put(2, "222");
        navigableMap.put(9, "999");
        navigableMap.put(3, "333");
        navigableMap.put(7, "777");
        navigableMap.put(4, "444");
        navigableMap.put(1, "111");
        navigableMap.put(6, "666");
        navigableMap.put(5, "555");

        // Returns a key-value mapping associated with the least key greater than or equal to the given key, or null if there is no such key.
        System.out.println(navigableMap.ceilingEntry(3));
        // Returns the least key greater than or equal to the given key, or null if there is no such key.
        System.out.println(navigableMap.ceilingKey(3));
        // Returns a key-value mapping associated with the least key in this map, or null if the map is empty
        System.out.println(navigableMap.firstEntry());
        // Returns the first (lowest) key currently in this map.
        System.out.println(navigableMap.firstKey());
        // Returns a key-value mapping associated with the greatest key less than or equal to the given key, or null if there is no such key.
        System.out.println(navigableMap.floorEntry(3));
        // Returns the greatest key less than or equal to the given key, or null if there is no such key.
        System.out.println(navigableMap.floorKey(3));
        // Returns a key-value mapping associated with the least key strictly greater than the given key, or null if there is no such key.
        System.out.println(navigableMap.higherEntry(3));
        // Returns the least key strictly greater than the given key, or null if there is no such key.
        System.out.println(navigableMap.higherKey(3));
        // Returns a key-value mapping associated with the greatest key in this map, or null if the map is empty.
        System.out.println(navigableMap.lastEntry());
        // Returns the last (highest) key currently in this map.
        System.out.println(navigableMap.lastKey());
        // Removes and returns a key-value mapping associated with the least key in this map, or null if the map is empty.
        System.out.println(navigableMap.pollFirstEntry());
        // Removes and returns a key-value mapping associated with the greatest key in this map, or null if the map is empty.
        System.out.println(navigableMap.pollLastEntry());
        // Returns a reverse order NavigableSet view of the keys contained in this map.
        System.out.println(navigableMap.descendingKeySet());
        // Returns a reverse order view of the mappings contained in this map.
        System.out.println(navigableMap.descendingMap());

    }

}

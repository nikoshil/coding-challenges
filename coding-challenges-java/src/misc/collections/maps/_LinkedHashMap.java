package misc.collections.maps;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class _LinkedHashMap {

    public static void main(String[] args) {

        /*
        LinkedHashMap orders its entries according to how they're inserted into the map. It also guarantees that this
        order will be maintained throughout the life cycle of the map. Order is not affected if a key is re-inserted.
        The LinkedHashMap class is very similar to HashMap in most aspects, however it is based on both hash table and
        linked list to enhance the functionality of hash map. It maintains a doubly-linked list running through all its
        entries in addition to an underlying array of default size 16. To maintain the order of elements, the linked
        hashmap modifies the Map.Entry class of HashMap by adding pointers to the next and previous entries.
         */

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(16, .75f, true);
        // - initial capacity of the underlying array
        // - load factor
        // - access order (true turns on access-order, whereas the default is insertion-order)
        // Any explicit access operation on the map results in an order such that the element that was accessed would
        // appear last if an iteration were to be carried out right away. Building a Least Recently Used (LRU) cache is
        // quite easy and practical with this kind of map.

        // Concurrency:
        // Just like HashMap, the LinkedHashMap implementation is not synchronized. If it is going to be accessed from
        // multiple threads and at least one of these threads is likely to change it structurally, then it must be
        // externally synchronized:
        Map<Integer, Integer> synchronizedLinkedHashMap = Collections.synchronizedMap(new LinkedHashMap<>());

    }

}

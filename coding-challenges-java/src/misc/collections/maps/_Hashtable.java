package misc.collections.maps;

import java.util.*;

public class _Hashtable {

    public static void main(String[] args) {

        /*
        Both Hashtable and HashMap provide very similar functionality:
         - Fail-fast iteration
         - Unpredictable iteration order
        But there are some differences too:
         - HashMap doesn't provide any Enumeration, while Hashtable provides non fail-fast Enumeration
         - HashMap iterator is fail-safe where HashTable iterator is not fail-safe.
         - Hashtable doesn't allow null keys and null values, while HashMap do allow one null key and any number of
           null values
         - Hashtable methods are synchronized while HashMaps methods are not
         - HashMap is generally faster than HashTable.
         - HashMap extends AbstractMap class where HashTable extends Dictionary class.
         */

        Map<Integer, Integer> hashtable = new Hashtable<>();

        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(1, "one");
        table.put(2, "two");
        table.put(3, "three");
        table.put(4, "four");
        table.put(5, "five");
        table.put(6, "six");
        table.put(7, "seven");
        table.put(8, "eight");

        Enumeration<String> elements = table.elements();
        while (elements.hasMoreElements()) {
            System.out.print(elements.nextElement() + " ");
        }

        System.out.println();

        // The iteration order in a Hashtable is unpredictable and does not match the order in which the entries were
        // added. This is understandable as it calculates each index using the key's hash code. Moreover, rehashing
        // takes place from time to time, rearranging the order of the data structure.
        Iterator<Map.Entry<Integer, String>> iteration = table.entrySet().iterator();
        while (iteration.hasNext()) {
            Map.Entry<Integer, String> entry = iteration.next();
            System.out.print(entry + " ");
        }

        // Collisions and Load Factor
        // Different hash codes can produce the same index (collisions). To resolve them the Hashtable stores a LinkedList
        // of key-value pairs - a hash table with chaining.
        // Collisions slow down operations with elements. To get an entry it is not enough to know its index, but we need
        // to go through the list and perform a comparison with each item. Therefore, it's important to reduce the number
        // of collisions. The bigger the array is, the smaller the chance of a collision. The load factor determines the
        // balance between the array size and the performance. By default, it's 0.75 which means that the array size
        // doubles when 75% of the buckets become not empty. This operation is executed by rehash() method.

        // Dictionary abstract class - an older, legacy class that represents a key-value data structure but is generally
        // replaced by Map and its implementations in modern Java programming.
        Dictionary<Integer, String> dictionary = new Hashtable<>();

    }

}



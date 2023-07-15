package misc.collections.maps;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class _EnumMap {

    public static void main(String[] args) {

        EnumMap<DayOfWeek, String> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.MONDAY, "Soccer");
        enumMap.put(DayOfWeek.TUESDAY, "Basketball");
        System.out.println(enumMap);

        EnumMap<DayOfWeek, String> enumMapCopy = new EnumMap<>(enumMap);
        System.out.println(enumMapCopy);

        System.out.println();

        enumMap.put(DayOfWeek.WEDNESDAY, "Hiking");
        System.out.println(enumMap.containsKey(DayOfWeek.WEDNESDAY)); // true
        System.out.println(enumMap.containsKey(DayOfWeek.SATURDAY)); // false
        System.out.println(enumMap.containsValue(null)); // false

        System.out.println();

        System.out.println(enumMap.put(DayOfWeek.SATURDAY, "Yoga")); // null
        System.out.println(enumMap.remove(DayOfWeek.SATURDAY)); // Yoga
        System.out.println(enumMap.containsKey(DayOfWeek.SATURDAY)); // false

        System.out.println();

        System.out.println(enumMap.put(DayOfWeek.THURSDAY, "Soccer")); // null
        System.out.println(enumMap.remove(DayOfWeek.THURSDAY, "Hiking")); // false
        System.out.println(enumMap.remove(DayOfWeek.THURSDAY, "Soccer")); // true

        System.out.println();

        Collection<String> values = enumMap.values();
        Set<DayOfWeek> keys = enumMap.keySet();
        Set<Map.Entry<DayOfWeek, String>> entrySet = enumMap.entrySet();
        System.out.println(values);
        System.out.println(keys);
        System.out.println(entrySet);

        // Using Enum as key makes it possible to do some extra performance optimization, like a quicker hash computation
        // since all possible keys are known in advance. The simplicity of having enum as key means EnumMap only need to
        // be backed up by a plain old Java Array with very simple logic for storage and retrieval. On the other hand,
        // generic Map implementations need to cater for concerns related to having a generic object as its key.
        // For example, HashMap needs a complex data structure and a considerably more complex storing and retrieval logic
        // to cater for the possibility of hash collision. EnumMap is also an ordered map, in that its views will iterate
        // in enum order.

    }

}

enum DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
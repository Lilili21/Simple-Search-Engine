package search;

import java.util.HashSet;
import static search.Main.*;

public class Find {
    static HashSet<Integer> findPeople(String searchWord) {

        if (invertedIndex.containsKey(searchWord)) {
            return new HashSet<>(invertedIndex.get(searchWord));
        } else {
            return new HashSet<Integer>();
        }
    }
}

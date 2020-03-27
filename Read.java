package search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;

import static search.Main.*;

public class Read {

    static void readFile(String fileName) throws IOException {
        phoneBook = (ArrayList<String>) Files.readAllLines(Paths.get(fileName));
        fillInvertedIndexMap();
    }
    static void fillInvertedIndexMap() {
        String[] elemName;
        String elemLowerCase;

        for (int i = 0; i < phoneBook.size(); i++) {
            elemName = phoneBook.get(i).split("\\s");
            for (String elem : elemName) {
                elemLowerCase = elem.toLowerCase();
                if (invertedIndex.containsKey(elemLowerCase)) invertedIndex.get(elemLowerCase).add(i);
                else {
                    HashSet<Integer> tmp = new HashSet<>();
                    tmp.add(i);
                    invertedIndex.put(elemLowerCase, tmp);
                }
            }
        }
    }
}

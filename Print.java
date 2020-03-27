package search;

import java.util.HashSet;
import static search.Main.*;

public class Print {
    static void printFoundedPeople(HashSet<Integer> foundedStrings){
        if (foundedStrings.isEmpty()) System.out.println("No matching people found.");
        else {
            System.out.println(foundedStrings.size() + " persons found:");
            for (int num : foundedStrings) {
                System.out.println(phoneBook.get(num));
            }
        }
    }
    static void printMenu() {
        System.out.println("\n=== Menu ===" +
                "\n1. Find a person" +
                "\n2. Print all people" +
                "\n0. Exit");
    }
    static void printAllPeople() {
        System.out.println("=== List of people ===");
        for (String person : phoneBook) {
            System.out.println(person);
        }
        System.out.println();
    }
}

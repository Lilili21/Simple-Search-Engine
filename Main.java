package search;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.*;

import static search.Print.*;
import static search.Read.*;

public class Main {

    static Scanner scanner  = new Scanner(System.in);
    static ArrayList<String> phoneBook;
    static Map<String, HashSet<Integer>> invertedIndex = new HashMap<>();

    public static void main(@NotNull String[] args) throws IOException {
        boolean exitParam;

        if (args[0].equals("--data")) {

            readFile(args[1]);
            exitParam = true;
            while (exitParam) {
                printMenu();
                switch (scanner.nextLine()) {
                    case ("1") :
                        System.out.println("Select a matching strategy: ALL, ANY, NONE");
                        Search search = new Search();
                        switch (scanner.nextLine()) {
                            case("ANY"):
                                search.setStrategy(new SearchAny());
                                break;
                            case("ALL"):
                                search.setStrategy(new SearchAll());
                                break;
                            case("NONE"):
                                search.setStrategy(new SearchNone());
                                break;
                            default:
                                System.out.println("Incorrect option! Try again.");
                                continue;
                        }
                        System.out.println("Enter a name or email to search all suitable people.");
                        search.findPrint(scanner.nextLine().split("\\s"));
                        break;
                    case ("2") :
                        printAllPeople();
                        break;
                    case ("0") :
                        System.out.print("Bye!");
                        exitParam = false;
                        break;
                    default:
                        System.out.println("Incorrect option! Try again.");
                }
            }
        }
    }
}

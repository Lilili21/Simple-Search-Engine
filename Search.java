package search;

import java.util.Arrays;
import java.util.HashSet;

import static search.Find.*;
import static search.Main.phoneBook;
import static search.Print.printFoundedPeople;

class Search {
    private SearchingStrategy strategy;

    public void setStrategy(SearchingStrategy strategy) {
        this.strategy = strategy;
    }

    public void findPrint(String[] people) {
        strategy.findPrint(people);
    }
}

class SearchAny implements SearchingStrategy{
    @Override
    public void findPrint(String[] people) {
        HashSet<Integer> result = new HashSet<>();
        HashSet<Integer> search;

        for (String person : people) {
            search = findPeople(person.toLowerCase());
            System.out.println(search);
            result.addAll(search);
            System.out.println(result);
        }
        printFoundedPeople(result);
    }
}

class SearchAll implements SearchingStrategy{
    @Override
    public void findPrint(String[] people) {
        HashSet<Integer> firstSearch;
        HashSet<Integer> search;

        firstSearch = findPeople(people[0].toLowerCase());
        for (String person : people) {
            search = findPeople(person.toLowerCase());
            firstSearch.retainAll(search);
        }
        printFoundedPeople(firstSearch);
    }
}

class SearchNone implements SearchingStrategy{
    @Override
    public void findPrint(String[] people) {
        HashSet<Integer> result = new HashSet<>();
        HashSet<Integer> search;

        for (int i = 0; i < phoneBook.size(); i++) {
            result.add(i);
        }
        System.out.println(result);
        for (String person : people) {
            search = findPeople(person.toLowerCase());
            result.removeAll(search);
        }
        printFoundedPeople(result);
    }
}
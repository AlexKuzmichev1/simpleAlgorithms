package GraphsTasks;

import org.jgrapht.Graph;

import java.util.*;

public class BreadthSearchAlgorithm {

    public boolean searchInBreadth(Graph names, String condition) {
        boolean result = false;
        ArrayDeque<String> searchQueue = new ArrayDeque();
        searchQueue.addAll(names.vertexSet());
        //searchQueue.addAll(Collections.singleton(names));
        ArrayList<String> searched = new ArrayList<>();
        for (String name : searchQueue) {
            //Object person = name;
            if (!searched.contains(name)) {
                if (isSeller(String.valueOf(name), condition)) {
                    System.out.println(name + " is a mango seller!");
                    result = true;
                } else {
                    searchQueue.addLast(name);
                    searched.add(name);
                }
            }
        }
        return result;
    }

    private boolean isSeller(String person, String condition) {
        return person.contains(condition);
    }
}

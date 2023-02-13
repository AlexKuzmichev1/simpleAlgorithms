package GraphsTasks;

import org.jgrapht.Graph;
import java.util.*;

public class BreadthFirstSearchAlgorithm {

    public boolean searchInBreadth(Graph names, String condition, String conditionTrueMessage) {
        boolean result = false;
        ArrayDeque<String> searchQueue = new ArrayDeque();
        searchQueue.addAll(names.vertexSet());
        ArrayList<String> searched = new ArrayList<>();
        for (String name : searchQueue) {
            if (!searched.contains(name)) {
                if (isConditionOk(String.valueOf(name), condition)) {
                    System.out.println(name + conditionTrueMessage);
                    result = true;
                } else {
                    searchQueue.addLast(name);
                    searched.add(name);
                }
            }
        }
        return result;
    }

    private boolean isConditionOk(String person, String condition) {
        return person.contains(condition);
    }
}

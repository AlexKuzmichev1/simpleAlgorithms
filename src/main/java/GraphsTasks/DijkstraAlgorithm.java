package GraphsTasks;

import Models.DijkstraConditionModel;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import static Utils.JsonUtils.JsonManager.gsonModelParser;
import static Utils.JsonUtils.Paths.FilePaths.DIJKSTRA_CONDITION_FILEPATH;

public class DijkstraAlgorithm {

    private static final DijkstraConditionModel DIJKSTRA_CONDITION = (DijkstraConditionModel)
            gsonModelParser(DIJKSTRA_CONDITION_FILEPATH, DijkstraConditionModel.class);

    public void searchCheapestRoute(SimpleDirectedWeightedGraph graph) {
        System.out.println(String.format(DIJKSTRA_CONDITION.getConditionMessage(), DIJKSTRA_CONDITION.getStartPoint(),
                DIJKSTRA_CONDITION.getEndPoint()));
        System.out.println(DijkstraShortestPath.findPathBetween(graph, DIJKSTRA_CONDITION.getStartPoint(),
                DIJKSTRA_CONDITION.getEndPoint()));
    }
}

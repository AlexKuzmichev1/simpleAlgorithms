import ApproxiAlgoTasks.GreedyAlgorithm;
import GraphsTasks.BreadthFirstSearchAlgorithm;
import GraphsTasks.DijkstraAlgorithm;
import Models.BFSConditionModel;
import Utils.GraphUtils.GraphManager;
import static Utils.JsonUtils.JsonManager.gsonModelParser;
import static Utils.JsonUtils.Paths.FilePaths.BFS_CONDITION_FILEPATH;

public class Start {

    private static final BFSConditionModel BFS_CONDITION = (BFSConditionModel) gsonModelParser(BFS_CONDITION_FILEPATH, BFSConditionModel.class);

    public static void main(String[] args) {
        var breadthSearchAlgorithm = new BreadthFirstSearchAlgorithm();
        breadthSearchAlgorithm.searchInBreadth(
                GraphManager.generateGraph(),
                BFS_CONDITION.getCondition(),
                BFS_CONDITION.getConditionSuccessfulMessage()
        );

        var dijkstraAlgorithm = new DijkstraAlgorithm();
        dijkstraAlgorithm.searchCheapestRoute(GraphManager.generateWeightedGraph());

        var greedyAlgorithm = new GreedyAlgorithm();
        System.out.println(greedyAlgorithm.findBestCoveredRadioStations());
    }
}

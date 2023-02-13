import GraphsTasks.BreadthFirstSearchAlgorithm;
import Models.BFSConditionModel;
import Utils.GraphUtils.GraphManager;
import Utils.GraphUtils.WeightedGraphManager;

import static Utils.JsonUtils.JsonManager.gsonModelParser;
import static Utils.JsonUtils.Paths.FilePaths.BFS_CONDITION_FILEPATH;

public class Start {

    private static final BFSConditionModel BFS_CONDITION = (BFSConditionModel) gsonModelParser(BFS_CONDITION_FILEPATH, BFSConditionModel.class);

    public static void main(String[] args) {
        BreadthFirstSearchAlgorithm breadthSearchAlgorithm = new BreadthFirstSearchAlgorithm();
        breadthSearchAlgorithm.searchInBreadth(
                GraphManager.generateGraph(),
                BFS_CONDITION.getCondition(),
                BFS_CONDITION.getConditionSuccessfulMessage()
        );

        WeightedGraphManager.generateWeightedGraph();
    }
}

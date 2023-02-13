package Tests;

import GraphsTasks.BreadthFirstSearchAlgorithm;
import Models.BFSConditionModel;
import Utils.GraphUtils.GraphManager;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Utils.JsonUtils.JsonManager.gsonModelParser;
import static Utils.JsonUtils.Paths.FilePaths.BFS_CONDITION_FILEPATH;

public class BreadthFirstSearchTest {

    private static final BFSConditionModel BFS_CONDITION_TO_CHECK = (BFSConditionModel) gsonModelParser(
            BFS_CONDITION_FILEPATH,
            BFSConditionModel.class
    );
    private static final BreadthFirstSearchAlgorithm BREADTH_FIRST_SEARCH_ALGORITHM = new BreadthFirstSearchAlgorithm();

    @Test
    public void graphReadingTest() {
        Graph<String, DefaultEdge> graphToCheck = new SimpleGraph<>(DefaultEdge.class);
        Assert.assertFalse(BREADTH_FIRST_SEARCH_ALGORITHM.searchInBreadth(
                graphToCheck, BFS_CONDITION_TO_CHECK.getCondition(),
                BFS_CONDITION_TO_CHECK.getConditionSuccessfulMessage()),
                "There is some problem with graph reading"
        );
    }

    @Test
    public void graphDataValidTest() {
        Assert.assertFalse(BREADTH_FIRST_SEARCH_ALGORITHM.searchInBreadth(
                GraphManager.generateGraph(), BFS_CONDITION_TO_CHECK.getFailureCondition(),
                BFS_CONDITION_TO_CHECK.getConditionSuccessfulMessage()),
                "There is some problem with graph data"
        );
    }
}

package Tests;

import Models.GraphModel;
import Models.GraphWeightsModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Utils.GraphUtils.GraphManager.generateWeightedGraph;
import static Utils.JsonUtils.JsonManager.gsonModelParser;
import static Utils.JsonUtils.Paths.FilePaths.GRAPH_FILEPATH;
import static Utils.JsonUtils.Paths.FilePaths.GRAPH_WEIGHTS_FILEPATH;

public class DijkstraAlgorithmTest {

    private static final GraphModel GRAPH_MODEL = (GraphModel)
            gsonModelParser(GRAPH_FILEPATH, GraphModel.class);
    private static final GraphWeightsModel GRAPH_WEIGHTS = (GraphWeightsModel)
            gsonModelParser(GRAPH_WEIGHTS_FILEPATH, GraphWeightsModel.class);

    @Test
    public void graphVertexValidTest() {
        Assert.assertTrue(generateWeightedGraph().containsVertex(GRAPH_MODEL.getAlice()),
                "Vertex data is not correct");
        Assert.assertTrue(generateWeightedGraph().containsVertex(GRAPH_MODEL.getAnuj()),
                "Vertex data is not correct");
        Assert.assertTrue(generateWeightedGraph().containsVertex(GRAPH_MODEL.getJonny()),
                "Vertex data is not correct");
    }

    @Test
    public void graphEdgeValidTest() {
        Assert.assertEquals(generateWeightedGraph().getEdge(GRAPH_MODEL.getYou(), GRAPH_MODEL.getBob()).toString(),
                String.format("(%s : %s)", GRAPH_MODEL.getYou(), GRAPH_MODEL.getBob()),
                "Edge data is not correct");
    }

    @Test
    public void graphWeightsValidTest() {
        Object edge = generateWeightedGraph().getEdge(GRAPH_MODEL.getYou(), GRAPH_MODEL.getBob());
        int edgeWeight = (int) generateWeightedGraph().getEdgeWeight(edge);
        Assert.assertEquals(edgeWeight, GRAPH_WEIGHTS.getYouToBob(), "Weights data is not correct");
    }
}

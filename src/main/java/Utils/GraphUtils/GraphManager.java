package Utils.GraphUtils;

import Models.GraphModel;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import static Utils.JsonUtils.JsonManager.gsonModelParser;
import static Utils.JsonUtils.Paths.FilePaths.BFS_GRAPH_FILEPATH;

public class GraphManager {

    private static final GraphModel GRAPH_MODEL = (GraphModel) gsonModelParser(BFS_GRAPH_FILEPATH, GraphModel.class);

    public static Graph generateGraph() {
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        String you = GRAPH_MODEL.getYou();
        String alice = GRAPH_MODEL.getAlice();
        String bob = GRAPH_MODEL.getBob();
        String claire = GRAPH_MODEL.getClaire();
        String anuj = GRAPH_MODEL.getAnuj();
        String peggy = GRAPH_MODEL.getPeggy();
        String thom = GRAPH_MODEL.getThom();
        String jonny = GRAPH_MODEL.getJonny();

        graph.addVertex(you);
        graph.addVertex(alice);
        graph.addVertex(bob);
        graph.addVertex(claire);
        graph.addVertex(anuj);
        graph.addVertex(peggy);
        graph.addVertex(thom);
        graph.addVertex(jonny);

        graph.addEdge(you, alice);
        graph.addEdge(you, bob);
        graph.addEdge(you, claire);
        graph.addEdge(bob, anuj);
        graph.addEdge(bob, peggy);
        graph.addEdge(alice, peggy);
        graph.addEdge(claire, thom);
        graph.addEdge(claire, jonny);

        return graph;
    }
}

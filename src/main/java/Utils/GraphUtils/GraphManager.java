package Utils.GraphUtils;

import Models.GraphModel;
import Models.GraphWeightsModel;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleGraph;
import static Utils.JsonUtils.JsonManager.gsonModelParser;
import static Utils.JsonUtils.Paths.FilePaths.GRAPH_FILEPATH;
import static Utils.JsonUtils.Paths.FilePaths.GRAPH_WEIGHTS_FILEPATH;

public class GraphManager {

    private static final GraphModel GRAPH_MODEL = (GraphModel) gsonModelParser(GRAPH_FILEPATH, GraphModel.class);
    private static final GraphWeightsModel GRAPH_WEIGHTS = (GraphWeightsModel)
            gsonModelParser(GRAPH_WEIGHTS_FILEPATH, GraphWeightsModel.class);

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

    public static SimpleDirectedWeightedGraph generateWeightedGraph() {
        SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
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

        DefaultWeightedEdge youToAlice = graph.addEdge(you, alice);
        graph.setEdgeWeight(youToAlice, GRAPH_WEIGHTS.getYouToAlice());

        DefaultWeightedEdge youToBob = graph.addEdge(you, bob);
        graph.setEdgeWeight(youToBob, GRAPH_WEIGHTS.getYouToBob());

        DefaultWeightedEdge youToClaire = graph.addEdge(you, claire);
        graph.setEdgeWeight(youToClaire, GRAPH_WEIGHTS.getYouToAlice());

        DefaultWeightedEdge bobToAnuj = graph.addEdge(bob, anuj);
        graph.setEdgeWeight(bobToAnuj, GRAPH_WEIGHTS.getBobToAnuj());

        DefaultWeightedEdge bobToPeggy = graph.addEdge(bob, peggy);
        graph.setEdgeWeight(bobToPeggy, GRAPH_WEIGHTS.getBobToPeggy());

        DefaultWeightedEdge aliceToPeggy = graph.addEdge(alice, peggy);
        graph.setEdgeWeight(aliceToPeggy, GRAPH_WEIGHTS.getAliceToPeggy());

        DefaultWeightedEdge claireToThom = graph.addEdge(claire, thom);
        graph.setEdgeWeight(claireToThom, GRAPH_WEIGHTS.getClaireToThom());

        DefaultWeightedEdge claireToJonny = graph.addEdge(claire, jonny);
        graph.setEdgeWeight(claireToJonny, GRAPH_WEIGHTS.getClaireToJonny());

        return graph;
    }
}

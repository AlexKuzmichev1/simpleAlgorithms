package Utils.GraphUtils;

import Models.GraphModel;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleGraph;

import java.util.List;

import static Utils.JsonUtils.JsonManager.gsonModelParser;
import static Utils.JsonUtils.Paths.FilePaths.BFS_GRAPH_FILEPATH;

public class WeightedGraphManager {

    private static final GraphModel GRAPH_MODEL = (GraphModel) gsonModelParser(BFS_GRAPH_FILEPATH, GraphModel.class);

    public static void generateWeightedGraph() {
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
        graph.setEdgeWeight(youToAlice, 5);

        DefaultWeightedEdge youToBob = graph.addEdge(you, bob);
        graph.setEdgeWeight(youToBob, 3);

        DefaultWeightedEdge youToClaire = graph.addEdge(you, claire);
        graph.setEdgeWeight(youToClaire, 6);

        DefaultWeightedEdge bobToAnuj = graph.addEdge(bob, anuj);
        graph.setEdgeWeight(bobToAnuj, 2);

        DefaultWeightedEdge bobToPeggy = graph.addEdge(bob, peggy);
        graph.setEdgeWeight(bobToPeggy, 4);

        DefaultWeightedEdge aliceToPeggy = graph.addEdge(alice, peggy);
        graph.setEdgeWeight(aliceToPeggy, 9);

        DefaultWeightedEdge claireToThom = graph.addEdge(claire, thom);
        graph.setEdgeWeight(claireToThom, 1);

        DefaultWeightedEdge claireToJonny = graph.addEdge(claire, jonny);
        graph.setEdgeWeight(claireToJonny, 2);

        System.out.println("Shortest path from me to peggy:");
        System.out.println(DijkstraShortestPath.findPathBetween(graph, you, peggy));


    }
}

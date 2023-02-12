import GraphsTasks.BreadthSearchAlgorithm;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.HashMap;

public class Start {

    public static void main(String[] args) {
        Graph<String, DefaultEdge> graph = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
        String you = "you";
        String alice = "alice";
        String bob = "bob";
        String claire = "claire";
        String anuj = "anuj";
        String peggy = "peggy";
        String thom = "thom";
        String jonny = "jonny";

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

        BreadthSearchAlgorithm breadthSearchAlgorithm = new BreadthSearchAlgorithm();
        breadthSearchAlgorithm.searchInBreadth(graph, "e");
    }
}

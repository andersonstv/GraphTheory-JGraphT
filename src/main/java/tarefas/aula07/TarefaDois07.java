package tarefas.aula07;

import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.BFSShortestPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.util.SupplierUtil;
import util.*;

public class TarefaDois07 {
    private static final String sep = System.getProperty("file.separator");
    private static final String graphpathname = "." + sep + "src" + sep + "main" + sep +"java" + sep + "graphs" + sep;

    public static void main(String[] args) {
        Graph<DefaultVertex, DefaultWeightedEdge> graph = new SimpleWeightedGraph<DefaultVertex, DefaultWeightedEdge>(
                VertexEdgeUtil.createDefaultVertexSupplier(),
                SupplierUtil.createDefaultWeightedEdgeSupplier());
        ImportUtil.importWeightedGraphCSV(graph, graphpathname + "weightededgelist.csv", false);

        ShortestPathAlgorithm<DefaultVertex, DefaultWeightedEdge> shortestPath = new DijkstraShortestPath<>(graph);
        ShortestPathAlgorithm<DefaultVertex, DefaultWeightedEdge> smallestPath = new BFSShortestPath<>(graph);

        DefaultVertex e = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(), "e");
        DefaultVertex f = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(), "f");

        System.out.println(shortestPath.getPath(e, f).getVertexList());
        System.out.println(smallestPath.getPath(e, f).getVertexList());
    }
}

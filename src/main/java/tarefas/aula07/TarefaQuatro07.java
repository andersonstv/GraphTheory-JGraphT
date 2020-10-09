package tarefas.aula07;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.nio.csv.CSVFormat;
import org.jgrapht.util.SupplierUtil;
import util.*;

public class TarefaQuatro07 {
    private static final String sep = System.getProperty("file.separator");
    private static final String graphpathname = "." + sep + "src" + sep + "main" + sep +"java" + sep + "graphs" + sep;

    public static void main(String[] args) {
        Graph<DefaultVertex, DefaultWeightedEdge> graph = new DefaultDirectedWeightedGraph<>(
                VertexEdgeUtil.createDefaultVertexSupplier(),
                SupplierUtil.createDefaultWeightedEdgeSupplier()
                );
        ImportUtil.importWeightedGraphCSV(
                graph,
                graphpathname + "csv-weighted-example.txt",
                CSVFormat.MATRIX,
                false,
                true,
                true
        );
        PrintUtil.printWeightedGraph(graph, "Grafo: ");

        AllDirectedPaths<DefaultVertex, DefaultWeightedEdge> paths = new AllDirectedPaths<>(graph);
        for (DefaultVertex v1 : graph.vertexSet()) {
            for (DefaultVertex v2 : graph.vertexSet()) {
                System.out.println("Paths from " + v1 + " to " + v2);
                printPaths(paths, v1, v2);
            }
        }
    }
    public static void printPaths(AllDirectedPaths<DefaultVertex, DefaultWeightedEdge> paths, DefaultVertex v1, DefaultVertex v2){
        for (GraphPath<DefaultVertex, DefaultWeightedEdge> p : paths.getAllPaths(v1, v2, true, null)) {
            System.out.println(p.getVertexList() + " " + p.getWeight());
        }
    }

}

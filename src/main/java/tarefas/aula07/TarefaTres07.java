package tarefas.aula07;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.tour.HamiltonianCycleAlgorithmBase;
import org.jgrapht.alg.tour.PalmerHamiltonianCycle;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.nio.csv.CSVFormat;
import org.jgrapht.util.SupplierUtil;
import util.DefaultVertex;
import util.ImportUtil;
import util.PrintUtil;
import util.VertexEdgeUtil;

public class TarefaTres07 {
    private static final String sep = System.getProperty("file.separator");
    private static final String graphpathname = "." + sep + "src" + sep + "main" + sep +"java" + sep + "graphs" + sep;

    public static void main(String[] args) {
        Graph<DefaultVertex, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(
                VertexEdgeUtil.createDefaultVertexSupplier(),
                SupplierUtil.createDefaultWeightedEdgeSupplier());
        ImportUtil.importWeightedGraphCSV(graph, graphpathname + "hamiltonian.csv", CSVFormat.MATRIX, false, true, true);
        PrintUtil.printWeightedGraph(graph, "Grafo Hamiltoniano");

        HamiltonianCycleAlgorithmBase<DefaultVertex, DefaultWeightedEdge> hamilton = new PalmerHamiltonianCycle<>();
        GraphPath<DefaultVertex, DefaultWeightedEdge> ciclosHamilton = hamilton.getTour(graph);
        System.out.println("Ciclo Hamiltoniano: " + ciclosHamilton);

        double weight = 0;
        for (DefaultWeightedEdge e : ciclosHamilton.getEdgeList()) {
            weight += graph.getEdgeWeight(e);
        }
        System.out.println("Peso: " + weight);
    }
}

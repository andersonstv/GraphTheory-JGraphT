package tarefas.aula07;

import org.jgrapht.Graph;
import org.jgrapht.graph.DirectedMultigraph;
import org.jgrapht.graph.Multigraph;
import org.jgrapht.graph.Pseudograph;
import util.*;

public class TarefaUm07 {
    private static final String sep = System.getProperty("file.separator");
    private static final String graphpathname = "." + sep + "src" + sep + "main" + sep +"java" + sep + "graphs" + sep;

    public static void main(String[] args) {
        Graph<DefaultVertex, RelationshipDirectedEdge> graph = new DirectedMultigraph<>(
                VertexEdgeUtil.createDefaultVertexSupplier(),
                VertexEdgeUtil.createRelationshipDirectedEdgeSupplier(), false);
        ImportUtil.importDirectedGraphGML(graph, graphpathname + "strongly3.gml");
        System.out.println(graph.edgeSet());
    }
}

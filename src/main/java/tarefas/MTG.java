package tarefas;

import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.util.SupplierUtil;
import util.DefaultVertex;
import util.RelationshipEdge;
import util.VertexEdgeUtil;

public class MTG {
    public static void main(String[] args) {
        Graph<DefaultVertex, DefaultEdge> graph = new SimpleGraph<>(
                VertexEdgeUtil.createDefaultVertexSupplier(),
                SupplierUtil.createDefaultEdgeSupplier());
        DefaultVertex a = new DefaultVertex("a");
        DefaultVertex b = new DefaultVertex("b");
        DefaultVertex c = new DefaultVertex("c");
        DefaultVertex d = new DefaultVertex("d");
        DefaultVertex e = new DefaultVertex("e");
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);

        graph.addEdge(a,c);
        graph.addEdge(a, b);
        graph.addEdge(b, c);
        graph.addEdge(b, d);
        graph.addEdge(b, e);
        graph.addEdge(c, e);
        graph.addEdge(c, d);

        ConnectivityInspector<DefaultVertex, DefaultEdge> ci = new ConnectivityInspector<>(graph);

        System.out.println(ci.);
    }
}

package classexamples;

import org.jgrapht.Graph;
import org.jgrapht.GraphTests;
import org.jgrapht.alg.connectivity.BiconnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.util.SupplierUtil;

import util.DefaultVertex;
import util.DrawUtil;
import util.ImportUtil;
import util.VertexEdgeUtil;

public class Aula17SeparationAndOrientation {

	public static void main(String[] args) {

		Graph<DefaultVertex, DefaultEdge> graph = 
				new SimpleGraph <> (VertexEdgeUtil.createDefaultVertexSupplier(), 
						SupplierUtil.createDefaultEdgeSupplier(), false);
		graph = ImportUtil.importDefaultGraphGML(graph, "./src/main/java/graphs/cubo.gml");
		DrawUtil.createAndShowGui(graph, "Graph", false, true, true, true, DrawUtil.layout_type.HIERARCHICAL);
		
		System.out.println("Is biconnected (non-separable)?  " +
		                     GraphTests.isBiconnected(graph));
		
		BiconnectivityInspector <DefaultVertex,DefaultEdge> insp =
				new BiconnectivityInspector <> (graph);
		System.out.println("Has strong orientation? " + insp.getBridges().isEmpty());

	}

}

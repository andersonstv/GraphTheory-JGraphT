// Teoria dos Grafos - UFCG
// Importa um grafo simples, sem labels (rótulos) nas arestas, a partir de um arquivo no formato CSV

package examples;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.nio.csv.CSVFormat;
import org.jgrapht.util.SupplierUtil;

public class Aula04ImportSimpleGraphMatrixCSV {

	public static void main(String[] args) {
		
		Graph<DefaultVertex, DefaultEdge> graph = 
				new SimpleGraph <> (MyJGraphTUtil.createDefaultVertexSupplier(), SupplierUtil.createDefaultEdgeSupplier(), false);
				
		graph = MyJGraphTUtil.importGraphCSV(
				graph, 
				"./src/main/java/graphs/5-3regular.csv",
				CSVFormat.MATRIX, 
				false,
				false,
				true); // MATRIX_FORMAT_NODEID
		
		System.out.println("Vertices: " + graph.vertexSet());
		System.out.println("Arestas: " + graph.edgeSet());
	}
}

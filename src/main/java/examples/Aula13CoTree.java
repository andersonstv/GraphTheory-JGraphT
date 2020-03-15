package examples;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.util.SupplierUtil;

public class Aula13CoTree {
	
	public static void main(String[] args) {
		
		Graph<DefaultVertex, DefaultEdge> basegraph = 
				new SimpleGraph <> (MyJGraphTUtil.createDefaultVertexSupplier(), SupplierUtil.createDefaultEdgeSupplier(), false);
		basegraph = MyJGraphTUtil.importDefaultGraphGML(basegraph, "./src/main/java/graphs/cubo.gml");
		
		Graph<DefaultVertex, DefaultEdge> tree = new SimpleGraph<>(RelationshipEdge.class);
		tree = MyJGraphTUtil.importDefaultGraphGML(tree, "./src/main/java/graphs/cubo-spanningtree.gml");
		
		Graph<DefaultVertex, DefaultEdge> coTree = new SimpleGraph<>(DefaultEdge.class);
		
		if (MyTreeUtil.testSpanningTree(basegraph, tree)) {
			MyTreeUtil.getcoTree(coTree,basegraph,tree);
			MyJGraphTUtil.printGraph(basegraph, "Base Graph");
			MyJGraphTUtil.printGraph(tree, "Spanning Tree");
			MyJGraphTUtil.printGraph(coTree, "coTree");
			
		}

	}
	




}

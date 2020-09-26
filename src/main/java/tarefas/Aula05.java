package tarefas;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.GraphTests;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.cycle.PatonCycleBase;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.YenKShortestPath;
import org.jgrapht.alg.util.NeighborCache;
import org.jgrapht.generate.ComplementGraphGenerator;
import org.jgrapht.generate.RandomRegularGraphGenerator;
import org.jgrapht.graph.*;
import org.jgrapht.util.SupplierUtil;
import util.*;

import javax.management.relation.Relation;
import java.util.*;

public class Aula05 {
    private static final String sep = System.getProperty("file.separator");
    private static final String graphpathname = "." + sep + "src" + sep + "main" + sep +"java" + sep + "graphs" + sep;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //tarefa01();
        //tarefa01pt2();
        //tarefa02();
        //tarefa03();
        //tarefa04();
        tarefa05();
    }
    static void tarefa01(){
        Graph<DefaultVertex, RelationshipDirectedEdge> pseudographgml = new Pseudograph<DefaultVertex, RelationshipDirectedEdge>(
                VertexEdgeUtil.createDefaultVertexSupplier(),
                VertexEdgeUtil.createRelationshipDirectedEdgeSupplier(), false);
        ImportUtil.importDirectedGraphGML(pseudographgml, graphpathname + "pseudograph-Aula02.gml");

        printMatrix(pseudographgml);
    }
    static void tarefa01pt2(){
        Graph<DefaultVertex, RelationshipDirectedEdge> graph = new DirectedMultigraph<>(
                VertexEdgeUtil.createDefaultVertexSupplier(),
                VertexEdgeUtil.createRelationshipDirectedEdgeSupplier(), false);
        ImportUtil.importDirectedGraphGML(graph, graphpathname + "cycle5.gml");

        printMatrix(graph);
    }
    static void tarefa02(){
        Graph<DefaultVertex, RelationshipEdge> graphCycle = new SimpleGraph<>(
                VertexEdgeUtil.createDefaultVertexSupplier(),
                VertexEdgeUtil.createRelationshipEdgeSupplier(), false);
        ImportUtil.importGraphGML(graphCycle, graphpathname + "cycle5.gml");
        printComplement(graphCycle);

        Graph<DefaultVertex, RelationshipEdge> graphK5 = new SimpleGraph<>(
                VertexEdgeUtil.createDefaultVertexSupplier(),
                VertexEdgeUtil.createRelationshipEdgeSupplier(), false);
        ImportUtil.importGraphGML(graphK5, graphpathname + "K5.gml");
        printComplement(graphK5);
    }
    static void tarefa03(){
        Graph<String, DefaultEdge> xnet = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
        sc.nextLine();
        boolean endTable = false;
        String[] temp;
        while (!endTable){
            temp = sc.nextLine().split("\\s+");
            if( temp[0].equals("------------------------------")){
                endTable = true;
            } else {
                xnet.addVertex(temp[0]);
                xnet.addVertex(temp[2]);
                xnet.addEdge(temp[0], temp[2]);
            }
        }
        boolean finishedQuery = false;
        while (!finishedQuery){
            temp = sc.nextLine().split(" ");
            if (temp[0].equals("end")){
                finishedQuery = true;
            } else {
                String person1 = temp[0];
                String person2 = temp[1];

                friendTable(xnet, person1, person2);
            }
        }
    }
    static void tarefa04(){
        Graph<DefaultVertex, RelationshipEdge> graph = new SimpleGraph<>(
                VertexEdgeUtil.createDefaultVertexSupplier(),
                VertexEdgeUtil.createRelationshipEdgeSupplier(), false);

        String filename = sc.nextLine();
        ImportUtil.importGraphGML(graph, graphpathname + filename);

        if(GraphTests.isBipartite(graph)){
            findPartitions(graph);
        } else{
            System.out.println("Não é bipartido");
        }

    };
    static void tarefa05(){
        int n = sc.nextInt();
        int d = sc.nextInt();
        sc.nextLine();
        RandomRegularGraphGenerator<DefaultVertex, RelationshipEdge> graphGenerator= new RandomRegularGraphGenerator<>(n, d);
        Graph<DefaultVertex, RelationshipEdge> graph = new SimpleGraph<>(
                VertexEdgeUtil.createDefaultVertexSupplier(),
                VertexEdgeUtil.createRelationshipEdgeSupplier(), false);
        graphGenerator.generateGraph(graph);
        ExportUtil.exportGML(graph, graphpathname + "tarefa05.gml");
    }
    static void printMatrix(Graph<DefaultVertex, RelationshipDirectedEdge> graph){
        for (DefaultVertex v : graph.vertexSet()) {
            Iterator<DefaultVertex> it = graph.vertexSet().iterator();
            while (it.hasNext()) {
                DefaultVertex v1 = it.next();
                int cont = (graph.containsEdge(v, v1)) ? 1 : 0;
                System.out.print(cont + (it.hasNext() ? "," : ""));
            }
            System.out.println();
        }
    }
    static void printComplement(Graph<DefaultVertex, RelationshipEdge> graph){
        Graph<DefaultVertex, RelationshipEdge> complement = new SimpleGraph<>(
                VertexEdgeUtil.createDefaultVertexSupplier(),
                VertexEdgeUtil.createRelationshipEdgeSupplier(), false);

        ComplementGraphGenerator<DefaultVertex, RelationshipEdge> gerador = new ComplementGraphGenerator<DefaultVertex, RelationshipEdge>(graph);
        gerador.generateGraph(complement);
        PrintUtil.printGraph(graph);
        PrintUtil.printGraph(complement);
    }
    static boolean isDirectFriends(Graph<String, DefaultEdge> graph, String person1, String person2){
        boolean amigosDiretos = false;
        if (graph.containsEdge(person1, person2)){
            amigosDiretos = true;
        }
        return amigosDiretos;
    }
    static List<String> friendConnections(Graph<String, DefaultEdge> graph, String person1, String person2){
        List<String> listaAmigos = new ArrayList<String>();
        YenKShortestPath<String, DefaultEdge> shortestPath = new YenKShortestPath<String, DefaultEdge>(graph);
        listaAmigos = shortestPath.getPaths(person1, person2, 1).get(0).getVertexList();
        return listaAmigos;
    }
    static  void friendTable(Graph<String, DefaultEdge> xnet,String person1,String person2){
        ConnectivityInspector<String, DefaultEdge> inspector = new ConnectivityInspector<>(xnet);

        if(xnet.containsVertex(person1) && xnet.containsVertex(person2)){
            if(isDirectFriends(xnet, person1, person2)){
                System.out.println("Sao Amigos Diretos");
            } else if (inspector.pathExists(person1, person2)){
                System.out.println(friendConnections(xnet, person1, person2));
            } else{
                System.out.println("Nao eh possivel se conhecerem");
            }
        } else{
            System.out.println((xnet.containsVertex(person1)? "_" : person1) + (xnet.containsVertex(person2) ? "" : " e " + person2) + " nao faz parte da rede");
        }
    }
    static void findPartitions(Graph<DefaultVertex, RelationshipEdge> graph){
        Set<DefaultVertex> A = new HashSet<>();
        Set<DefaultVertex> B =  new HashSet<>();
        NeighborCache<DefaultVertex, RelationshipEdge> neighborCache = new NeighborCache<>(graph);
        for (DefaultVertex v : graph.vertexSet()) {
            if(!A.contains(v) && !B.contains(v)){
                A.add(v);
                B.addAll(neighborCache.neighborsOf(v));
            }
        }
        System.out.println(A.toString() + System.lineSeparator() + B.toString() + System.lineSeparator());
    }
}

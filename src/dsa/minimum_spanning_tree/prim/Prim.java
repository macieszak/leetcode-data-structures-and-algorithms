//package minimum_spanning_tree;
//
//import org.apache.commons.math4.legacy.core.Pair;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//public class Prim {
//
//    private List<Vertex> graph;
//
//    public Prim(List<Vertex> graph){
//        this.graph = graph;
//    }
//
//    public void run(){
//        if (!graph.isEmpty()){
//            graph.get(0).setVisited(true);
//        }
//        while (isDisconnected()){
//            Edge nextMinimum = new Edge(Integer.MAX_VALUE);
//            Vertex nextVertex = graph.get(0);
//            for (Vertex vertex : graph){
//                if (vertex.isVisited()){
//                    Pair<Vertex, Edge> candidate = vertex.nextMinimum();
//                    if (candidate.getValue().getWeight() < nextMinimum.getWeight()){
//                        nextMinimum = candidate.getValue();
//                        nextVertex = candidate.getKey();
//                    }
//                }
//            }
//            nextMinimum.setIncluded(true);
//            nextVertex.setVisited(true);
//        }
//    }
//
//    private boolean isDisconnected(){
//        for (Vertex vertex : graph){
//            if (!vertex.isVisited()){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public String originalGraphToString(){
//        StringBuilder sb = new StringBuilder();
//        for (Vertex vertex : graph){
//            sb.append(vertex.originalToString());
//        }
//        return sb.toString();
//    }
//
//    public void resetPrintHistory(){
//        for (Vertex vertex : graph){
//            Iterator<Map.Entry<Vertex,Edge>> it = vertex.getEdges().entrySet().iterator();
//            while (it.hasNext()) {
//                Map.Entry<Vertex,Edge> pair = it.next();
//                pair.getValue().setPrinted(false);
//            }
//        }
//    }
//
//    public String minimumSpanningTreeToString(){
//        StringBuilder sb = new StringBuilder();
//        for (Vertex vertex : graph){
//            sb.append(vertex.includedToString());
//        }
//        return sb.toString();
//    }
//
//    public static List<Vertex> createGraph() {
//        List<Vertex> graph = new ArrayList<>();
//        Vertex a = new Vertex("A");
//        Vertex b = new Vertex("B");
//        Vertex c = new Vertex("C");
//        Vertex d = new Vertex("D");
//        Vertex e = new Vertex("E");
//        Edge ab = new Edge(2);
//        a.addEdge(b, ab);
//        b.addEdge(a, ab);
//        Edge ac = new Edge(3);
//        a.addEdge(c, ac);
//        c.addEdge(a, ac);
//        Edge bc = new Edge(2);
//        b.addEdge(c, bc);
//        c.addEdge(b, bc);
//        Edge be = new Edge(5);
//        b.addEdge(e, be);
//        e.addEdge(b, be);
//        Edge cd = new Edge(1);
//        c.addEdge(d, cd);
//        d.addEdge(c, cd);
//        Edge ce = new Edge(1);
//        c.addEdge(e, ce);
//        e.addEdge(c, ce);
//        graph.add(a);
//        graph.add(b);
//        graph.add(c);
//        graph.add(d);
//        graph.add(e);
//        return graph;
//    }
//
//
//
//
//
//
//
//}

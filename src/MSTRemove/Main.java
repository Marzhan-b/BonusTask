package MSTRemove;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(7);
        // sample graph
        g.addEdge(0, 1, 7);
        g.addEdge(0, 3, 5);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 3, 9);
        g.addEdge(1, 4, 7);
        g.addEdge(2, 4, 5);
        g.addEdge(3, 4, 15);
        g.addEdge(3, 5, 6);
        g.addEdge(4, 5, 8);
        g.addEdge(4, 6, 9);
        g.addEdge(5, 6, 11);

        System.out.println("Building MST...");
        List<Edge> mst = Kruskal.buildMST(g);

        System.out.println("\nMST edges:");
        for (Edge e : mst) System.out.println(e);

        // choose an edge to remove
        Edge removed = mst.get(2);
        mst.remove(removed);

        System.out.println("\nRemoved edge: " + removed);

        // components after removal
        List<List<Integer>> comps = g.getComponents(mst, removed);
        System.out.println("\nComponents:");
        System.out.println(" - " + comps.get(0));
        System.out.println(" - " + comps.get(1));

        // find replacement
        Edge repl = g.findReplacement(comps);
        System.out.println("\nReplacement edge: " + repl);

        // rebuild MST
        mst.add(repl);

        System.out.println("\nNew MST:");
        for (Edge e : mst) System.out.println(e);
    }
}

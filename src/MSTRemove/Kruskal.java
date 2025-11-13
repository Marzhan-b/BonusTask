package MSTRemove;
import java.util.*;

public class Kruskal {
    public static List<Edge> buildMST(Graph g) {
        List<Edge> sortedEdges = new ArrayList<>(g.edges);
        Collections.sort(sortedEdges);

        UnionFind uf = new UnionFind(g.V);
        List<Edge> mst = new ArrayList<>();

        for (Edge e : sortedEdges) {
            if (uf.union(e.u, e.v)) {
                mst.add(e);
            }
        }
        return mst;
    }
}


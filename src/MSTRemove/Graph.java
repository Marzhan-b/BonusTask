package MSTRemove;
import java.util.*;
public class Graph {
    public int V;
    public List<Edge> edges = new ArrayList<>();

    public Graph(int V) {
        this.V = V;
    }
    public void addEdge(int u, int v, int w) {
        edges.add(new Edge(u, v, w));
    }
    public List<List<Integer>> getComponents(List<Edge> mst, Edge removed) {

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < V; i++) adj.put(i, new ArrayList<>());

        for (Edge e : mst) {
            if (e == removed) continue;

            adj.get(e.u).add(e.v);
            adj.get(e.v).add(e.u);
        }

        boolean[] visited = new boolean[V];
        List<List<Integer>> comps = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                List<Integer> comp = new ArrayList<>();
                dfs(i, adj, visited, comp);
                comps.add(comp);
            }
        }
        return comps;
    }
    private void dfs(int node, Map<Integer, List<Integer>> adj,
                     boolean[] visited, List<Integer> comp) {

        visited[node] = true;
        comp.add(node);

        for (int nxt : adj.get(node)) {
            if (!visited[nxt])
                dfs(nxt, adj, visited, comp);
        }
    }
    public Edge findReplacement(List<List<Integer>> comps) {
        Set<Integer> A = new HashSet<>(comps.get(0));
        Set<Integer> B = new HashSet<>(comps.get(1));

        Edge best = null;

        for (Edge e : edges) {
            boolean connectAB = (A.contains(e.u) && B.contains(e.v)) ||
                    (A.contains(e.v) && B.contains(e.u));

            if (connectAB) {
                if (best == null || e.weight < best.weight)
                    best = e;
            }
        }
        return best;
    }
}


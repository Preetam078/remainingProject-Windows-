import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS {

    public static void main(String[] args) {

        ArrayList<List<Integer>> adj = new ArrayList<>();
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList(1, 4, 7));
        adj.add(Arrays.asList(5));
        adj.add(Arrays.asList(2, 6));
        adj.add(Arrays.asList(3));
        adj.add(Arrays.asList(4, 7));
        adj.add(Arrays.asList(2, 6));

        int n = adj.size();

        ArrayList<Integer> ans = dfsTraversal(adj, n);

        for (Integer num : ans) {
            System.out.print(num + " ");
        }
        System.out.println();

    }

    public static ArrayList<Integer> dfsTraversal(ArrayList<List<Integer>> adj, int v) {

        ArrayList<Integer> dfsStore = new ArrayList<>();
        boolean vis[] = new boolean[v + 1];

        for (int i = 1; i <= v; i++) {
            if (vis[i] == false) {
                dfs(adj, dfsStore, vis, i);
            }
        }
        return dfsStore;
    }

    public static void dfs(ArrayList<List<Integer>> adj, ArrayList<Integer> dfsStore, boolean[] vis, int node) {
        dfsStore.add(node);
        vis[node] = true;
        for (Integer num : adj.get(node)) {
            if (vis[node] == false) {
                dfs(adj, dfsStore, vis, num);
            }
        }
    }
}

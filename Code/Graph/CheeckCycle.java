import java.util.ArrayList;
import java.util.Arrays;

public class CheeckCycle { // Checking in Undirected Graph

    private boolean checkDFS(ArrayList<ArrayList<Integer>> adj, int[] vis, int[] dfsVis, int node) {

        vis[node] = 1;
        dfsVis[node] = 1;

        for (Integer num : adj.get(node)) {
            if (vis[num] == 0) {
                if (checkDFS(adj, vis, dfsVis, num)) {
                    return true;
                }
            } else if (dfsVis[num] == 1) {
                return true;
            }
        }

        dfsVis[node] = 0;
        return false;
    }

    public boolean checkCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[n];
        int[] dfsVis = new int[n];

        Arrays.fill(vis, 0);
        Arrays.fill(dfsVis, 0);

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                if (checkDFS(adj, vis, dfsVis, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        int n = 9;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(2).add(5);
        adj.get(3).add(4);
        adj.get(5).add(4);
        adj.get(6).add(1);
        adj.get(6).add(7);
        adj.get(7).add(8);
        adj.get(8).add(6);

        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }

        CheeckCycle obj = new CheeckCycle();

        if (obj.checkCycle(n, adj))
            System.out.println("Cycle Detected");
        else
            System.out.println("Cycle Not Detected");
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSort {

    private void SortDfs(ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, int[] vis, int node) {

        vis[node] = 1;
        for (int num : adj.get(node)) {
            if (vis[node] == 0) {
                SortDfs(adj, st, vis, num);
            }
        }
        st.push(node);
    }

    public ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj, int n) {

        ArrayList<Integer> ans = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<Integer>();
        int[] vis = new int[n];
        Arrays.fill(vis, 0);

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                SortDfs(adj, st, vis, i);
            }
        }

        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int n = 6;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        System.out.println("The Adjacency List fror the Graph : ");
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }

        TopologicalSort obj = new TopologicalSort();
        ArrayList<Integer> SortedArray = obj.topologicalSort(adj, n);

        for (int i = 0; i < SortedArray.size(); i++) {
            System.out.print(SortedArray.get(i) + " ");
        }
        System.out.println();

    }
}

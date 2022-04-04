import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopoSortBFS {

    public ArrayList<Integer> kahnAlgo(ArrayList<ArrayList<Integer>> adj, int n) {

        ArrayList<Integer> anwer = new ArrayList<>();
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (Integer num : adj.get(i)) { // Calculated the Indegree of the vertices and stored in the List
                inDegree[num]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            anwer.add(node);

            for (Integer num : adj.get(node)) {
                inDegree[num]--;
                if (inDegree[num] == 0) {
                    q.add(num);
                }
            }
        }

        return anwer;
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

        System.out.println("Adjacency List for the Graph is : ");
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }

        TopoSortBFS obj = new TopoSortBFS();
        ArrayList<Integer> SortedList = obj.kahnAlgo(adj, n);

        System.out.println("topo sorted list using bfs or kahn's Algo : ");
        for (int i = 0; i < SortedList.size(); i++) {
            System.out.print(SortedList.get(i) + " ");
        }
        System.out.println();
    }
}
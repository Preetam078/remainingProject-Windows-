import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath { // shortest path in the undirected path with unweighted

    public void ShortedPath(ArrayList<ArrayList<Integer>> adj, int src, int n) {

        int[] distArray = new int[n];
        Arrays.fill(distArray, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();

        distArray[src] = 0;
        q.add(src);

        while (q.isEmpty() == false) {
            int node = q.poll();

            for (Integer num : adj.get(node)) {
                if (distArray[node] + 1 < distArray[num]) {
                    distArray[num] = distArray[node] + 1;
                    q.add(num);
                }
            }
        }

        for (int i = 0; i < distArray.length; i++) {
            System.out.print(distArray[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int n = 9;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        adj.get(0).add(1);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(2).add(6);
        adj.get(3).add(0);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(5);
        adj.get(5).add(4);
        adj.get(5).add(6);
        adj.get(6).add(2);
        adj.get(6).add(5);
        adj.get(6).add(7);
        adj.get(6).add(8);
        adj.get(7).add(6);
        adj.get(7).add(8);
        adj.get(8).add(6);
        adj.get(8).add(7);

        System.out.println("The Adjacency List of the Graph is : ");
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }

        ShortestPath obj = new ShortestPath();
        System.out.println("Shortest Path in the form of Array : ");
        obj.ShortedPath(adj, 0, n);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Pair { // made a class to define the pair datatype which will store the value and
             // weight

    int Value;
    int weight;

    Pair(int Value, int weight) {
        this.Value = Value;
        this.weight = weight;
    }

    int getValue() {
        return Value;
    }

    int getWeight() {
        return weight;
    }
}

class DAGshortestPath {

    private void topoSort(ArrayList<ArrayList<Pair>> adj, Stack<Integer> stack, boolean[] vis, int node) {

        vis[node] = true;
        for (Pair it : adj.get(node)) {
            if (vis[it.getValue()] == false) {
                topoSort(adj, stack, vis, it.getValue());
            }
        }
        stack.add(node);
    }

    void shortedPath(ArrayList<ArrayList<Pair>> adj, int src, int n) {

        Stack<Integer> stack = new Stack<>();
        int[] distArray = new int[n];
        Arrays.fill(distArray, Integer.MAX_VALUE);
        distArray[src] = 0;

        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);

        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                topoSort(adj, stack, vis, i);
            }
        }

        while (!stack.isEmpty()) {

            int node = stack.peek();
            stack.pop();

            if (distArray[node] != Integer.MAX_VALUE) {
                for (Pair it : adj.get(node)) {
                    if (distArray[it.getValue()] > distArray[node] + it.getWeight()) {
                        distArray[it.getValue()] = distArray[node] + it.getWeight();
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (distArray[i] == Integer.MAX_VALUE) {
                System.out.print("NIL");
            } else
                System.out.print(distArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int n = 6;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(4, 1));
        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(3, 6));
        adj.get(4).add(new Pair(2, 2));
        adj.get(4).add(new Pair(5, 4));
        adj.get(5).add(new Pair(3, 1));

        DAGshortestPath obj = new DAGshortestPath();
        obj.shortedPath(adj, 0, n);

    }
}

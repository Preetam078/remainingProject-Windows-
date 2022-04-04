import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BypertiteGraph {

    private boolean checkBfs(ArrayList<ArrayList<Integer>> adj, int node, int[] color) {

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(node);
        color[node] = 1;

        while (!q.isEmpty()) {
            int BaseNode = q.poll();
            for (Integer num : adj.get(BaseNode)) {
                if (color[num] == -1) {
                    color[num] = 1 - color[BaseNode];
                    q.add(num);
                } else if (color[num] == color[BaseNode]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkBypertite(ArrayList<ArrayList<Integer>> adj, int n) {

        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!checkBfs(adj, i, color))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        // System.out.println("enter the nodes and edges : ");
        // int n = sc.nextInt();
        // int m = sc.nextInt();

        // System.out.println(n + " " + m);

        int n = 7;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 7; i++) {
            adj.add(new ArrayList<Integer>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(4).add(3);
        adj.get(3).add(4);

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(4).add(6);
        adj.get(6).add(4);

        adj.get(1).add(6);
        adj.get(6).add(1);

        // for (int i = 0; i < adj.size(); i++) {
        // for (int j = 0; j < adj.get(i).size(); j++) {
        // System.out.print(adj.get(i).get(j) + " ");
        // }
        // System.out.println();
        // }

        BypertiteGraph obj = new BypertiteGraph();

        if (obj.checkBypertite(adj, n) == true) {
            System.out.println("Graph is Bypertite");
        } else {
            System.out.println("Graph is not Bypertite");
        }

    }
}
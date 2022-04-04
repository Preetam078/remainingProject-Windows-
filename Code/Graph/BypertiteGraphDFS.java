import java.util.ArrayList;

public class BypertiteGraphDFS {

    private boolean checkDfs(ArrayList<ArrayList<Integer>> adj, int node, int[] color) {

        if (color[node] == -1) {
            color[node] = 1;
        }

        for (Integer num : adj.get(node)) {
            if (color[num] == -1) {
                if (!checkDfs(adj, num, color))
                    return false;
            } else if (color[num] == color[node])
                return false;
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
                if (!checkDfs(adj, i, color))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

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

        BypertiteGraphDFS obj = new BypertiteGraphDFS();

        if (obj.checkBypertite(adj, n)) {
            System.out.println("graph is bypertite");
        } else
            System.out.println("graph is not Bypertite");
    }
}

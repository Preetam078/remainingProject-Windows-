#include <bits/stdc++.h>
using namespace std;

bool checkCycle(int node, int parent, vector<int> adj[], vector<int> &vis)
{
    vis[node] = 1;
    for (int num : adj[node])
    {
        if (vis[num] == 0)
        {
            if (checkCycle(num, node, adj, vis))
                return true;
        }
        else if (num != parent)
            return true;
    }
    return false;
}

bool isCycle(int v, vector<int> adj[])
{
    vector<int> vis(v + 1, 0);

    for (int i = 1; i <= v; i++)
    {
        if (!vis[i])
        {
            if (checkCycle(i, -1, adj, vis))
                return true;
        }
    }
    return false;
}

int main()
{

    int n, m;
    cout << "enter the nodes and edges respectively" << endl;
    cin >> n >> m;

    vector<int> adj[n + 1];

    cout << "enter the pair of the connected nodes" << endl;
    for (int i = 0; i < m; i++)
    {
        int v, u;
        cin >> v >> u;
        adj[u].push_back(v); //this is for undirected graph
        adj[v].push_back(u);
    }

    cout << "displaying Adjacency List" << endl;
    for (int i = 0; i < n + 1; i++)
    {
        for (auto num : adj[i])
        {
            cout << num << " ";
        }
        cout << endl;
    }

    if (isCycle(m, adj))
    {
        cout << "cycle found" << endl;
    }
    else
        cout << "cycle not found" << endl;

    return 0;
}
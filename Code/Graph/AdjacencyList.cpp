#include <iostream>
#include <vector>
using namespace std;

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

    return 0;
}
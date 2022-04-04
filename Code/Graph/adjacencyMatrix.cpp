#include <iostream>
using namespace std;

int main()
{

    int n, m;
    cout << "enter nodes and edges" << endl;
    cin >> n >> m;

    int **adj = new int *[n + 1];
    for (int i = 0; i < n + 1; i++)
    {
        adj[i] = new int[n + 1];
    }

    for (int i = 0; i < n + 1; i++)
    {
        for (int j = 0; j < n + 1; j++)
        { // initialized the matrix with 0;
            adj[i][j] = 0;
        }
    }
    cout << "enter the connected node pair" << endl; //main logic to store the value for the connected graph pair
    for (int i = 0; i < m; i++)
    {
        int v, u;
        cin >> v >> u;
        adj[v][u] = 1;
        adj[u][v] = 1;
    }

    cout << "displaying the adjacency matrix" << endl;
    for (int i = 0; i < n + 1; i++)
    {
        for (int j = 0; j < n + 1; j++)
        {
            cout << adj[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}
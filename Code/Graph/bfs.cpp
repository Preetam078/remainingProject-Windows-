#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<int> bfsTraversal(vector<vector<int>> adj, int v)
{
    vector<int> vis(v + 1, 0);
    vector<int> bfs;

    for (int i = 1; i < v + 1; i++)
    {
        if (!vis[i])
        {
            queue<int> q;
            q.push(i);
            vis[i] = 1;

            while (!q.empty())
            {
                int node = q.front();
                q.pop();

                bfs.push_back(node);
                for (auto num : adj[node])
                {
                    if (!vis[num])
                    {
                        q.push(num);
                        vis[num] = 1;
                    }
                }
            }
        }
    }
    return bfs;
}

int main()
{

    vector<vector<int>> adj = {{2}, {1, 4, 7}, {5}, {2, 6}, {3}, {4, 7}, {2, 6}};
    int n = adj.size();
    for (int i = 1; i <= 7; i++)
    {
        for (int j = 0; j < adj[i].size(); j++)
        {
            cout << adj[i][j] << " ";
        }
        cout << endl;
    }

    vector<int> res = bfsTraversal(adj, n);

    for (auto num : res)
    {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}
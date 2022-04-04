#include <bits/stdc++.h>
using namespace std;

vector<int> solve(int *arr, int k, int n)
{

    vector<int> res;

    unordered_map<int, int> mp;
    for (int i = 0; i < n; i++)
    {
        mp[arr[i]]++;
    }

    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> minHeap;
    for (unordered_map<int, int>::iterator it = mp.begin(); it != mp.end(); it++)
    {

        minHeap.push(make_pair(it->second, it->first));
        if (minHeap.size() > k)
        {
            minHeap.pop();
        }
    }

    while (!minHeap.empty())
    {
        res.push_back(minHeap.top().second);
        minHeap.pop();
    }

    return res;
}

int main()
{

    int arr[] = {1, 1, 1, 2, 2, 3, 3, 4};
    int n = sizeof(arr) / sizeof(int);
    int k = 3;

    vector<int> k_frequent_Numbers = solve(arr, k, n);
    cout << "the K frequent numbers are : " << endl;
    for (int num : k_frequent_Numbers)
    {
        cout << num << " ";
    }
    cout << endl;
    return 0;
}
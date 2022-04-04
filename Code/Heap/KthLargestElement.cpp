#include <bits/stdc++.h>
using namespace std;

int MinHeapfunction(vector<int> &heap, int n, priority_queue<int, vector<int>, greater<int>> minHeap)
{

    for (int num : heap)
    {
        minHeap.push(num);
        if (minHeap.size() > n)
        {
            minHeap.pop();
        }
    }
    return minHeap.top();
}

int main()
{

    vector<int> arr = {7, 10, 4, 3, 20, 15};
    int k = 3;
    priority_queue<int, vector<int>, greater<int>> minHeap;

    int ans = MinHeapfunction(arr, k, minHeap);

    cout << "kth largest element is : " << ans << endl;

    return 0;
}
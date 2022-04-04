#include <bits/stdc++.h>
using namespace std;

vector<int> ksortedArray(vector<int> arr, int k)
{

    vector<int> ans;
    priority_queue<int, vector<int>, greater<int>> maxHeap;

    for (int num : arr)
    {
        maxHeap.push(num);
        if (maxHeap.size() > k)
        {
            ans.push_back(maxHeap.top());
            maxHeap.pop();
        }
    }

    while (!maxHeap.empty())
    {
        ans.push_back(maxHeap.top());
        maxHeap.pop();
    }
    return ans;
}
int main()
{

    vector<int> arr = {6, 5, 3, 2, 8, 10, 9};
    int k = 3;

    vector<int> sortedArray = ksortedArray(arr, k);
    for (int num : sortedArray)
    {
        cout << num << " ";
    }
    cout << endl;
    return 0;
}
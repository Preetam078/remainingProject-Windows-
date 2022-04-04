#include <bits/stdc++.h>
using namespace std;

int main()
{

    vector<int> arr = {7, 10, 4, 3, 20, 15};
    int k = 3;

    priority_queue<int> maxHeap;
    for (int num : arr)
    {
        maxHeap.push(num);
        if (maxHeap.size() > k)
        {
            maxHeap.pop();
        }
    }

    cout << "the kth smallest element is : " << maxHeap.top();
    cout << endl;

    return 0;
}
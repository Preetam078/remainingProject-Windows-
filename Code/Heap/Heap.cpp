#include <bits/stdc++.h>
using namespace std;

class heap
{

public:
    int arr[100];
    int size;

    heap()
    {
        arr[0] = -1;
        size = 0;
    }

    void insert(int val)
    {
        size = size + 1;
        int index = size;
        arr[index] = val;

        while (index > 1)
        {
            int parent = index / 2;
            if (arr[parent] < arr[index])
            {
                swap(arr[parent], arr[index]);
                index = parent;
            }
            else
            {
                return;
            }
        }
    }

    void deleteFromHeap()
    {

        if (size == 0)
        {
            return;
        }

        arr[1] = arr[size];
        size--;

        int i = 1;
        while (i < size)
        {

            int leftWay = 2 * i;
            int rightWay = 2 * i + 1;

            if (leftWay < size && arr[i] < arr[leftWay])
            {
                swap(arr[i], arr[leftWay]);
                i = leftWay;
            }
            else if (rightWay < size && arr[i] < arr[rightWay])
            {
                swap(arr[i], arr[rightWay]);
                i = rightWay;
            }
            else
            {
                return;
            }
        }
    }

    void print()
    {
        for (int i = 1; i <= size; i++)
        {
            cout << arr[i] << " ";
        }
        cout << endl;
    }
};

void heapifyAlgo(int arr[], int n, int index)
{

    int largest = index;
    int left = largest * 2;
    int right = largest * 2 + 1;

    if (left < n && arr[left] > arr[largest])
    {
        largest = left;
    }
    if (right < n && arr[right] > arr[largest])
    {
        largest = right;
    }

    if (largest != index)
    {
        swap(arr[largest], arr[index]);
        heapifyAlgo(arr, n, largest);
    }
}

int main()
{

    heap h;
    h.insert(50);
    h.insert(55);
    h.insert(53);
    h.insert(52);
    h.insert(54);

    h.print();
    h.deleteFromHeap();
    h.print();

    int arr[] = {-1, 54, 53, 55, 52, 50};
    int n = 5;
    for (int i = n / 2; i > 0; i--)
    {
        heapifyAlgo(arr, n, i);
    }

    for (int i = 1; i <= n; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;

    return 0;
}
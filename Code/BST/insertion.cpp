#include <bits/stdc++.h>
using namespace std;

class Node
{

public:
    int data;
    Node *right;
    Node *left;

    Node(int data)
    {
        this->data = data;
        right = left = NULL;
    }
};

Node *insertBST(Node *&root, int data)
{

    if (root == NULL)
    {
        root = new Node(data);
        return root;
    }

    if (data > root->data)
    {
        root->right = insertBST(root->right, data);
    }
    else
    {
        root->left = insertBST(root->left, data);
    }
}

void takeInput(Node *&root)
{

    int d;
    cin >> d;
    while (d != -1)
    {
        insertBST(root, d);
        cin >> d;
    }
}

void Traversal(Node *root)
{

    queue<Node *> q;
    q.push(root);

    while (!q.empty())
    {

        int size = q.size();

        for (int i = 0; i < size; i++)
        {
            cout << q.front()->data << " ";
            if (q.front()->left != NULL)
            {
                q.push(q.front()->left);
            }
            if (q.front()->right != NULL)
            {
                q.push(q.front()->right);
            }
            q.pop();
        }
    }
}

int main()
{

    Node *root = NULL;

    cout << "Please Enter the value to be added in BST" << endl;
    takeInput(root);

    cout << "Level order trversal of the BST" << endl;
    Traversal(root);

    return 0;
}
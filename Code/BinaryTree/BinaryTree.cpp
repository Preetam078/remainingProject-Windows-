#include <iostream>
using namespace std;

class Node
{
public:
    int Data;
    Node *left;
    Node *right;

    Node(int Data)
    {
        this->Data = Data;
        this->left = this->right = NULL;
    }
};

void inorderTraverse(Node *root, string &pre, string &post, string &in)
{
    if (root == NULL)
    {
        return;
    }
    pre += to_string(root->Data);
    pre += " ";
    inorderTraverse(root->left, pre, post, in);
    in += to_string(root->Data);
    in += " ";
    inorderTraverse(root->right, pre, post, in);
    post += to_string(root->Data);
    post += " ";
}

int main()
{

    Node *root = new Node(10);
    root->left = new Node(11);
    root->right = new Node(12);
    root->left->left = new Node(13);
    root->left->right = new Node(14);
    root->right->left = new Node(15);
    root->right->right = new Node(16);

    string pre = "";
    string post = "";
    string in = "";

    inorderTraverse(root, pre, post, in);
    cout << endl;
    cout << pre << endl;
    cout << in << endl;
    cout << post << endl;
    return 0;
}
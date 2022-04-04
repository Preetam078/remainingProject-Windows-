#include <iostream>
using namespace std;

class Node
{

public:
    int data;
    Node *next;

    Node(int data)
    {
        this->data = data;
        next = NULL;
    }
};

void deleteNode(Node *&head, int position)
{

    int count = 1;
    Node *temp = head;
    while (count < position - 1)
    {
        temp = temp->next;
        count++;
    }
    Node *todelete = temp->next;
    temp->next = temp->next->next;
    delete todelete;
}

void insertMiddle(Node *&head, int position, int data)
{
    int count = 1;
    Node *temp = head;
    while (count < position - 1)
    {
        temp = temp->next;
        count++;
    }
    Node *n = new Node(data);
    n->next = temp->next;
    temp->next = n;
}

void insertTail(Node *&head, int data)
{

    Node *temp = head;
    Node *n = new Node(data);
    while (temp->next != NULL)
    {
        temp = temp->next;
    }
    temp->next = n;
}

void insertHead(Node *&head, int data)
{

    Node *temp = new Node(data);
    temp->next = head;
    head = temp;
}

void displayLL(Node *&head)
{
    Node *temp = head;

    while (temp != NULL)
    {
        cout << temp->data << "->";
        temp = temp->next;
    }
    cout << "NULL" << endl;
}

int main()
{

    Node *head = new Node(10);
    insertHead(head, 20);
    displayLL(head);
    insertTail(head, 30);
    displayLL(head);
    insertMiddle(head, 2, 50);
    displayLL(head);
    deleteNode(head, 2);
    displayLL(head);
    return 0;
}
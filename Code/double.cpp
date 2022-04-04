#include <iostream>
using namespace std;

class Node
{

public:
    int data;
    Node *prev;
    Node *next;

    Node(int data) //constructor called
    {
        this->data = data;
        prev = NULL;
        next = NULL;
    }
};

void printNode(Node *head) //print the linked list
{

    while (head != NULL)
    {
        cout << head->data << "->";
        head = head->next;
    }
    cout << "NULL" << endl;
}

void insertHead(Node *&head, int data) //insertion at head
{

    Node *temp = head;
    Node *n = new Node(data);

    temp->prev = n;
    n->next = temp;
    head = n;
}

void insertTail(Node *&head, int data) // insertion at tail
{

    Node *temp = head;
    Node *n = new Node(data);

    while (temp->next != NULL)
    {
        temp = temp->next;
    }

    temp->next = n;
    n->prev = temp;
}

void insertMiddle(Node *&head, int position, int data)
{ //insertion at middle
    Node *temp = head;
    int count = 1;
    while (count < position - 1)
    {
        temp = temp->next;
        count++;
    }
    Node *n = new Node(data);
    n->next = temp->next;
    temp->next = n;
    n->prev = temp;
}

void deleteHead(Node *&head) //deletion at head
{
    Node *temp = head;
    Node *todelete = temp;

    head = temp->next;
    delete todelete;
}

void deleteTail(Node *&head) //deletion at tail
{

    Node *temp = head;
    while (temp->next != NULL)
    {
        temp = temp->next;
    }
    Node *todelete = temp;
    temp->prev->next = NULL;
    delete todelete;
}

void deleteMiddle(Node *&head, int position)
{

    int count = 1;
    Node *temp = head;

    while (count < position)
    {
        temp = temp->next;
        count++;
    }

    Node *todelete = temp;
    temp->prev->next = temp->next;
    delete todelete;
}

int main()
{
    Node *head = new Node(10);
    printNode(head);
    insertHead(head, 20);
    insertHead(head, 30);
    printNode(head);
    insertTail(head, 50);
    printNode(head);
    insertMiddle(head, 2, 100);
    printNode(head);
    deleteHead(head);
    printNode(head);
    deleteTail(head);
    printNode(head);
    deleteMiddle(head, 2);
    printNode(head);
    return 0;
}
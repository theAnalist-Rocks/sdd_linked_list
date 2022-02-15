#ifndef FUNCTION_H_INCLUDED
#define FUNCTION_H_INCLUDED

typedef struct Node{
    int data;
    struct Node *suivant;
}Node;

typedef struct LinkedInfo {
    Node *debut;
    Node *fin;
    int longueur;
}LinkedInfo;


LinkedInfo *createLinkedList();
void deleteLinkedList(LinkedInfo *linkedList);
void showLinkedList(LinkedInfo *linkedList);
void addToLeft(LinkedInfo *linkedList);
void addToRight(LinkedInfo *linkedList);
void addToPos(LinkedInfo * linkedList);
void deletePos(LinkedInfo *linkedList);
int getPos();


#endif // FUNCTION_H_INCLUDED

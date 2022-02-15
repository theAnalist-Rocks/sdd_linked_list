#include <stdio.h>
#include <stdlib.h>
#include "function.h"


/*typedef struct List {
    LinkedInfo *debut;
}*/


LinkedInfo *createLinkedList(){
    LinkedInfo *linkedlist = malloc(sizeof(LinkedInfo));
    linkedlist->debut = NULL;
    linkedlist->fin = NULL;
    linkedlist->longueur = 0;
    return linkedlist;
}

void showLinkedList(LinkedInfo *linkedlist) {
    Node *courant = linkedlist->debut;
    if (!courant)
        printf("\nEmpty List");
    else {
        while (courant != NULL) {
            printf("\nData: %d", courant->data);
            courant = courant->suivant;
        }
    }
}

void addToRight(LinkedInfo *linkedlist) {
    Node *nouveau = malloc(sizeof(Node));
    int data;
    //repmlir les informations du nouveau maillon
    printf("\nEntrer la donnée: ");
    scanf("%d", &data);
    nouveau->data = data;
    nouveau->suivant = NULL;

    //on l'ajoute à la fin
    linkedlist->fin->suivant = nouveau;
    linkedlist->fin = nouveau;
    linkedlist->longueur = linkedlist->longueur++;
}

void addToLeft(LinkedInfo *linkedlist) {
    Node *nouveau = malloc(sizeof(Node));
    int data;

    //remplir les informations
    printf("\nEntrer la donnée: ");
    scanf("%d", &data);
    nouveau->data = data;

    nouveau->suivant = linkedlist->debut;
    linkedlist->debut = nouveau;
    linkedlist->longueur = linkedlist->longueur++;
    //ajouter une fonction qui pointe sur les autres pour pouvoir manipuler ceci printf("\n\t\t\e[5;32m OPERATION DONE \e[m");
}

int getPos() {
    int pos;
    printf("\nEntrez la position de la donnée à manipuler: ");
    scanf("%d", &pos);
    return pos;
}

void addToPos(LinkedInfo* linkedlist) {
    int cpt=0, pos=getPos(), data;
    Node * courant = linkedlist->debut;
    Node * nouveau = malloc(sizeof(Node));

    while (cpt != pos-1) {
        cpt ++;
        courant = courant->suivant;
    }

    // on est arrivé ?
    if (cpt == pos-1) {
        data = getPos();

        nouveau->data = data;
        nouveau->suivant = courant->suivant;
        courant->suivant = nouveau;
    }
}

void deletePos(LinkedInfo* linkedlist) {
    int cpt=0, pos = getPos();
    Node *courant = linkedlist->debut;
    Node *tofree = malloc(sizeof(Node));

    while (cpt!= pos-1) {
        courant = courant->suivant;
        cpt ++;
    }

    if(cpt == pos-1) {
        tofree = courant->suivant;
        courant->suivant = tofree->suivant;
        free(tofree);
    }
}

#include <stdio.h>
#include <stdlib.h>
#include "view.h"
#include "time.h"
#include "function.h"

/*
    On doit avoir une liste contenant les structures de control sur les différentes listes
    END_EXIT est une variable à deux valeurs 0 ou 1
    Si c'est 1 alors tout c'est bien passé sinon 0
    0 dans le cas où
*/

void process(void (*func)(LinkedInfo *), LinkedInfo* listinfo) {
    (*func)(listinfo);
    printf("\n\e[5;32m OPERATION DONE \e[m");
}

void try_again(int (*func)(ActuaList *), ActuaList*actuaList) {
    int (*f)(ActuaList *) = func;
    int END_EXIT;

    do {
        END_EXIT = (*f)(actuaList);
    }
    while(END_EXIT != 1);
}


/*int option_delete(){
    int choice, END_EXIT= 1;

    printf("\e[5;40;32m \nEntrer la position:\e[m");
    scanf("%d", &choice);
    ///je laisse l'option de vérification à la fonction de suppression\
    qui doit me renvoyer un résultat: c'est fait ou ce n'est pas fait ?

    flush;
    return END_EXIT;

}*/


int option_insert(LinkedInfo *linkedlist) {
    int choice, END_EXIT=1;
    void (*func)(LinkedInfo*);

    printf("\e[5;32m \n\t[1]\t\e[m Insérer au début");
    printf("\e[5;32m \n\t[2]\t\e[m Insérer à la fin");
    printf("\e[5;32m \n\t[3]\t\e[m Insérer à une position\n\nChoix:");
    scanf("%d", &choice);

    switch (choice) {
        case 1:
            func = addToLeft;
            break;
        case 2:
            func = addToRight;
            break;
        case 3:
            func = addToPos;
            break;
        default:
            printf("\e[5;31m\nEntrez un nombre entre [1 - 3]\e[m");
            END_EXIT = 0;
    }
    process(func, linkedlist);
    flush;
    return END_EXIT;
}

int showMenu(ActuaList *actuaList) {
    int choice, END_EXIT=1;
    void (*func)(LinkedInfo *);

    printf("\nFaites un choix :");

    printf("\e[5;32m \n[1]\t\e[m Créer une liste chaînée\n");
    printf("\e[5;32m \n[2]\t\e[m Ajouter un élément une liste existante\n");
    printf("\e[5;32m \n[3]\t\e[m Supprimer un élément à une position donnée\n");
    printf("\e[5;32m \n[4]\t\e[m Afficher une liste chaînée\n");
    printf("\e[5;32m \n[5]\t\e[m Supprimer une liste chaînée\n");
    printf("\e[5;32m \n[6]\t\e[m Supprimer tout et Arrêter le programme\n\nChoix:");
    scanf("%d", &choice);

    switch (choice) {
        case 1:
            actuaList->actuel = createLinkedList();
            break;
        case 2:
            option_insert(actuaList->actuel);
            break;
        case 3:
            deletePos(actuaList->actuel);
            break;
        case 4:
            showLinkedList(actuaList->actuel);
            break;
        case 5:
            //deleteLinkedList(actuaList->actuel);
            break;
        case 6:
            printf("\nEXIT SUCCES\n");
            exit(0);
            break;
        default:
            system("clear");
            printf("\e[5;31m\nEntrez un nombre entre [1 - 6]\e[m");
            END_EXIT = 0;
    }
    flush;
    return END_EXIT;
}

void launch() {
    char exit;
    ActuaList * newList = malloc(sizeof(ActuaList));
    system("clear");

    printf("\nLaunch ?:[y/N] ");
    scanf("%c", &exit);

    while (exit != 'N') {
        try_again(showMenu, newList);
        printf("\nLaunch ?:[y/N] ");
        scanf("%c", &exit);
    }


}

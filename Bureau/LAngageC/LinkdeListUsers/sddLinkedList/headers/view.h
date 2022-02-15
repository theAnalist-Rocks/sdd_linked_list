#ifndef VIEW_H_INCLUDED
#define VIEW_H_INCLUDED

#include "function.h"
#define flush while(getchar()!='\n');


typedef struct ActuaList ActuaList;

struct ActuaList {
    LinkedInfo *actuel;
};

void process(void (*func)(LinkedInfo *), LinkedInfo *);
int option_insert(LinkedInfo *);
int option_delete(LinkedInfo*);
void try_again(int (*func)(ActuaList *), ActuaList*);
int showMenu(ActuaList*);
void launch();

#endif // VIEW_H_INCLUDED

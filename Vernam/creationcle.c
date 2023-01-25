#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "creationcle.h"


int creationcle (char * cheminFic_m, char * cheminFic_k){
  FILE *f_m, *f_k;

  int c, caractere;

  f_m = fopen(cheminFic_m, "r");
  if (f_m==NULL){
    printf("Le fichier message est vide !\n");
    return EXIT_FAILURE;
  }
  f_k = fopen(cheminFic_k, "w");
  srand(time(NULL));
  while ((c = fgetc(f_m)) != EOF){
    caractere=rand()%52;
    fputc(caractere, f_k);
  }

  fclose(f_m);
  fclose(f_k);
  printf("Clé créé avec succès !\n");
  return EXIT_SUCCESS;
}

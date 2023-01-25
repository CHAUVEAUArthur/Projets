#include <stdio.h>
#include <stdlib.h>
#include "decodage.h"

int decodage(char * cheminFic_m,char * cheminFic_k,char * cheminFic_mdc ) {
  FILE *f_m, *f_k, *f_mdc;
  
  int c,k1,calcul;
  
  f_m = fopen(cheminFic_m, "r");
  if (f_m==NULL){
     printf("Le fichier message codé est vide !\n");
    return EXIT_FAILURE;
  }
  f_k = fopen(cheminFic_k, "r");
  if (f_k==NULL){
     printf("Le fichier clé est vide !\n");
    return EXIT_FAILURE;
  }
  f_mdc = fopen(cheminFic_mdc, "w");
  while ((c = fgetc(f_m)) != EOF){
    k1 = fgetc(f_k);
    calcul = c-k1 >= 0?c-k1:256-(c-k1);
    fputc(calcul, f_mdc);
  }
  
  fclose(f_m);
  fclose(f_k);
  fclose(f_mdc);
  printf("Message décrypté avec succès !\n");
  return EXIT_SUCCESS;
}

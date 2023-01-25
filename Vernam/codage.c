#include <stdio.h>
#include <stdlib.h>
#include "codage.h"

int codage( char * cheminFic_m,char * cheminFic_k,char * cheminFic_mc ) {
  FILE *f_m, *f_k, *f_mc;
  
  int c,k1,calcul;
  
  f_m = fopen(cheminFic_m, "r");
  if (f_m==NULL){
    printf("Le fichier message est vide !\n");
    return EXIT_FAILURE;
  }
  f_k = fopen(cheminFic_k, "r");
  if (f_k==NULL){
    printf("Le fichier clé est vide !\n");
    return EXIT_FAILURE;
  }
  f_mc = fopen(cheminFic_mc, "w");
  while ((c = fgetc(f_m)) != EOF){
    k1 = fgetc(f_k);
    calcul = (c+k1) % 256;
    fputc(calcul, f_mc);
  }
  
  fclose(f_m);
  fclose(f_k);
  fclose(f_mc);
  printf("Message crypté avec succès !\n");
  return EXIT_SUCCESS;
}

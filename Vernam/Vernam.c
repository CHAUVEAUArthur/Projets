#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "codage.h"
#include "decodage.h"
#include "creationcle.h"

int main (int argc,char * argv[]){
  if(argc==1){
    printf("Usage : ./vernam -option[-c/-d/-k] <message> <cle> (<message_codé>/<message_décodé\n");
  }
  if (strcmp(argv[1],"-c")==0){
      if(argc<5){
	printf("Usage : ./vernam -option[-c] <message> <cle> <message_codé>\n");
	return EXIT_FAILURE;
      }
      else{
	codage(argv[2], argv[3], argv[4]);
      }
  }
  if (strcmp(argv[1],"-d")==0){
      if(argc<5){
	printf("Usage : ./vernam -option[-d] <message_codé> <cle> <message_décodé>\n");
	return EXIT_FAILURE;
      }
      else{
	decodage(argv[2], argv[3], argv[4]);
      }
  }
  if (strcmp(argv[1],"-k")==0){
      if(argc<4){
	printf("Usage : ./vernam -option[-k] <message> <cle>\n");
	return EXIT_FAILURE;
      }
      else{
	creationcle(argv[2], argv[3]);
      }
  }
  
  return EXIT_SUCCESS;
}
  
    
	      
	
	

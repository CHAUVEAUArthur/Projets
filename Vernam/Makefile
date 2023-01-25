# fichier Makefile

# CHAPITRE 1 : BUT FINAL

but : vernam

# CHAPITRE 2 : VARIABLES

OFILES = codage.o \
	 decodage.o \
         creationcle.o\
	 Vernam.o
CC = gcc
CFLAGS = -ansi -Wall

# CHAPITRE 3 : DEPENDANCES (REGLES IMPLICITES)

codage.o : codage.h
decodage.o : decodage.h
creationcle.o : creationcle.h
Vernam.o : codage.h decodage.h creationcle.h
vernam : $(OFILES)
	$(CC) $(CFLAGS) -o vernam $(OFILES)

#CHAPITRE 5 : NETTOYAGE DES FICHIERS GENERES
clean :
	-rm -f $(OFILES) vernam

#CHAPITRE 6 : BUTS FACTICES
.PHONY : but clean

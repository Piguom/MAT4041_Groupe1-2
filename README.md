# Gestion de file d'attente d'un supermarché

## R�alisation
```
Ce projet � �t� r�alis� par 3 �tudiants en 4�me ann�e d'�col� d'ing�nieur � l'ESIEA pour le cours de Processus Stochastique.\n
Geoffrey DEMOLON
Maxime ERDEM
Pierre FRIN
```

## Problèmatique
On souhaite étudier quelques aspects de l'organisation des caisses de supermarché, et éventuellement l'optimisation du système. 
Il y a un nombre ni de caisses.
L'organisation classique consiste à avoir une queue par caisse. Une organisation alternative consiste à n'avoir qu'une seule queue, et le premier dans la queue va à la première caisse qui se libère.         Comment modéliser l'arrivée de clients aux caisses, et le temps de traitement de chaque caisse ?                                  Comment s'assurer que la taille de la ou des queues (nombre total de personnes en attente) n'explose pas ?

## Packages
* Main 
```
C'est le package qui contient la classe principale du lancement de l'application
```

* Fenetre 
```
C'est le package qui contient tous les éléments principaux de notre fenêtre d'application
```

* ButtonsActions 
```
C'est le package qui contient tous les boutons disponibles entrainant une action sur l'application
```

* Caisses 
```
C'est le package qui gère les caisses
```

* Clients 
```
C'est le package qui gère les clients
```

* Simulateur 
```
C'est le package qui simule la file d'attente et tout ce qui va bien autour
```

## Fonctionnement principale
Il est nécessaire d'avoir exécuter le fichier "simulation" en bash qui retourne un fichier JSON qui est ensuite traité par l'application. Ce fichier JSON est le résultat de la simulation créé aléatoire par notre programme "simulation.cpp" codé en C++.
Lorsque le fichier JSON est à la racine du projet (même niveau que le dossier "src"), alors le programme lance l'application qui s'occupe d'interprêter graphiquement les données retournée par le script en C++.


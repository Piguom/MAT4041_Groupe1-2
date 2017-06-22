# Gestion de file d'attente d'un supermarch�

## R�alisation
```
Ce projet � �t� r�alis� par 3 �tudiants en 4�me ann�e d'�col� d'ing�nieur � l'ESIEA pour le cours de Processus Stochastique.
Geoffrey DEMOLON
Maxime ERDEM
Pierre FRIN
```

## Probl�matique
On souhaite �tudier quelques aspects de l'organisation des caisses de supermarch�, et �ventuellement l'optimisation du syst�me. 
Il y a un nombre ni de caisses.
L'organisation classique consiste à avoir une queue par caisse. Une organisation alternative consiste à n'avoir qu'une seule queue, et le premier dans la queue va � la premi�re caisse qui se lib�re.         Comment mod�liser l'arriv�e de clients aux caisses, et le temps de traitement de chaque caisse ?                                  Comment s'assurer que la taille de la ou des queues (nombre total de personnes en attente) n'explose pas ?

## Packages
* Main 
```
C'est le package qui contient la classe principale du lancement de l'application
```

* Fenetre 
```
C'est le package qui contient tous les �l�ments principaux de notre fen�tre d'application
```

* ButtonsActions 
```
C'est le package qui contient tous les boutons disponibles entrainant une action sur l'application
```

* Caisses 
```
C'est le package qui g�re les caisses
```

* Clients 
```
C'est le package qui g�re les clients
```

* Simulateur 
```
C'est le package qui simule la file d'attente et tout ce qui va bien autour
```

## Fonctionnement principale
Il est n�cessaire d'avoir ex�cuter le fichier "simulation" en bash qui retourne un fichier JSON qui est ensuite trait� par l'application. Ce fichier JSON est le r�sultat de la simulation cr�� al�atoire par notre programme "simulation.cpp" cod� en C++.
Lorsque le fichier JSON est à la racine du projet (même niveau que le dossier "src"), alors le programme lance l'application qui s'occupe d'interprêter graphiquement les donn�es retourn�e par le script en C++.


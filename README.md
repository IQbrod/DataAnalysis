# DataAnalysis [![Build Status](https://travis-ci.org/IQbrod/DataAnalysis.svg?branch=master)](https://travis-ci.org/IQbrod/DataAnalysis) [![codecov](https://codecov.io/gh/IQbrod/DataAnalysis/branch/master/graph/badge.svg)](https://codecov.io/gh/IQbrod/DataAnalysis)

M1 Info - DevOps - Projet

Description des fonctionnalitées offertes :
- Création d'un Dataframe de deux manières : depuis un fichier CSV/via plusieurs object de type List
- Récupération de données depuis ce Dataframe : une ou plusieurs lignes/une ou plusieurs colonnes
- Outils statistiques : moyenne/min/max sur une colonne

Description choix d'outils :
- Codecoverage : outil très utile pour voir l'étendue des test effectués
- Travis : outil très utile qui permet d'être sur que toute modification du code fonctionne
- JUnit : outil utilisé pour les tests
- Maven : outil utilisé afin de permettre un build automatique des sources du projet

Feedback :
Il s'avère au final que Maven est un outil qui nous a permis une fois configuré de gagner beaucoup de temps sur le build et la recherche de dépendances liés au projet. Il permet aussi de faire une installation rapide du projet sur une nouvelle machine en étant sur que le projet fonctionne à la sortie.
Codecoverage est un outil qui nous a permis de déployer les tests rapidement, vu qu'il nous montre clairement ou passent nos tests dans le code et permet ainsi de savoir ce qui n'a pas encore été testé.
JUnit a été notre outil pour le test, permettant de nous assurer que notre code ne contient pas de gros bug avant le déploiement.
Travis a bien rempli son rôle aussi, nous permettant d'être sur que notre code passe les tests à chaque push sur Github.

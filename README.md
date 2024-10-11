# FeelBack - Système de Feedback Client

## Description

FeelBack est une application qui permet de collecter les avis des clients sur les commandes livrées. L'objectif est d'améliorer la satisfaction client en recueillant des évaluations sur le délai de livraison, l'état du colis et le comportement du livreur. Les résultats sont ensuite utilisés pour fournir des statistiques au service commercial.

Le projet comprend :
- Un modèle de base de données relationnelle MySQL pour stocker les informations des utilisateurs, des commandes, des produits, et des feedbacks.
- Un questionnaire de satisfaction lié aux commandes, comprenant des questions notées de 1 à 5.

## Table des matières

1. [Conventions de nommage](#conventions-de-nommage)
2. [Dictionnaire de données](#dictionnaire-de-données)
3. [Installation](#installation)
4. [Utilisation des scripts SQL](#utilisation-des-scripts-sql)
5. [Modèle conceptuel et physique](#modèle-conceptuel-et-physique)
6. [Auteur](#auteur)

## Conventions de nommage

- **Noms des tables** : Utilisation du format `snake_case`, au singulier (ex. : `user`, `order`, `product`).
- **Noms des colonnes** : Format `snake_case`, en anglais (ex. : `user_id`, `order_id`).
- **Clés primaires** : `id` (auto-incrément).
- **Clés étrangères** : Doivent inclure le nom de la table référencée avec le suffixe `_id`.
- **Noms d'index** : Format `idx_table_column`.

## Dictionnaire de données

Le [dictionnaire de données](dictionnaire_donnees.csv) est disponible au format CSV, et décrit les tables, colonnes, types de données et leur description.

## Installation

### Prérequis

- [MySQL](https://www.mysql.com/) (version 5.7+)
- [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) pour gérer la base de données et générer le schéma visuel
- le fichier nommé : "feelback_db_localhost-2024_10_11_16_32_47-dump.sql" comporte les données factices nécéssaires pour vérifier le bon fonctionnement de le base.  

### Étapes d'installation

1. **Cloner le dépôt** :
   ```bash
   git clone https://github.com/VOTRENOMDUTILISATEUR/feelback.git
   cd feelback

# 🏨 OPC-03 : Gestion d'un Hôtel

## 📄 Contexte :
Bienvenue dans ce challenge où vous allez devoir développer un programme de gestion pour l'hôtel **"Soleil Royal"**. Cet hôtel souhaite un système qui permet de gérer les **réservations de chambres** et leur **disponibilité**. L'hôtel dispose de trois types de chambres :

- **Chambre Simple** 🛏️ : 1 lit simple
- **Chambre Double** 🛏️🛏️ : 1 lit double
- **Suite** 🏠 : 1 chambre avec un salon, un lit double et des services supplémentaires (comme le service en chambre).

Votre mission sera de créer un programme qui permettra de gérer les réservations pour ces différentes chambres.

---

## 🎯 Objectifs :
Vous devez développer un programme en Kotlin qui permettra à l'hôtel de réaliser les actions suivantes :

1. **Ajouter une chambre** 🛎️ :  
   L'hôtel doit pouvoir ajouter des chambres avec un **numéro unique**, un **type de chambre** (simple, double, suite), et un **prix par nuit**.

2. **Faire une réservation** 📅 :  
   Les clients doivent pouvoir **réserver une chambre** en fonction de son **type** et pour un **nombre donné de nuits**.

3. **Afficher la disponibilité des chambres** ✅ :  
   Le programme doit permettre de **voir les chambres disponibles** en fonction du **type de chambre** sélectionné.

4. **Calculer le coût total de la réservation** 💶 :  
   Le programme doit **calculer le coût total** de la réservation, basé sur le **nombre de nuits** et le **type de chambre** réservé.

5. **Annuler une réservation** ❌ :  
   L'hôtel doit pouvoir **annuler une réservation** en fonction du **numéro de réservation**.

---

## 📋 Consignes :
Afin de bien structurer votre projet, voici quelques consignes :

- 🖼️ **Diagrammes** : Proposez un **diagramme de cas d'utilisation** et un **diagramme de classes** pour représenter le système de gestion décrit.
  
- 💻 **Classes et Objets** : Utilisez les **concepts de classes et d'objets** en Kotlin pour organiser votre programme.
  
- 🛏️ **Classe Chambre** : Créez une classe `Chambre` qui contiendra toutes les propriétés nécessaires pour chaque type de chambre (numéro, type, prix par nuit, disponibilité, etc.).
  
- 🏨 **Classe Hotel** : Créez une classe `Hotel` qui gérera toutes les chambres, les réservations et leurs statuts (disponibilité, coût total, annulation, etc.).

- 📊 **Structure de données** : Utilisez une **structure de données adaptée** pour stocker les informations sur les chambres et les réservations (listes, maps, etc.).

---

## 💡 Astuces pour débuter :
- Réfléchissez aux propriétés que chaque classe doit avoir (par exemple, une chambre a un numéro, un type, et un prix).
- Pensez aux méthodes que vous allez devoir implémenter (par exemple, réserver une chambre, annuler une réservation).
- Utilisez des **listes** ou des **maps** pour gérer les chambres et les réservations de manière efficace.
- N'oubliez pas de bien tester votre programme avec plusieurs scénarios de réservation.

Bonne chance et amusez-vous à coder ! 🎉

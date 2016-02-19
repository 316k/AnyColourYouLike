# AnyColourYouLike

Vous devez implanter un programme simple qui utilise l'apprentissage machine pour identifier des couleurs par leur nom.

## Code fourni

Le code a plusieurs classes, celles auquelles vous allez toucher sont :

- AnyColourYouLike.java : main
- ColorLabel : Représentation d'une couleur (r: 0-255, g: 0-255, b: 0-255, name: nom donné à la couleur)
- ColorClassifier : Classe abstraite de classificateur
    - SimpleColorClassifier : Classificateur par la méthode de l'histogramme
    - KNNColorClassifier : Classificateur par la méthode des K plus proches voisins


ColorClassifier définit les méthodes `add` et `colorName`, que vous devrez implanter.


## Étapes du projet

### 0. Familiarisation

Avant de commencer à coder, vous pouvez lancer le programme et vous familiariser avec l'interface. Le Color Picker permet de sélectionner une couleur et de voir son nom en temps réel.

Pour l'instant, ça ne devrait afficher qu'un "?", car les algorithmes n'ont pas été implantées...

Notez le champ d'entrée sous le "?", où vous pourrez ajouter des couleurs arbitraires à l'ensemble de couleurs connues.

Prenez ensuite le temps de lire un peu les classes mentionnées précédement et de les comprendre.


### 1. Classification par histogramme

Le premier algorithme à implanter est celui de l'histogramme.

Vous avez (au moins) deux méthodes à implanter dans la classe `SimpleColorClassifier` :

#### a) La méthode add

```java
    public void add(int r, int g, int b, String name) { ... }
```

Se chargera d'ajouter une couleur au `this.cube` dans la bonne section selon les valeurs r,g,b passées en paramètre.

Notez que le nombre de sections est une variable, `this.sections` (un `int`).

Notez également que `this.cube[x][y][z]` est un ArrayList de String. On peut donc faire `this.cube[x][y][z].add("Bonjour")` pour ajouter le nom "Bonjour" dans la section (x,y,z).

#### b) La méthode colorName

```java
    public String colorName(int r, int g, int b) { ... }
```

Se chargera de donner le nom d'une couleur selon ce qui se trouve dans la section du cube correspondant à (r, g, b).

*Indice* : Le code de classification dans une section donnée de (r, g, b) va se répéter entre `add` et `colorName`, ça peut être une bonne idée d'en faire une méthode de la classe.

Vous pouvez utiliser la fonction `ColorClassifier.majorityVote(ArrayList<String> arr)` pour obtenir le résultat du vote majoritaire sur un ArrayList de noms de couleurs.

Une fois que votre code fonctionne, vous pouvez le tester sur des plus gros ensembles de données que l'ensemble de base.
[(Voir la section sur les ensembles de données)](#dataset)
    
### 2. Classification par les K plus proches voisins

Le deuxième algorithme à implanter est celui des K plus proches voisins (*K nearest neighbors*).

Encore une fois, vous devrez implanter les deux mêmes méthodes pour la classe `KNNColorClassifier`, en plus d'une méthode de comparaison de deux couleurs qui sera utile :

#### a) La méthode add

Puisqu'on n'a plus à gérer un cube d'ArrayList, le code de cette fonction devrait être plus simple.

La classe possède un ArrayList de ColorLabel, `this.colors`, où vous pouvez simplement stocker les couleurs.

#### b) La méthode de comparaison des couleurs

Cette méthode sera utile pour savoir quels sont les voisins les plus proches d'une couleur donnée.

Vous trouverez dans la classe `ColorLabel` la fonction :

```java
    public int compareTo(ColorLabel other) { ... }
```

Qui devra retourner la distance Euclidienne entre deux couleurs.

Rappelez-vous que les couleurs peuvent être vus comme des vecteurs à 3 valeurs (r, g, b), la formule de la distance sera donc :

![Distance euclidienne en 3D](distance-euclidienne.png)

#### c) La méthode colorName

Cette méthode sera un peu plus complexe que les autres : vous allez devoir trouver les K plus proches voisins d'une couleur donnée.

Pour cela, vous devrez donc :

1. Parcourir la liste de couleurs connues
2. Garder seulement les `this.k` éléments ayant la plus faible distance avec la couleur inconnue.

Une fois votre liste de 

### Bonus : K plus proches voisins pondérés



## Ensembles de données

<span id="dataset"></span>

On dispose de trois ensembles de données pour tester les algorithmes :

- SimpleDataset : un ensemble ayant seulement 5 données : Rouge, Vert, Bleu, Blanc et Noir
- BigDataset : Un échantillon de 2700 données d'un ensemble de réponses à un sondage fait sur Internet
- HugeDataset : L'ensemble des données (> 3 millions) du sondage mentionné ci-haut

<small>Référence du sondage : [http://blog.xkcd.com/2010/05/03/color-survey-results/](http://blog.xkcd.com/2010/05/03/color-survey-results/)</small>


Vous remarquerez que le choix de l'ensemble de données change drastiquement les résultats ainsi que la vitesse du programme.


Pour choisir l'ensemble utilisé, changez la classe utilisée dans :

<code><pre>
// Fichier : AnyColourYouLike.java
1 package anycolouryoulike;
2 
3 public class AnyColorYouLike {
4 
5     public static void main(String[] args) {
6
7         Window w = new Window(new SimpleColorClassifier(<b><u>SimpleDataset</u></b>.colors(), 2));
8     }
9 }
</pre></code>


# Question 1 : Ou se trouve ce fichier ? Donnez son nom et son emplacement dans l'arborescence du projet ?
R4A11\TP1\app\src\main\res\layout\activity_main.xml

# Question 2 : Qu'avez-vous modifier ?
La ligne android:text="Coucou, j'ai trouvé comment faire !" du TextView dans le fichier activity_main.xml

# Question 3 : Qu'avez-vous modifié pour changer l'icone ?
La ligne android:icon="@mipmap/ic_launcher" et android:roundIcon="" du manifest

# Question 4 : Est-ce nécessaire de cliquer sur le bouton valider pour afficher le texte saisi sur la seconde activité ? Pourquoi ?
Non, on ne doit pas cliquer sur le bouton valider pour afficher le texte saisi sur la seconde activité car il n'y a pas de verification préalable au changement d'activité

# Question 5 : Le comportement de la question 4 vous semble-t-il normal ?
Non, nous devrions vérifier que le texte est bien saisi avant de changer d'activité

# Question 6 : Comment faire pour ne pas afficher le nouveau texte sur la deuxième activité tant que le bouton valider n'a pas été cliqué ?
Faire l'attribution de la variable dans le bouton valider et vérifier si la variable est vide ou non avant de changer d'activité
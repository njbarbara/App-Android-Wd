# Application Android - 🐺 Wolves of Democracy

Application Android de **Loup-Garou en ligne**, développée en **Kotlin** avec **Jetpack Compose**, sur GitLab.

## Le jeu

Une adaptation des *Loups-Garous de Thiercelieu* dans un univers de science-fiction.
Chaque joueur est soit un **Citoyen**, soit un **Traître** :

- **La nuit**, les traîtres choisissent ensemble une victime.
- **Le jour**, les citoyens débattent puis votent pour exécuter un suspect.
- La partie se termine quand tous les traîtres sont éliminés, ou quand ils deviennent majoritaires.

## Fonctionnalités

- Inscription et connexion, avec session conservée sur l'appareil
- Liste des salons publics, filtrable par statut (en attente, en cours, terminés)
- Création d'une partie (nombre de joueurs, durée d'une phase)
- Profil du joueur et historique de ses parties
- Pages Règles, Paramètres et Crédits

## Stack technique

| Domaine          | Outils                                         |
| ---------------- | ---------------------------------------------- |
| Langage          | Kotlin                                         |
| Interface        | Jetpack Compose, Material 3                    |
| Navigation       | Navigation Compose (routes typées)             |
| Architecture     | MVVM (ViewModel, StateFlow)                    |
| Réseau           | Retrofit, OkHttp, Gson                         |
| Stockage local   | DataStore                                      |
| Asynchrone       | Coroutines Kotlin                              |
| Tests            | JUnit, Robolectric, Espresso, Compose UI Test  |
| Qualité / CI     | JaCoCo, SonarQube, GitLab CI                   |

## Architecture

L'application suit une architecture **MVVM** :

- les **écrans** Compose (`pages/`) affichent l'état fourni par les ViewModels ;
- les **ViewModels** (`viewmodel/`, `viewmodels/`) gèrent la logique et l'état de chaque écran ;
- la **couche données** (`data/`, `services/`, `models/`) communique avec l'API REST du jeu via Retrofit et stocke la session utilisateur avec DataStore.

## Lancer le projet

**Prérequis :** Android Studio, JDK 17, un appareil ou émulateur sous Android 7.0 (API 24) minimum.

1. Ouvrir le projet dans Android Studio.
2. Lancer la configuration `app` sur un émulateur ou un appareil.

Ou en ligne de commande :

```bash
./gradlew assembleDebug
```

> Les fonctionnalités en ligne (connexion, salons, profil, historique) nécessitent que l'API du jeu soit accessible, ce qui n'est pas encore le cas. Son adresse est définie dans `data/api/RetrofitClient.kt`.

## Tests

```bash
./gradlew testDebugUnitTest           # tests unitaires
./gradlew jacocoDebugUnitTestReport   # rapport de couverture (JaCoCo)
./gradlew connectedAndroidTest        # tests instrumentés (émulateur ou appareil requis)
```

À chaque push sur `main`, la pipeline GitLab CI exécute les tests, génère le rapport de couverture et lance une analyse SonarQube.

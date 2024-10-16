### FIRST
- F => FAST
- I => ISOLATED
- R => REPEATABLE
- S => SELF-VALIDATING
- T => TIMELY

#### FAST

- Les tests unitaires doivent être rapides à executer.
- Le temps ne doit pas dissuader le développeur de less exécuter !

#### ISOLATED AND INDEPENDENT

- Les tests unitaires doivent être isolés.
- Les ne doivent pas dépendre d'autres tests, ni de l'environnement
- Ils doivent pouvoir être executés dans n'importe quel ordre !


#### REPEATABLE

- On doit pouvoir ( à condition égale) exécuter un test et avoir le m^me résultat à chaque fois !
- Pas de dépendance, pas de hasard, pas de date, pas de connexion internet, base de données...

#### SELF-VALIDATING

- Un test doit se valider tout seul.


#### TIMELY

- Les tests doivent être écrits au bon moment, idéalement avant ou pendant le développement de la fonctionnalité
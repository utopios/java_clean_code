## Kata 1 : Gestion des Commandes

**Description :**

Vous disposez d'une classe `OrderManager` qui gère les commandes clients. Le code actuel est difficile à maintenir en raison de sa complexité et de sa mauvaise organisation.

**Code de Départ :**

```java
public class OrderManager {
    public void processOrder(Order order) {
        // Validation de la commande
        if (order != null) {
            if (order.getItems() != null && !order.getItems().isEmpty()) {
                // Calcul du total
                double total = 0;
                for (Item item : order.getItems()) {
                    total += item.getPrice() * item.getQuantity();
                }
                // Application des taxes
                double taxes = total * 0.2;
                total += taxes;
                // Vérification du stock
                for (Item item : order.getItems()) {
                    int stock = getStockForItem(item);
                    if (stock < item.getQuantity()) {
                        System.out.println("Stock insuffisant pour l'article : " + item.getName());
                        return;
                    }
                }
                // Mise à jour du stock
                for (Item item : order.getItems()) {
                    updateStock(item, item.getQuantity());
                }
                // Envoi de la confirmation
                sendOrderConfirmation(order, total);
            } else {
                System.out.println("La commande ne contient aucun article.");
            }
        } else {
            System.out.println("Commande invalide.");
        }
    }

    // Autres méthodes : getStockForItem, updateStock, sendOrderConfirmation
}
```


---

## Kata 3 : Calculateur de Prix

**Description :**

Une application calcule le prix de produits en fonction de leur type et applique des remises spécifiques. Le code actuel utilise de nombreux `if` et `switch` et est difficile à maintenir.

**Code de Départ :**

```java
public class PriceCalculator {
    public double calculatePrice(Product product) {
        double price = product.getBasePrice();
        if (product.getType() == ProductType.ELECTRONICS) {
            price += price * 0.15; // Taxe électronique
            if (product.isOnSale()) {
                price -= price * 0.1; // Remise de 10%
            }
        } else if (product.getType() == ProductType.BOOK) {
            price += price * 0.05; // Taxe livre
        } else if (product.getType() == ProductType.CLOTHING) {
            price += price * 0.2; // Taxe vêtements
            if (product.isImported()) {
                price += price * 0.05; // Taxe d'importation
            }
        }
        // Autres types de produits
        return price;
    }
}
```

---

## Kata 4 : Gestion des Employés

**Description :**

Le système de gestion des employés doit calculer les salaires en fonction du type d'employé et de leurs heures travaillées. Le code est complexe et contient des duplications.

**Code de Départ :**

```java
public class Payroll {
    public double calculateSalary(Employee employee) {
        double salary = 0;
        if (employee.getRole().equals("Developer")) {
            salary = employee.getHoursWorked() * 50;
            // Bonus pour les développeurs
            if (employee.getYearsOfExperience() > 5) {
                salary += 1000;
            }
        } else if (employee.getRole().equals("Manager")) {
            salary = employee.getHoursWorked() * 60;
            // Bonus pour les managers
            if (employee.getTeamSize() > 10) {
                salary += 2000;
            }
        } else if (employee.getRole().equals("Intern")) {
            salary = employee.getHoursWorked() * 20;
        }
        // Autres rôles
        return salary;
    }
}
```

---

## Kata 5 : Analyse des Données

**Description :**

Une classe `DataAnalyzer` lit des données à partir de différentes sources et les traite. Le code est rempli de duplications et ne suit pas les principes de conception.

**Code de Départ :**

```java
public class DataAnalyzer {
    public void analyzeData(String sourceType) {
        if (sourceType.equals("database")) {
            // Connexion à la base de données
            // Lecture des données
            // Traitement des données
        } else if (sourceType.equals("file")) {
            // Ouverture du fichier
            // Lecture des données
            // Traitement des données
        } else if (sourceType.equals("api")) {
            // Appel de l'API
            // Lecture des données
            // Traitement des données
        } else {
            System.out.println("Type de source inconnu.");
        }
    }
}
```

---

## Kata 6 : Gestion des Transactions Bancaires

**Description :**

Le système bancaire gère les transactions entre comptes. Le code actuel a des problèmes de couplage et de complexité, ce qui rend difficile l'ajout de nouveaux types de transactions.

**Code de Départ :**

```java
public class TransactionManager {
    public void processTransaction(Transaction transaction) {
        if (transaction.getType() == TransactionType.DEPOSIT) {
            Account account = getAccount(transaction.getAccountId());
            account.setBalance(account.getBalance() + transaction.getAmount());
        } else if (transaction.getType() == TransactionType.WITHDRAWAL) {
            Account account = getAccount(transaction.getAccountId());
            account.setBalance(account.getBalance() - transaction.getAmount());
        } else if (transaction.getType() == TransactionType.TRANSFER) {
            Account sourceAccount = getAccount(transaction.getSourceAccountId());
            Account destinationAccount = getAccount(transaction.getDestinationAccountId());
            sourceAccount.setBalance(sourceAccount.getBalance() - transaction.getAmount());
            destinationAccount.setBalance(destinationAccount.getBalance() + transaction.getAmount());
        }
        // Enregistrement de la transaction
        saveTransaction(transaction);
    }
}
```

---

## Kata 7 : Système de Réservation

**Description:**

Un système de réservation de salles doit gérer les réservations pour différents types d'événements. Le code contient des structures conditionnelles complexes et est difficile à maintenir.

**Code de Départ :**

```java
public class BookingSystem {
    public void bookRoom(Event event) {
        if (event.getType() == EventType.CONFERENCE) {
            // Réserver une salle de conférence
            // Configurer l'équipement audiovisuel
            // Organiser le service de restauration
        } else if (event.getType() == EventType.MEETING) {
            // Réserver une salle de réunion
            // Organiser les boissons
        } else if (event.getType() == EventType.WEDDING) {
            // Réserver une salle de banquet
            // Décoration
            // Service traiteur
            // Musique
        }
        // Autres types d'événements
    }
}
```

---

## Kata 8 : Gestion des Utilisateurs

**Description :**

Le système gère les utilisateurs avec différents rôles et permissions. Le code actuel est mal organisé et mélange les responsabilités.

**Code de Départ :**

```java
public class UserManager {
    public void createUser(String username, String password, String role) {
        // Validation des données
        // Création de l'utilisateur dans la base de données
        // Attribution du rôle
        if (role.equals("admin")) {
            // Donner toutes les permissions
        } else if (role.equals("editor")) {
            // Donner les permissions d'édition
        } else if (role.equals("viewer")) {
            // Donner les permissions de visualisation
        } else {
            System.out.println("Rôle inconnu.");
        }
    }
}
```

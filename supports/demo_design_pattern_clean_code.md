### 1. **Singleton**

Le patron **Singleton** garantit qu'une classe n'a qu'une seule instance dans tout le système.

```java
public class Singleton {
    private static Singleton instance;

    // Constructeur privé pour empêcher l'instanciation
    private Singleton() {}

    public synchronized static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton instance");
    }
}
```

---

### 2. **Factory Method**

Le patron **Factory Method** crée des objets sans spécifier leur classe concrète.

```java
interface Product {
    void use();
}

class ConcreteProductA implements Product {
    public void use() {
        System.out.println("Using product A");
    }
}

class ConcreteProductB implements Product {
    public void use() {
        System.out.println("Using product B");
    }
}

abstract class Creator {
    public abstract Product createProduct();
}

class ConcreteCreatorA extends Creator {
    public Product createProduct() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    public Product createProduct() {
        return new ConcreteProductB();
    }
}

// Utilisation
Creator creator = new ConcreteCreatorA();
Product product = creator.createProduct();
product.use();
```

---

### 3. **Decorator**

Le patron **Decorator** ajoute dynamiquement des fonctionnalités à un objet sans modifier son code.

```java
interface Coffee {
    double cost();
}

class SimpleCoffee implements Coffee {
    public double cost() {
        return 5.0;
    }
}

class MilkDecorator implements Coffee {
    private Coffee coffee;

    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public double cost() {
        return coffee.cost() + 2.0;
    }
}

// Utilisation
Coffee coffee = new SimpleCoffee();
coffee = new MilkDecorator(coffee); // Ajoute du lait
System.out.println("Cost: " + coffee.cost());
```

---

### 4. **Adapter**

Le patron **Adapter** permet à des classes avec des interfaces incompatibles de travailler ensemble.

```java
interface OldSystem {
    void oldRequest();
}

class NewSystem {
    public void newRequest() {
        System.out.println("New system request");
    }
}

class Adapter implements OldSystem {
    private NewSystem newSystem;

    public Adapter(NewSystem newSystem) {
        this.newSystem = newSystem;
    }

    public void oldRequest() {
        newSystem.newRequest();
    }
}

// Utilisation
OldSystem oldSystem = new Adapter(new NewSystem());
oldSystem.oldRequest();
```

---

### 5. **Facade**

Le patron **Facade** fournit une interface simplifiée pour un sous-système complexe.

```java
class SubsystemA {
    public void operationA() {
        System.out.println("Operation A");
    }
}

class SubsystemB {
    public void operationB() {
        System.out.println("Operation B");
    }
}

class Facade {
    private SubsystemA subsystemA = new SubsystemA();
    private SubsystemB subsystemB = new SubsystemB();

    public void doOperation() {
        subsystemA.operationA();
        subsystemB.operationB();
    }
}

// Utilisation
Facade facade = new Facade();
facade.doOperation();
```

---

### 6. **Strategy**

Le patron **Strategy** permet de choisir dynamiquement l'algorithme à utiliser.

```java
interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using credit card");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public ShoppingCart(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Utilisation
ShoppingCart cart = new ShoppingCart(new CreditCardPayment());
cart.checkout(100);  // Choix de la stratégie de paiement
```

---

### 7. **Observer**

Le patron **Observer** permet à des objets d'être informés des changements d'un autre objet.

```java
interface Observer {
    void update();
}

class ConcreteObserver implements Observer {
    public void update() {
        System.out.println("Observer updated");
    }
}

class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// Utilisation
Subject subject = new Subject();
Observer observer1 = new ConcreteObserver();
Observer observer2 = new ConcreteObserver();

subject.addObserver(observer1);
subject.addObserver(observer2);
subject.notifyObservers();  // Notifie tous les observateurs
```

---

### 8. **Command**

Le patron **Command** encapsule une requête en tant qu'objet pour paramétrer les actions à effectuer.

```java
interface Command {
    void execute();
}

class LightOnCommand implements Command {
    public void execute() {
        System.out.println("Light is ON");
    }
}

class LightOffCommand implements Command {
    public void execute() {
        System.out.println("Light is OFF");
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Utilisation
RemoteControl remote = new RemoteControl();
Command lightOn = new LightOnCommand();
remote.setCommand(lightOn);
remote.pressButton();  // Active la commande allumer la lumière
```

---

### 9. **Template Method**

Le patron **Template Method** définit un squelette d'algorithme avec certaines étapes définies par les sous-classes.

```java
abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    // Template method
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

class Football extends Game {
    void initialize() {
        System.out.println("Football Game Initialized!");
    }

    void startPlay() {
        System.out.println("Football Game Started!");
    }

    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}
class Basketball extends Game {
    void initialize() {
        System.out.println("Basketball Game Initialized!");
    }

    void startPlay() {
        System.out.println("Basketball Game Started!");
    }

    void endPlay() {
        System.out.println("Basketball Game Finished!");
    }
}

// Utilisation
Game game = new Football();
game.play();

Game game2 = new Basketball();
game2.play();

```

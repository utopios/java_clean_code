public class Singleton {
    private static Singleton instance;

    private Singleton() {
        //Création de l'objet
    }

    public synchronized static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void action1() {

    }

    public void action2() {

    }
}

public class Main() {
    public static void main(String[] args) {
        Singleton.getInstance().action1();
        Singleton.getInstance().action2();
    } 
}
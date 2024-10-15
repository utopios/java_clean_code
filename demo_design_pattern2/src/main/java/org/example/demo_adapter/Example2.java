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
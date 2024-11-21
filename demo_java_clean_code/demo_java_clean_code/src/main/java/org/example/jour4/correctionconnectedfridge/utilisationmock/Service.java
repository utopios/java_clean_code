package org.example.jour4.correctionconnectedfridge.utilisationmock;

public class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public String getData(int id) {
        String data = repository.findDataById(id);
        return data != null ? data.toUpperCase() : "NO DATA";
    }
}

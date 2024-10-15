package org.example.demo_revision_singelton;

import java.util.*;

public class QuiCorrige {

    private static QuiCorrige instance = null;

    private Random random = new Random();

    public List<String> dejaCorrige = new ArrayList<>();
    public List<String> pasEncore = new ArrayList<>(Arrays.asList("Alexandre M", "Alexandre P", "Anthony", "Cindy", "Fares", "Florian", "François", "Jaber", "Jeremy", "Lalia", "Nawal", "Roxane"));

    private QuiCorrige() {

    }

    public synchronized static QuiCorrige getInstance() {
        if(instance == null)
            instance = new QuiCorrige();
        return instance;
    }

    public String quiCorrige() {
        if(pasEncore.size() == 0) {
            pasEncore.addAll(dejaCorrige);
            dejaCorrige.clear();
        }
        String stagiaire = pasEncore.get(random.nextInt(0, pasEncore.size()));
        dejaCorrige.add(stagiaire);
        int index = pasEncore.indexOf(stagiaire);
        pasEncore.remove(index);
        return stagiaire;
    }

}

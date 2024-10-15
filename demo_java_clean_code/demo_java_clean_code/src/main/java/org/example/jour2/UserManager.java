package org.example.jour2;

public class UserManager {

    private final EmailService emailService;

    public UserManager(EmailService emailService) {
        this.emailService = emailService;
    }

    public void createUser() {
        //Logique création du user
    }

    /*public void sendEmail() {
        //Logique envoie mail
    }*/
}

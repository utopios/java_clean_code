package org.example.jour2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailService {

    private final Logger logger;

    public EmailService(Logger logger) {
        this.logger = logger;
    }

    public void sendEmail(String mailAddress) {
        logger.log(Level.INFO, "mail address "+mailAddress);
    }
}

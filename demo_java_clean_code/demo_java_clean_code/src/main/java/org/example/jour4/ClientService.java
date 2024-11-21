public class ClientService {
    public void processClientData(Client client) {
        // Validation des données client
        if (client.getName() != null && client.getAge() > 0) {
            // Calcul du score de crédit
            int creditScore = calculateCreditScore(client);
            // Envoi d'un email de bienvenue
            EmailService emailService = new EmailService();
            emailService.sendWelcomeEmail(client.getEmail());
            // Mise à jour de la base de données
            Database database = new Database();
            database.updateClientRecord(client);
        } else {
            throw new IllegalArgumentException("Données client invalides");
        }
    }
}
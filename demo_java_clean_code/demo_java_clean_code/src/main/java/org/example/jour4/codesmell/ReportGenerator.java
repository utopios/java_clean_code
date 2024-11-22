/*
public class ReportGenerator {
    private String title;
    private String content;
    private String footer;
    

    public ReportGenerator(String title, String content, String footer) {
        this.title = title;
        this.content = content;
        this.footer = footer;
    }

    public void generate() {
        // Génération du rapport
        
    }
}

public class DatabaseReportGenerator extends ReportGenerator {
    private Connection databaseConnection; // Utilisé uniquement pour certains rapports
    public ReportGenerator(String title, String content, String footer, Connection databaseConnection) {
        super(title, content, footer);
        this.databaseConnection = databaseConnection;
    }


    @Override
    public void generate() {
        super.generate();
        //Génération spécifique avec accès à la base de données
    }
} */

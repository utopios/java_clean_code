package org.example.jour2;

/*public class ReportGenerator {
    private DatabaseConnection dbConnection = new DatabaseConnection();
}*/
public class ReportGenerator {
    private Database dbConnection;

    public ReportGenerator(Database dbConnection) {
        this.dbConnection = dbConnection;
    }
}


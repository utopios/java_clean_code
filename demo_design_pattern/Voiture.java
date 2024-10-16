interface Observer {
    void update(double prix);
}

class Voiture {
    private List<Observer> observers = new ArrayList<>();
    private double prix;

    public void promotion(double promo) {
        prix = promo;
        //Email, sms,...
        notifyObservers()
    }
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void notifyObservers() {
        for(Observer observer: observers) {
            observer.update(prix);
        }
    }
}

class EmailService implements Observer {
    public void update(doube prix) {
        //Envoie du mail
    }
}

class VoitureService {
    private final EmailService emailService;

    public Voiture get(int id) {
        
        /// récupération de la voiture à partir du repository
        Voiture voiture = voitureRepository.get(id);
        voiture.addObserver(emailService);
    }
}


@Path("voiture")
class VoitureRessource {

    @GET
    @Path("{id}/promo/{promo}")
    public Response promotion(@PathVariable("promo") int id,@PathVariable("promo") double promo) {

        Voiture voiture = voitureService.get(id);
        voiture.promotion(promo);
        ///emailService.envoiePromo();
        //...
        return Response.ok();
    }
}
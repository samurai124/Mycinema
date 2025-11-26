package Ticket;


public class Ticket {
    private float prix;
    private int seanceId;
    private int spectateurId;

    public Ticket(float prix, int seanceId, int spectateurId) {
        this.prix = prix;
        this.seanceId = seanceId;
        this.spectateurId = spectateurId;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getSeanceId() {
        return seanceId;
    }

    public void setSeanceId(int seanceId) {
        this.seanceId = seanceId;
    }

    public int getSpectateurId() {
        return spectateurId;
    }

    public void setSpectateurId(int spectateurId) {
        this.spectateurId = spectateurId;
    }
}


package Film;

public class Film {
    private String titre;
    private String duree;
    private String categorie;


    public Film(String titre, String duree, String categorie){
        this.titre = titre;
        this.duree = duree;
        this.categorie = categorie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}

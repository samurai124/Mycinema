package Film;

public class Film {
    static int idgenerator = 1;
    private int filmId;
    private String titre;
    private String duree;
    private String categorie;

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public Film(String titre, String duree, String categorie){
        this.filmId = idgenerator++;
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

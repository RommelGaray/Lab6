package Beans;

public class Cancion {
    private int idCancion;
    private String nombreCancion;
    private String banda;
    private int favorito;
    private int idLista;

    public Cancion(int idCancion, String nombreCancion, String banda, int favorito) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.banda = banda;
        this.favorito=favorito;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }
}

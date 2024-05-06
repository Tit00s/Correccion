import java.io.Serializable;

public class Jugador implements Serializable {

    private  int poder;
    private  String tipo;
    private String[] armas;

    public Jugador(int p, String t, String []a) {
        setArmas(a);
        setPoder(p);
        setTipo(t);
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public String getTipo() {
        return tipo;
    }

    public String[] getArmas() {
        return armas;
    }

    public void setArmas(String[] armas) {
        this.armas = armas;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

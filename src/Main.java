import javax.swing.*;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Jugador> Jugadores = new ArrayList<>();
    private static ArrayList<JFrame> Ventanas = new ArrayList<>();
    public static void main(String[] args) {

        VentanaCrea frame = new VentanaCrea();
        frame.setVisible(true);
        Ventanas.add(frame);

    }
    public static void AñadirVentana(JFrame jf){        //Añadir las ventanas a su arrayList
        Ventanas.add(jf);
    }
    public static JFrame BuscaVentana(String titulo){       //Buscar ventanas por su titulo
        int i=0;
        while (i<Ventanas.size()){
            if (Ventanas.get(i).getTitle().equalsIgnoreCase(titulo)){
                return Ventanas.get(i);
            }
            i++;
        }
        return null;
    }
    public static int Tamaño(){

        return  Jugadores.size();
    }
    public static void Añadir(Jugador J){       //Añadir al ArrayList
        Jugadores.add(J);
    }
    public static Jugador getJugador(int posi){       //Coger un jugador en la posi pasada
        return Jugadores.get(posi);
    }
}
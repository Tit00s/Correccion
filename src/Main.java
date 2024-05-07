import javax.swing.*;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Jugador> Jugadores = new ArrayList<>();
    private static ArrayList<JFrame> Ventanas = new ArrayList<>();
    public static void main(String[] args) {

        VentanaCrea frame = new VentanaCrea();  //crear la primera ventana
        frame.setVisible(true);
        Ventanas.add(frame);

    }
    public static void AñadirVentana(JFrame jf){        //Añadir las ventanas a su arrayList
        Ventanas.add(jf);
    }   //Añadir las ventanas al array list
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
    public static int Tamaño(){     //Recuerda que NUNCA llamo al arraylist fuera de Main, creo metodos publicos en main para mandar la info

        return  Jugadores.size();
    }
    public static void Añadir(Jugador J){       //Añadir al ArrayList
        Jugadores.add(J);
    }
    public static Jugador getJugador(int posi){       //Coger un jugador en la posi pasada, es un get normal pero con un metodo hecho por nosotros
        return Jugadores.get(posi);
    }

    public static void Borrar(){
        Jugadores.clear();
    }


}
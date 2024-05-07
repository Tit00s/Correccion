import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.*;

public class Mostrar extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTable table1;
    private JList ListaArmas;
    private JLabel nombre;
    private JButton Guarda;
    private JButton Cargar;

    public static DefaultTableModel modelo = new DefaultTableModel();



    Mostrar(){
        this.setTitle("Mostrar");
        this.setVisible(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);   //Todas las ventanas que no sean la princiapal tendran hide on close, se guardaran en el list de ventanas de main
        this.setSize(500,500);
        modelo.addColumn("Poder");
        modelo.addColumn("Tipo");
        table1.setModel(modelo);
        this.add(panel1);
        Main.AñadirVentana(this);
        Guarda.addActionListener(this);
        Cargar.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            @Override   //listener de eventos de ventana
            public void windowClosing(WindowEvent e) {  //Para las acciones de la ventana, sirve para las de cerrar, minimizar y maximizar.
                super.windowClosing(e);
                JFrame frame=   Main.BuscaVentana("Crear");
                frame.setVisible(true);
            }
        });
      table1.addMouseListener(new MouseListener() { //Eventos de raton
          @Override
          public void mouseClicked(MouseEvent e) {
              int row = table1.getSelectedRow();      //Coger la fila seleccioanda, tambien sirve como indice del array
              if (row != -1){
                  Jugador j = Main.getJugador(row);
                  nombre.setText(j.getTipo());
                  ListaArmas.setListData(j.getArmas());       //Para poner las armas
          }
          }
          @Override
          public void mousePressed(MouseEvent e) {

          }

          @Override
          public void mouseReleased(MouseEvent e) {

          }

          @Override
          public void mouseEntered(MouseEvent e) {

          }

          @Override
          public void mouseExited(MouseEvent e) {

          }
      });
    }
    public static void Actualizar(){      //Para Actualizar la tabla, sirve para todo
        for (int i =modelo.getRowCount();i<Main.Tamaño();i++){
            modelo.addRow(new Object[]{Main.getJugador(i).getPoder(),Main.getJugador(i).getTipo()});    //No usamos el Tostring, cogemos los datos a dedo.
        }
    }
    public int Info(String mensaje, String titulo){ //Un Joption que muestra la info pasada, para no crear uno siempre
        JOptionPane.showMessageDialog(this, mensaje,titulo,JOptionPane.WARNING_MESSAGE);
        return 0;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Guarda){
            String ruta =elegirRuta();
            if (ruta != null){
                escribir(ruta);
            }
        }
        if (e.getSource() == Cargar){
            String ruta = elegirRuta();
            if (ruta != null){
                read(ruta);
            }
        }
    }



    public  static  void escribir(String ruta){

        File f = new File(ruta);    //Abrir el archivo en la ruta
        FileOutputStream fo = null; //Para escribir en el archivo
        ObjectOutputStream oo = null;
        try {
            fo = new FileOutputStream(f);
            oo = new ObjectOutputStream(fo);
            for (int i=0; i<Main.Tamaño();i++){ //Para coger todos los elementos del list
                oo.writeObject(Main.getJugador(i)); //Para escribir en el archivo
            }
            oo.close(); //Cerar el flujo

        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void  read(String ruta){  //Metodo para leer

        File f = new File(ruta);    //Esto sirve para "cargar" el archivo

        FileInputStream fi;     //Para que haga el input
        ObjectInputStream oi = null;


        try {
            fi = new FileInputStream(f);    //que eligo el file del file input
            oi = new ObjectInputStream(fi); //eligo el input del object
            Main.Borrar();      //Vaciar el array
            while (true){   //Siempre tiene que se while true
               Jugador j = (Jugador) oi.readObject();   //Para que lea los que ya hemos guardado
               Main.Añadir(j);  //Añadirlos de nuevo al array


            }

        } catch (FileNotFoundException e) {
           // throw new RuntimeException(e);
        } catch (IOException e) {
           // throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
          //  throw new RuntimeException(e);
        }finally {
            try {
                oi.close(); //Cerrar el flujo

            } catch (IOException e) {
              //  throw new RuntimeException(e);
            }
            modelo.setNumRows(0);   //Vaciar la tabla
            Actualizar();   //actualizarla
        }


    }

    public String elegirRuta(){

        File f = new File("C:\\Users\\masca\\IdeaProjects\\Persona-Armas-Corecion");    //Elegir donde se abre
        JFileChooser files = new JFileChooser(f);   //te muestra los archivos de manera grafica
        int r = files.showOpenDialog(this); //para que abra el file choseer
        if (r == JFileChooser.APPROVE_OPTION){  //controlar si acepto ocancelo
            return files.getSelectedFile().getAbsolutePath();   //Coger la ruta

        }else{
            System.out.println("Cancelado");
            return null;
        }


    }

}



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.File;

public class Mostrar extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTable table1;
    private JList ListaArmas;
    private JLabel nombre;
    private JButton Guarda;
    private JButton Cargar;

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo1;



    Mostrar(){
        this.setTitle("Mostrar");
        this.setVisible(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(500,500);
        modelo.addColumn("Poder");
        modelo.addColumn("Tipo");
        table1.setModel(modelo);
        this.add(panel1);
        Main.AñadirVentana(this);

        addWindowListener(new WindowAdapter() {
            @Override   //listener de eventos de ventana
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                JFrame frame=   Main.BuscaVentana("Crear");
                frame.setVisible(true);
            }
        });
      table1.addMouseListener(new MouseListener() {
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
    public  void Actualizar(){      //Para Actualizar una tabla con Datos ya dentro
        for (int i =modelo.getRowCount();i<Main.Tamaño();i++){
            modelo.addRow(new Object[]{Main.getJugador(i).getPoder(),Main.getJugador(i).getTipo()});
        }
    }
    public int ConfirmaSave(String mensaje, String titulo){
        JOptionPane.showMessageDialog(this, mensaje,titulo,JOptionPane.WARNING_MESSAGE);
        return 0;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Guarda){
           int r= ConfirmaSave("Seguro que quieres guardar?","Guardar");

        }
    }
    public static void GuardaDatos(){
        File j = new File("C:\\Users");
    }
}



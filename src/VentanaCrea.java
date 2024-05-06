import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCrea extends JFrame implements ActionListener {
    private JTextField poderTextField;
    private JTextField tipoTextField;
    private JPanel Panel1;
    private JTextArea TextArmas;
    private JButton crearButton;
    private JButton mostarButton;


    VentanaCrea(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setTitle("Crear");
        this.add(Panel1);
        crearButton.addActionListener(this);
        mostarButton.addActionListener(this);
    }
    private  void MostarMensje(String mensaje,String titulo){       //Metodo para no hacer un JOption siempre, bastante util
        JOptionPane.showMessageDialog(this,mensaje,titulo,JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crearButton){
            int poder = Integer.parseInt(poderTextField.getText());
            String tipo = tipoTextField.getText();
            String[] armas = TextArmas.getText().split(",");
            Jugador j = new Jugador(poder,tipo,armas);
            Main.Añadir(j);
            tipoTextField.setText("");
            poderTextField.setText("");
            TextArmas.setText("");
            MostarMensje("Jugador creado","INFO");
        }if (e.getSource() == mostarButton){
            JFrame frame = Main.BuscaVentana("Mostrar");
            if (frame == null){
                Mostrar mos = new Mostrar();
                mos.Actualizar();
                Main.AñadirVentana(mos);
                mos.setVisible(true);
            }
            else{
                ((Mostrar)frame).Actualizar();      //Hacer Casting a la Ventana
                frame.setVisible(true);
            }
            this.setVisible(false);
        }
    }
}

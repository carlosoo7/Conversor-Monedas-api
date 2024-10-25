package app;
import java.awt.*;
import javax.swing.*;

public class AplicacionDeEscritorio extends JFrame {
    public AplicacionDeEscritorio() {
        Lamina lamina = new Lamina();
        Dimension Pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int Alto=Pantalla.height/2;
        int Ancho=Pantalla.width/2;
        setSize(Ancho,Alto);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(lamina);
        setVisible(true);
    }
}
class Lamina extends JPanel{
    JLabel titulo = new JLabel("Conversor de monedas, Escoja a continuacion la conversion que desea realizar");
    JLabel a = new JLabel("convertir a: ");
    JLabel cantidad = new JLabel("cantidad:  ");
    JTextField Tcantidad = new JTextField(10);
    JComboBox menuconvertir = new JComboBox();
    JComboBox menuconvertira = new JComboBox();
    JPanel Ptitulo = new JPanel();
    JPanel Pdatos = new JPanel();
    JPanel PCuanto =new JPanel();
    JPanel PBoton = new JPanel();
    JButton Convertir = new JButton("Convertir");
public Lamina() {
    setLayout(new GridLayout(4,0));
    Ptitulo.add(titulo);
    add(Ptitulo);

    menuconvertir.addItem("Usd");
    menuconvertira.addItem("Eur");
    menuconvertir.addItem("Eur");
    menuconvertira.addItem("Usd");

    Pdatos.add(menuconvertir);
    Pdatos.add(a);
    Pdatos.add(menuconvertira);
    add(Pdatos);

    PCuanto.add(cantidad);
    PCuanto.add(Tcantidad);
    add(PCuanto);

    PBoton.add(Convertir);
    add(PBoton);
   }
}


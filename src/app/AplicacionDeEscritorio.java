package app;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        setTitle("Conversor de monedas");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icono.png")));
        setVisible(true);
    }
}
class Lamina extends JPanel{
    listaDeMonedas monedas = new listaDeMonedas();
    JLabel titulo = new JLabel("Escoja la conversion que desea realizar");
    JLabel a = new JLabel("Convertir a: ");
    JLabel cantidad = new JLabel("Cantidad:  ");
    JLabel Total = new JLabel("Resultado:");
    JLabel mon = new JLabel("");
    JSpinner Tcantidad = new JSpinner(new SpinnerNumberModel(0.5,0.1,100000000000.0,0.5));
    JTextField Ttotal = new JTextField(10);
    JComboBox <String> menuconvertir = new JComboBox<>(monedas.currencyInitials);
    JComboBox <String> menuconvertira = new JComboBox<>(monedas.currencyInitials);
    JPanel Ptitulo = new JPanel();
    JPanel Pdatos = new JPanel();
    JPanel PCuanto =new JPanel();
    JPanel PBoton = new JPanel();
    JPanel Presultado = new JPanel();
    JButton Convertir = new JButton("Convertir");
    private Image fondo;


public Lamina() {
    Ptitulo.setOpaque(false);
    Pdatos.setOpaque(false);
    PCuanto.setOpaque(false);
    PBoton.setOpaque(false);
    Presultado.setOpaque(false);


    Ptitulo.setBackground(new Color(0, 0, 0, 0));
    Pdatos.setBackground(new Color(0, 0, 0, 0));
    PCuanto.setBackground(new Color(0, 0, 0, 0));
    PBoton.setBackground(new Color(0, 0, 0, 0));
    Presultado.setBackground(new Color(0, 0, 0, 0));

    titulo.setForeground(Color.WHITE);
    titulo.setFont(new Font("Tahoma", Font.BOLD, 15));
    a.setForeground(Color.WHITE);
    a.setFont(new Font("Tahoma", Font.BOLD, 15));
    cantidad.setForeground(Color.WHITE);
    cantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
    Total.setForeground(Color.WHITE);
    Total.setFont(new Font("Tahoma", Font.BOLD, 15));
    mon.setForeground(Color.WHITE);
    mon.setFont(new Font("Tahoma", Font.BOLD, 15));


    setLayout(new GridLayout(5, 0));
    Ptitulo.add(titulo);
    add(Ptitulo);
    fondo = new ImageIcon(getClass().getResource("/fondo.png")).getImage();

    Pdatos.add(menuconvertir);
    Pdatos.add(a);
    Pdatos.add(menuconvertira);
    add(Pdatos);

    PCuanto.add(cantidad);
    PCuanto.add(Tcantidad);
    add(PCuanto);

    Ttotal.setEditable(false);
    Presultado.add(Total);
    Presultado.add(Ttotal);
    Presultado.add(mon);
    add(Presultado);


    Convertir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(Convertir)){
                EjecucionDeConversion ejecutar = new EjecucionDeConversion();
                Double resultado = ejecutar.EjecucionConversion(menuconvertir.getSelectedItem().toString(),menuconvertira.getSelectedItem().toString(),(Double)Tcantidad.getValue());
                Ttotal.setText(resultado.toString());
                mon.setText(menuconvertira.getSelectedItem().toString());
                repaint();

            }
        }});
    PBoton.add(Convertir);
    add(PBoton);


   }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Llamada al método padre para limpiar el panel
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this); // Dibuja la imagen en el panel
    }

}


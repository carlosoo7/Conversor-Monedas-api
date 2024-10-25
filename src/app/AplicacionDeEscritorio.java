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
        setLocationRelativeTo(null);                                   //Configurando el Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(lamina);
        setTitle("Conversor de monedas");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icono.png"))); //Icono de la aplicacion
        setVisible(true);
    }
}
class Lamina extends JPanel{
    listaDeMonedas monedas = new listaDeMonedas();
    JLabel titulo = new JLabel("Escoja la conversion que desea realizar");
    JLabel a = new JLabel("Convertir a: ");
    JLabel cantidad = new JLabel("Cantidad:  "); //Uso de labels para texto en aplicacion
    JLabel Total = new JLabel("Resultado:");
    JLabel mon = new JLabel("");
    JSpinner Tcantidad = new JSpinner(new SpinnerNumberModel(0.5,0.1,100000000000.0,0.5)); //Spinner para cantidad a convertir
    JTextField Ttotal = new JTextField(10);
    JComboBox <String> menuconvertir = new JComboBox<>(monedas.currencyInitials); //Combobox para seleccionar las monedas a convertir
    JComboBox <String> menuconvertira = new JComboBox<>(monedas.currencyInitials);
    JPanel Ptitulo = new JPanel();
    JPanel Pdatos = new JPanel();
    JPanel PCuanto =new JPanel(); //Paneles contenedores de los elementos del Panle principal
    JPanel PBoton = new JPanel();
    JPanel Presultado = new JPanel();
    JButton Convertir = new JButton("Convertir");
    private Image fondo;


public Lamina() {
    Ptitulo.setOpaque(false);
    Pdatos.setOpaque(false);
    PCuanto.setOpaque(false);  //configuraciones para que se vea el fondo correctamente
    PBoton.setOpaque(false);
    Presultado.setOpaque(false);


    Ptitulo.setBackground(new Color(0, 0, 0, 0));
    Pdatos.setBackground(new Color(0, 0, 0, 0));
    PCuanto.setBackground(new Color(0, 0, 0, 0)); //Color de fondo para transparencia y que se vea la imagen de fondo
    PBoton.setBackground(new Color(0, 0, 0, 0));
    Presultado.setBackground(new Color(0, 0, 0, 0));

    titulo.setForeground(Color.WHITE);
    titulo.setFont(new Font("Arial", Font.BOLD, 15));
    a.setForeground(Color.WHITE);
    a.setFont(new Font("Tahoma", Font.BOLD, 15));
    cantidad.setForeground(Color.WHITE);
    cantidad.setFont(new Font("Tahoma", Font.BOLD, 15)); //Configuracion de los textos del aplicativo
    Total.setForeground(Color.WHITE);
    Total.setFont(new Font("Tahoma", Font.BOLD, 15));
    mon.setForeground(Color.WHITE);
    mon.setFont(new Font("Tahoma", Font.BOLD, 15));


    setLayout(new GridLayout(5, 0));
    Ptitulo.add(titulo);
    add(Ptitulo);
    fondo = new ImageIcon(getClass().getResource("/fondo.png")).getImage(); //trae la iamgen para el fondo

    Pdatos.add(menuconvertir);
    Pdatos.add(a);
    Pdatos.add(menuconvertira);   //configuracion general, añadir elementos a paneles secundarios y al panel principal
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
        public void actionPerformed(ActionEvent e) { //Action performer que ejecuta las acciones del boton convertir
            if(e.getSource().equals(Convertir)){
                EjecucionDeConversion ejecutar = new EjecucionDeConversion();
                Double resultado = ejecutar.EjecucionConversion(menuconvertir.getSelectedItem().toString()
                        ,menuconvertira.getSelectedItem().toString() //invocacion del metodo para realizar consulta y operacion
                        ,(Double)Tcantidad.getValue());
                Ttotal.setText(resultado.toString());
                mon.setText(menuconvertira.getSelectedItem().toString()); //set text para mostrar la denominacion de la moneda convertida
                repaint(); //repaint para actualizar elementos en pantalla

            }
        }});
    PBoton.add(Convertir);
    add(PBoton);


   }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this); //Dibujado de imagen de fondo en el aplicativo
    }

}


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class Licencia extends JFrame implements ActionListener, ChangeListener {

    private JLabel label1, label2;
    private JCheckBox check1;
    private JButton boton1, boton2;
    private JScrollPane scrollpane1; 
    private JTextArea textarea1;
    String nombre = "";

    public Licencia() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Licencia de uso");

        // Obtiene el nombre de la clase Bienvenida
        Bienvenida ventanaBienvenida = new Bienvenida();
        nombre = ventanaBienvenida.texto;

        // Si el nombre está vacío, solicita al usuario que lo ingrese por consola
        if (nombre.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Por favor, ingresa tu nombre: ");
            nombre = scanner.nextLine();
            scanner.close(); // Cerrar el scanner después de su uso
        }   
        

        label1 = new JLabel("TÉRMINOS Y CONDICIONES");
        label1.setBounds(215, 5, 200, 30);
        label1.setFont(new Font("Andale Mono", 1, 14));
        label1.setForeground(new Color(0, 0, 0));
        add(label1);

        textarea1 = new JTextArea();
        textarea1.setEditable(false);

        // Cambiar el tamaño de la fuente a 14
        textarea1.setFont(new Font("Andale Mono", Font.PLAIN, 14));   

        // Agregar texto con saltos de línea
        textarea1.setText("Al utilizar esta aplicación, aceptas los términos establecidos y te comprometes a proteger \n la confidencialidad de tus datos.\n"
                + "La empresa no se responsabiliza por el mal uso de la aplicación.\n"
                + "Nos reservamos el derecho de modificar estos términos en cualquier momento,\n"
                + "y el uso continuado implica la aceptación de los cambios.");

        // Configurar el JScrollPane
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(10, 40, 575, 200);
        add(scrollpane1); 

        check1 = new JCheckBox("Yo " + nombre + " Acepto");
        check1.setBounds(10, 250, 300, 30);
        check1.addChangeListener(this);
        add(check1);

        boton1 = new JButton("Continuar");
        boton1.setBounds(10, 290, 100, 30);
        boton1.addActionListener(this);
        boton1.setEnabled(false);
        add(boton1);

        boton2 = new JButton("No Acepto");
        boton2.setBounds(120, 290, 100, 30);
        boton2.addActionListener(this);
        boton2.setEnabled(true);
        add(boton2);

        ImageIcon imagenOriginal = new ImageIcon("images/koders.jpg");
        Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Ajustar a un tamaño más pequeño
        ImageIcon imagenRedimensionada = new ImageIcon(imagenEscalada);

        // Ajusta la posición de la imagen por debajo del JScrollPane
        label2 = new JLabel(imagenRedimensionada);
        label2.setBounds(290, 140, 300, 300); // Mantener las dimensiones del JLabel
        add(label2);
    }

    public void stateChanged(ChangeEvent e) {
        boton1.setEnabled(check1.isSelected());
        boton2.setEnabled(!check1.isSelected());
    } 

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            Principal ventanaPrincipal = new Principal();
            ventanaPrincipal.setBounds(0, 0, 640, 535);
            ventanaPrincipal.setVisible(true);
            ventanaPrincipal.setResizable(false);
            ventanaPrincipal.setLocationRelativeTo(null);
            this.setVisible(false);
        } else if (e.getSource() == boton2) {
            Bienvenida ventanabienvenida = new Bienvenida();
            ventanabienvenida.setBounds(0, 0, 350, 450);
            ventanabienvenida.setVisible(true);
            ventanabienvenida.setResizable(false);
            ventanabienvenida.setLocationRelativeTo(null);
            this.setVisible(false);   
        } 
    }

    public static void main(String args[]) {
        Licencia ventanalicencia = new Licencia();
        ventanalicencia.setBounds(0, 0, 600, 360);
        ventanalicencia.setVisible(true);
        ventanalicencia.setResizable(false);
        ventanalicencia.setLocationRelativeTo(null);
    }
    
}

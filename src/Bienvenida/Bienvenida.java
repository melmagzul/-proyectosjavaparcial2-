import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Bienvenida extends JFrame implements ActionListener {

    private JTextField textfield1;
    private JLabel label1, label2, label3, label4;
    private JButton boton1;
    public static String texto = "";

    public Bienvenida() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bienvenido al Sistema");
        getContentPane().setBackground(new Color(89, 89, 89));

        // Imagen del logo
        ImageIcon imagenOriginal = new ImageIcon("images/koders.jpg");
        Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon imagenRedimensionada = new ImageIcon(imagenEscalada);

        // Ajusta la posición de la imagen por debajo del JScrollPane
        label1 = new JLabel(imagenRedimensionada);
        label1.setBounds(25, 28, 300, 130); 
        add(label1);

        label2 = new JLabel("Vacaciones empleados");
        label2.setBounds(55, 135, 300, 30);
        label2.setFont(new Font("Melvyn", 3, 18));
        label2.setForeground(new Color(255, 255, 255));
        add(label2);

        label3 = new JLabel("Ingrese su nombre");
        label3.setBounds(45, 212, 200, 30);
        label3.setFont(new Font("Melvyn", 1, 12));
        label3.setForeground(new Color(255, 255, 255));
        add(label3);

        label4 = new JLabel("Koders S.A, Melvyn Magzul, Seccion A");
        label4.setBounds(70, 375, 300, 30);
        label4.setFont(new Font("Melvyn", 1, 12));
        label4.setForeground(new Color(255, 255, 255));
        add(label4);

        textfield1 = new JTextField();
        textfield1.setBounds(45, 240, 255, 25);
        textfield1.setBackground(new Color(224, 224, 224));
        textfield1.setFont(new Font("Melvyn", 1, 14));
        textfield1.setForeground(new Color(255, 0, 0));
        add(textfield1);

        boton1 = new JButton("Ingresar");
        boton1.setBounds(125, 280, 100, 30);
        boton1.setBackground(new Color(255, 255, 255));
        boton1.setFont(new Font("Melvyn", 1, 14));
        boton1.setForeground(new Color(69, 185, 211));
        boton1.addActionListener(this);
        add(boton1);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            texto = textfield1.getText().trim();

            // Si el campo de texto está vacío, mostrar mensaje de advertencia
            if (texto.equals("")) {
                JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Bienvenido, " + texto);
                // Abrir la siguiente ventana
                Licencia ventanalicencia = new Licencia();
                ventanalicencia.setBounds(0, 0, 600, 360);
                ventanalicencia.setVisible(true);
                ventanalicencia.setResizable(false);
                ventanalicencia.setLocationRelativeTo(null);
                this.setVisible(false); // Ocultar la ventana de bienvenida
            }
        }
    }

    public static void main(String args[]) {
        Bienvenida ventanabienvenida = new Bienvenida();
        ventanabienvenida.setBounds(0, 0, 350, 450);
        ventanabienvenida.setVisible(true);
        ventanabienvenida.setResizable(false);
        ventanabienvenida.setLocationRelativeTo(null);
    }
}

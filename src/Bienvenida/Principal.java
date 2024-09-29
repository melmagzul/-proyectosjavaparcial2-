import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal extends JFrame {

    // Componentes de la interfaz gráfica
    private JLabel label1;
    private JTextField nombreField;
    private JTextField apellidoPField;
    private JTextField apellidoMField;
    private JComboBox<String> departamentoCombo;
    private JComboBox<String> antiguedadCombo;
    private JTextArea resultadoArea;

    public Principal() {
        // Configuración de la ventana
         
        setTitle("Calculadora de Vacaciones");
        getContentPane().setBackground(new Color(216, 216, 216));
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana
        setLayout(new GridBagLayout()); // Usar GridBagLayout para un mejor diseño
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Llenar horizontalmente
        

        // Inicialización de componentes
        nombreField = new JTextField(20);
        apellidoPField = new JTextField(20);
        apellidoMField = new JTextField(20);

        // Opciones de departamento
        String[] departamentos = {
                "Atención al Cliente",
                "Departamento de Logística",
                "Departamento de Gerencia"
        };
        departamentoCombo = new JComboBox<>(departamentos);

        // Opciones de antigüedad
        String[] antiguedades = {
                "1 año de servicio",
                "2 a 6 años de servicio",
                "7 años o más de servicio"
        };
        antiguedadCombo = new JComboBox<>(antiguedades);

        // Área de texto para mostrar resultados
        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);
        resultadoArea.setLineWrap(true); // Habilitar ajuste de línea
        resultadoArea.setWrapStyleWord(true); // Ajustar palabra por palabra

        // Botón para calcular vacaciones
        JButton calcularButton = new JButton("Calcular Vacaciones");
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularVacaciones();
            }
        });

        // Botón para limpiar campos
        JButton limpiarButton = new JButton("Limpiar");
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        // Botón para regresar a la bienvenida
        JButton bienvenidaButton = new JButton("Salir");
        bienvenidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarBienvenida();
            }
        });

        // Añadir componentes a la ventana con GridBagConstraints
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes

        add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1; // Columna 1
        add(nombreField, gbc);

        gbc.gridx = 0; // Regresar a columna 0
        gbc.gridy = 1; // Fila 1
        add(new JLabel("Apellido Paterno:"), gbc);
        gbc.gridx = 1; // Columna 1
        add(apellidoPField, gbc);

        gbc.gridx = 0; // Regresar a columna 0
        gbc.gridy = 2; // Fila 2
        add(new JLabel("Apellido Materno:"), gbc);
        gbc.gridx = 1; // Columna 1
        add(apellidoMField, gbc);

        gbc.gridx = 0; // Regresar a columna 0
        gbc.gridy = 3; // Fila 3
        add(new JLabel("Departamento:"), gbc);
        gbc.gridx = 1; // Columna 1
        add(departamentoCombo, gbc);

        gbc.gridx = 0; // Regresar a columna 0
        gbc.gridy = 4; // Fila 4
        add(new JLabel("Años de Servicio:"), gbc);
        gbc.gridx = 1; // Columna 1
        add(antiguedadCombo, gbc);

        gbc.gridx = 0; // Regresar a columna 0
        gbc.gridy = 5; // Fila 5
        gbc.gridwidth = 2; // Ocupa dos columnas
        add(calcularButton, gbc);

        gbc.gridwidth = 1; // Regresar a una columna
        gbc.gridy = 6; // Fila 6
        add(new JScrollPane(resultadoArea), gbc); // Agregar scroll para el área de texto

        // Añadir botones de Limpiar y Bienvenida
        gbc.gridy = 7; // Fila 7
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        add(limpiarButton, gbc); // Botón limpiar

        gbc.gridx = 1;
        add(bienvenidaButton, gbc); // Botón bienvenida
        
    }

    public static void main(String[] args) {
        Principal ventanaPrincipal = new Principal();
        ventanaPrincipal.setVisible(true); // Hacer visible la ventana
    }

    // Método para calcular vacaciones
    private void calcularVacaciones() {
        String nombreTrabajador = nombreField.getText();
        String AP = apellidoPField.getText();
        String AM = apellidoMField.getText();
        String departamento = (String) departamentoCombo.getSelectedItem();
        String antiguedad = (String) antiguedadCombo.getSelectedItem();

        String resultado = calcularVacaciones(nombreTrabajador, AP, AM, departamento, antiguedad);
        resultadoArea.setText(resultado); // Mostrar resultado en el área de texto
    }

    public static String calcularVacaciones(String nombre, String AP, String AM, String departamento, String antiguedad) {
        String resultado = "";

        if (departamento.equals("Atención al Cliente")) {
            if (antiguedad.equals("1 año de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 6 días de vacaciones.";
            } else if (antiguedad.equals("2 a 6 años de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 14 días de vacaciones.";
            } else if (antiguedad.equals("7 años o más de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 20 días de vacaciones.";
            }
        } else if (departamento.equals("Departamento de Logística")) {
            if (antiguedad.equals("1 año de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 7 días de vacaciones.";
            } else if (antiguedad.equals("2 a 6 años de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 15 días de vacaciones.";
            } else if (antiguedad.equals("7 años o más de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 22 días de vacaciones.";
            }
        } else if (departamento.equals("Departamento de Gerencia")) {
            if (antiguedad.equals("1 año de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 10 días de vacaciones.";
            } else if (antiguedad.equals("2 a 6 años de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 20 días de vacaciones.";
            } else if (antiguedad.equals("7 años o más de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 30 días de vacaciones.";
            }
        }

        return resultado;
    }

    // Método para limpiar campos
    private void limpiarCampos() {
        nombreField.setText("");
        apellidoPField.setText("");
        apellidoMField.setText("");
        departamentoCombo.setSelectedIndex(0);
        antiguedadCombo.setSelectedIndex(0);
        resultadoArea.setText("");
    }
    

    // Método para regresar a la pantalla de bienvenida
    private void regresarBienvenida() {
        this.dispose(); // Cerrar la ventana actual
        Bienvenida bienvenida = new Bienvenida(); // Abrir la pantalla de bienvenida
        bienvenida.setVisible(true);
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible); // Llama al método setVisible de JFrame
    }
    
    
    
}


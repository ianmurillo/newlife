package newlife1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.lang.*;

public class InsertarProductoGUI extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfparam6;
    private JTextField tfparam7;
    // ... Agrega más JTextField según sea necesario
    private JTextField tfparam8;

    private JButton btnInsertar;
    private JLabel dada;
    private JTextField tfparam1;
    private JLabel da;
    private JTextField tfparam2;
    private JLabel lblParmetro_4;
    private JTextField tfparam3;
    private JLabel lblParmetro_5;
    private JTextField tfparam4;
    private JLabel lblParmetro_6;
    private JTextField tfparam5;

    public InsertarProductoGUI() {
        super("Insertar Nuevo Producto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(542, 546);

        // Crea los componentes
        tfparam6 = new JTextField(20);
        tfparam6.setBounds(0, 289, 528, 19);
        tfparam7 = new JTextField(20);
        tfparam7.setBounds(0, 347, 528, 19);
        // ... Crea más JTextField según sea necesario
        tfparam8 = new JTextField(20);
        tfparam8.setBounds(0, 422, 528, 19);

        btnInsertar = new JButton("Gehitu");
        btnInsertar.setBounds(0, 462, 528, 47);
        getContentPane().setLayout(null);

        // Agrega los componentes al contenedor
        JLabel lblParmetro_1 = new JLabel("PrezioaE:");
        lblParmetro_1.setBounds(0, 271, 528, 19);
        getContentPane().add(lblParmetro_1);
        getContentPane().add(tfparam6);
        JLabel lblParmetro = new JLabel("PrezioaS:");
        lblParmetro.setBounds(0, 318, 528, 19);
        getContentPane().add(lblParmetro);
        getContentPane().add(tfparam7);
        // ... Agrega más JLabel y JTextField según sea necesario
        JLabel lblBerria = new JLabel("Berria:");
        lblBerria.setBounds(0, 403, 528, 19);
        getContentPane().add(lblBerria);
        getContentPane().add(tfparam8);

        getContentPane().add(btnInsertar);
        
        dada = new JLabel("ID:");
        dada.setBounds(0, 10, 528, 19);
        getContentPane().add(dada);
        
        tfparam1 = new JTextField(20);
        tfparam1.setBounds(0, 27, 528, 19);
        getContentPane().add(tfparam1);
        
        da = new JLabel("Izena:");
        da.setBounds(0, 56, 528, 19);
        getContentPane().add(da);
        
        tfparam2 = new JTextField(20);
        tfparam2.setBounds(0, 74, 528, 19);
        getContentPane().add(tfparam2);
        
        lblParmetro_4 = new JLabel("Kantitatea:");
        lblParmetro_4.setBounds(0, 107, 528, 19);
        getContentPane().add(lblParmetro_4);
        
        tfparam3 = new JTextField(20);
        tfparam3.setBounds(0, 128, 528, 19);
        getContentPane().add(tfparam3);
        
        lblParmetro_5 = new JLabel("Modeloa:");
        lblParmetro_5.setBounds(0, 169, 528, 19);
        getContentPane().add(lblParmetro_5);
        
        tfparam4 = new JTextField(20);
        tfparam4.setBounds(0, 185, 528, 19);
        getContentPane().add(tfparam4);
        
        lblParmetro_6 = new JLabel("Marka:");
        lblParmetro_6.setBounds(0, 214, 528, 19);
        getContentPane().add(lblParmetro_6);
        
        tfparam5 = new JTextField(20);
        tfparam5.setBounds(0, 232, 528, 19);
        getContentPane().add(tfparam5);

        // Configura el evento del botón
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarProducto();
            }
        });
    }

    private void insertarProducto() {
        // Obtiene los valores de los JTextField
        String param1 = tfparam1.getText();
        String param2 = tfparam2.getText();
        String param3 = tfparam3.getText();
        String param4 = tfparam4.getText();
        String param5 = tfparam5.getText();
        String param6 = tfparam6.getText();
        String param7 = tfparam7.getText();
        String param8 = tfparam8.getText();
        // ... Obtiene más valores de JTextField según sea necesario

        // Configura la conexión a la base de datos
        String url = "jdbc:mysql://192.168.1.1/newlife";
        String usuario = "newlife";
        String contraseña = "@Newlifeioi1";

        try (Connection connection = DriverManager.getConnection(url, usuario, contraseña)) {
            // Prepara la consulta SQL para insertar un nuevo producto
            String sql = "INSERT INTO almazena (ErregistroID, izena, kantitatea, modeloa, marka, prezioaE, prezioaS, berria) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Configura los parámetros en la consulta
                preparedStatement.setString(1, param1);
                preparedStatement.setString(2, param2);
                preparedStatement.setString(3, param3);
                preparedStatement.setString(4, param4);
                preparedStatement.setString(5, param5);
                preparedStatement.setString(6, param6);
                preparedStatement.setString(7, param7);
                preparedStatement.setString(8, param8);
                // ... Configura más parámetros según sea necesario

                // Ejecuta la consulta
                preparedStatement.executeUpdate();

                // Limpia los campos después de la inserción
                tfparam1.setText("");
                tfparam2.setText("");
                tfparam3.setText("");
                tfparam4.setText("");
                tfparam5.setText("");
                tfparam6.setText("");
                tfparam7.setText("");
                tfparam8.setText("");
                // ... Limpia más campos según sea necesario

                JOptionPane.showMessageDialog(this, "Producto insertado correctamente.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al insertar el producto: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InsertarProductoGUI().setVisible(true);
            }
        });
    }
}

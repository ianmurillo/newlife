import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Berriaalmazena extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
    private JTable table;
    private JTextField nombreField;

    public Berriaalmazena() {
        setTitle("Interfaz Base de Datos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        nombreField = new JTextField(20);
        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarFila();
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Nombre: "));
        inputPanel.add(nombreField);
        inputPanel.add(agregarButton);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        cargarDatosDesdeBD();

        setVisible(true);
    }

    private void cargarDatosDesdeBD() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_base_de_datos", "tu_usuario", "tu_contraseña");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM mi_tabla");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                tableModel.addRow(new Object[]{id, nombre});
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void agregarFila() {
        String nombre = nombreField.getText();
        if (!nombre.isEmpty()) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/1taldea", "root", "1WMG2023");
                Statement stmt = conn.createStatement();
                String query = "INSERT INTO almazena (nombre) VALUES ('" + nombre + "')";
                stmt.executeUpdate(query);
                stmt.close();
                conn.close();
                nombreField.setText(""); // Limpiar el campo de entrada
                cargarDatosDesdeBD(); // Actualizar la tabla
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Berriaalmazena();
            }
        });
    }
}


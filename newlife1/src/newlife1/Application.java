package newlife1;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Label;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idTextField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Application() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Gehitu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			gehitu();
			}

			private void gehitu() {
				InsertarProductoGUI oforma = new InsertarProductoGUI();
				oforma.setVisible(true);
		}
		});
	
		btnNewButton.setBounds(0, 45, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Kendu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarRegistro();
			}
		});
		btnNewButton_1.setBounds(1, 76, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("Aktualizatu");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			aktualizatu();
			}

			private void aktualizatu() {
				// TODO Auto-generated method stub
				bdd oforma = new bdd();
				oforma.setVisible(true);
		
			}
		});
		btnNewButton_4.setBounds(0, 107, 85, 21);
		contentPane.add(btnNewButton_4);
		
		idTextField = new JTextField();
		idTextField.setBounds(92, 16, 72, 19);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		table = new JTable();
		table.setBounds(95, 45, 497, 296);
		contentPane.add(table);
		
		
		Label label = new Label("ID:");
		label.setBounds(58, 10, 27, 21);
		contentPane.add(label);
		
		 try {
	            Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.1/newlife","newlife","@Newlifeioi1");
	            Statement statement = conexion.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM almazena");

	            // Crea un DefaultTableModel y agrega las columnas
	            DefaultTableModel model = new DefaultTableModel();
	            int columnCount = resultSet.getMetaData().getColumnCount();
	            for (int i = 1; i <= columnCount; i++) {
	                model.addColumn(resultSet.getMetaData().getColumnName(i));
	            }

	            // Agrega filas al modelo
	            while (resultSet.next()) {
	                Object[] row = new Object[columnCount];
	                for (int i = 1; i <= columnCount; i++) {
	                    row[i - 1] = resultSet.getObject(i);
	                }
	                model.addRow(row);
	            }

	            // Cierra la conexión
	            resultSet.close();
	            statement.close();
	            conexion.close();

	            // Asigna el modelo a la JTable
	            table.setModel(model);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

	private void eliminarRegistro() {
String url = "jdbc:mysql://192.168.1.1/newlife";
String usuario = "newlife";
String clave = "@Newlifeioi1";

try (Connection connection = DriverManager.getConnection(url, usuario, clave)) {
    String query = "DELETE FROM almazena WHERE ErregistroID = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, Integer.parseInt(idTextField.getText()));

        int filasAfectadas = statement.executeUpdate();
        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(this, "Ondo ezabatu da");
        } else {
            JOptionPane.showMessageDialog(this, "Ez da aurkitu erregistroa");
        }
    }
} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "Erregistroa ezabatu egin da: " + e.getMessage());
}
}
}
 

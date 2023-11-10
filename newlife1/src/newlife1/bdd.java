package newlife1;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class bdd extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	/**
	 * @wbp.nonvisual location=31,284
	 */
	private final JTextField textField = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bdd frame = new bdd();
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
	public bdd() {
		textField.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 10, 416, 228);
		contentPane.add(table);
		try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.1/newlife\",\"newlife\",\"@Newlifeioi1");
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
            
            JLabel Produktua = new JLabel("Produktua");
            Produktua.setBounds(40, 368, 72, 13);
            contentPane.add(Produktua);
            
            textField = new JTextField();
            textField.setBounds(122, 365, 330, 19);
            contentPane.add(textField);
            textField.setColumns(10);

        } catch (Exception e) {
            e.printStackTrace();
        }
}
	}



package newlife1;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JTextField;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Font;
import java.awt.Color;


public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("NAN-A");
		label.setBounds(72, 72, 69, 21);
		contentPane.add(label);
		
		JButton Login = new JButton("Login");
		Login.setBounds(141, 136, 148, 21);
		contentPane.add(Login);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(141, 72, 148, 21);
		contentPane.add(passwordField);
		
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nan = passwordField.getText();
				// Establecemos la conexión con la base de datos.
				try {
					Connection conexion = DriverManager.getConnection ("jdbc:mysql://192.168.1.1/newlife","newlife","@Newlifeioi1");
					// Preparamos la consulta
					Statement st = conexion.createStatement();
					ResultSet rs = st.executeQuery ("SELECT * FROM langileak WHERE nan='"+nan+"'");
					//ResultSet rs = st.executeQuery ("SELECT * FROM langileak");
					int cont=0;
					while(rs.next()) {
						cont++;
						System.out.println(cont);}
					if(cont!=0) {
						showMessageDialog(null, "Saioa hasita");
						dispose();
						Application oforma = new Application();
						oforma.setVisible(true);
					}else {
						showMessageDialog(null, "NAN-A gaizki jarrita");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
		            }
		        });
	}
}

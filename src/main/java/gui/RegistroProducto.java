package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Producto;
import modelo.Usuario;

import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class RegistroProducto extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtstock;
	private JTextField txtPrecio;
	private JTextField txtCategoria;
	private JTable Producto;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextArea txtDescripcion;
	private JLabel lblDescripcion;
	private JLabel lblNewLabel;
	private JLabel lblStock;
	private JLabel lblPrecio;
	private JLabel lblCategoria;
	private JButton btnAgregar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroProducto frame = new RegistroProducto();
					frame.setLocationRelativeTo(null);
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
	DefaultTableModel model = new DefaultTableModel();
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnConsultar;
	public RegistroProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 76, 413, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCodigo.setBounds(114, 11, 148, 30);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNewLabel = new JLabel("CODIGO:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 12, 104, 27);
		panel.add(lblNewLabel);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setForeground(new Color(230, 230, 250));
		btnAgregar.setBackground(new Color(65, 105, 225));
		btnAgregar.setBounds(289, 10, 114, 47);
		panel.add(btnAgregar);
		
		lblDescripcion = new JLabel("DESCRIPCION:");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescripcion.setBounds(10, 52, 104, 27);
		panel.add(lblDescripcion);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 52, 149, 64);
		panel.add(scrollPane);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(txtDescripcion);
		
		lblStock = new JLabel("STOCK:");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStock.setBounds(10, 117, 104, 27);
		panel.add(lblStock);
		
		lblPrecio = new JLabel("PRECIO:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(10, 155, 104, 30);
		panel.add(lblPrecio);
		
		lblCategoria = new JLabel("CATEGORIA:");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCategoria.setBounds(10, 196, 104, 33);
		panel.add(lblCategoria);
		
		txtstock = new JTextField();
		txtstock.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtstock.setColumns(10);
		txtstock.setBounds(114, 119, 148, 30);
		panel.add(txtstock);
		
		txtPrecio = new JTextField();
		txtPrecio.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(114, 156, 148, 30);
		panel.add(txtPrecio);
		
		txtCategoria = new JTextField();
		txtCategoria.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(114, 198, 148, 30);
		panel.add(txtCategoria);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setForeground(new Color(230, 230, 250));
		btnEliminar.setBackground(new Color(255, 102, 102));
		btnEliminar.setBounds(289, 67, 114, 47);
		panel.add(btnEliminar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setForeground(new Color(230, 230, 250));
		btnModificar.setBackground(new Color(255, 255, 102));
		btnModificar.setBounds(289, 124, 114, 47);
		panel.add(btnModificar);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.setForeground(new Color(230, 230, 250));
		btnConsultar.setBackground(new Color(105, 105, 105));
		btnConsultar.setBounds(289, 181, 114, 47);
		panel.add(btnConsultar);
		
		lblNewLabel_1 = new JLabel("Registro Producto");
		lblNewLabel_1.setForeground(new Color(230, 230, 250));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(47, 79, 79));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 413, 54);
		contentPane.add(lblNewLabel_1);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 326, 413, 147);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 393, 125);
		panel_1.add(scrollPane_1);
		
		Producto = new JTable();
		scrollPane_1.setViewportView(Producto);
		
	
		model.addColumn("ID CODIGO");
		model.addColumn("DESCRIPCION");
		model.addColumn("STOCK");
		model.addColumn("PRECIO");
		model.addColumn("CATEGORIA");
		Producto.setModel(model);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		//2.Obtener el DAO
		EntityManager em=fabrica.createEntityManager();
		//procesos...registrar un nuevo usuario
		Producto p= new Producto(txtCodigo.getText(), txtDescripcion.getText(),Integer.parseInt(txtstock.getText()) , Double.parseDouble(txtPrecio.getText()),Integer.parseInt(txtCategoria.getText()));
		
		
		// reg,act,elim->Transacciones.
		em.getTransaction().begin();
		em.persist(p);//agregar
		em.getTransaction().commit();
		System.out.println("Registro ok");
		em.close();
		
		
	}
	public void listar() {
	EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		//2.Obtener el DAO
		EntityManager em=fabrica.createEntityManager();
	
		TypedQuery<Usuario> query=em.createQuery("Select p  from Producto p", Usuario.class);
		List<Usuario> lstUsuarios= query.getResultList();
		System.out.println("Cantidad de usuarios: "+ lstUsuarios.size());
		if(lstUsuarios.size()==0) {
			System.out.println("Listado vacio");
		}else {
			for(Usuario u: lstUsuarios) {
				System.out.println(">>> "+u);
			}
		}
		em.close();
	}
}

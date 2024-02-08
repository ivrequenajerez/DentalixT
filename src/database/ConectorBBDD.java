package database;

import java.awt.Toolkit;
// Importaciones BBDD
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.DatabaseMetaData;

import mainPack.VentanaOdontograma;
import mainPack.VentanaPaciente;
import mainPack.VentanaEspectador;
import mainPack.VentanaInicial;
import mainPack.VentanaPrincipal;
import Modelo.ModeloDiente;

import java.sql.PreparedStatement;

/**
 * Autores: David Andrade Pablo Rodriguez Ian Requena 2023
 */

public class ConectorBBDD {

	// Variables

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String DB = "dentilax";
	private static final String usuario = "root";
//	private static final String contrasenia = "pass";
	private static final String contrasenia = "1234";

	public Connection conexion;
	public static ConectorBBDD instancia;

	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	boolean credencialesValidas = false;

	// Constructores

	/*
	 * //para pruebas public static void main(String[] args) {
	 * 
	 * ConectorBBDD conector = new ConectorBBDD(); List<Odontograma> odontogramas =
	 * conector.cargarOdontogramaPorDocumento("documento_del_paciente");
	 * 
	 * // Haz lo que necesites con los datos del odontograma for (Odontograma
	 * odontograma : odontogramas) { System.out.println("ID: " +
	 * odontograma.getIdOdontograma() + ", Diente: " + odontograma.getIdDiente() +
	 * ", Descripción: " + odontograma.getDescripcion()); } }
	 */

	public ConectorBBDD() {
		// Llama al método para establecer la conexión al crear una instancia
		conectarConBBDD();
	}

	// Métodos/Funciones conectarConBBDD

	public Connection conectarConBBDD() {
		try {
			Class.forName(DRIVER);
			this.conexion = DriverManager.getConnection(url + DB, usuario, contrasenia);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return this.conexion;
	}

	/* Desconectar */
	public void cerrarConexion() {
		try {
			if (this.conexion != null) {
				this.conexion.close();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	public static synchronized ConectorBBDD getInstancia() {
		if (instancia == null) {
			instancia = new ConectorBBDD();
		}
		return instancia;
	}

	public Connection obtenerConexion() {
		return this.conexion;
	}

	public void insertarPaciente(String nombre, String apellidos, String direccion, String telefono,
			String ultimaConsulta, String id) {
		try {

			if (this.conexion != null && !this.conexion.isClosed()) {
				String consulta = "INSERT INTO paciente (nombre, apellidos, direccion, telefono, ultimaConsulta) VALUES (?, ?, ?, ?, ?)";
				
				// Prueba
				System.out.println("Consulta SQL: " + consulta);
				
				PreparedStatement statement = conexion.prepareStatement(consulta);
				statement.setString(1, nombre);
				statement.setString(2, apellidos);
				statement.setString(3, direccion);
				statement.setString(4, telefono);
				statement.setString(5, ultimaConsulta);
				
				// Prueba
				System.out.println("Nombre: " + nombre);
				System.out.println("Apellidos: " + apellidos);
				System.out.println("Dirección: " + direccion);
				System.out.println("Tlf: " + telefono);
				System.out.println("Ult Cons: " + ultimaConsulta);

				int filasAfectadas = statement.executeUpdate();

				if (filasAfectadas > 0) {
					JOptionPane.showMessageDialog(null, "Paciente insertado correctamente", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error al insertar paciente", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				cerrarConexion();
			} else {
				System.err.println("Error: La conexión está cerrada.");
			}
		} catch (SQLException ex) {
		    ex.printStackTrace();
		    System.err.println("Error SQL al insertar paciente: " + ex.getMessage());
		    JOptionPane.showMessageDialog(null, "Error SQL al insertar paciente", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void insertarPaciente1(String nombre, String apellidos, String direccion, String telefono,
			String ultimaConsulta, String id) {
		try {
			if (this.conexion != null) {
				String consulta = "INSERT INTO paciente (nombre, apellidos, direccion, telefono, ultimaConsulta) VALUES (?, ?, ?, ?, ?)";
				PreparedStatement statement = conexion.prepareStatement(consulta);
				statement.setString(1, nombre);
				statement.setString(2, apellidos);
				statement.setString(3, direccion);
				statement.setString(4, telefono);
				statement.setString(5, ultimaConsulta);

				// Si id es un campo autoincremental, no es necesario incluirlo en la consulta

				int filasAfectadas = statement.executeUpdate();

				if (filasAfectadas > 0) {
					JOptionPane.showMessageDialog(null, "Paciente insertado correctamente", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error al insertar paciente", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				cerrarConexion();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error SQL al insertar paciente", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void insertarCita(String idPaciente, String motivo, String fecha, String hora, String idDoctor) {
		try {
			if (this.conexion != null) {
				String consulta = "INSERT INTO cita (fecha, hora, motivo, idPaciente_FK, idDoctor_FK) VALUES (?, ?, ?, ?, ?)";
				PreparedStatement statement = conexion.prepareStatement(consulta);
				statement.setString(1, fecha);
				statement.setString(2, hora);
				statement.setString(3, motivo);
				statement.setString(4, idPaciente);
				statement.setString(5, idDoctor);

				int filasAfectadas = statement.executeUpdate();

				if (filasAfectadas > 0) {
					JOptionPane.showMessageDialog(null, "Cita insertada correctamente", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error al insertar cita", "Error", JOptionPane.ERROR_MESSAGE);
				}

				cerrarConexion();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error SQL al insertar cita", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizarDatosCita(String documento, String motivo, String fecha, String hora, String docDoctor) {
		// Lógica para actualizar los datos en la base de datos
		String consulta = "UPDATE cita SET motivo = ?, fecha = ?, hora = ?, idDoctor_FK = ? WHERE idPaciente_FK = ?";

		try {
			conectarConBBDD();
			PreparedStatement statement = obtenerConexion().prepareStatement(consulta);
			statement.setString(1, motivo);
			statement.setString(2, fecha);
			statement.setString(3, hora);
			statement.setString(4, docDoctor);
			statement.setString(5, documento);

			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Datos de la cita actualizados correctamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Error al actualizar datos de la cita", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			// Cierra los recursos
			statement.close();
			cerrarConexion();

		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error SQL al actualizar datos de la cita", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizarDatosMaterial(String nombre, String cantidad, String precio) {
		// Lógica para actualizar los datos en la base de datos
		String consulta = "UPDATE material SET nombre = ?, cantidad = ?, precio = ?";

		try {
			conectarConBBDD();
			PreparedStatement statement = obtenerConexion().prepareStatement(consulta);
			statement.setString(1, nombre);
			statement.setString(2, cantidad);
			statement.setString(3, precio);

			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Datos actualizados correctamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Error al actualizar datos", "Error", JOptionPane.ERROR_MESSAGE);
			}

			// Cierra los recursos
			statement.close();
			cerrarConexion();

		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error SQL al actualizar datos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void realizarBusqueda(String criterio, DefaultTableModel modeloTabla) {
		PreparedStatement statementPaciente = null;
		PreparedStatement statementDoctor = null;
		PreparedStatement statementCita = null;
		PreparedStatement statementMaterial = null;
		ResultSet resultadoMaterial = null;
		ResultSet resultadoPaciente = null;
		ResultSet resultadoDoctor = null;
		ResultSet resultadoCita = null;

		try {
			// Verificar si la conexión está cerrada y abrir si es necesario
			if (conexion == null || conexion.isClosed()) {
				conectarConBBDD();
			}

			// CONSULTA SQL para la tabla 'dentilax.paciente'
			String consultaPaciente = "SELECT nombre, apellidos, idPaciente, direccion, telefono, ultimaConsulta FROM dentilax.paciente WHERE nombre LIKE ? OR apellidos LIKE ? OR idPaciente LIKE ? OR direccion LIKE ? OR telefono LIKE ? OR ultimaConsulta LIKE ?";
			statementPaciente = conexion.prepareStatement(consultaPaciente);
			statementPaciente.setString(1, "%" + criterio + "%");
			statementPaciente.setString(2, "%" + criterio + "%");
			statementPaciente.setString(3, "%" + criterio + "%");
			statementPaciente.setString(4, "%" + criterio + "%");
			statementPaciente.setString(5, "%" + criterio + "%");
			statementPaciente.setString(6, "%" + criterio + "%");

			resultadoPaciente = statementPaciente.executeQuery();

			// CONSULTA SQL para la tabla 'dentilax.doctor'
			String consultaDoctor = "SELECT nombre, apellidos, idDoctor, email FROM dentilax.doctor WHERE nombre LIKE ? OR idDoctor LIKE ?";
			statementDoctor = conexion.prepareStatement(consultaDoctor);
			statementDoctor.setString(1, "%" + criterio + "%");
			statementDoctor.setString(2, "%" + criterio + "%");

			resultadoDoctor = statementDoctor.executeQuery();

			// CONSULTA SQL para la tabla 'dentilax.cita'
			String consultaCita = "SELECT fecha, hora, motivo, idPaciente_FK, idDoctor_FK FROM dentilax.cita WHERE motivo LIKE ?";
			statementCita = conexion.prepareStatement(consultaCita);
			statementCita.setString(1, "%" + criterio + "%");

			resultadoCita = statementCita.executeQuery();

			// CONSULTA SQL para la tabla 'dentilax.material'
			String consultaMaterial = "SELECT id, nombre, cantidad, precio FROM dentilax.material WHERE nombre LIKE ?";
			statementMaterial = conexion.prepareStatement(consultaMaterial);
			statementMaterial.setString(1, "%" + criterio + "%");

			resultadoMaterial = statementMaterial.executeQuery();

			// Limpiar la tabla antes de agregar nuevos resultados
			modeloTabla.setRowCount(0);

			// Procesar y mostrar los resultados para 'dentilax.paciente'
			while (resultadoPaciente.next()) {
				String nombre = resultadoPaciente.getString("nombre");
				String apellidos = resultadoPaciente.getString("apellidos");
				int idPaciente = resultadoPaciente.getInt("idPaciente");
				String direccion = resultadoPaciente.getString("direccion");
				String telefono = resultadoPaciente.getString("telefono");
				String ultimaConsulta = resultadoPaciente.getString("ultimaConsulta");

				// Agregar la fila a la tabla
				modeloTabla.addRow(new Object[] { nombre, apellidos, idPaciente, direccion, telefono, ultimaConsulta });

				// Si solo necesitas el primer resultado, puedes salir del bucle después de la
				// primera iteración
				break;
			}

			// Procesar y mostrar los resultados para 'dentilax.doctor'
			while (resultadoDoctor.next()) {
				String nombreDoctor = resultadoDoctor.getString("nombre");
				String apellidosDoctor = resultadoDoctor.getString("apellidos");
				int idDoctor = resultadoDoctor.getInt("idDoctor");
				String emailDoctor = resultadoDoctor.getString("email");

				// Agregar la fila a la tabla
				modeloTabla.addRow(new Object[] { nombreDoctor, apellidosDoctor, idDoctor, emailDoctor });
			}

			// Procesar y mostrar los resultados para 'dentilax.cita'
			while (resultadoCita.next()) {
				String fecha = resultadoCita.getString("fecha");
				String hora = resultadoCita.getString("hora");
				String motivo = resultadoCita.getString("motivo");
				int idPaciente_FK = resultadoCita.getInt("idPaciente_FK");
				String idDoctor_FK = resultadoCita.getString("idDoctor_FK");

				// Agregar la fila a la tabla
				modeloTabla.addRow(new Object[] { idPaciente_FK, motivo, fecha, hora });
			}

			// Procesar y mostrar los resultados para 'dentilax.material'
			while (resultadoMaterial.next()) {
				int id = resultadoMaterial.getInt("id");
				String nombre = resultadoMaterial.getString("nombre");
				int cantidad = resultadoMaterial.getInt("cantidad");
				int precio = resultadoMaterial.getInt("precio");

				// Agregar la fila a la tabla
				modeloTabla.addRow(new Object[] { nombre, cantidad, precio });
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error SQL al realizar la búsqueda", "Error",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			cerrarRecursos(resultadoPaciente, statementPaciente);
			cerrarRecursos(resultadoDoctor, statementDoctor);
			cerrarRecursos(resultadoCita, statementCita);
			cerrarRecursos(resultadoMaterial, statementMaterial);
		}
	}

	public void realizarBusquedaSoloPacientes(String criterio, DefaultTableModel modeloTabla) {
		PreparedStatement statementPaciente = null;
		ResultSet resultadoPaciente = null;

		try {
			// Verificar si la conexión está cerrada y abrir si es necesario
			if (conexion == null || conexion.isClosed()) {
				conectarConBBDD();
			}

			// Limpiar la tabla antes de agregar nuevos resultados
			modeloTabla.setRowCount(0);

			// Buscar en la tabla 'dentilax.paciente'
			String consultaPaciente = "SELECT nombre, apellidos, idPaciente, ultimaConsulta FROM dentilax.paciente WHERE nombre LIKE ? OR apellidos LIKE ? OR idPaciente LIKE ?";
			statementPaciente = conexion.prepareStatement(consultaPaciente);
			statementPaciente.setString(1, "%" + criterio + "%");
			statementPaciente.setString(2, "%" + criterio + "%");
			statementPaciente.setString(3, "%" + criterio + "%");

			// Ejecutar la consulta
			resultadoPaciente = statementPaciente.executeQuery();

			// Procesar y mostrar los resultados para 'dentilax.paciente'
			while (resultadoPaciente.next()) {
				String nombre = resultadoPaciente.getString("nombre");
				String apellidos = resultadoPaciente.getString("apellidos");
				int idPaciente = resultadoPaciente.getInt("idPaciente");
				String ultimaConsulta = resultadoPaciente.getString("ultimaConsulta");

				// Agregar la fila a la tabla
				modeloTabla.addRow(new Object[] { nombre, apellidos, idPaciente, ultimaConsulta });
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error SQL al realizar la búsqueda", "Error",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			cerrarRecursos(resultadoPaciente, statementPaciente);
		}
	}

	// Método para cerrar los recursos (ResultSet y PreparedStatement)
	private void cerrarRecursos(ResultSet rs, PreparedStatement stmt) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean cargandoDatos = false; // Variable que indica si se están cargando datos

	public boolean isCargandoDatos() {
		return cargandoDatos;
	}

	public void setCargandoDatos(boolean cargandoDatos) {
		this.cargandoDatos = cargandoDatos;
	}

	public boolean cargarDatosPacientes(DefaultTableModel modeloTabla) {
		try {

			// Indicar que se están cargando datos
			setCargandoDatos(true);

			Vector<String> columnas = new Vector<>();
			columnas.add("Nombre");
			columnas.add("Apellidos");
			columnas.add("Documento"); // idPaciente
			columnas.add("Dirección");
			columnas.add("Teléfono");
			columnas.add("Última Consulta");

			modeloTabla.setColumnIdentifiers(columnas);

			// Verifica si hay conexión, si la hay se realiza la consulta
			if (this.conexion != null) {

				String consulta = "SELECT nombre, apellidos, idPaciente, direccion, telefono, ultimaConsulta FROM dentilax.paciente";
				Statement statement = conexion.createStatement();
				ResultSet resultado = statement.executeQuery(consulta);

				while (modeloTabla.getRowCount() > 0) {
					modeloTabla.removeRow(0);
				}

				while (resultado.next()) {
					Object[] fila = { resultado.getString("nombre"), resultado.getString("apellidos"),
							resultado.getInt("idPaciente"), resultado.getString("direccion"),
							resultado.getString("telefono"), resultado.getString("ultimaConsulta") };
					modeloTabla.addRow(fila);
				}

			} else {

			}

			// cerrarConexion(); // Puedes habilitar esto si necesitas cerrar la conexión en
			// este punto
			if (modeloTabla.getRowCount() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error SQL al cargar los datos de pacientes", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar los datos de pacientes", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			// Indicar que se ha terminado de cargar datos, ya sea con éxito o con error
			setCargandoDatos(false);
		}
	}
//////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////

	public boolean cargarDatosMaterial(DefaultTableModel modeloTabla) {
		try {

			// Indicar que se están cargando datos
			setCargandoDatos(true);

			Vector<String> columnas = new Vector<>();
			columnas.add("Nombre");
			columnas.add("cantidad");
			columnas.add("precio");

			modeloTabla.setColumnIdentifiers(columnas);

			// Verifica si la conexión es null antes de utilizarla
//			System.out.println("Conexión a la base de datos: " + (this.conexion != null ? "exitosa" : "fallida"));

			if (this.conexion != null) {
				// CONSULTA SQL
				String consulta = "SELECT nombre, cantidad, precio FROM dentilax.material";
//				System.out.println("Consulta SQL: " + consulta);

				Statement statement = conexion.createStatement();
				ResultSet resultado = statement.executeQuery(consulta);

				while (modeloTabla.getRowCount() > 0) {
					modeloTabla.removeRow(0);
				}

				while (resultado.next()) {
					Object[] fila = { resultado.getString("nombre"), resultado.getInt("cantidad"),
							resultado.getInt("precio") };
					modeloTabla.addRow(fila);
				}

//				System.out.println("Filas en la tabla de pacientes: " + modeloTabla.getRowCount());
			} else {
//				System.out.println("La conexión es null. Asegúrate de haber establecido la conexión.");
			}

			// cerrarConexion(); // Puedes habilitar esto si necesitas cerrar la conexión en
			// este punto
			if (modeloTabla.getRowCount() > 0) {
				return true; // Devuelve true solo si se cargaron datos
			} else {
				return false; // Devuelve false si no se cargaron datos
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error SQL al cargar los datos de materal", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar los datos de material", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;

		} finally {
			// Indicar que se ha terminado de cargar datos, ya sea con éxito o con error
			setCargandoDatos(false);

			// Desconectar
			cerrarConexion();

		}
	}

	public void insertarMaterial(String nombre, String cantidad, String precio) {
		try {
			if (this.conexion != null) {
				String consulta = "INSERT INTO material (nombre, cantidad, precio) VALUES (?, ?, ?)";
				PreparedStatement statement = conexion.prepareStatement(consulta);
				statement.setString(1, nombre);
				statement.setString(2, cantidad);
				statement.setString(3, precio);

				// Si id es un campo autoincremental, no es necesario incluirlo en la consulta

				int filasAfectadas = statement.executeUpdate();

				if (filasAfectadas > 0) {

					JOptionPane.showMessageDialog(null, "Paciente insertado correctamente", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error al insertar material", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				cerrarConexion();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error SQL al insertar material", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

//////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////

	public void insertarDoctor(String nombre, String apellidos, String telefono, String direccion, int idEspecialidad,
			int salario, String email) {
		try {
			if (this.conexion != null) {
				String consulta = "INSERT INTO doctor (nombre, apellidos, telefono, direccion, idEspecialidad_FK, salario, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = conexion.prepareStatement(consulta);
				statement.setString(1, nombre);
				statement.setString(2, apellidos);
				statement.setString(3, telefono);
				statement.setString(4, direccion);
				statement.setInt(5, idEspecialidad);
				statement.setInt(6, salario);
				statement.setString(7, email);

				int filasAfectadas = statement.executeUpdate();

				if (filasAfectadas > 0) {
					JOptionPane.showMessageDialog(null, "Doctor insertado correctamente", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error al insertar doctor", "Error", JOptionPane.ERROR_MESSAGE);
				}

				cerrarConexion();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error SQL al insertar doctor", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public boolean cargarDatosDoctores(DefaultTableModel modeloTabla) {
		try {

			// Indicar que se están cargando datos
			setCargandoDatos(true);

			// Verifica si la conexión es null antes de utilizarla
			if (this.conexion != null) {
				Vector<String> columnas = new Vector<>();
				columnas.add("Nombre");
				columnas.add("Apellidos");
				columnas.add("ID");
				columnas.add("Email");

				modeloTabla.setColumnIdentifiers(columnas);

				// CONSULTA SQL
				String consulta = "SELECT nombre, apellidos, idDoctor, email FROM dentilax.doctor";
				Statement statement = conexion.createStatement();
				ResultSet resultado = statement.executeQuery(consulta);

				while (modeloTabla.getRowCount() > 0) {
					modeloTabla.removeRow(0);
				}

				while (resultado.next()) {
					Object[] fila = { resultado.getString("nombre"), resultado.getString("apellidos"),
							resultado.getInt("idDoctor"), resultado.getString("email") };
					modeloTabla.addRow(fila);
				}
			} else {
//				System.out.println("La conexión es null. Asegúrate de haber establecido la conexión.");
			}
			if (modeloTabla.getRowCount() > 0) {
				return true; // Devuelve true solo si se cargaron datos
			} else {
				return false; // Devuelve false si no se cargaron datos
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error SQL al cargar los datos de doctores", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar los datos de doctores", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			// Indicar que se ha terminado de cargar datos, ya sea con éxito o con error
			setCargandoDatos(false);
		}
	}

	public boolean cargarDatosCitas(DefaultTableModel modeloTabla) {
		try {
			// Indicar que se están cargando datos
			setCargandoDatos(true);

			Vector<String> columnas = new Vector<>();
			columnas.add("ID Paciente");
			columnas.add("Motivo");
			columnas.add("Fecha");
			columnas.add("Hora");

			modeloTabla.setColumnIdentifiers(columnas);

			// Verifica si la conexión es null antes de utilizarla
			if (this.conexion != null) {
				// CONSULTA SQL
				String consulta = "SELECT idCita, fecha, hora, motivo, idPaciente_FK, idDoctor_FK FROM dentilax.cita";
				Statement statement = conexion.createStatement();
				ResultSet resultado = statement.executeQuery(consulta);

				while (modeloTabla.getRowCount() > 0) {
					modeloTabla.removeRow(0);
				}

				while (resultado.next()) {
					Object[] fila = { resultado.getInt("idPaciente_FK"), resultado.getString("motivo"),
							resultado.getDate("fecha"), resultado.getString("hora") };
					modeloTabla.addRow(fila);
				}
			} else {
//				System.out.println("La conexión es null. Asegúrate de haber establecido la conexión.");
			}

			if (modeloTabla.getRowCount() > 0) {
				return true; // Devuelve true solo si se cargaron datos
			} else {
				return false; // Devuelve false si no se cargaron datos
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error SQL al cargar los datos de citas", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar los datos de citas", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			// Indicar que se ha terminado de cargar datos, ya sea con éxito o con error
			setCargandoDatos(false);
		}
	}

	private String obtenerEspecialidad(int idEspecialidad) {
		try {
			String consultaEspecialidad = "SELECT nombre FROM dentilax.especialidad WHERE idEspecialidad = ?";
			PreparedStatement statementEspecialidad = conexion.prepareStatement(consultaEspecialidad);
			statementEspecialidad.setInt(1, idEspecialidad);
			ResultSet resultadoEspecialidad = statementEspecialidad.executeQuery();

			if (resultadoEspecialidad.next()) {
				return resultadoEspecialidad.getString("nombre");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return "";
	}

	public boolean verificarCredencialesEnBaseDeDatos(String usuario, String contrasenia) {

		try {
			/*
			 * String url = "jdbc:mysql://localhost:3306/sys?useSSL=false"; String dbUser =
			 * "root"; String dbPassword = "1234"; conexion =
			 * DriverManager.getConnection(url, dbUser, dbPassword);
			 */

			conectarConBBDD();

			// Sentencia SQL para comprobar usuario y contraseña
			String selectSQL = "SELECT * FROM dentilax.usuario WHERE Nombre = ? AND contraseña = ?";
			preparedStatement = (PreparedStatement) conexion.prepareStatement(selectSQL);
			preparedStatement.setString(1, usuario);
			preparedStatement.setString(2, contrasenia);
			resultSet = preparedStatement.executeQuery();

			// Condicional para controlar si es admin o es doctor
			if (resultSet.next()) {

				// Rol
				String rol = resultSet.getString("rol");

				// Si es admin...
				if ("administrador".equals(rol)) {
					credencialesValidas = true;

					VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
					ventanaPrincipal.setResizable(false);
					ventanaPrincipal.setIconImage(
							Toolkit.getDefaultToolkit().getImage(VentanaInicial.class.getResource("/logoAzul.png")));
					ventanaPrincipal.setLocationRelativeTo(null);
					ventanaPrincipal.setVisible(true);
					new VentanaEspectador().setVisible(false);

				} else if ("doctor".equals(rol)) {
					credencialesValidas = true;
					new VentanaEspectador().setVisible(true);
					new VentanaPrincipal().setVisible(false);
				}

			} else if (usuario.isEmpty() || contrasenia.isEmpty()) {
				// Usuario o contraseña no ingresados, muestra un mensaje de error
				JOptionPane.showMessageDialog(null, "Por favor, ingresa tu nombre de usuario y contraseña",
						"Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
			} else if (usuario.isEmpty()) {
				// Usuario o contraseña no ingresados, muestra un mensaje de error
				JOptionPane.showMessageDialog(null, "Por favor, ingresa tu nombre de usuario",
						"Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
			} else if (contrasenia.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Por favor, ingresa tu contraseña", "Error de Inicio de Sesión",
						JOptionPane.ERROR_MESSAGE);
			} else {
				// Usuario no encontrado en la base de datos, muestra un mensaje de error
				// específico
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de Inicio de Sesión",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return credencialesValidas;
	}

	// Método para cargar el odontograma por documento
	public List<ModeloDiente> cargarOdontogramaPorDocumento(int idPaciente) {
		List<ModeloDiente> odontograma = new ArrayList<>();

		// Consulta SQL para obtener el odontograma del paciente
		String consulta = "SELECT D.id_diente, D.numero_diente, D.descripcion " + "FROM dentilax.odontograma O "
				+ "JOIN dentilax.diente D ON O.id_diente = D.id_diente " + "WHERE D.idPaciente = ?";

		try (Connection conexion = obtenerConexion();
				PreparedStatement statement = conexion.prepareStatement(consulta)) {

			// Establecer el parámetro (idPaciente) en la consulta
			statement.setInt(1, idPaciente);

			// Ejecutar la consulta
			try (ResultSet resultado = statement.executeQuery()) {
				// Recorrer el resultado y construir la lista de ModeloDiente
				while (resultado.next()) {
					int idDiente = resultado.getInt("id_diente");
					int numeroDiente = resultado.getInt("numero_diente");
					String descripcion = resultado.getString("descripcion");

					// Crear un nuevo objeto ModeloDiente con los valores obtenidos de la base de
					// datos
					ModeloDiente diente = new ModeloDiente(idDiente, numeroDiente, descripcion, idPaciente);
					odontograma.add(diente);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// Puedes manejar la excepción según tus necesidades (lanzarla, loggearla, etc.)
		}

		return odontograma;
	}

	// Método para guardar la descripción; los cambios realizados se actualizan en
	// la BBDD
	public void actualizarDescripcion(int idDiente, String nuevaDescripcion) {
		String consulta = "UPDATE dentilax.diente SET descripcion = ? WHERE id_diente = ?";

		try {

			try (Connection conexion = obtenerConexion();
					PreparedStatement statement = conexion.prepareStatement(consulta)) {

				// Establecer los parámetros en la consulta
				statement.setString(1, nuevaDescripcion);
				statement.setInt(2, idDiente);

				// Ejecutar la actualización
				int filasActualizadas = statement.executeUpdate();

				if (filasActualizadas > 0) {
					JOptionPane.showMessageDialog(null, "Descripción actualizada para el diente con ID: " + idDiente);
				} else {
					JOptionPane.showMessageDialog(null, "Actualización fallida para el diente con ID: " + idDiente);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(
					"Error al actualizar la descripción en la base de datos para el diente con ID: " + idDiente);
		}
	}

	// listaBotonesDientes((nDiente-1)) //

	// ListaDientes --> listtaBotonesDientes(nDiente-1) --> JbuttonDiente
}
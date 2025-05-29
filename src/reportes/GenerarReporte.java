package reportes;

import MySQLConexion.Conectar; // Importa tu clase de conexión a la base de datos
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JOptionPane;
import java.awt.Window; // Importa Window, que es un tipo genérico para JFrame o JDialog

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GenerarReporte {

    // Método para mostrar el reporte de todas las películas, recibiendo la ventana padre
    public void mostrarReporteTodasPeliculas(Window parentWindow) {
        Connection conn = null; // Variable para la conexión a la base de datos
        try {
            // 1. Establecer la conexión a la base de datos usando tu clase Conectar
            conn = Conectar.realizarConexion();

            // 2. Cargar el archivo .jasper (reporte compilado) desde los recursos del proyecto
            // Asegúrate que 'peliculas_reporte.jasper' esté en la carpeta 'reportes' de tu 'src'
            InputStream jasperStream = getClass().getResourceAsStream("/reportes/peliculas_reporte.jasper"); 

            // Si el archivo .jasper no se encuentra, mostrar un mensaje de error
            if (jasperStream == null) {
                JOptionPane.showMessageDialog(parentWindow, "Error: No se encontró el archivo del reporte 'peliculas_reporte.jasper'.\nAsegúrate de que está en la carpeta 'reportes' de tu proyecto.", "Archivo de Reporte no Encontrado", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 3. Cargar el objeto JasperReport
            JasperReport reporte = (JasperReport) JRLoader.loadObject(jasperStream);

            // 4. Preparar los parámetros del reporte (vacío si no usas parámetros en tu reporte)
            Map<String, Object> parametros = new HashMap<>();

            // 5. Llenar el reporte con los datos de la base de datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, conn);

            // 6. Mostrar el reporte en una ventana de visor, pasándole la ventana padre
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setTitle("Reporte de Películas"); // Título para la ventana del visor
            viewer.setAlwaysOnTop(true);
            viewer.toFront(); // Intenta traer la ventana del reporte al frente
            viewer.setVisible(true);

        } catch (SQLException ex) {
            // Manejo de errores de base de datos (ej. conexión fallida)
            JOptionPane.showMessageDialog(parentWindow, "Error de base de datos al generar el reporte:\n" + ex.getMessage(), "Error de DB", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (JRException ex) {
            // Manejo de errores específicos de JasperReports (ej. reporte dañado, campos no encontrados)
            JOptionPane.showMessageDialog(parentWindow, "Error al procesar el reporte de JasperReports:\n" + ex.getMessage(), "Error de Reporte", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            // Asegurarse de cerrar la conexión a la base de datos, usando tu clase Conectar
            try {
                Conectar.realizarDesconexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión a la base de datos: " + ex.getMessage());
            }
        }
    }
}
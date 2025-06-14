/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import DAO.DAOException;
import DAO.DAOManager;
import DAOMySQL.MySQLDAOManager;
import Modelo.Pelicula;
import Modelo.GeneroPelicula;
import Modelo.Genero;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import reportes.GenerarReporte;


/**
 *
 * @author Javier
 */
public class JDPeliculas extends javax.swing.JDialog {
    //creamos un objeto del tipo interdace IPeliculaDAO
    private DAOManager manager = null;
    
    //el modelo para nuestra tabla tblGeneros
    private GenerosTableModel model;
    
    //propiedades para modificar el width de nuestra tabla tblGeneros
    TableColumnModel columnModel = null;
    
    //campos para almacenar los datos del formulario
    private int idPelicula;
    private String titulo; //nombre
    private String anio;//apellido
    
    /**
     * 
     * Creates new form JDPeliculas
     * @param parent
     * @param modal 
     */
    public JDPeliculas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        //creamos la propiedad para manejar nuestros DAO
        this.manager = new MySQLDAOManager();
        
        //llamada el método para inicializar la tabla tblTitulos
        inicializarListaGeneros();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIdPelicula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAño = new javax.swing.JTextField();
        btnTitulo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        pnlEntrada = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarPorId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtIdGenero = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGeneros = new javax.swing.JTable();
        btnEliminarGenero = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Id. Pelicula: ");

        txtIdPelicula.setText("-1");
        txtIdPelicula.setEnabled(false);

        jLabel2.setText("Titulo: ");

        jLabel3.setText("Año:");

        btnTitulo.setText("Nuevo");
        btnTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTituloActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        pnlEntrada.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar una entrada por:"));

        jLabel4.setText("Id.Pelicula: ");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEntradaLayout = new javax.swing.GroupLayout(pnlEntrada);
        pnlEntrada.setLayout(pnlEntradaLayout);
        pnlEntradaLayout.setHorizontalGroup(
            pnlEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEntradaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarPorId, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEntradaLayout.setVerticalGroup(
            pnlEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEntradaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscarPorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Genero de la pelicula"));

        jLabel5.setText("<HTML>Agregar Nuevo genero: <br> (Escribe el Id del genero de la pelicula)</HTML>");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblGeneros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "IdGenero", "Descripcion"
            }
        ));
        tblGeneros.setName("tblGeneros"); // NOI18N
        jScrollPane1.setViewportView(tblGeneros);

        btnEliminarGenero.setText("Eliminar genero de la pelicula");
        btnEliminarGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarGeneroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnEliminarGenero)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtIdGenero, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)))
                .addGap(66, 66, 66))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarGenero)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTitulo)
                            .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(245, 245, 245)))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar))
                    .addComponent(pnlEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTitulo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(pnlEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTituloActionPerformed
        // llamamos al método limpiarFormulario
        limpiarFormulario();
        limpiarRestoPantalla();
    }//GEN-LAST:event_btnTituloActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //llamamos al método validar para ver si procede guardar los datos
        if (validar()) {
            
        //si idAutor == -1 entonces insertamos el registro
        if (idPelicula == -1) {
            
            //llamamos al constructor para crear un objeto de tipo Pelicula
            Pelicula miPelicula = new Pelicula(titulo, anio);
            
            try {
                manager.getPeliculaDAO().insertar(miPelicula);
                txtIdPelicula.setText(Integer.toString(miPelicula.getIdPelicula()));
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados");
            } catch (DAOException ex) {
                imprimirMensajeDeErrorDAO(ex);
            }
        } else { //si es diferente a -1 quiere decir que se esta realizando una modificación
            
            //llamamos al constructor para crear un objeto de tipo Pelicula
            Pelicula miPelicula = new Pelicula(idPelicula, titulo, anio);
            
            try {
            manager.getPeliculaDAO().modificar(miPelicula);
            JOptionPane.showMessageDialog(null, "Los cambios han sido guardados");
            } catch (DAOException ex) {
                imprimirMensajeDeErrorDAO(ex);
            }
        } //fin del else
        } //fin del if validar
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //solo se puede eliminar si el idpeliculaes diferente a -1
        if (!txtIdPelicula.getText().equals("-1")) {
            int idPelicula = Integer.parseInt(txtIdPelicula.getText());          
            int respuesta = JOptionPane.showConfirmDialog(null,
                "¿Deseas eliminar la pelicula con id=" + idPelicula + "?", "Confirmar", 0);
            
            if (respuesta == 0) {
                
                try {
                //eliminamos la pelicula
                manager.getPeliculaDAO().eliminar(idPelicula);
                
                //si no ocurre una excepción
                JOptionPane.showMessageDialog(null, "La pelicula ha sido eliminado");
                } catch (DAOException ex) {
                    imprimirMensajeDeErrorDAO(ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Busca una pelicula para poder eliminarlo");
        }       
        limpiarFormulario();
        limpiarRestoPantalla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            //obtenemos el id. de la Pelicula a buscar
            int idABuscar = (Integer) Integer.parseInt(txtBuscarPorId.getText());
            
            //obtenemos los datos de la pelicula y lo asignamos al objetio miPelicula.
            Pelicula miPelicula = manager.getPeliculaDAO().obtener(idABuscar);
            
            actualizarListaGeneros(miPelicula.getIdPelicula());
            
            //mostramos los datos en la caja de texto
            txtIdPelicula.setText(Integer.toString(miPelicula.getIdPelicula()));
            txtTitulo.setText(miPelicula.getTitulo());
            txtAño.setText(miPelicula.getAnio());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Especifica "
                + "un número entero", "Error", JOptionPane.ERROR_MESSAGE);
            txtBuscarPorId.requestFocusInWindow();
            txtBuscarPorId.selectAll();
        } catch (DAOException ex) {
            imprimirMensajeDeErrorDAO(ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String idPeliculaText = txtIdPelicula.getText().trim();
    if (idPeliculaText.equals("-1")) {
        JOptionPane.showMessageDialog(null, "Busca primero la película a la que deseas agregar el género. El ID de la película es -1.");
        return; // Salir del método
    }

    int idPelicula;
    try {
        idPelicula = Integer.parseInt(idPeliculaText);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "El ID de la película debe ser un número entero válido.");
        txtIdPelicula.requestFocusInWindow();
        txtIdPelicula.selectAll();
        return; // Salir del método
    }

    // 2. Validar que el ID del género no esté vacío y sea numérico.
    String idGeneroText = txtIdGenero.getText().trim();
    if (idGeneroText.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Especifica el ID del Género que deseas agregar.");
        txtIdGenero.requestFocusInWindow();
        return; // Salir del método
    }

    int idGenero;
    try {
        idGenero = Integer.parseInt(idGeneroText);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "El ID del Género debe ser un número entero válido.");
        txtIdGenero.requestFocusInWindow();
        txtIdGenero.selectAll();
        return; // Salir del método
    }

    // 3. Verificar si el Género existe en la base de datos y luego intentar la inserción.
    try {
        // Intentamos obtener el género de la base de datos
        // Esto validará si el idGenero realmente corresponde a un género existente.
        Genero miGenero = manager.getGeneroDAO().obtener(idGenero);

        if (miGenero == null) {
            // Si miGenero es null, significa que el género no existe en la base de datos
            JOptionPane.showMessageDialog(null, "El ID de Género '" + idGenero + "' no se encontró en la base de datos. Por favor, verifica el ID.");
            txtIdGenero.requestFocusInWindow();
            txtIdGenero.selectAll();
            return; // Salir del método
        }

        // Si llegamos aquí, el género existe, procedemos a insertar la relación.
        GeneroPelicula generopelicula = new GeneroPelicula(idPelicula, idGenero);
        manager.getGeneroPeliculaDAO().insertar(generopelicula);

        actualizarListaGeneros(idPelicula);
        JOptionPane.showMessageDialog(null, "¡Género agregado exitosamente a la película!");

    } catch (DAOException ex) {
        // Captura excepciones específicas de tu capa de acceso a datos (DAO)
        imprimirMensajeDeErrorDAO(ex); // Un método que ya usas para manejar errores de DAO
        txtIdGenero.requestFocusInWindow();
        txtIdGenero.selectAll();
    } catch (Exception ex) {
        // Captura cualquier otra excepción inesperada
        JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado al agregar el género: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        System.err.println("Error inesperado al agregar género a película: " + ex.getMessage());
        ex.printStackTrace(); // Imprime el stack trace para depuración
    }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarGeneroActionPerformed
    if (tblGeneros.getRowCount() > 0) {
        // Verificar si hay una fila seleccionada en la tabla
        int selectedRow = tblGeneros.getSelectedRow();
        if (selectedRow == -1) {
            // No hay fila seleccionada, mostrar un mensaje al usuario
            JOptionPane.showMessageDialog(null, "Por favor, selecciona el género que deseas borrar de la tabla.",
                                      "Ningún Género Seleccionado", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método ya que no hay nada que borrar
        }

        // Usar un bloque try-catch para manejar posibles NumberFormatException
        // si el valor en la tabla no es un número (aunque debería serlo si se carga correctamente)
        int idGenero;
        try {
            // Obtenemos el idGenero de la fila seleccionada en la columna 0
            idGenero = Integer.parseInt(tblGeneros.getValueAt(selectedRow, 0).toString());
        } catch (NumberFormatException e) {
            // En caso de que el valor en la tabla no sea un número válido
            JOptionPane.showMessageDialog(null, "Error: El ID del género en la tabla no es un número válido.",
                                      "Error de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Imprimir el stack trace para depuración
            return; // Salir del método
        }

        // Confirmación del usuario antes de borrar
        int confirmResult = JOptionPane.showConfirmDialog(rootPane,
            "¿Estás seguro de que quieres borrar el Género con ID: " + idGenero +
            "\nvinculado a la película activa?",
            "Borrar Género Vinculado a Película",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        if (confirmResult == JOptionPane.YES_OPTION) {
            // Obtenemos el IdPelicula de la caja de texto
            // También debemos validar este campo, ya que es crucial para la eliminación
            int idPelicula;
            try {
                idPelicula = Integer.parseInt(txtIdPelicula.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: El ID de la película no es un número válido. " +
                    "Asegúrate de que la película esté correctamente seleccionada.",
                    "Error de ID de Película", JOptionPane.ERROR_MESSAGE);
                txtIdPelicula.requestFocusInWindow();
                txtIdPelicula.selectAll();
                e.printStackTrace();
                return; // Salir del método
            }

            // Creamos un objeto de GeneroPelicula con los IDs obtenidos
            GeneroPelicula generopelicula = new GeneroPelicula(idPelicula, idGenero);

            try {
                // Llamamos al método eliminar que recibe el objeto creado anteriormente
                manager.getGeneroPeliculaDAO().eliminar(generopelicula);

                // Actualizamos nuestra tabla para reflejar el cambio
                actualizarListaGeneros(idPelicula);

                // Mandamos mensaje de confirmación de éxito
                JOptionPane.showMessageDialog(null, "El Género con ID " + idGenero +
                    " ha sido desvinculado exitosamente de la película.",
                    "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);

            } catch (DAOException ex) {
                // Capturamos excepciones específicas de tu capa de acceso a datos (DAO)
                imprimirMensajeDeErrorDAO(ex); // Un método que ya usas para manejar errores de DAO
            } catch (Exception ex) {
                // Captura cualquier otra excepción inesperada durante la eliminación
                JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado al eliminar el género vinculado: " + ex.getMessage(),
                    "Error Inesperado", JOptionPane.ERROR_MESSAGE);
                System.err.println("Error inesperado al eliminar género de película: " + ex.getMessage());
                ex.printStackTrace(); // Imprime el stack trace para depuración
            }
        }
    } else {
        // No hay filas en la tabla para borrar
        JOptionPane.showMessageDialog(null, "No hay géneros vinculados para borrar en esta película.",
            "Tabla Vacía", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_btnEliminarGeneroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDPeliculas dialog = new JDPeliculas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarGenero;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlEntrada;
    private javax.swing.JTable tblGeneros;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtBuscarPorId;
    private javax.swing.JTextField txtIdGenero;
    private javax.swing.JTextField txtIdPelicula;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables

    /**
     * Este método permite limpiar las cajas de texto 
     * y ubicar el focus en la caja de texto del nombre
    */
    private void limpiarFormulario(){
        //asignamos el string -1 a la caja de texto del id. Pelicula
        txtIdPelicula.setText("-1");
        //limpiamos las otras cajas de texto
        txtTitulo.setText("");
        txtAño.setText("");
        
        //ubicamos el focus en la caja de texto del titulo
        txtTitulo.requestFocusInWindow();
    }
    
    /**
     * Calida los datos de entrada del formulario
     * @return true si todos son validados
     * correctamente, false en caso contrario
     */
    private boolean validar() {
        // Inicializa validacion a false, solo se establecerá en true si todas las verificaciones pasan
        boolean validacion = false;

        // 1. Validar Título
        titulo = txtTitulo.getText().trim();
        if (titulo.isEmpty()) { // Usa isEmpty() para mayor claridad y eficiencia
            JOptionPane.showMessageDialog(null, "El título de la película no puede estar vacío.");
            txtTitulo.requestFocusInWindow();
            return false; // Retorna false inmediatamente si la validación falla
        }

        // 2. Validar Año
        anio = txtAño.getText().trim();
        if (anio.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El año de la película no puede estar vacío.");
            txtAño.requestFocusInWindow();
            return false;
        }
        try {
            int anioNumerico = Integer.parseInt(anio);
            // Opcional: Agrega más validación específica del año (por ejemplo, dentro de un rango razonable)
            // Las películas comenzaron alrededor de 1888. +5 para futuros lanzamientos.
            if (anioNumerico < 1888 || anioNumerico > java.time.Year.now().getValue() + 5) {
                JOptionPane.showMessageDialog(null, "El año de la película no es válido. Debe ser entre 1888 y " + (java.time.Year.now().getValue() + 5) + ".");
                txtAño.requestFocusInWindow();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El año de la película debe ser un número entero válido.");
            txtAño.requestFocusInWindow();
            return false;
        }

        // Si todas las validaciones pasan
        validacion = true;
        return validacion;
    }
    
    /**
     * Imrpime un mensaje de error personalizado para aquellos errores 
     * que son producidos por el acceso a la base de datos
     * @param ex objeto de tipo DAOExcepción
     */
    private void imprimirMensajeDeErrorDAO(DAOException ex) {
        String mensajeDetalle = ""; // Este será el mensaje que incluirá la causa raíz

        // 1. Obtener el mensaje específico de la DAOException
        String mensajePrincipal = ex.getMessage();
        if (mensajePrincipal == null || mensajePrincipal.trim().isEmpty()) {
            mensajePrincipal = "Ha ocurrido un error en la base de datos.";
        }

        // 2. Intentar obtener el mensaje de la causa raíz de forma segura
        if (ex.getCause() != null) {
            // Si hay una causa, intentar obtener su mensaje
            String causaMensaje = ex.getCause().getMessage();
            if (causaMensaje != null && !causaMensaje.trim().isEmpty()) {
                mensajeDetalle = "\nCausa raíz: " + causaMensaje;
            } else {
                // Si la causa existe pero su mensaje es nulo o vacío
            mensajeDetalle = "\nCausa raíz: (Mensaje no disponible)";
            }
        } else {
            // Si no hay una causa raíz
            mensajeDetalle = "\nNo se proporcionó una causa raíz específica.";
       }

        // 3. (Importante para depurar): Imprimir el stack trace completo en la consola
        ex.printStackTrace();

        // 4. Mostrar el mensaje combinado al usuario
        JOptionPane.showMessageDialog(null,
                mensajePrincipal + mensajeDetalle, // Combinamos el mensaje principal y el detalle
                "Error de Base de Datos", // Título de la ventana
                JOptionPane.ERROR_MESSAGE);
    } // fin del método imprimirMensajeDeErrorDAO
    
    private void inicializarListaGeneros() {
        model = new GenerosTableModel(manager.getGeneroPeliculaDAO());
        
        //asignamos el modelo pero sin llamar al método actualizar
        //ya que el inciar el id. Pelicula es -1
        tblGeneros.setModel((TableModel) model);
        //redimensionamos las celdas
        setJTableColumnsWidth(tblGeneros, 480,50,120);
    }
    
    /**
     * Este método redimensiona el ancho de las celdas de nuestra tabla tblGeneros
     * @param table
     * @param tablePreferredWidth
     * @param percentages
     */
    public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth,
        double... percentages) {
        double total = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }

        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int)
                (tablePreferredWidth * (percentages[i] / total)));
        }
    }//fin del método setJTable...
    
    /**
     * actualiza el contenido de la tabla tblGeneros
     * @param idPelicula parámetro para realizar la búsqueda de genero por pelicula
     * @throws DAOException
     */
    private void actualizarListaGeneros(int idPelicula) throws DAOException{
        /*si no hay ningún error actualizamos la tabla
         * para mostrar los libros de este pelicula
         */
        model.updateModel(idPelicula);

        //hacemos que se reflejen los cambios
        model.fireTableDataChanged();

        //redimensionamos la celda
        setJTableColumnsWidth(tblGeneros, 480,50,120);
    }//fin del método
    
    private void limpiarRestoPantalla(){
        txtBuscarPorId.setText("");
        txtIdGenero.setText("");
        inicializarListaGeneros();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Clases.ClsCandidato;
import Clases.ClsMensajes;
import Controladores.CtlCandidato;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hueck
 */
public class VistaGestorCandidato extends javax.swing.JFrame {

    JFrame menuPrincipal;
    CtlCandidato controladorCandidato;
    ClsMensajes mensaje, mensaje2;
    boolean respuesta;
    String tipoDocumento;
    String numeroDocumento;
    String nombre;
    String telefono;
    String correo;
    String partidoP;
    String ciudad;
    String descripcion;
    String mensajeCampania;
    List propuestas;
    String id;
    // Patrón para validar el email
    Pattern patron = Pattern
            .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    /**
     * Creates new form VistaGestorCandidato
     */
    public VistaGestorCandidato(JFrame menuPrincipal) {
        initComponents();
        this.menuPrincipal = menuPrincipal;
        this.controladorCandidato = new CtlCandidato();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        botonVolver = new javax.swing.JButton();
        tabTabla = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoNumeroDocumento = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listadoPropuestas = new javax.swing.JList<>();
        jLabel11 = new javax.swing.JLabel();
        campoCorreo = new javax.swing.JTextField();
        comboPartido = new javax.swing.JComboBox<>();
        comboTipoDocumento = new javax.swing.JComboBox<>();
        botonAgregar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        campoDescripcion = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        campoMensajeCampania = new javax.swing.JTextArea();
        botonConsultar = new javax.swing.JButton();
        comboCiudad = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCandidatos = new javax.swing.JTable();
        refrescarTabla = new javax.swing.JButton();
        botoneliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaResultados = new javax.swing.JTextArea();
        botonRefrescar = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Gestor Candidato");

        botonVolver.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        tabTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabTablaMousePressed(evt);
            }
        });

        jLabel1.setText("Numero de Documento");

        jLabel2.setText("Nombre");

        campoNumeroDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNumeroDocumentoActionPerformed(evt);
            }
        });

        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipo Documento");

        jLabel5.setText("Telefono");

        campoTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTelefonoActionPerformed(evt);
            }
        });

        jLabel6.setText("Partido Politico");

        jLabel7.setText("Ciudad Origen");

        jLabel8.setText("Descripción");

        jLabel9.setText("Mensaje Campaña");

        jLabel10.setText("Propuestas");

        listadoPropuestas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Mejorar Educación", "Mejorar Salud", "Reducir Iva", "Quitar 4 x 1000", "Reducir Impuestos", "Aumentar Salarios" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listadoPropuestas.setRequestFocusEnabled(false);
        listadoPropuestas.setSelectedIndex(0);
        jScrollPane1.setViewportView(listadoPropuestas);

        jLabel11.setText("Correo");

        campoCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCorreoActionPerformed(evt);
            }
        });

        comboPartido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Centro Demoniaco", "Liberal", "Conservador", "Polo", "Pacto Historico" }));
        comboPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPartidoActionPerformed(evt);
            }
        });

        comboTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula Ciudadania", "Pasaporte", "Cedula Extranjeria" }));

        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        campoDescripcion.setColumns(20);
        campoDescripcion.setRows(5);
        jScrollPane4.setViewportView(campoDescripcion);

        campoMensajeCampania.setColumns(20);
        campoMensajeCampania.setRows(5);
        jScrollPane5.setViewportView(campoMensajeCampania);

        botonConsultar.setText("Consultar");
        botonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarActionPerformed(evt);
            }
        });

        comboCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Armenia", "Barranquilla", "Bogotá", "Cali", "Cartagena", "Manizales", "Medellin", "Pereira", "Santa Marta" }));
        comboCiudad.setToolTipText("");
        comboCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCiudadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboCiudad, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboTipoDocumento, javax.swing.GroupLayout.Alignment.LEADING, 0, 195, Short.MAX_VALUE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNumeroDocumento, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(18, 40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(botonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(comboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(campoNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonAgregar)
                            .addComponent(botonConsultar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(campoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(comboCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(183, 183, 183))))
        );

        tabTabla.addTab("Formulario", jPanel2);

        tablaCandidatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Candidato", "Nombre", "Telefono", "Correo", "Partido Politico", "Mensaje Campaña", "Propuestas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaCandidatos);

        refrescarTabla.setText("Refrescar");
        refrescarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refrescarTablaActionPerformed(evt);
            }
        });

        botoneliminar.setText("Eliminar");
        botoneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(refrescarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botoneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refrescarTabla)
                    .addComponent(botoneliminar))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        tabTabla.addTab("Tabla Candidatos", jPanel4);

        areaResultados.setColumns(20);
        areaResultados.setRows(5);
        jScrollPane2.setViewportView(areaResultados);

        botonRefrescar.setText("Refrescar");
        botonRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRefrescarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(botonRefrescar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(botonRefrescar)
                .addContainerGap())
        );

        tabTabla.addTab("Listado Candidatos", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(254, 254, 254)
                .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabTabla)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        this.setVisible(false);
        this.menuPrincipal.setVisible(true);

    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        List propuestas = this.listadoPropuestas.getSelectedValuesList();

        if (this.comboTipoDocumento.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(this, "El campo Tipo de Documento no puede ser Vacio");
        } else {
            tipoDocumento = this.comboTipoDocumento.getSelectedItem().toString();
            if (this.campoNumeroDocumento.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "El campo Numero de Documento no puede ser Vacio");
            } else {
                numeroDocumento = this.campoNumeroDocumento.getText();
                if (this.campoNombre.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "El campo Nombre no puede ser Vacio");
                } else {
                    nombre = this.campoNombre.getText();
                    if (this.campoTelefono.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "El campo Telefono no puede ser Vacio");
                    } else {
                        telefono = this.campoTelefono.getText();
                        if (this.campoCorreo.getText().equals("")) {
                            JOptionPane.showMessageDialog(this, "El campo Correo no puede ser Vacio");
                        } else {
                            correo = this.campoCorreo.getText();
                            Matcher mather = patron.matcher(correo);
                            if (mather.find() == true) {
                                System.out.println("El email ingresado es válido.");
                                if (this.comboPartido.getSelectedItem().toString().equals("")) {
                                    JOptionPane.showMessageDialog(this, "El campo Partido Politico no puede ser Vacio");
                                } else {
                                    partidoP = this.comboPartido.getSelectedItem().toString();
                                    if (this.comboCiudad.getSelectedItem().toString().equals("")) {
                                        JOptionPane.showMessageDialog(this, "El campo Ciudad de Origen no puede ser Vacio");
                                    } else {
                                        ciudad = this.comboCiudad.getSelectedItem().toString();
                                        if (this.campoDescripcion.getText().equals("")) {
                                            JOptionPane.showMessageDialog(this, "El campo Descripción no puede ser Vacio");
                                        } else {
                                            descripcion = this.campoDescripcion.getText();
                                            if (this.campoMensajeCampania.getText().equals("")) {
                                                JOptionPane.showMessageDialog(this, "El campo Mensaje Campaña no puede ser Vacio");
                                            } else {
                                                mensajeCampania = this.campoMensajeCampania.getText();
                                                if (this.listadoPropuestas.getSelectedValuesList().equals("")) {
                                                    JOptionPane.showMessageDialog(this, "El campo Propuestas no puede ser Vacio");
                                                } else {
                                                    propuestas = this.listadoPropuestas.getSelectedValuesList();
                                                    ClsCandidato candidato = new ClsCandidato(numeroDocumento, tipoDocumento, nombre, telefono, correo, partidoP, ciudad, descripcion, mensajeCampania, propuestas);
                                                    respuesta = this.controladorCandidato.agregarCandidato(candidato);
                                                    if (respuesta == true) {
                                                        JOptionPane.showMessageDialog(null, "Votante Ingresado Correctamente a la BD");
                                                        this.comboTipoDocumento.setSelectedIndex(0);
                                                        this.campoNumeroDocumento.setText("");
                                                        this.campoNombre.setText("");
                                                        this.campoTelefono.setText("");
                                                        this.campoCorreo.setText("");
                                                        this.comboPartido.setSelectedIndex(0);
                                                        this.comboCiudad.setSelectedIndex(0);
                                                        this.campoDescripcion.setText("");
                                                        this.campoMensajeCampania.setText("");
                                                        this.listadoPropuestas.setSelectedIndex(0);
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "El Votante no pudo ser agregado a la BD");
                                                    }

                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                System.out.println("El email ingresado es inválido.");
                                JOptionPane.showMessageDialog(this, "El correo ingresado no cumple con el formato solicitado: ejemplo@ejemplo.com");
                            }

                        }
                    }
                }
            }
        }


    }//GEN-LAST:event_botonAgregarActionPerformed

    private void comboPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPartidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPartidoActionPerformed

    private void campoTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTelefonoActionPerformed

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActionPerformed

    private void campoNumeroDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNumeroDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNumeroDocumentoActionPerformed

    private void botonRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRefrescarActionPerformed
        ClsCandidato candidato = new ClsCandidato();
        String listado = this.controladorCandidato.consultarCandidato(candidato);
        areaResultados.setText(listado);
        this.ObtenerCandidatos();
    }//GEN-LAST:event_botonRefrescarActionPerformed

    private void tabTablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabTablaMousePressed
        ClsCandidato candidato = new ClsCandidato();
        String listado = this.controladorCandidato.consultarCandidato(candidato);
        areaResultados.setText(listado);
        this.ObtenerCandidatos();

    }//GEN-LAST:event_tabTablaMousePressed

    public void ObtenerCandidatos() {
        LinkedList<ClsCandidato> listaCandidatos = this.controladorCandidato.ObtenerCandidatos();
        this.ActualizarTabla(listaCandidatos);
    }

    public void ActualizarTabla(LinkedList<ClsCandidato> candidatos) {
        DefaultTableModel modelo = (DefaultTableModel) this.tablaCandidatos.getModel();
        modelo.setRowCount(0);

        for (ClsCandidato c : candidatos) {
            Object[] fila = {c.getNumeroDocumento(), c.getNombre(), c.getTelefono(), c.getCorreo(), c.getPartidoPolitico(), c.getMensajeCampania(), c.getPropuestas()};
            modelo.addRow(fila);
        }
    }
    private void refrescarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrescarTablaActionPerformed
        this.ObtenerCandidatos();
    }//GEN-LAST:event_refrescarTablaActionPerformed

    private void botoneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoneliminarActionPerformed
        int columna = 0;
        int fila = this.tablaCandidatos.getSelectedRow();
        

        System.err.println(fila);

        if (fila >= 0) {
            String id=this.tablaCandidatos.getValueAt(fila, columna).toString();
            mensaje = this.controladorCandidato.eliminarCandidato(id);
            if (mensaje.getTipo().equals(ClsMensajes.OK)) {
                ObtenerCandidatos();
                mensaje.mostrarMensajeOk();
            }
        } else {
            mensaje2 = new ClsMensajes(ClsMensajes.ERROR, "El id a eliminar no puede ser vacio y debe seleccionar alguna fila");
            mensaje2.mostrarMensajeError();
        }


    }//GEN-LAST:event_botoneliminarActionPerformed

    private void campoCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCorreoActionPerformed

    private void botonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonConsultarActionPerformed

    private void comboCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCiudadActionPerformed

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
            java.util.logging.Logger.getLogger(VistaGestorCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGestorCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGestorCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGestorCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaGestorCandidato(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaResultados;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonConsultar;
    private javax.swing.JButton botonRefrescar;
    private javax.swing.JButton botonVolver;
    private javax.swing.JButton botoneliminar;
    private javax.swing.JTextField campoCorreo;
    private javax.swing.JTextArea campoDescripcion;
    private javax.swing.JTextArea campoMensajeCampania;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoNumeroDocumento;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JComboBox<String> comboCiudad;
    private javax.swing.JComboBox<String> comboPartido;
    private javax.swing.JComboBox<String> comboTipoDocumento;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<String> listadoPropuestas;
    private javax.swing.JButton refrescarTabla;
    private javax.swing.JTabbedPane tabTabla;
    private javax.swing.JTable tablaCandidatos;
    // End of variables declaration//GEN-END:variables
}

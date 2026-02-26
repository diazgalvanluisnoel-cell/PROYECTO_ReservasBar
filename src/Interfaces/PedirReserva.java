package Interfaces;


import Gestion.Coneccion;
import Interfaces.VistaReserva;
import java.awt.Color;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class PedirReserva extends javax.swing.JFrame {

   private Connection con;
   private int idMesaSeleccion=-1;
   private javax.swing.border.Border bordenombre;
   
    public PedirReserva() {
        initComponents();
        
       try {
           con=Coneccion.getConnection();
       } catch (SQLException ex) {
           Logger.getLogger(PedirReserva.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
        spnhora.setEditor(new JSpinner.NumberEditor(spnhora,"#"));
          spnpersonas.setEditor(new JSpinner.NumberEditor(spnpersonas,"#"));
          
          ButtonGroup grupoHora=new ButtonGroup();
          grupoHora.add(rbam);
          grupoHora.add(rbpm);
          
          rbam.setSelected(true);
          
          txtmesa.setHorizontalAlignment(JTextField.CENTER);
          
    }
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        rbam = new javax.swing.JRadioButton();
        rbpm = new javax.swing.JRadioButton();
        btnguardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        spnpersonas = new javax.swing.JSpinner();
        spnhora = new javax.swing.JSpinner();
        cbdia = new javax.swing.JComboBox();
        cbmes = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        btngenerarmesa = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        txtmesa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel1.setText("REGISTRO RESERVA");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Nombre de Cliete >");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Telefono de Cliete >");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Fecha >");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Hora >");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Cantidad de personas >");

        rbam.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbam.setText("AM");

        rbpm.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbpm.setText("PM");

        btnguardar.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        btnguardar.setText("GUARDAR");
        btnguardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("< ATRAS");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setText("SALIR");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        spnpersonas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        spnpersonas.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        spnhora.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        spnhora.setModel(new javax.swing.SpinnerNumberModel(0, 0, 12, 1));

        cbdia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbdia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));
        cbdia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbdiaActionPerformed(evt);
            }
        });

        cbmes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbmes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Mesa >");

        btngenerarmesa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btngenerarmesa.setText("BUSCAR");
        btngenerarmesa.setToolTipText("Mesas disponibles");
        btngenerarmesa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btngenerarmesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngenerarmesaActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton4.setText("RESTAURAR");
        jButton4.setToolTipText("Limpiar Campos \nVolver a guardar reserva");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtmesa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 404, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(348, 348, 348))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(63, 63, 63)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rbpm, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txttelefono)
                                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btngenerarmesa, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtmesa, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(spnhora, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(rbam, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(108, 108, 108)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(spnpersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(3, 3, 3)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbdia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(cbmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtnombre))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbdia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spnhora)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbpm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnpersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngenerarmesa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmesa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(23, 23, 23)
                .addComponent(jButton3)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        
        if(idMesaSeleccion==-1 || txtmesa == null ){
        JOptionPane.showMessageDialog(this, "Debe generar una mesa primero","Error",JOptionPane.ERROR_MESSAGE);
        return;
        }
        
        String nombre="";
        String telefono="";
        int idCliente=0;
        int cantpersonas=0;
        LocalDate fecha = null;
         LocalTime hora1=null; 
        bordenombre=txtnombre.getBorder();
         
        try{
        
             nombre=txtnombre.getText();
            if(nombre.length()<4 || nombre.matches(".*\\d.*")){
                txtnombre.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
             JOptionPane.showMessageDialog(this, "Introducir nombre correctamente .","Error",JOptionPane.WARNING_MESSAGE);
             txtnombre.setCaretColor(Color.RED);
             txtnombre.setBorder(bordenombre);
             return;
            }
             telefono=txttelefono.getText();
            
            if(telefono.length()!=8 || telefono.matches(".*a-zA-Z*.") ){
             JOptionPane.showMessageDialog(this, "Introducir telefono correctammente","Error",JOptionPane.WARNING_MESSAGE);
             return;
            }
            
        int dia=(int) cbdia.getSelectedIndex()+1;
        
        int mes=(int) cbmes.getSelectedIndex()+1;
        
        int ano=LocalDate.now().getYear();
        
        fecha=LocalDate.of(ano, mes, dia);
        
        int hora=(int) spnhora.getValue();
        
        if(hora==0){
        JOptionPane.showMessageDialog(this, "Introducir hora correctamente .","Error",JOptionPane.WARNING_MESSAGE);
        return;
        }
        
        boolean isAM=rbam.isSelected();
        
        if(!isAM && hora != 12){
        hora+=12;
        }
        if(isAM && hora == 12){
        hora=0;
        }
        
         hora1=LocalTime.of(hora, 0);
        
         cantpersonas=(int) spnpersonas.getValue();
        
        if(cantpersonas==0 || cantpersonas==1){
        JOptionPane.showMessageDialog(null, "Introducir cantidad de personas correctamente .");
        return ;
        }
        
          }catch(Exception e){
          JOptionPane.showMessageDialog(this, "Datos invalidos en fecha o hora", "Error", JOptionPane.ERROR_MESSAGE
          );
                   
          }
        String nombreBuscado="";
        
        try (Connection con = Coneccion.getConnection()) {

        int idcliente = -1;

        // 1Buscar cliente por teléfono
        String sqlBuscarCliente = "SELECT id_cliente,nombre FROM cliente WHERE telefono = ?";
        try (PreparedStatement psBuscar = con.prepareStatement(sqlBuscarCliente)) {
            
            psBuscar.setString(1, telefono);
            
            try (ResultSet rs = psBuscar.executeQuery()) {
                
                if (rs.next()) {
                     nombreBuscado=rs.getString("nombre");
                
                     if(!nombreBuscado.equalsIgnoreCase(nombre)){
  JOptionPane.showMessageDialog(this, "El cliente "+nombreBuscado+" ys esta registrado en el sistema con ese numero de telefono .");
                    return;
                    }
                  
                    if(nombreBuscado.equalsIgnoreCase(nombre)){
                    idcliente=rs.getInt("id_cliente");
                    }
                
                }
                 else {
                    // Cliente no existe → insertarlo
     String sqlInsertarCliente = "INSERT INTO cliente(nombre, telefono) VALUES (?, ?) RETURNING id_cliente";
                    try (PreparedStatement psInsert = con.prepareStatement(sqlInsertarCliente)) {
                        psInsert.setString(1, nombre);
                        psInsert.setString(2, telefono);
                        try (ResultSet rsInsert = psInsert.executeQuery()) {
                            if (rsInsert.next()) {
                                idcliente = rsInsert.getInt("id_cliente");
                            }
                        }
                    }
                }
            }
        }
        
        String sqlreserva="INSERT INTO reserva (fecha,hora,cant_personas,fk_cliente,fk_mesa) "
                + "VALUES(?,?,?,?,?)";
        
        PreparedStatement psres=con.prepareStatement(sqlreserva);
        psres.setDate(1, java.sql.Date.valueOf(fecha));
        psres.setTime(2, java.sql.Time.valueOf(hora1));
        psres.setInt(3, cantpersonas);
        psres.setInt(4, idcliente);
        psres.setInt(5, idMesaSeleccion);
        
        btnguardar.setEnabled(false);
        psres.executeUpdate();
        JOptionPane.showMessageDialog(null, "Reserva Guardada "+"\n\n Nombre : "+nombre.toUpperCase()+"\n Cantidad de Personas : " +cantpersonas+"\n Mesa Asignada "+idMesaSeleccion+"\n Fecha : "+fecha+"\n Hora : "+hora1+"\n");
        
        }catch(SQLException e){
            e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al guardar reservacion");
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        VistaReserva vr=new VistaReserva();
        vr.setLocationRelativeTo(null);
        vr.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btngenerarmesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngenerarmesaActionPerformed
        // TODO add your handling code here:
        bordenombre=txtnombre.getBorder();
        
         int cantpersonas=0;
        LocalDate fecha = null;
         LocalTime hora1=null; 
        LocalDate fechahoy=LocalDate.now();
        
        try{
        
            String nombre=txtnombre.getText();
            if(nombre.length() < 4 || nombre.matches(".*\\d.*")){
                
             txtnombre.setBorder ( BorderFactory.createLineBorder (Color.RED , 1));
                
             JOptionPane.showMessageDialog(this, "Introducir nombre correctamente .",
                                          "Error",JOptionPane.WARNING_MESSAGE);
              txtnombre.setBorder(bordenombre);
             return;
            }
            String telefono=txttelefono.getText();
            
            if(telefono.length() < 8 || telefono.matches(".*a-zA-Z.*")){
             JOptionPane.showMessageDialog(this, "Introducir telefono correctammente","Error",JOptionPane.WARNING_MESSAGE);
             return;
            }
            
        int dia=(int) cbdia.getSelectedIndex()+1;
        
        int mes=(int) cbmes.getSelectedIndex()+1;
        
        int ano=LocalDate.now().getYear();
        
        fecha=LocalDate.of(ano, mes, dia);
        
  if(fecha.isBefore(fechahoy)){
  
  JOptionPane.showMessageDialog(this, "La fecha ("+fecha+") es anterior a la fecha actual .","ERROR",JOptionPane.ERROR_MESSAGE);
  return;
  }
        
        int hora=(int) spnhora.getValue();
        
        if(hora==0){
        JOptionPane.showMessageDialog(this, "Introducir hora correctamente .","Error",JOptionPane.WARNING_MESSAGE);
        return;
        }
        
        boolean isAM=rbam.isSelected();
        
        if(!isAM && hora != 12){
        hora+=12;
        }
        if(isAM && hora == 12){
        hora=0;
        }
        
         hora1=LocalTime.of(hora, 0);
        
         cantpersonas=(int) spnpersonas.getValue();
        
        if(cantpersonas==0 || cantpersonas==1){
        JOptionPane.showMessageDialog(null, "Introducir cantidad de personas correctamente .");
        return ;
        }
        
        
          }catch(Exception e){
          JOptionPane.showMessageDialog(this, "Datos invalidos en fecha o hora", "Error", JOptionPane.ERROR_MESSAGE
          );
                   
          }
        
        LocalTime horafin=hora1.plusHours(1).plusMinutes(30);
          
       String sql ="SELECT m.id_mesa, m.numero, m.capacidad " +"FROM mesa m " +
    "WHERE (m.capacidad = ? OR m.capacidad = ?) " +"AND m.id_mesa NOT IN (" +
    "SELECT r.fk_mesa " +"FROM reserva r "  +"Where r.fecha = ? " +
    " AND (? < r.hora_fin AND ? > r.hora )) " +"ORDER BY m.capacidad ASC LIMIT 1";

try (Connection conex = Coneccion.getConnection();
     PreparedStatement ps = conex.prepareStatement(sql)) {

    // 2. Rellenar los ?
    ps.setInt(1, cantpersonas);
    ps.setInt(2, cantpersonas+1);
    ps.setDate(3, java.sql.Date.valueOf(fecha)); // LocalDate → SQL DATE
    ps.setTime(4, java.sql.Time.valueOf(hora1)); // LocalTime → SQL TIME
    ps.setTime(5, java.sql.Time.valueOf(horafin));
    
    // 3. Ejecutar consulta
    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        int idMesa = rs.getInt("id_mesa");
        int numeroMesa = rs.getInt("numero");

        // 4. Mostrar al usuario
        JOptionPane.showMessageDialog(this,
            "Mesa " + numeroMesa + " asignada correctamente ");

        // Mostrar Mesas y bloquear campos
        txtmesa.setText(String.valueOf(numeroMesa));
        txtmesa.setEditable(false);
        txtnombre.setEditable(false);
        txttelefono.setEditable(false);
        spnhora.setEnabled(false);
        cbdia.setEditable(false);
        cbdia.setEnabled(false);
        cbmes.setEnabled(false);
        cbmes.setEditable(false);
        spnpersonas.setEnabled(false);
          
        // 5. Guardar idMesa para usarlo luego al guardar el pedido
        this.idMesaSeleccion = idMesa;

        // 6. Evitar generar otra mesa
        btngenerarmesa.setEnabled(false);

    } else {
        JOptionPane.showMessageDialog(this,
            "No hay mesas disponibles para esa fecha seleccionada",
            "Sin mesas",
            JOptionPane.WARNING_MESSAGE);
    }

} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(this,
        "Error metodo generar la mesa",
        "Error",
        JOptionPane.ERROR_MESSAGE);
}
          
          
    }//GEN-LAST:event_btngenerarmesaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
        
        txtnombre.setText("");
        txttelefono.setText("");
        cbdia.setSelectedIndex(0);
        cbmes.setSelectedIndex(0);
        spnhora.setValue(0);
        spnpersonas.setValue(0);
        txtmesa.setText("");
        rbam.setSelected(true);
        rbpm.setSelected(false);
        btngenerarmesa.setEnabled(true);
        btnguardar.setEnabled(true);
        txtnombre.setForeground(Color.BLACK);
        
        txtnombre.setEditable(true);
        txttelefono.setEditable(true);
        spnhora.setEnabled(true);
        cbdia.setEditable(true);
        cbdia.setEnabled(true);
        cbmes.setEnabled(true);
        cbmes.setEditable(true);
        spnpersonas.setEnabled(true);
        
        JOptionPane.showMessageDialog(null,"Campos restaurados");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbdiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbdiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbdiaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btngenerarmesa;
    private javax.swing.JButton btnguardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cbdia;
    private javax.swing.JComboBox cbmes;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbam;
    private javax.swing.JRadioButton rbpm;
    private javax.swing.JSpinner spnhora;
    private javax.swing.JSpinner spnpersonas;
    private javax.swing.JTextField txtmesa;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}

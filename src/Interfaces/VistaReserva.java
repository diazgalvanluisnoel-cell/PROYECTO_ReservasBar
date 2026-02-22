package Interfaces;

import Gestion.Coneccion;
import Clases.ClienteFrecuente;
import Clases.ClienteHistoria;
import Clases.ReservaDtaos;
import Estructuras.LinkedPila;
import Estructuras.ListaEnlazada;
import Estructuras.Node;
import Gestion.ControlCliente;
import Gestion.ControlReserva;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaReserva extends javax.swing.JFrame {

    private LinkedPila<ReservaDtaos> pilaHistoria = new LinkedPila<>();
    private  ControlReserva control = new ControlReserva();
    
    public VistaReserva() {
        pilaHistoria = new LinkedPila<>();

        initComponents();

        mostrarFechatxt();
    }

    private void mostrarFechatxt() {

        LocalDate fecha = LocalDate.now();

        String fechatxt = fecha.toString();

        txtFecha.setHorizontalAlignment(0);
        txtFecha.setFont(new Font("Arial", Font.BOLD, 18));
        txtFecha.setEditable(false);
        txtFecha.setBackground(Color.white);
        txtFecha.setText(fechatxt);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        historialTodo = new javax.swing.JButton();
        historialHoy = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        lblimg = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        actualizarEstado = new javax.swing.JButton();
        actualizarEstado1 = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        btnclientehistorial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        historialTodo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        historialTodo.setText("HISTORIAL > Reservas");
        historialTodo.setToolTipText("Todas");
        historialTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialTodoActionPerformed(evt);
            }
        });

        historialHoy.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        historialHoy.setText("RESERVAS > HOY");
        historialHoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialHoyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel1.setText(" MENU RESERVAS");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("REGISTRAR RESERVACION");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setText("MODIFICAR RESERVACION");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton3.setText("ELIMINAR RESERVACION");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton7.setText("BUSCAR RESERVACION");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton8.setText("<- ATRAS");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton9.setText("SALIR");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        lblimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cscs.png"))); // NOI18N

        jButton10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton10.setText("HISTORIAL > Pendientes");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton11.setText("HISTORIAL > Canceladas");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        actualizarEstado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        actualizarEstado.setText("CANCELAR RESERVACION");
        actualizarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarEstadoActionPerformed(evt);
            }
        });

        actualizarEstado1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        actualizarEstado1.setText("Historial > Completadas");
        actualizarEstado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarEstado1ActionPerformed(evt);
            }
        });

        txtFecha.setEditable(false);
        txtFecha.setToolTipText("Fecha Actual");
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        btnclientehistorial.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnclientehistorial.setText("Historial > Clientes");
        btnclientehistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclientehistorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(actualizarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(lblimg)
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(actualizarEstado1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(historialTodo, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(historialHoy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnclientehistorial, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(411, 411, 411))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(11, 11, 11)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(actualizarEstado))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(historialHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(historialTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(actualizarEstado1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnclientehistorial))
                    .addComponent(lblimg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:

        VistaInicial vi = new VistaInicial();
        vi.setLocationRelativeTo(null);
        vi.setVisible(true);

        this.dispose();

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PedirReserva pr = new PedirReserva();
        pr.setLocationRelativeTo(null);
        pr.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int iden = 0;
        int id_cliente = 0;
        String fecha = null;

        try {
            iden = Integer.parseInt(JOptionPane.showInputDialog(this, "Inserte el ID de la reservacion a modificar "));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID valido ");
            return;
        }

        try {
            Connection con = Coneccion.getConnection();

            String sql = "SELECT r.id_reserva,r.fecha,r.hora,r.cant_personas,r.fk_cliente, "
                    + "r.fk_mesa,c.nombre,c.telefono From reserva r JOIN cliente c "
                    + "On r.fk_cliente=c.id_cliente WHERE id_reserva = ? AND NOT estado = 'Completada' ";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, iden);
            ps.executeQuery();

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                fecha = rs.getString("fecha");
                String hora = rs.getString("hora");
                int cant_persona = rs.getInt("cant_personas");
                int mesa = rs.getInt("fk_mesa");
                String telefono = rs.getString("telefono");
                String nombre = rs.getString("nombre");
                id_cliente = rs.getInt("fk_cliente");
                
                JOptionPane.showMessageDialog(this, "Reserva Encontrada " + "\n\nNombre : " + nombre + "\nTelefono : " + telefono + "\nFecha : " + fecha + "\nHora : " + hora + "\nCantidad de Personas : " + cant_persona + "\nNumero de Mesa : " + mesa);

                String atributo = JOptionPane.showInputDialog(null, "Que atributo desea modificar:\n\n"
                        + "1 - Nombre del Cliente\n"
                        + "2 - Telefono del Cliente\n"
                        + "3 - Fecha\n"
                        + "4 - Hora\n"+
                        "  5 - Salir\n\n");
                 
                int opcion=0;
                
                try{
                 opcion = (Integer.parseInt(atributo));
                }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Ingrese una opcion valida");
                }   
                
                switch (opcion) {

                    case 1: { // MODIFICAR NOMBRE
                        String nuevoNombre;

                        do {
                            nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre del cliente :");
                            if (nuevoNombre == null) {
                                break;
                            }

                            if (!nuevoNombre.matches("[a-zA-Z ]+")) {
                                JOptionPane.showMessageDialog(null, "Nombre inválido");
                                nuevoNombre = null;
                            }

                        } while (nuevoNombre == null);

                        if (nuevoNombre == null) {
                            break;
                        }

                        ControlReserva cr=new ControlReserva();
                        
                       if( cr.verificarClienteReserva(nuevoNombre)){
                       JOptionPane.showMessageDialog(this, "Existe en la base de datos un cliente con el nombre : "
                               +nuevoNombre,
                               "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                       return;
                       }
                        
                        try (PreparedStatement ps2 = con.prepareStatement(
                                "UPDATE cliente SET nombre = ? WHERE id_cliente = ?")) {

                            ps2.setString(1, nuevoNombre);
                            ps2.setInt(2, id_cliente);
                            ps2.executeUpdate();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(this, "No se guardo el nuevo nombre puede estar repetido");
                        }

                        JOptionPane.showMessageDialog(null, "Nombre actualizado correctamente");
                        break;
                    }

                    case 2: { // MODIFICAR TELÉFONO
                        String nuevoTelefono;

                        do {
                            nuevoTelefono = JOptionPane.showInputDialog("Nuevo teléfono :");
                            if (nuevoTelefono == null) {
                                break;
                            }

                            if (nuevoTelefono.length() != 8 || !nuevoTelefono.matches("\\d+")) {
                                JOptionPane.showMessageDialog(this, "Teléfono inválido", "Error", JOptionPane.ERROR_MESSAGE);
                                nuevoTelefono = null;
                            }

                        } while (nuevoTelefono == null);

                        if (nuevoTelefono == null) {
                            break;
                        }

                        try (PreparedStatement ps3 = con.prepareStatement(
                                "UPDATE cliente SET telefono = ? WHERE id_cliente = ?")) {

                            ps3.setString(1, nuevoTelefono);
                            ps3.setInt(2, id_cliente);
                            ps3.executeUpdate();
                        }

                        JOptionPane.showMessageDialog(null, "Teléfono actualizado correctamente");
                        break;
                    }

                    case 3: { // MODIFICAR FECHA
                        String fechaTxt;

                        do {
                            fechaTxt = JOptionPane.showInputDialog(
                                    "Nueva fecha (YYYY-MM-DD)\nEj: 2026-01-20");
                            if (fechaTxt == null) {
                                break;
                            }

                            if (!fechaTxt.matches("\\d{4}-\\d{2}-\\d{2}")) {
                                JOptionPane.showMessageDialog(null, "Formato de fecha inválido");
                                fechaTxt = null;
                                continue;
                            }

                            try {
                                LocalDate.parse(fecha);
                            } catch (DateTimeParseException e) {
                                JOptionPane.showMessageDialog(null, "Fecha inexistente");
                                fechaTxt = null;
                            }

                        } while (fechaTxt == null);

                        if (fecha == null) {
                            break;
                        }

                        // metodo modificarFecha()
                     LocalDate fechaNueva = LocalDate.parse(fechaTxt);
                     
                    control.modificarFecha(iden, fechaNueva);                
                     
                        break;
                    }

                    case 4: { // MODIFICAR HORA
                        String horaTxt;

                        do {
                            horaTxt = JOptionPane.showInputDialog(
                                    "Nueva hora (HH:MM)\nEj: 19:30");
                            if (horaTxt == null) {
                                break;
                            }

                            if (!horaTxt.matches("([01]\\d|2[0-3]):[0-5]\\d")) {
                                JOptionPane.showMessageDialog(null, "Formato de hora inválido");
                                horaTxt = null;
                            }

                        } while (horaTxt == null);

                        if (horaTxt == null) {
                            break;
                        }

                        try (PreparedStatement ps5 = con.prepareStatement(
                                "UPDATE reserva SET hora = ? WHERE id_reserva = ?")) {

                            ps5.setTime(1, Time.valueOf(LocalTime.parse(horaTxt)));
                            ps5.setInt(2, iden);
                            ps5.executeUpdate();
                        }

                        JOptionPane.showMessageDialog(null, "Hora actualizada correctamente");
                        break;
                    }

                    case 5 :
                        JOptionPane.showMessageDialog(null, "Modificación cancelada");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida");
                     break;
                }

            } else {
                JOptionPane.showMessageDialog(this, "No se encontraron reservaciones con el ID : " + iden + "\nO es una reservacion realizada ");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar reservacion .");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int iden = 0;
        String nombreBuscar = "";
        int opcion = 0;

        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(this, "Escoja forma de busqueda \n\n"
                    + "1 - Por ID \n"
                    + "2 - Por Nombre del cliente\n"
                    + "3 - Salir\n\n"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Inserte una opcion correcta ");
            return;
        }

        switch (opcion) {

            case 1:
                
                try {
                    iden = Integer.parseInt(JOptionPane.showInputDialog(this, "Inserte el ID de la reservacion "));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Ingrese un ID valido ");
                    return;
                }

                try {
                    Connection con = Coneccion.getConnection();

                    String sql = "SELECT r.id_reserva,r.fecha,r.hora,r.estado,r.fk_mesa,r.fk_cliente,r.cant_personas,c.nombre,c.telefono FROM reserva r JOIN cliente c ON r.fk_cliente=c.id_cliente WHERE r.id_reserva=?";

                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, iden);
                    ps.executeQuery();

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "Reserva Encontrada");

                        Object[] fila = new Object[]{
                            rs.getInt("id_reserva"),
                            rs.getString("nombre"),
                            rs.getString("telefono"),
                            rs.getDate("fecha"),
                            rs.getTime("hora"),
                            rs.getInt("fk_mesa"),
                            rs.getInt("cant_personas"),
                            rs.getString("estado")

                        };

                        TablaReserva Tabla = new TablaReserva();

                        Tabla.mostrarReservaEnTabla(fila);
                        Tabla.setLocationRelativeTo(null);
                        Tabla.setVisible(true);

                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "No hay reservaciones con ID : " + iden);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error al buscar reservacion");
                }

                break;

            case 2:

                nombreBuscar = JOptionPane.showInputDialog(this, "Inserte el nombre del cliente ");

                if (!nombreBuscar.matches("[a-zA-Z ]+")) {
                    JOptionPane.showMessageDialog(this, "Nombre invalido .");
                    break;
                }

                ControlReserva control = new ControlReserva();
                ListaEnlazada <ReservaDtaos> lista = control.buscarReservasPorNombre(nombreBuscar); 
                
                if (lista.isEmpty()) { 
                    JOptionPane.showMessageDialog(this, "No hay reservas para " + nombreBuscar);
                    return; 
                } 
                
                TablaReserva tabla = new TablaReserva();
                tabla.limpiarTabla();
                
                
                Node <ReservaDtaos> nodo = lista.getCabeza();
                
                while(nodo!=null){
                Object [] fila=new Object[]{
                        nodo.getInfo().getIdReserva(),
                        nodo.getInfo().getNombre(),
                        nodo.getInfo().getTelefono(),
                        nodo.getInfo().getFecha(),
                        nodo.getInfo().getHora(),
                        nodo.getInfo().getMesa(),
                        nodo.getInfo().getPersonas(),
                        nodo.getInfo().getEstado()
                };
                tabla.aggReservaEnTablaHistorial(fila);
                nodo=nodo.getNext();
                }
                tabla.setLocationRelativeTo(null);
                tabla.setVisible(true); 
                
                this.dispose(); 
    
                break;

            case 3:
                break;

            default:
                JOptionPane.showMessageDialog(this, "Introduzca la opcion correctamente",
                        "ERROR",JOptionPane.ERROR_MESSAGE);
                break;
        }


    }//GEN-LAST:event_jButton7ActionPerformed

    private void historialTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialTodoActionPerformed
        // TODO add your handling code here:

        try {
            Connection con = Coneccion.getConnection();

            String sql = "SELECT r.id_reserva,r.fecha,r.hora,r.estado,r.cant_personas,fk_mesa,c.nombre,c.telefono FROM reserva r"
                    + " JOIN cliente c ON r.fk_cliente = c.id_cliente ORDER BY r.fecha DESC ";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs1 = ps.executeQuery();
            TablaReserva tabla = new TablaReserva();

            tabla.limpiarTabla();

            while (rs1.next()) {

                LocalDate fechac = rs1.getDate("fecha").toLocalDate();
                LocalTime horac = rs1.getTime("hora").toLocalTime();

                ReservaDtaos r = new ReservaDtaos(
                        rs1.getInt("id_reserva"),
                        rs1.getString("nombre"),
                        rs1.getString("telefono"),
                        fechac,
                        horac,
                        rs1.getInt("fk_mesa"),
                        rs1.getInt("cant_personas"),
                        rs1.getString("estado")
                );

                pilaHistoria.push(r);

            }

            if (pilaHistoria.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay reservacionoes registradas");
                return;
            }

            while (!pilaHistoria.isEmpty()) {

                ReservaDtaos r2 = pilaHistoria.pop();

                Object[] fila = new Object[]{
                    r2.getIdReserva(),
                    r2.getNombre(),
                    r2.getTelefono(),
                    r2.getFecha(),
                    r2.getHora(),
                    r2.getMesa(),
                    r2.getPersonas(),
                    r2.getEstado()
                };
                tabla.aggReservaEnTablaHistorial(fila);
            }

            tabla.setLocationRelativeTo(null);
            tabla.setVisible(true);
            this.dispose();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en mostrar el historial");
        }
        
    }//GEN-LAST:event_historialTodoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        int iden = 0;
        try {
            iden = Integer.parseInt(JOptionPane.showInputDialog(this, "Inserte el ID de la reservacion "));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID valido ");
            return;
        }

        try {
            Connection con = Coneccion.getConnection();

            String sql = "DELETE FROM reserva WHERE id_reserva=?";
            String sql2 = "SELECT c.nombre FROM cliente c WHERE id_cliente=?  ";

            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, iden);
            ps2.executeQuery();

            ResultSet rs = ps2.executeQuery();
            String nombreCliente ="";
            if (rs.next()) {
                nombreCliente = rs.getString("nombre");
            }

            if(!nombreCliente.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Reservacion de " + nombreCliente.toUpperCase() + " eliminada con exito ");
            }else {
        JOptionPane.showMessageDialog(this, "No hay reservaciones con ID : "+iden);
        return;
        }
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, iden);
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar reservacion .");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void historialHoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialHoyActionPerformed
        // TODO add your handling code here:

        LocalDate fechahoy = LocalDate.now();
        Date fechasql = Date.valueOf(fechahoy);

        try {
            Connection con = Coneccion.getConnection();

            String sql = "SELECT r.id_reserva,r.fecha,r.hora,r.estado,r.cant_personas,fk_mesa,c.nombre,c.telefono FROM reserva r JOIN cliente c ON r.fk_cliente=c.id_cliente WHERE r.fecha = ? ORDER BY r.id_reserva DESC";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, fechasql);
            ps.executeQuery();

            ResultSet rs1 = ps.executeQuery();
            TablaReserva Tabla2 = new TablaReserva();

            Tabla2.limpiarTabla();
            boolean datos = false;

            while (rs1.next()) {

                datos = true;

                Object[] fila = new Object[]{
                    rs1.getInt("id_reserva"),
                    rs1.getString("nombre"),
                    rs1.getString("telefono"),
                    rs1.getDate("fecha"),
                    rs1.getTime("hora"),
                    rs1.getInt("fk_mesa"),
                    rs1.getInt("cant_personas"),
                    rs1.getString("estado")

                };

                Tabla2.aggReservaEnTablaHistorial(fila);
                Tabla2.setLocationRelativeTo(null);
                Tabla2.setVisible(true);

                this.dispose();
            }

            if (datos == false) {
                JOptionPane.showMessageDialog(this, "No hay reservas el dia de hoy");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en mostrar historial");
        }
    }//GEN-LAST:event_historialHoyActionPerformed

    private void actualizarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarEstadoActionPerformed
        // TODO add your handling code here:

        int iden = 0;

        try {
            iden = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID de la reserva "));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID valido ");
        }

        try {
            Connection con = Coneccion.getConnection();

            String sql = "UPDATE reserva SET estado = 'Cancelada' WHERE id_reserva=? AND estado <> 'Completada' ";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, iden);
            ps.executeUpdate();

            int filas = ps.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(this, "Estado actualizado .");
            } else {
                JOptionPane.showMessageDialog(this, "No hay reservas con ese ID o es una reserva Realizada .");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar el estado perdone  ");
        }
    }//GEN-LAST:event_actualizarEstadoActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        try {
            Connection con = Coneccion.getConnection();

            String sql = "SELECT r.id_reserva,r.fecha,r.hora,r.estado,r.cant_personas,fk_mesa,c.nombre,c.telefono FROM reserva r JOIN cliente c ON r.fk_cliente=c.id_cliente WHERE r.estado='Pendiente' ";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();

            ResultSet rs1 = ps.executeQuery();
            TablaReserva Tabla2 = new TablaReserva();

            Tabla2.limpiarTabla();

            while (rs1.next()) {

                Object[] fila = new Object[]{
                    rs1.getInt("id_reserva"),
                    rs1.getString("nombre"),
                    rs1.getString("telefono"),
                    rs1.getDate("fecha"),
                    rs1.getTime("hora"),
                    rs1.getInt("fk_mesa"),
                    rs1.getInt("cant_personas"),
                    rs1.getString("estado")

                };

                Tabla2.aggReservaEnTablaHistorial(fila);
                Tabla2.setLocationRelativeTo(null);
                Tabla2.setVisible(true);

                this.dispose();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en mostrar historial ");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:

        try {
            Connection con = Coneccion.getConnection();

            String sql = "SELECT r.id_reserva,r.fecha,r.hora,r.estado,r.cant_personas,fk_mesa,c.nombre,c.telefono FROM reserva r JOIN cliente c ON r.fk_cliente=c.id_cliente WHERE r.estado = 'Cancelada' ";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();

            ResultSet rs1 = ps.executeQuery();
            TablaReserva Tabla2 = new TablaReserva();

            Tabla2.limpiarTabla();
            boolean datos = false;

            while (rs1.next()) {

                datos = true;

                Object[] fila = new Object[]{
                    rs1.getInt("id_reserva"),
                    rs1.getString("nombre"),
                    rs1.getString("telefono"),
                    rs1.getDate("fecha"),
                    rs1.getTime("hora"),
                    rs1.getInt("fk_mesa"),
                    rs1.getInt("cant_personas"),
                    rs1.getString("estado")

                };

                Tabla2.aggReservaEnTablaHistorial(fila);

                this.dispose();
            }
            if (datos == false) {
                JOptionPane.showMessageDialog(this, "No hay reservas con estado (Cancelada) ");
                return;
            }

            Tabla2.setLocationRelativeTo(null);
            Tabla2.setVisible(true);

        } catch (SQLException e){
            JOptionPane.showMessageDialog(this, "Error en mostrar historial ");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void actualizarEstado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarEstado1ActionPerformed
        // TODO add your handling code here:

        try {
            Connection con = Coneccion.getConnection();

            String sql = "SELECT r.id_reserva,r.fecha,r.hora,r.estado,r.cant_personas,fk_mesa,c.nombre,c.telefono FROM reserva r JOIN cliente c ON r.fk_cliente=c.id_cliente WHERE r.estado='Completada' ";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();

            ResultSet rs1 = ps.executeQuery();
            TablaReserva Tabla2 = new TablaReserva();

            Tabla2.limpiarTabla();

            while (rs1.next()) {

                Object[] fila = new Object[]{
                    rs1.getInt("id_reserva"),
                    rs1.getString("nombre"),
                    rs1.getString("telefono"),
                    rs1.getDate("fecha"),
                    rs1.getTime("hora"),
                    rs1.getInt("fk_mesa"),
                    rs1.getInt("cant_personas"),
                    rs1.getString("estado")

                };

                Tabla2.aggReservaEnTablaHistorial(fila);
                Tabla2.setLocationRelativeTo(null);
                Tabla2.setVisible(true);

                this.dispose();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en actualizar estado");
        }
    }//GEN-LAST:event_actualizarEstado1ActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnclientehistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclientehistorialActionPerformed
        // TODO add your handling code here:
     TablaCliente tc=new TablaCliente();

        tc.cargarHistoral();
        tc.setLocationRelativeTo(null);
        tc.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnclientehistorialActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarEstado;
    private javax.swing.JButton actualizarEstado1;
    private javax.swing.JButton btnclientehistorial;
    private javax.swing.JButton historialHoy;
    private javax.swing.JButton historialTodo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblimg;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}

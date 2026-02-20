
package Interfaces;

import Clases.ClienteFrecuente;
import Clases.ClienteHistoria;
import Estructuras.LinkedPila;
import Gestion.ControlCliente;
import Gestion.ControlReserva;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;


public class TablaCliente extends javax.swing.JFrame {

    
    public TablaCliente() {
        initComponents();
        
        personalizarTabla();
    }

    private void personalizarTabla() {
    JTableHeader header = tablacliente.getTableHeader();
    header.setFont(new Font("Segoe UI", Font.BOLD, 15));
    header.setPreferredSize(new Dimension(
            header.getPreferredSize().width, 38));

   
    tablacliente.setFont(new Font("Arial", Font.BOLD, 12));
    
   TableColumnModel cm=tablacliente.getColumnModel();
    cm.getColumn(0).setPreferredWidth(20);
     cm.getColumn(1).setPreferredWidth(230);
    cm.getColumn(2).setPreferredWidth(120);
    cm.getColumn(3).setPreferredWidth(20);
    
    tablacliente.setRowHeight(28);
    
    
    DefaultTableCellRenderer centrado=new DefaultTableCellRenderer();
    centrado.setHorizontalAlignment(SwingConstants.CENTER);
    
    for (int i = 0; i < tablacliente.getColumnModel().getColumnCount(); i++) {
    tablacliente.getColumnModel().getColumn(i).setCellRenderer(centrado);
    }
}
    
    public void agregarFilaClienteFrecuente(ClienteFrecuente cf) {
        DefaultTableModel modelo = (DefaultTableModel) tablacliente.getModel(); 
        modelo.addRow(new Object[]{
            cf.getCliente().getId(),
            cf.getCliente().getNombre().toUpperCase(),
            cf.getCliente().getTelefono(),
            cf.getCant_reserva() }); 
    }
    
    private void agregarFilaClienteHistoria(ClienteHistoria ch) {
        ClienteFrecuente cf = ch.getFrecuente();
        
        DefaultTableModel modelo = (DefaultTableModel) tablacliente.getModel();
        
        modelo.addRow(new Object[]{
            cf.getCliente().getId(),
            cf.getCliente().getNombre(),
            cf.getCliente().getTelefono(),
            cf.getCant_reserva(), 
            ch.getFecha() }); 
    }
    
    public void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablacliente.getModel();
     modelo.setRowCount(0); 
    }
    
    public void cargarHistoral(){
    
        ControlCliente control = new ControlCliente();
        
        LinkedPila<ClienteHistoria> pila = control.historialClientes();
        
        DefaultTableModel modelo = (DefaultTableModel) tablacliente.getModel(); 
        
        modelo.setRowCount(0); 
        
        while (!pila.isEmpty()) {
            ClienteHistoria ch = pila.pop();
            ClienteFrecuente cf = ch.getFrecuente();
            modelo.addRow(new Object[]{ 
                cf.getCliente().getId(), 
                cf.getCliente().getNombre(),
                cf.getCliente().getTelefono(),
                cf.getCant_reserva(), 
                ch.getFecha() }); 
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        popupMenu2 = new java.awt.PopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacliente = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnFrecunte = new javax.swing.JButton();

        popupMenu1.setLabel("popupMenu1");

        popupMenu2.setLabel("popupMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablacliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "TELEFONO", "RESERVAS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablacliente);

        btnAtras.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAtras.setText("< ATRAS");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnFrecunte.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnFrecunte.setText("Mas Frecunte");
        btnFrecunte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFrecunteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFrecunte, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(379, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtras)
                    .addComponent(btnFrecunte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        
        VistaReserva vr=new VistaReserva();
        vr.setLocationRelativeTo(null);
        vr.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnFrecunteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFrecunteActionPerformed
        // TODO add your handling code here:
        
        TablaCliente tc=new TablaCliente();
        
        ControlReserva control=new ControlReserva();
        ClienteFrecuente cf= control.clienteMasFrecuente();
        
       tc.limpiarTabla();
       tc.agregarFilaClienteFrecuente(cf);
        
       tc.setLocationRelativeTo(null);
        tc.setVisible(true);
       
        this.dispose();
    }//GEN-LAST:event_btnFrecunteActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnFrecunte;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.PopupMenu popupMenu2;
    private javax.swing.JTable tablacliente;
    // End of variables declaration//GEN-END:variables
}

package Interfaces;


import Gestion.ControlReserva;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import org.apache.poi.ss.usermodel.*; 
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
import java.io.FileOutputStream;

public class TablaReserva extends javax.swing.JFrame {

    
    public TablaReserva() {
        initComponents();
        
        personalizarTabla();
    }

    public void limpiarTabla(){
     DefaultTableModel model =
            (DefaultTableModel) tablareserva.getModel();

    model.setRowCount(0);
    }
    
    public void mostrarReservaEnTabla(Object[] fila) {

    DefaultTableModel model =
            (DefaultTableModel) tablareserva.getModel();

    model.setRowCount(0); // limpia
    model.addRow(fila);   // agrega la reserva
}
    
    public void aggReservaEnTablaHistorial(Object[] fila) {

    DefaultTableModel model =
            (DefaultTableModel) tablareserva.getModel();

   
    model.addRow(fila);   // agrega la reserva
}
    
    public void mostrarReservaEnTabla2(Object[] fila) {

    DefaultTableModel model =
            (DefaultTableModel) tablareserva.getModel();

    
    model.addRow(fila);   // agrega la reserva
}
    
    public JTable getTablareserva() {
        return tablareserva;
    }

    public void setTablareserva(JTable tablareserva) {
        this.tablareserva = tablareserva;
    }

    private void personalizarTabla() {
    JTableHeader header = tablareserva.getTableHeader();
    header.setFont(new Font("Segoe UI", Font.BOLD, 15));
    header.setPreferredSize(new Dimension(
            header.getPreferredSize().width, 38));

   
   TableColumnModel cm=tablareserva.getColumnModel();
    cm.getColumn(0).setPreferredWidth(45);
     cm.getColumn(1).setPreferredWidth(250);
    cm.getColumn(2).setPreferredWidth(140);
    cm.getColumn(5).setPreferredWidth(30);
    cm.getColumn(6).setPreferredWidth(30);
    tablareserva.setRowHeight(28);
    
    
    DefaultTableCellRenderer centrado=new DefaultTableCellRenderer();
    centrado.setHorizontalAlignment(SwingConstants.CENTER);
    
    for (int i = 0; i < tablareserva.getColumnModel().getColumnCount(); i++) {
    tablareserva.getColumnModel().getColumn(i).setCellRenderer(centrado);
    }
}
    
    public void exportarTabla(JTable tabla, String nombreArchivo) {
        try {
            Workbook libro = new XSSFWorkbook();
            Sheet hoja = libro.createSheet("Historial");

             // Escribir encabezados
            Row filaEncabezado = hoja.createRow(0);

            for (int i = 0; i < tabla.getColumnCount(); i++) {

                Cell celda = filaEncabezado.createCell(i);
                celda.setCellValue(tabla.getColumnName(i));
            }

            // Escribir filas
            for (int i = 0; i < tabla.getRowCount(); i++) {

                Row fila = hoja.createRow(i + 1);

                for (int j = 0; j < tabla.getColumnCount(); j++) {

                    Object valor = tabla.getValueAt(i, j);
                    Cell celda = fila.createCell(j);
                    if (valor instanceof Number) {
                        celda.setCellValue(Double.parseDouble(valor.toString()));
                    } else {
                        celda.setCellValue(valor != null ? valor.toString() : "");
                    }
                }
            }
            FileOutputStream archivo = new FileOutputStream(nombreArchivo + ".xlsx");

            libro.write(archivo);
            archivo.close();
            libro.close();

            System.out.println("Archivo Excel creado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablareserva = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnactualizarEst = new javax.swing.JButton();
        btnactualizarEst1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablareserva.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tablareserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID - Reserva", "Nombre de Cliente", "Telefono #", "Fecha", "Hora", "# de Mesa", "Personas", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablareserva);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("< ATRAS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnactualizarEst.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnactualizarEst.setText("Actualizar Estado");
        btnactualizarEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarEstActionPerformed(evt);
            }
        });

        btnactualizarEst1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnactualizarEst1.setText("Exportar a Excel");
        btnactualizarEst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarEst1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnactualizarEst1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnactualizarEst, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnactualizarEst))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnactualizarEst1))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        VistaReserva vr=new VistaReserva();
        vr.setLocationRelativeTo(null);
        vr.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnactualizarEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarEstActionPerformed
        // TODO add your handling code here:
        
        ControlReserva control=new ControlReserva();
       
       int veces = control.actualizarEstadoAutomatico();
        
        if(veces>0){
        JOptionPane.showMessageDialog(this, "Reservas actualizadas "+veces);
        }else{
        JOptionPane.showMessageDialog(this, "Las reservaciones estan actualizadas");
        }
    }//GEN-LAST:event_btnactualizarEstActionPerformed

    private void btnactualizarEst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarEst1ActionPerformed
        // TODO add your handling code here:
        
       exportarTabla(tablareserva, "HistorialReservas");
    }//GEN-LAST:event_btnactualizarEst1ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizarEst;
    private javax.swing.JButton btnactualizarEst1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablareserva;
    // End of variables declaration//GEN-END:variables
}

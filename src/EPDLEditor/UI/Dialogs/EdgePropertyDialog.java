/*
 * EdgePropertyDialog.java
 *
 * Created on March 22, 2007, 2:23 PM
 * Copyright 2007 Grotto Networking
 */

package EPDLEditor.UI.Dialogs;

import EPDLEditor.MainEditor;
import EPDLEditor.Types.GraphElements;

/**
 *
 * @author  Ronen Vaisenberg and Greg
 */
public class EdgePropertyDialog extends javax.swing.JDialog {
    GraphElements.MyEdge edge;
    
    /** Creates new form EdgePropertyDialog */
    public EdgePropertyDialog(java.awt.Frame parent, GraphElements.MyEdge edge) {
        super(parent, true);
        initComponents();
        this.edge = edge;
        setTitle("Edge: " + edge.toString());
        if (edge.getEventIds()!=null)
        	this.jList1.setSelectedIndices(edge.getEventIds());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edge Properties");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonHandler(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Event 1", "Event 2", "Event 3", "Derived Event 1", "Derived Event 2", "Derived Event 3" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(82, 82, 82)
                        .add(jButton1))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(17, 17, 17)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonHandler
    	edge.setEvents(this.jList1.getSelectedIndices());
    	setTitle(edge.toString());
    	MainEditor.vv.repaint();
        dispose();
    }//GEN-LAST:event_okButtonHandler

    public void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        jList1.setModel(new javax.swing.AbstractListModel() {             
            public int getSize() { return MainEditor.events.size(); }
            public Object getElementAt(int i) { return MainEditor.events.get(i).eventTypeIdentifier; }
        });
        if (edge.getEventIds()!=null)
        	jList1.setSelectedIndices(edge.getEventIds());
    }//GEN-LAST:event_formComponentShown
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
}
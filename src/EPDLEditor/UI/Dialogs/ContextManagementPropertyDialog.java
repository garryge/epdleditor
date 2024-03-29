/*
 * EdgePropertyDialog.java
 *
 * Created on March 22, 2007, 2:23 PM
 * Copyright 2007 Grotto Networking
 */

package EPDLEditor.UI.Dialogs;

import java.awt.Dimension;

import EPDLEditor.MainEditor;
import EPDLEditor.Types.Context;
import EPDLEditor.exceptions.ObjectBeingUsedException;

/**
 *
 * @author  Ronen Vaisenberg and Greg
 */
public class ContextManagementPropertyDialog extends javax.swing.JDialog {

    
    /** Creates new form EdgePropertyDialog */
    public ContextManagementPropertyDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        setTitle("Context Management");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDoneButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jReferencedEventScrollPane = new javax.swing.JScrollPane();
        jReferencedContext = new javax.swing.JList();
        jEditButton = new javax.swing.JButton();
        jDeleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Event Type Properties");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jDoneButton.setText("Done");
        jDoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDoneButtonokButtonHandler(evt);
            }
        });

        jButton1.setText("Create a New Context Definition...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Existing Contexts (Click to edit):");

        jReferencedContext.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Event 1", "Event 2", "Event 3", "Derived Event 1", "Derived Event 2", "Derived Event 3" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jReferencedContext.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jReferencedContext.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jReferencedContextValueChanged(evt);
            }
        });
        jReferencedEventScrollPane.setViewportView(jReferencedContext);

        jEditButton.setText("Edit");
        jEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditButtonokButtonHandler(evt);
            }
        });

        jDeleteButton.setText("Delete");
        jDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteButtonokButtonHandler(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jReferencedEventScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 267, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1)
                    .add(jLabel1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jEditButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jDeleteButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 42, Short.MAX_VALUE)
                        .add(jDoneButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(jReferencedEventScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 406, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jDoneButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .add(jEditButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .add(jDeleteButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .add(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void jDoneButtonokButtonHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDoneButtonokButtonHandler
        dispose();
    }//GEN-LAST:event_jDoneButtonokButtonHandler

    public void formComponentShown(java.awt.event.ComponentEvent evt) {                                       
    	updateContextsList();
    }                                   

    private void updateContextsList() {
        jReferencedContext.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return MainEditor.contexts.size(); }
            public Object getElementAt(int i) { return MainEditor.contexts.get(i).contextIdentifier; }
        });
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	Context ev = new Context();
    	MainEditor.contexts.add(ev);
    	
    	editContext(ev);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void editContext(Context cx) {
    	ContextPropertyDialog dialog = new ContextPropertyDialog(MainEditor.frame,cx);
        Dimension componentSize =  dialog.getSize();
		Dimension panelSize =  MainEditor.frame.getSize();
		int componentX = (panelSize.width<componentSize.width?0: MainEditor.frame.getX()+(panelSize.width-componentSize.width)/2);
		int componentY = (panelSize.height<componentSize.height?0: MainEditor.frame.getY()+(panelSize.height-componentSize.height)/2);
		dialog.setLocation(componentX, componentY);
    	dialog.setVisible(true);
        // repaint the list
        updateContextsList();
		
	}

	private void jReferencedContextValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jReferencedContextValueChanged
//    	int selectedEventIdx = jReferencedContext.getSelectedIndex();
//    	if (selectedEventIdx==-1) return;
//    	Context ev = MainEditor.contexts.get(selectedEventIdx);
//    	
//    	editContext(ev);
    }//GEN-LAST:event_jReferencedContextValueChanged

        private void jEditButtonokButtonHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditButtonokButtonHandler
        	int selectedEventIdx = jReferencedContext.getSelectedIndex();
        	if (selectedEventIdx==-1) return;
        	Context ev = MainEditor.contexts.get(selectedEventIdx);
        	
        	editContext(ev);
        }//GEN-LAST:event_jEditButtonokButtonHandler

        private void jDeleteButtonokButtonHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteButtonokButtonHandler
        	int selectedEventIdx = jReferencedContext.getSelectedIndex();
        	if (selectedEventIdx==-1) return;
        	Context ev = MainEditor.contexts.get(selectedEventIdx);
        	
        	String agentUsing = Context.deleteContext(ev);
        	if (agentUsing!=null){
        		String errorTxt = ev.getID() +" is being used by "+agentUsing;
        		MainEditor.dispayError(errorTxt, new ObjectBeingUsedException(errorTxt));
        	} else 
                updateContextsList();
        	
        }//GEN-LAST:event_jDeleteButtonokButtonHandler
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jDeleteButton;
    private javax.swing.JButton jDoneButton;
    private javax.swing.JButton jEditButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jReferencedContext;
    private javax.swing.JScrollPane jReferencedEventScrollPane;
    // End of variables declaration//GEN-END:variables
    
}

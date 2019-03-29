/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.principal;


import com.bean.Rota;
import com.dao.RotaDAO;
import com.utils.Tabela;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author thiago.napoleao
 */
public final class InclusaoRotas extends javax.swing.JPanel {

    /**
     * Creates new form InclusaoRotas
     */
    public InclusaoRotas() {
        initComponents();
        defaults();
    }

    public void defaults() {
        codigoTxt.requestFocus(true);
        preencherTabela();
    }
    
    
    public void inserir() {
        Rota rota = new Rota();
        
        rota.setCodigo(Integer.parseInt(codigoTxt.getText()));
        rota.setRt(rtTxt.getText());
        rota.setDestino(destinoTxt.getText());
        rota.setMeta(metaTxt.getText());
        
        RotaDAO rotaDAO = new RotaDAO();
        rotaDAO.insert(rota);
        
        JOptionPane.showMessageDialog(null, "Rota inserido com sucesso!");
        
        preencherTabela();
        
        limparCampos();
    }
    
    
    public void preencherTabela() {//para iniciar junto com o frame é só fazer a chamada deste metodo dentro do metodo construtor ou no metodo defaults()
       
        
        RotaDAO dao = new RotaDAO();
        try {
            
            ArrayList dados = new ArrayList();

            String[] Colunas = new String[]{"Codigo da Rota", "Rota", "Destino", "Meta de saida"};
            
            /////////////////////////////////////
                  
             List<Rota> rota = dao.findAll();// o objeto mot rececebe todos os registros do metodo findAll da classe RotaDAO
           
         
    
            for(int i = 0; i < rota.size(); i++) {

                dados.add(new Object[]{rota.get(i).getCodigo(), rota.get(i).getRt(), rota.get(i).getDestino(), rota.get(i).getMeta()});
            
            }

            Tabela tabela = new Tabela(dados, Colunas);
            tblRota.setModel(tabela);
            
            tblRota.getColumnModel().getColumn(0).setPreferredWidth(120);
            tblRota.getColumnModel().getColumn(0).setResizable(false);
            
            tblRota.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblRota.getColumnModel().getColumn(1).setResizable(false);
            
            tblRota.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblRota.getColumnModel().getColumn(2).setResizable(false);
            
            tblRota.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblRota.getColumnModel().getColumn(3).setResizable(false);
                  
           
            tblRota.getTableHeader().setReorderingAllowed(false);
            tblRota.setAutoResizeMode(tblRota.AUTO_RESIZE_OFF);
            tblRota.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        }catch(Exception ex) {
            ex.printStackTrace();
        } 
    } 
          
    
    
    
    public void limparCampos() {
        
        codigoTxt.setText("");
        rtTxt.setText("");
        destinoTxt.setText("");
        metaTxt.setText("");
        
        rtTxt.requestFocus(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        destinoTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rtTxt = new javax.swing.JTextField();
        metaTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        codigoTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRota = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jButton1.setText("Incluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel1.setText("Destino");

        destinoTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        destinoTxt.setNextFocusableComponent(metaTxt);

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel2.setText("Rota");

        rtTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        rtTxt.setNextFocusableComponent(destinoTxt);

        metaTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        metaTxt.setNextFocusableComponent(jButton1);

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setText("Meta de Saida");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/MedSantaCruz1.png"))); // NOI18N

        codigoTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        codigoTxt.setNextFocusableComponent(rtTxt);

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel5.setText("Codigo Rota");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/cadstro de rota.png"))); // NOI18N

        tblRota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblRota);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(rtTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(destinoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addComponent(metaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigoTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rtTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(destinoTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(metaTxt)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(279, 279, 279))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        inserir();
    }//GEN-LAST:event_jButton1ActionPerformed


   
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JTextField destinoTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField metaTxt;
    private javax.swing.JTextField rtTxt;
    private javax.swing.JTable tblRota;
    // End of variables declaration//GEN-END:variables

   
}

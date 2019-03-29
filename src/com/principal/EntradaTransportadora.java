/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.principal;

import com.bean.EntradaTransport;
import com.bean.Motorista;
import com.bean.Veiculo;
import com.dao.EntradaTransportDAO;
import com.dao.MotoristaDAO;
import com.dao.VeiculoDAO;
import com.utils.DataHora;
import com.utils.Tabela;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;

/**
 *
 * @author thiago.napoleao
 */
public class EntradaTransportadora extends javax.swing.JPanel {

    /**
     * Creates new form EntradaTransportadora
     */
    public EntradaTransportadora() {
        initComponents();
        defaults();
       preencherTabela();
        preencherTabela3();
        preencherTabela4();
    }

    public void defaults(){
    
     DataHora data = new DataHora();
     dataTxt.setText(data.Data());       
     DataHora hora = new DataHora();
     entradaTxt.setText(hora.Hora());
       
     codigoTxt.requestFocus(true);
    }
    
    public void inserir() {
      
         DataHora dataHora = new DataHora();
        
        EntradaTransport erro = new EntradaTransport();
        
        
        erro.setData(dataTxt.getText());
        erro.setEmpresa(empresaTxt.getText());
        erro.setEntrada(entradaTxt.getText());
        erro.setNome(nomeTxt.getText());
        erro.setPlaca(placaTxt.getText());
        erro.setObs(obsTxt.getText());
         erro.setVigilante(vigilanteTxt.getText());
        
        EntradaTransportDAO erroDAO = new EntradaTransportDAO();
        
        // linha que realiza a persistencia no banco(salvar)
        erroDAO.insert(erro);
        
       
     preencherTabela();
        
        zeraCampos();
    }
     
   
    
     public void zeraCampos() {
        
       
        codigoTxt.setText("");
        codigo1Txt.setText("");
        empresaTxt.setText("");
        obsTxt.setText("");
        placaTxt.setText("");
        nomeTxt.setText("");
        vigilanteTxt.setText("");
        
        
        codigoTxt.requestFocus(true);
    }

     
      public void preencherTabela() {
       
        
        EntradaTransportDAO dao = new EntradaTransportDAO();
        try {
            ArrayList dados = new ArrayList();

            String[] Colunas = new String[]{"Nome", "Placa do Veiculo", "Horario de Entrada", "Empresa"};
            
            /////////////////////////////////////
            
            
            
            // erro ao pegar a data   (nao existe o campo)
            List<EntradaTransport> erro = dao.findByData(dataTxt.getText());

            for(int i = 0; i < erro.size(); i++) {

                dados.add(new Object[]{erro.get(i).getNome(), erro.get(i).getPlaca(), erro.get(i).getEntrada(), erro.get(i).getEmpresa()});
            
            }

            Tabela tabela = new Tabela(dados, Colunas);
            tblEntrada.setModel(tabela);
            
            tblEntrada.getColumnModel().getColumn(0).setPreferredWidth(230);
            tblEntrada.getColumnModel().getColumn(0).setResizable(false);
            
            tblEntrada.getColumnModel().getColumn(1).setPreferredWidth(190);
            tblEntrada.getColumnModel().getColumn(1).setResizable(false);
            
            tblEntrada.getColumnModel().getColumn(2).setPreferredWidth(180);
            tblEntrada.getColumnModel().getColumn(2).setResizable(false);
            
            tblEntrada.getColumnModel().getColumn(3).setPreferredWidth(230);
            tblEntrada.getColumnModel().getColumn(3).setResizable(false);
            
          
                  
            tblEntrada.getTableHeader().setReorderingAllowed(false);
            tblEntrada.setAutoResizeMode(tblEntrada.AUTO_RESIZE_OFF);
            tblEntrada.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        }catch(Exception ex) {
            ex.printStackTrace();
        } 
    } 
     
    public void preencherTabela3() {
       
        
        VeiculoDAO dao = new VeiculoDAO();
        try {
            ArrayList dados = new ArrayList();

            String[] Colunas = new String[]{"Cod", "Veiculo", "Tranportadora"};
            
            /////////////////////////////////////
                      
            List<Veiculo> veic = dao.findAll();
            
            

            for(int i = 0; i < veic.size(); i++) {

                dados.add(new Object[]{veic.get(i).getCodigo(), veic.get(i).getPlaca(), veic.get(i).getTransportadora()});
            
            }

            Tabela tabela = new Tabela(dados, Colunas);
            tblVeiculo.setModel(tabela);
            
            tblVeiculo.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblVeiculo.getColumnModel().getColumn(0).setResizable(false);
            
            tblVeiculo.getColumnModel().getColumn(1).setPreferredWidth(90);
            tblVeiculo.getColumnModel().getColumn(1).setResizable(false);
            
            tblVeiculo.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblVeiculo.getColumnModel().getColumn(2).setResizable(false);
            
                    
           tblVeiculo.getTableHeader().setReorderingAllowed(false);
           tblVeiculo.setAutoResizeMode(tblVeiculo.AUTO_RESIZE_OFF);
           tblVeiculo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        }catch(Exception ex) {
            ex.printStackTrace();
        } 
    } 
    
     public void preencherTabela4() {
       
        
        MotoristaDAO dao = new MotoristaDAO();
        try {
            ArrayList dados = new ArrayList();

            String[] Colunas = new String[]{"Cod", "Motorista", "Transportadora"};
            
            /////////////////////////////////////
                      
            List<Motorista> mot = dao.findAll();
            
            

            for(int i = 0; i < mot.size(); i++) {

                dados.add(new Object[]{mot.get(i).getCodigo(), mot.get(i).getMoto(), mot.get(i).getEmpresa()});
            
            }

            Tabela tabela = new Tabela(dados, Colunas);
            tblMotorista.setModel(tabela);
            
           tblMotorista.getColumnModel().getColumn(0).setPreferredWidth(50);
           tblMotorista.getColumnModel().getColumn(0).setResizable(false);
            
           tblMotorista.getColumnModel().getColumn(1).setPreferredWidth(150);
           tblMotorista.getColumnModel().getColumn(1).setResizable(false);
            
           tblMotorista.getColumnModel().getColumn(2).setPreferredWidth(150);
           tblMotorista.getColumnModel().getColumn(2).setResizable(false); 
                    
           tblMotorista.getTableHeader().setReorderingAllowed(false);
           tblMotorista.setAutoResizeMode(tblMotorista.AUTO_RESIZE_OFF);
           tblMotorista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        }catch(Exception ex) {
            ex.printStackTrace();
        } 
    } 
      public void nomePlaca(int codigo) {
        
        Veiculo rota = null;
     
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        List<Veiculo> veiculos = veiculoDAO.findByCodigo(codigo);
        rota = veiculos.get(0);
        if(rota != null) {
           placaTxt.setText(rota.getPlaca()); 
            empresaTxt.setText(rota.getTransportadora()); 
            
        }
    }
    
    public void nomeMotorista(int codigo) {
        
        Motorista rota = null;
     
        MotoristaDAO motoristaDAO = new MotoristaDAO();
        List<Motorista> motoristas = motoristaDAO.findByCodigo(codigo);
        rota = motoristas.get(0);
        if(rota != null) {
           nomeTxt.setText(rota.getMoto());
           
            
        }
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
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nomeTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        codigo1Txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        obsTxt = new javax.swing.JTextField();
        entradaTxt = new javax.swing.JTextField();
        codigoTxt = new javax.swing.JTextField();
        empresaTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        placaTxt = new javax.swing.JTextField();
        vigilanteTxt = new javax.swing.JTextField();
        dataTxt = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblVeiculo = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMotorista = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEntrada = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel1.setText("Data");

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel7.setText("Obs.");

        jLabel10.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel10.setText("Codigo do Motorista");

        nomeTxt.setEditable(false);
        nomeTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        nomeTxt.setFocusable(false);
        nomeTxt.setRequestFocusEnabled(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/MedSantaCruz1.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel9.setText("Codigo do Veiculo");

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel8.setText("Vigilante");

        codigo1Txt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        codigo1Txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codigo1Txt.setNextFocusableComponent(obsTxt);
        codigo1Txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigo1TxtKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setText("Horario de Entrada");

        obsTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        obsTxt.setNextFocusableComponent(vigilanteTxt);

        entradaTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        entradaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        codigoTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        codigoTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codigoTxt.setNextFocusableComponent(codigo1Txt);
        codigoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigoTxtKeyReleased(evt);
            }
        });

        empresaTxt.setEditable(false);
        empresaTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        empresaTxt.setFocusable(false);
        empresaTxt.setRequestFocusEnabled(false);

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel6.setText("Empresa");

        placaTxt.setEditable(false);
        placaTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        placaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        placaTxt.setFocusable(false);
        placaTxt.setRequestFocusEnabled(false);

        vigilanteTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        vigilanteTxt.setNextFocusableComponent(jButton1);

        dataTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        dataTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dataTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dataTxtKeyReleased(evt);
            }
        });

        tblVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblVeiculo);

        tblMotorista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tblMotorista);

        tblEntrada.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        tblEntrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblEntrada);

        jButton1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jButton1.setText("Lançar Entrada");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/transportadora.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(dataTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(entradaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(placaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(codigo1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(empresaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(obsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(vigilanteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(116, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(entradaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(placaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(codigo1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(empresaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vigilanteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(29, 29, 29))
                    .addComponent(obsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(186, 186, 186)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(302, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void codigo1TxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigo1TxtKeyReleased
        // TODO add your handling code here:
        try {
            if(Integer.parseInt(codigo1Txt.getText()) > 0) {
                nomeMotorista(Integer.parseInt(codigo1Txt.getText()));
            }
        }catch(Exception e) {

        }
    }//GEN-LAST:event_codigo1TxtKeyReleased

    private void codigoTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTxtKeyReleased
        // TODO add your handling code here:
        try {
            if(Integer.parseInt(codigoTxt.getText()) > 0) {
                nomePlaca(Integer.parseInt(codigoTxt.getText()));
            }
        }catch(Exception e) {

        }
    }//GEN-LAST:event_codigoTxtKeyReleased

    private void dataTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataTxtKeyReleased
        // TODO add your handling code here:
       preencherTabela();
    }//GEN-LAST:event_dataTxtKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        inserir();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigo1Txt;
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JTextField dataTxt;
    private javax.swing.JTextField empresaTxt;
    private javax.swing.JTextField entradaTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField nomeTxt;
    private javax.swing.JTextField obsTxt;
    private javax.swing.JTextField placaTxt;
    private javax.swing.JTable tblEntrada;
    private javax.swing.JTable tblMotorista;
    private javax.swing.JTable tblVeiculo;
    private javax.swing.JTextField vigilanteTxt;
    // End of variables declaration//GEN-END:variables
}

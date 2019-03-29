/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.principal;


import com.bean.SaidaPe;
import com.bean.SaidaVe;

import com.bean.Transportadora;
import com.dao.SaidaPeDAO;
import com.dao.SaidaVeDAO;
import com.dao.TransportadoraDAO;
import com.utils.DataHora;
import com.utils.Tabela;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author thiago.napoleao
 */
public class SaidaTransportadora extends javax.swing.JPanel {

    /**
     * Creates new form Transportadora
     */
    public SaidaTransportadora() {
        initComponents();
        defaults();
        preencherTabela();
       
        
    }

    public void defaults(){
        
    idTxt.requestFocus(true);
    
    DataHora data = new DataHora();
    dataTxt.setText(data.Data());       
     DataHora hora = new DataHora();
     saidaTxt.setText(hora.Hora());
      preencherTabela();
      preencherTabela1();  
    }
    
   
   public void inserir() {
       
        SaidaVe saida = new SaidaVe();
        
        saida.setId(Integer.parseInt(idTxt.getText()));
        saida.setData(dataTxt.getText());
        saida.setSaida(saidaTxt.getText());
        saida.setPlaca(placaTxt.getText());
        saida.setObs(obsTxt.getText());
        saida.setNome(nomeTxt.getText());
        saida.setEntrada(entradaTxt.getText());
        
        SaidaVeDAO saidaDAO = new SaidaVeDAO();
        
        saidaDAO.insert(saida);
        
        JOptionPane.showMessageDialog(null, "Saida inserida com sucesso!");
        
        preencherTabela();   
        preencherTabela1();   
        limparcampos();
    }
   
        public void limparcampos() {
    
        idTxt.setText("");
        placaTxt.setText("");
        obsTxt.setText("");
        entradaTxt.setText("");
        nomeTxt.setText("");
        
        idTxt.requestFocus(true);
    }

     public void nomePlaca(int id) {
        
        Transportadora rota = null;
     
        TransportadoraDAO transportadoraDAO = new TransportadoraDAO();
        List<Transportadora> transportadoras = transportadoraDAO.findById(id);
        rota = transportadoras.get(0);
        if(rota != null) {
           placaTxt.setText(rota.getPlaca()); 
           nomeTxt.setText(rota.getNome());
           entradaTxt.setText(rota.getEntrada());
        }
    }
        
         public void preencherTabela() {
       
        
        TransportadoraDAO dao = new TransportadoraDAO();
        try {
            ArrayList dados = new ArrayList();

            String[] Colunas = new String[]{"Cod. Entrada", "Motorista", "Placa do Veiculo", "Horario de Entrada", "Empresa"};
            
            /////////////////////////////////////
             List<Transportadora> erro = dao.findByData(dataTxt.getText());

            for(int i = 0; i < erro.size(); i++) {

                dados.add(new Object[]{erro.get(i).getId(), erro.get(i).getNome(), erro.get(i).getPlaca(), erro.get(i).getEntrada(), erro.get(i).getEmpresa()});
            
            }

            Tabela tabela = new Tabela(dados, Colunas);
            tblEntrada.setModel(tabela);
            
            tblEntrada.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblEntrada.getColumnModel().getColumn(0).setResizable(false);
            
            tblEntrada.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblEntrada.getColumnModel().getColumn(1).setResizable(false);
            
            tblEntrada.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblEntrada.getColumnModel().getColumn(2).setResizable(false);
            
            tblEntrada.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblEntrada.getColumnModel().getColumn(3).setResizable(false);
                  
            tblEntrada.getColumnModel().getColumn(4).setPreferredWidth(120);
            tblEntrada.getColumnModel().getColumn(4).setResizable(false);
           
            tblEntrada.getTableHeader().setReorderingAllowed(false);
            tblEntrada.setAutoResizeMode(tblEntrada.AUTO_RESIZE_OFF);
            tblEntrada.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        }catch(Exception ex) {
            ex.printStackTrace();
        } 
    } 
        
      public void preencherTabela1() {
       
        
        SaidaVeDAO dao = new SaidaVeDAO();
        try {
            ArrayList dados = new ArrayList();

            String[] Colunas = new String[]{"Motorista", "Placa do Veiculo", "Horario de Entrada", "Horario de Saida"};
            
            /////////////////////////////////////
             List<SaidaVe> saida = dao.findByData(dataTxt.getText());

            for(int z = 0; z < saida.size(); z++) {

                dados.add(new Object[]{saida.get(z).getNome(), saida.get(z).getPlaca(), saida.get(z).getEntrada(), saida.get(z).getSaida()});
            
            }

            Tabela tabela = new Tabela(dados, Colunas);
            tblSaida.setModel(tabela);
            
            tblSaida.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblSaida.getColumnModel().getColumn(0).setResizable(false);
            
            tblSaida.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblSaida.getColumnModel().getColumn(1).setResizable(false);
            
            tblSaida.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblSaida.getColumnModel().getColumn(2).setResizable(false);
            
            tblSaida.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblSaida.getColumnModel().getColumn(3).setResizable(false);
                  
                       
            tblSaida.getTableHeader().setReorderingAllowed(false);
            tblSaida.setAutoResizeMode(tblSaida.AUTO_RESIZE_OFF);
            tblSaida.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        }catch(Exception ex) {
            ex.printStackTrace();
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

        jLabel5 = new javax.swing.JLabel();
        dataTxt = new javax.swing.JTextField();
        saidaTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        obsTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nomeTxt = new javax.swing.JTextField();
        placaTxt = new javax.swing.JTextField();
        idTxt = new javax.swing.JTextField();
        entradaTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEntrada = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSaida = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/MedSantaCruz1.png"))); // NOI18N

        dataTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        dataTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        saidaTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        saidaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setText("Placa do veiculo");

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel7.setText("Obs");

        obsTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setText("Horario de Saida");

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel1.setText("Data");

        jButton1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jButton1.setText("Lançar Saida");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel6.setText("Nome do Motorista");

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel8.setText("Cod. de Entrada");

        nomeTxt.setEditable(false);
        nomeTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        nomeTxt.setFocusable(false);
        nomeTxt.setRequestFocusEnabled(false);

        placaTxt.setEditable(false);
        placaTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        placaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        placaTxt.setFocusable(false);
        placaTxt.setRequestFocusEnabled(false);

        idTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        idTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idTxtKeyReleased(evt);
            }
        });

        entradaTxt.setEditable(false);
        entradaTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        entradaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        entradaTxt.setFocusable(false);
        entradaTxt.setRequestFocusEnabled(false);

        jLabel9.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel9.setText("Horario de Entrada");

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

        tblSaida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblSaida);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/saida Transportadora.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(dataTxt)
                                            .addComponent(placaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel9)
                                                    .addComponent(entradaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(nomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jButton1))
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(jLabel4)
                                                        .addGap(21, 21, 21)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(saidaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(23, 23, 23)
                                                        .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(23, 23, 23)
                                                        .addComponent(obsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(31, 31, 31)
                                                        .addComponent(jLabel7))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel1)))))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(obsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saidaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(placaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(entradaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        inserir();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void idTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idTxtKeyReleased
        // TODO add your handling code here:
        try {
            if(Integer.parseInt(idTxt.getText()) > 0) {
                nomePlaca(Integer.parseInt(idTxt.getText()));
            }
        }catch(Exception e) {

        }
    }//GEN-LAST:event_idTxtKeyReleased
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dataTxt;
    private javax.swing.JTextField entradaTxt;
    private javax.swing.JTextField idTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nomeTxt;
    private javax.swing.JTextField obsTxt;
    private javax.swing.JTextField placaTxt;
    private javax.swing.JTextField saidaTxt;
    private javax.swing.JTable tblEntrada;
    private javax.swing.JTable tblSaida;
    // End of variables declaration//GEN-END:variables
}

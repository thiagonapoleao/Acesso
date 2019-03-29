/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.principal;

import com.bean.Motoristat;
import com.bean.Transportadora;
import com.dao.MotoristatDAO;
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


public final class IncTransportadora extends javax.swing.JPanel {

    /**
     * Creates new form Transportadora
     */
    public IncTransportadora() {
        initComponents();
        defaults();
        preencherTabela();
    }

    public void defaults(){
    cpfTxt.requestFocus(true);
    
    DataHora data = new DataHora();
    dataTxt.setText(data.Data());       
     DataHora hora = new DataHora();
     entradaTxt.setText(hora.Hora());
       
    }
    
     
    
    
   public void inserir() {
        Transportadora transportadora = new Transportadora();
        
        transportadora.setData(dataTxt.getText());
        transportadora.setNome(nomeTxt.getText());
        transportadora.setCpf(cpfTxt.getText());
        transportadora.setNome1(nome1Txt.getText());
        transportadora.setCpf1(cpf1Txt.getText());
        transportadora.setPlaca(placaTxt.getText());
        transportadora.setEntrada(entradaTxt.getText());
        transportadora.setObs(obsTxt.getText());
        transportadora.setEmpresa(empresaTxt.getText());
        transportadora.setVigilante(vigilanteTxt.getText());
        
        TransportadoraDAO transportadoraDAO = new TransportadoraDAO();
        
        transportadoraDAO.insert(transportadora);
        
        JOptionPane.showMessageDialog(null, "Transportadora inserido com sucesso!");
        
        preencherTabela();
                
        limparcampos();
    }
   
   
   public void preencherTabela() {
       
        
        TransportadoraDAO dao = new TransportadoraDAO();
        try {
            ArrayList dados = new ArrayList();

            String[] Colunas = new String[]{"Cod Entrada", "Motorista", "Ajudante", "Placa do Veiculo", "Horario de Entrada", "Empresa"};
            
            /////////////////////////////////////
             List<Transportadora> erro = dao.findByData(dataTxt.getText());

            for(int i = 0; i < erro.size(); i++) {

                dados.add(new Object[]{erro.get(i).getId(),erro.get(i).getNome(), erro.get(i).getNome1(), erro.get(i).getPlaca(), erro.get(i).getEntrada(), erro.get(i).getEmpresa()});
            
            }

            Tabela tabela = new Tabela(dados, Colunas);
            tblTrans.setModel(tabela);
            
            tblTrans.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblTrans.getColumnModel().getColumn(0).setResizable(false);
            
            tblTrans.getColumnModel().getColumn(1).setPreferredWidth(220);
            tblTrans.getColumnModel().getColumn(1).setResizable(false);
            
            tblTrans.getColumnModel().getColumn(2).setPreferredWidth(220);
            tblTrans.getColumnModel().getColumn(2).setResizable(false);
            
            tblTrans.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblTrans.getColumnModel().getColumn(3).setResizable(false);
                  
            tblTrans.getColumnModel().getColumn(4).setPreferredWidth(120);
            tblTrans.getColumnModel().getColumn(4).setResizable(false);
            
            tblTrans.getColumnModel().getColumn(5).setPreferredWidth(220);
            tblTrans.getColumnModel().getColumn(5).setResizable(false);
           
            tblTrans.getTableHeader().setReorderingAllowed(false);
            tblTrans.setAutoResizeMode(tblTrans.AUTO_RESIZE_OFF);
            tblTrans.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        }catch(Exception ex) {
            ex.printStackTrace();
        } 
    } 
     
     
     public void nomeMotorista(String cpf) {
        
        Motoristat motoristat = null;
     
        MotoristatDAO motoristatDAO = new MotoristatDAO();
        List<Motoristat> motoristas = motoristatDAO.findByCpf(cpf);
        motoristat = motoristas.get(0);
        if(motoristat != null) {
            nomeTxt.setText(motoristat.getNome()); 
       }
     }
     
    public void limparcampos(){
       
        nomeTxt.setText("");
        nome1Txt.setText("");
        placaTxt.setText("");
        entradaTxt.setText("");
        cpfTxt.setText("");
        cpf1Txt.setText("");
        obsTxt.setText("");
        empresaTxt.setText("");
        vigilanteTxt.setText("");
        
        cpfTxt.requestFocus(true);   
        
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
        jLabel7 = new javax.swing.JLabel();
        nome1Txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        obsTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        dataTxt = new javax.swing.JTextField();
        cpf1Txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cpfTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        vigilanteTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        placaTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        empresaTxt = new javax.swing.JTextField();
        entradaTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTrans = new javax.swing.JTable();
        nomeTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jButton1.setText("Lançar Entrada ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel7.setText("Obs");

        nome1Txt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        nome1Txt.setNextFocusableComponent(placaTxt);

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setText("Entrada");

        jLabel10.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel10.setText("Nome ajudante");

        obsTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        obsTxt.setNextFocusableComponent(vigilanteTxt);

        jLabel11.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel11.setText("CPF Ajudante");

        dataTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        dataTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        cpf1Txt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        cpf1Txt.setNextFocusableComponent(nome1Txt);

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel5.setText("CPF Motorista");

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel8.setText("Vigilante");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/transportadora.png"))); // NOI18N

        cpfTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        cpfTxt.setNextFocusableComponent(cpf1Txt);
        cpfTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cpfTxtKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel1.setText("Data");

        vigilanteTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        vigilanteTxt.setNextFocusableComponent(jButton1);

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel6.setText("Empresa");

        placaTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        placaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        placaTxt.setNextFocusableComponent(empresaTxt);

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel2.setText("Nome Motorista");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/MedSantaCruz1.png"))); // NOI18N

        empresaTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        empresaTxt.setNextFocusableComponent(obsTxt);

        entradaTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        entradaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setText("Placa ");

        tblTrans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblTrans);

        nomeTxt.setEditable(false);
        nomeTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        nomeTxt.setFocusable(false);
        nomeTxt.setRequestFocusEnabled(false);

        jLabel13.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 51));
        jLabel13.setText("( Apenas Numeros )");

        jLabel14.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 0, 51));
        jLabel14.setText("( Apenas Numeros )");

        jLabel15.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 51));
        jLabel15.setText("( ex. CZB1234 )");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(dataTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(entradaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13))
                            .addComponent(cpfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(nomeTxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14))
                            .addComponent(cpf1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(nome1Txt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15))
                            .addComponent(placaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(125, 125, 125))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(empresaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(obsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(vigilanteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 59, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(5, 5, 5)
                                .addComponent(dataTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(entradaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpf1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nome1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(placaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(empresaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(obsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vigilanteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        inserir();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cpfTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpfTxtKeyReleased
        // TODO add your handling code here: 
        
         if(cpfTxt.getText().length() == 11) {
            try {
                if(Long.parseLong(cpfTxt.getText()) > 0) {
                    nomeMotorista(cpfTxt.getText());
                } 
            }catch(Exception e) {
                e.printStackTrace();
             
            }
          }
    }//GEN-LAST:event_cpfTxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpf1Txt;
    private javax.swing.JTextField cpfTxt;
    private javax.swing.JTextField dataTxt;
    private javax.swing.JTextField empresaTxt;
    private javax.swing.JTextField entradaTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nome1Txt;
    private javax.swing.JTextField nomeTxt;
    private javax.swing.JTextField obsTxt;
    private javax.swing.JTextField placaTxt;
    private javax.swing.JTable tblTrans;
    private javax.swing.JTextField vigilanteTxt;
    // End of variables declaration//GEN-END:variables

    
}

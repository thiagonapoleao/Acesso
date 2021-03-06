/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.principal;

import com.bean.Motorista;
import com.dao.MotoristaDAO;
import com.utils.Tabela;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author thiago.napoleao
 */
public final class NovoMotorista extends javax.swing.JPanel {

    /**
     * Creates new form NovoMotorista
     */
    
    public NovoMotorista() {//metodo construtor , todo metodo com nome idendico da classe é o metodo que é iniciado ao fazer uma nova instancia da classe
        initComponents();
        defaults();//este metodo serve apenas para organizar tudo oque será iniciado com o frame
        //não inicie nada antes de initComponents() pois senão demorará para iniciar a aplicação , isto acontece porque ele processará os comandos antes dos componentes gráficos
    }

    public void defaults (){//este metodo é inciado junto com o inicio do frame , tudo que estiver aqui iniciará automaticamente
        codigoTxt.requestFocus(true);
        preencherTabela();//preenchendo a tabela ao iniciar o frame
    }
    
     public void inserir(){
     Motorista mot = new Motorista();
     
     mot.setCodigo(Integer.parseInt(codigoTxt.getText()));
     mot.setMoto(motoTxt.getText());
     mot.setCpf(cpfTxt.getText());
     mot.setEmpresa(empresaTxt.getText());
     
     MotoristaDAO motoristaDAO = new MotoristaDAO();
     motoristaDAO.insert(mot);
     
     
     JOptionPane.showMessageDialog(null, "Motorista inserido com sucesso!");
             
     preencherTabela();
     
     limparCampos();
          
     }       
   
     
      public void preencherTabela() {//para iniciar junto com o frame é só fazer a chamada deste metodo dentro do metodo construtor ou no metodo defaults()
       
        
        MotoristaDAO dao = new MotoristaDAO();
        try {
            
            ArrayList dados = new ArrayList();

            String[] Colunas = new String[]{"Codigo do Motorista", "Nome", "Cpf", "Empresa"};
            
            /////////////////////////////////////
                  
             List<Motorista> mot = dao.findAll();// o objeto mot rececebe todos os registros do metodo findAll da classe MotoristaDAO
           
         
    
            for(int i = 0; i < mot.size(); i++) {

                dados.add(new Object[]{mot.get(i).getCodigo(), mot.get(i).getMoto(), mot.get(i).getCpf(), mot.get(i).getEmpresa()});
            
            }

            Tabela tabela = new Tabela(dados, Colunas);
            tblMotorista.setModel(tabela);
            
            tblMotorista.getColumnModel().getColumn(0).setPreferredWidth(120);
            tblMotorista.getColumnModel().getColumn(0).setResizable(false);
            
            tblMotorista.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblMotorista.getColumnModel().getColumn(1).setResizable(false);
            
            tblMotorista.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblMotorista.getColumnModel().getColumn(2).setResizable(false);
            
            tblMotorista.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblMotorista.getColumnModel().getColumn(3).setResizable(false);
                  
           
            tblMotorista.getTableHeader().setReorderingAllowed(false);
            tblMotorista.setAutoResizeMode(tblMotorista.AUTO_RESIZE_OFF);
            tblMotorista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        }catch(Exception ex) {
            ex.printStackTrace();
        } 
    } 
          
     
     public void LimparCampos(){
         
         codigoTxt.setText("");
         motoTxt.setText("");
         cpfTxt.setText("");
         empresaTxt.setText("");
         
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        codigoTxt = new javax.swing.JTextField();
        motoTxt = new javax.swing.JTextField();
        cpfTxt = new javax.swing.JTextField();
        empresaTxt = new javax.swing.JTextField();
        lblSalvar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMotorista = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel1.setText("Codigo");

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setText("CPF");

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setText("Empresa");

        codigoTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        codigoTxt.setNextFocusableComponent(motoTxt);

        motoTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        motoTxt.setNextFocusableComponent(cpfTxt);

        cpfTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        cpfTxt.setNextFocusableComponent(empresaTxt);

        empresaTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        empresaTxt.setNextFocusableComponent(lblSalvar);

        lblSalvar.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblSalvar.setText("Salvar");
        lblSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSalvarActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/MedSantaCruz1.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/cadstro de motorista.png"))); // NOI18N

        tblMotorista.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
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
        jScrollPane1.setViewportView(tblMotorista);

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 51));
        jLabel7.setText("( Completo )");

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 51));
        jLabel8.setText("( Apenas Numeros )");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(empresaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel7))
                            .addComponent(jLabel8)))
                    .addComponent(motoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(motoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(empresaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(lblSalvar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSalvarActionPerformed
        // TODO add your handling code here:
        inserir();
        
    }//GEN-LAST:event_lblSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JTextField cpfTxt;
    private javax.swing.JTextField empresaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lblSalvar;
    private javax.swing.JTextField motoTxt;
    private javax.swing.JTable tblMotorista;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

  
}

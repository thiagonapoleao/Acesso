/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.principal;
import com.bean.Motorista;
import com.bean.Rota;
import com.bean.SaidaRota;
import com.bean.Veiculo;
import com.dao.MotoristaDAO;
import com.dao.RotaDAO;
import com.dao.SaidaRotaDAO;
import com.dao.VeiculoDAO;
import com.utils.DataHora;
import java.util.List;
import javax.swing.ListSelectionModel;
import com.utils.Tabela;
import java.util.ArrayList;



/**
 *
 * @author thiago.napoleao
 * 
 */

public final class Saida extends javax.swing.JPanel {
    DataHora dataHora;
    
    
    
    /**
     * Creates new form Saida
     */
    public Saida() {
        initComponents();
        defaults();
        preencherTabela();
        
    }
 public void defaults() {
        codigoTxt.requestFocus(true);
        hora();
        preencherTabela2();
        preencherTabela3();
         preencherTabela4();
    }
        
    public void inserirSaida() {
        dataHora = new DataHora();
        
        SaidaRota erro = new SaidaRota();
        
        
        erro.setData(dataTxt.getText());
        erro.setDestino(destinoTxt.getText());
        erro.setSaida(saidaTxt.getText());
        erro.setMeta(metaTxt.getText());
        erro.setRt(rtTxt.getText());
        erro.setMoto(motoTxt.getText());
        erro.setPlaca(placaTxt.getText());
        
        
        SaidaRotaDAO erroDAO = new SaidaRotaDAO();
        
        // linha que realiza a persistencia no banco(salvar)
        erroDAO.insert(erro);
        
        preencherTabela();
        
        zeraCampos();
       
        
        
    }
    
    public void preencherTabela() {
       
        
        SaidaRotaDAO dao = new SaidaRotaDAO();
        try {
            ArrayList dados = new ArrayList();

            String[] Colunas = new String[]{"Rota", "Destino", "Saida", "Meta Saida"};
            
            /////////////////////////////////////
            
            
            
            // erro ao pegar a data   (nao existe o campo)
            List<SaidaRota> erro = dao.findByData(dataTxt.getText());
            
            

            for(int i = 0; i < erro.size(); i++) {

                dados.add(new Object[]{erro.get(i).getRt(), erro.get(i).getDestino(), erro.get(i).getSaida(), erro.get(i).getMeta()});
            
            }

            Tabela tabela = new Tabela(dados, Colunas);
            tblSaidas.setModel(tabela);
            
            tblSaidas.getColumnModel().getColumn(0).setPreferredWidth(120);
            tblSaidas.getColumnModel().getColumn(0).setResizable(false);
            
            tblSaidas.getColumnModel().getColumn(1).setPreferredWidth(310);
            tblSaidas.getColumnModel().getColumn(1).setResizable(false);
            
            tblSaidas.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblSaidas.getColumnModel().getColumn(2).setResizable(false);
            
             tblSaidas.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblSaidas.getColumnModel().getColumn(2).setResizable(false);
            
           
            tblSaidas.getTableHeader().setReorderingAllowed(false);
            tblSaidas.setAutoResizeMode(tblSaidas.AUTO_RESIZE_OFF);
            tblSaidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        }catch(Exception ex) {
            ex.printStackTrace();
        } 
    } 
    
    
    
      public void preencherTabela2() {
       
        
        RotaDAO dao = new RotaDAO();
        try {
            ArrayList dados = new ArrayList();

            String[] Colunas = new String[]{"Cod", "Rota"};
            
            /////////////////////////////////////
                      
            List<Rota> rota = dao.findAll();
            
            

            for(int i = 0; i < rota.size(); i++) {

                dados.add(new Object[]{rota.get(i).getCodigo(), rota.get(i).getRt()});
            
            }

            Tabela tabela = new Tabela(dados, Colunas);
            tblCodRt.setModel(tabela);
            
            tblCodRt.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblCodRt.getColumnModel().getColumn(0).setResizable(false);
            
            tblCodRt.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblCodRt.getColumnModel().getColumn(1).setResizable(false);
            
                    
           tblCodRt.getTableHeader().setReorderingAllowed(false);
           tblCodRt.setAutoResizeMode(tblCodRt.AUTO_RESIZE_OFF);
           tblCodRt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        }catch(Exception ex) {
            ex.printStackTrace();
        } 
    } 
    
     public void preencherTabela3() {
       
        
        VeiculoDAO dao = new VeiculoDAO();
        try {
            ArrayList dados = new ArrayList();

            String[] Colunas = new String[]{"Cod", "Veiculo"};
            
            /////////////////////////////////////
                      
            List<Veiculo> veic = dao.findAll();
            
            

            for(int i = 0; i < veic.size(); i++) {

                dados.add(new Object[]{veic.get(i).getCodigo(), veic.get(i).getPlaca()});
            
            }

            Tabela tabela = new Tabela(dados, Colunas);
            tblVeiculo.setModel(tabela);
            
            tblVeiculo.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblVeiculo.getColumnModel().getColumn(0).setResizable(false);
            
            tblVeiculo.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblVeiculo.getColumnModel().getColumn(1).setResizable(false);
            
                    
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

            String[] Colunas = new String[]{"Cod", "Motorista"};
            
            /////////////////////////////////////
                      
            List<Motorista> mot = dao.findAll();
            
            

            for(int i = 0; i < mot.size(); i++) {

                dados.add(new Object[]{mot.get(i).getCodigo(), mot.get(i).getMoto()});
            
            }

            Tabela tabela = new Tabela(dados, Colunas);
            tblMotorista.setModel(tabela);
            
           tblMotorista.getColumnModel().getColumn(0).setPreferredWidth(50);
           tblMotorista.getColumnModel().getColumn(0).setResizable(false);
            
           tblMotorista.getColumnModel().getColumn(1).setPreferredWidth(150);
           tblMotorista.getColumnModel().getColumn(1).setResizable(false);
            
                    
           tblMotorista.getTableHeader().setReorderingAllowed(false);
           tblMotorista.setAutoResizeMode(tblMotorista.AUTO_RESIZE_OFF);
           tblMotorista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        }catch(Exception ex) {
            ex.printStackTrace();
        } 
    } 
    
    
     public void hora(){
         
         
        new Thread() {
            @Override
            public void run() {
                while (true){
             DataHora hora = new DataHora();
                    horaTxt.setText(hora.Hora());
                }
            }
        }.start(); 
         
     }
     
    public void destinoRota(int codigo) {
        
        Rota rota = null;
     
        RotaDAO rotaDAO = new RotaDAO();
        List<Rota> rotas = rotaDAO.findByCodigo(codigo);
        rota = rotas.get(0);
        if(rota != null) {
            destinoTxt.setText(rota.getDestino()); 
            metaTxt.setText(rota.getMeta());
            rtTxt.setText(rota.getRt());
       }
        }
    
    public void nomePlaca(int codigo) {
        
        Veiculo rota = null;
     
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        List<Veiculo> veiculos = veiculoDAO.findByCodigo(codigo);
        rota = veiculos.get(0);
        if(rota != null) {
           placaTxt.setText(rota.getPlaca()); 
            
        }
    }
    
    public void nomeMotorista(int codigo) {
        
        Motorista rota = null;
     
        MotoristaDAO motoristaDAO = new MotoristaDAO();
        List<Motorista> motoristas = motoristaDAO.findByCodigo(codigo);
        rota = motoristas.get(0);
        if(rota != null) {
           motoTxt.setText(rota.getMoto());
           
            
        }
    }
      
    
      public void zeraCampos() {
        
        codigoTxt.setText("");
        codigo2Txt.setText("");
        codigo3Txt.setText("");
        destinoTxt.setText("");
        saidaTxt.setText("");
        metaTxt.setText("");
        placaTxt.setText("");
        motoTxt.setText("");
        rtTxt.setText("");
        
        
        codigoTxt.requestFocus(true);
    }
      
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        destinoTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dataTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSaidas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        saidaTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        metaTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        codigoTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        codigo2Txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        codigo3Txt = new javax.swing.JTextField();
        placaTxt = new javax.swing.JTextField();
        motoTxt = new javax.swing.JTextField();
        rtTxt = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCodRt = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblVeiculo = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMotorista = new javax.swing.JTable();
        horaTxt = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        destinoTxt.setEditable(false);
        destinoTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        destinoTxt.setFocusable(false);
        destinoTxt.setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel1.setText("Data");

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel6.setText("Destino");

        dataTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        dataTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dataTxt.setNextFocusableComponent(codigoTxt);
        dataTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dataTxtKeyReleased(evt);
            }
        });

        tblSaidas.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        tblSaidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblSaidas);

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setText("Horario de Saida");

        saidaTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        saidaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        saidaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                saidaTxtKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel7.setText("Meta");

        metaTxt.setEditable(false);
        metaTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        metaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        metaTxt.setFocusable(false);
        metaTxt.setRequestFocusEnabled(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/MedSantaCruz1.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 36)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/Saida.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel8.setText("Codigo da Rota");

        codigoTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        codigoTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codigoTxt.setNextFocusableComponent(codigo2Txt);
        codigoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigoTxtKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel9.setText("Codigo do Veiculo");

        codigo2Txt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        codigo2Txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codigo2Txt.setNextFocusableComponent(codigo3Txt);
        codigo2Txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigo2TxtKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel10.setText("Codigo do Motorista");

        codigo3Txt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        codigo3Txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codigo3Txt.setNextFocusableComponent(saidaTxt);
        codigo3Txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigo3TxtKeyReleased(evt);
            }
        });

        placaTxt.setEditable(false);
        placaTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        placaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        placaTxt.setFocusable(false);
        placaTxt.setRequestFocusEnabled(false);

        motoTxt.setEditable(false);
        motoTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        motoTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        motoTxt.setFocusable(false);
        motoTxt.setRequestFocusEnabled(false);

        rtTxt.setEditable(false);
        rtTxt.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        rtTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rtTxt.setFocusable(false);
        rtTxt.setRequestFocusEnabled(false);

        tblCodRt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblCodRt);

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

        horaTxt.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 51));
        jLabel11.setText("( Data do Faturamento )");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(destinoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(metaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codigo2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(placaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addComponent(jLabel4)
                            .addComponent(saidaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codigo3Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(motoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(dataTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(horaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rtTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rtTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigo2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(placaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigo3Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(motoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saidaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(destinoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(metaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 27, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents
  
    private void saidaTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saidaTxtKeyReleased
        // TODO add your handling code here:
        
        if(evt.getKeyCode() == 10) {
            inserirSaida();
        
    }//GEN-LAST:event_saidaTxtKeyReleased
    }
        
    private void codigoTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTxtKeyReleased
        // TODO add your handling code here:
         try {
            if(Integer.parseInt(codigoTxt.getText()) > 0) {
                destinoRota(Integer.parseInt(codigoTxt.getText()));
            }
        }catch(Exception e) {
            
        }
    }//GEN-LAST:event_codigoTxtKeyReleased

    private void codigo2TxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigo2TxtKeyReleased
        // TODO add your handling code here:
        try {
            if(Integer.parseInt(codigo2Txt.getText()) > 0) {
                nomePlaca(Integer.parseInt(codigo2Txt.getText()));
            }
        }catch(Exception e) {
            
        }
    }//GEN-LAST:event_codigo2TxtKeyReleased

    private void codigo3TxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigo3TxtKeyReleased
        // TODO add your handling code here:
         try {
            if(Integer.parseInt(codigo3Txt.getText()) > 0) {
                nomeMotorista(Integer.parseInt(codigo3Txt.getText()));
            }
        }catch(Exception e) {
            
        }
    }//GEN-LAST:event_codigo3TxtKeyReleased

    private void dataTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataTxtKeyReleased
        // TODO add your handling code here:
        preencherTabela();
        
        
    }//GEN-LAST:event_dataTxtKeyReleased

           
        
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigo2Txt;
    private javax.swing.JTextField codigo3Txt;
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JTextField dataTxt;
    private javax.swing.JTextField destinoTxt;
    private javax.swing.JLabel horaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField metaTxt;
    private javax.swing.JTextField motoTxt;
    private javax.swing.JTextField placaTxt;
    private javax.swing.JTextField rtTxt;
    private javax.swing.JTextField saidaTxt;
    private javax.swing.JTable tblCodRt;
    private javax.swing.JTable tblMotorista;
    private javax.swing.JTable tblSaidas;
    private javax.swing.JTable tblVeiculo;
    // End of variables declaration//GEN-END:variables


}


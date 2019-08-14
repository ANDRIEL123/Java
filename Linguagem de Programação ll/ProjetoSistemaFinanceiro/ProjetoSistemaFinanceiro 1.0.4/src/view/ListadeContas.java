package view;

import Model.Competencia;
import Model.Contas;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelDAO.CompetenciaDAO;
import modelDAO.ContasDAO;

public class ListadeContas extends javax.swing.JFrame {
    Contas C = new Contas();
    ContasDAO CDAO = new ContasDAO();
    Competencia comp = new Competencia();
    Competencia competencia = new Competencia();
    CompetenciaDAO CompDAO = new CompetenciaDAO();
    public ListadeContas() throws SQLException {
        initComponents();
        iniciarComponentes();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    
    public void iniciarComponentes() throws SQLException{
        T_Gastos.setEnabled(false);
        FMT_CompetenciaLista.setEnabled(false);
        calculaGastosCompetencia();
        CDAO.trazDadosDoBancoParaoSistemaContas(C.ListaContas);
        loadTableCadastro();
    }
    
    public void setCompetenciaInicial(String competencia){
        FMT_CompetenciaLista.setText(competencia);
    }
    
    
    
    public void calculaGastosCompetencia(){
        double gastos = 0;
        for(int i = 0; i < C.ListaContas.size(); i++){
            gastos += C.ListaContas.get(i).getValor();
        }
       DecimalFormat df = new DecimalFormat("0.##");
       String s = df.format(gastos);
       
       T_Gastos.setText(s);
    }
    
    public void loadTableCadastro(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Descrição", "Valor", "Situação", "Data/Hora"}, 0);
        
        for(int i = 0; i < C.ListaContas.size(); i++){
        modelo.addRow(new Object[]{C.ListaContas.get(i).getDescricao(),
                                   C.ListaContas.get(i).getValor(),C.ListaContas.get(i).getPago(),
                                   C.ListaContas.get(i).getDataHora()});
        }
        jTable_Cadastro.setModel(modelo);
        jTable_Cadastro.getColumnModel().getColumn(0).setPreferredWidth(200);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        C_Competencia = new javax.swing.JLabel();
        FMT_CompetenciaLista = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        TITLE_Cadastrar = new javax.swing.JLabel();
        C_DescricaoCadastro = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        T_Descricao = new javax.swing.JTextField();
        C_Valor = new javax.swing.JLabel();
        T_Valor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Cadastro = new javax.swing.JTable();
        BTN_Cadastrar = new javax.swing.JButton();
        C_Saldo = new javax.swing.JLabel();
        T_Saldo = new javax.swing.JTextField();
        C_Gastos = new javax.swing.JLabel();
        T_Gastos = new javax.swing.JTextField();
        BTN_Salvar = new javax.swing.JButton();
        C_Pago = new javax.swing.JLabel();
        JComboBox_Pago = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        C_Competencia.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        C_Competencia.setText("Competência:");

        try {
            FMT_CompetenciaLista.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        TITLE_Cadastrar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TITLE_Cadastrar.setText("Cadastrar conta");

        C_DescricaoCadastro.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        C_DescricaoCadastro.setText("Descrição:");

        C_Valor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        C_Valor.setText("Valor:");

        jTable_Cadastro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Valor", "Situação", "Data/Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_Cadastro);
        if (jTable_Cadastro.getColumnModel().getColumnCount() > 0) {
            jTable_Cadastro.getColumnModel().getColumn(0).setPreferredWidth(200);
        }

        BTN_Cadastrar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BTN_Cadastrar.setText("Cadastrar");
        BTN_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CadastrarActionPerformed(evt);
            }
        });

        C_Saldo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        C_Saldo.setText("Saldo:");

        C_Gastos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        C_Gastos.setText("Gastos:");

        BTN_Salvar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BTN_Salvar.setText("Salvar competência");
        BTN_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SalvarActionPerformed(evt);
            }
        });

        C_Pago.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        C_Pago.setText("Pago:");

        JComboBox_Pago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione>", "Pago", "Não pago" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(C_Competencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FMT_CompetenciaLista, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(C_Saldo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(T_Saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addComponent(C_Gastos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(T_Gastos, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(270, 270, 270)
                                .addComponent(TITLE_Cadastrar))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(C_DescricaoCadastro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(T_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(C_Valor))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(BTN_Cadastrar)
                                        .addGap(17, 17, 17)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(T_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(C_Pago)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JComboBox_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(BTN_Salvar)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C_Competencia)
                    .addComponent(FMT_CompetenciaLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C_Saldo)
                    .addComponent(T_Saldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C_Gastos)
                    .addComponent(T_Gastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TITLE_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C_DescricaoCadastro)
                    .addComponent(T_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C_Valor)
                    .addComponent(T_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C_Pago)
                    .addComponent(JComboBox_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_Cadastrar)
                    .addComponent(BTN_Salvar))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(349, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void BTN_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CadastrarActionPerformed
        if(!JComboBox_Pago.getSelectedItem().equals("<Selecione>") && !T_Descricao.equals("") && !T_Valor.equals("")){
            
            Contas C1 = new Contas(T_Descricao.getText(), Float.parseFloat(T_Valor.getText()),
                            C.getDataHora(), FMT_CompetenciaLista.getText(), (String) JComboBox_Pago.getSelectedItem());
               C.ListaContas.add(C1);
               try {
                CDAO.saveConta(C1);
            } catch (SQLException ex) {
                System.err.println("Erro ao incluir: " + ex);
            }
               JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
        }
        if(JComboBox_Pago.getSelectedItem().equals("<Selecione>")){
            JOptionPane.showMessageDialog(null,"Favor selecionar um valor válido para o campo 'Pago'");
        }
        if(T_Descricao.equals("")){
            JOptionPane.showMessageDialog(null,"Digite um valor para o campo Descricao!");
        }
        if(T_Valor.equals("")){
            JOptionPane.showMessageDialog(null,"Digite um valor para o campo valor!");
        }
        
        loadTableCadastro();
        calculaGastosCompetencia();
        T_Descricao.setText("");
        T_Valor.setText("");
    }//GEN-LAST:event_BTN_CadastrarActionPerformed
    
    public void verificaCompetencia(){
        String auxiliar = FMT_CompetenciaLista.getText();
        for(int i = 0; i < competencia.ListaCompetencia.size(); i++){
            if(competencia.ListaCompetencia.get(i).getData().equals(auxiliar)){
                C.setCadastrado(true);
                competencia.setData(FMT_CompetenciaLista.getText());
                competencia.setGastos(Float.parseFloat(T_Gastos.getText()));
                competencia.setSaldo(Float.parseFloat(T_Saldo.getText()));
                try {
                    CompDAO.atualizaCompetencia(competencia);
                } catch (SQLException ex) {
                    System.err.println("Erro de atualização: " + ex);
                }
                JOptionPane.showMessageDialog(null,"Dados atualizados com sucesso!");
            }else{
                C.setCadastrado(false);
            }
               
        }
    }
    
    
    private void BTN_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SalvarActionPerformed
        verificaCompetencia();
        if(C.getCadastrado() == false){
                comp = new Competencia(FMT_CompetenciaLista.getText(),
                       Float.parseFloat(T_Gastos.getText()), Float.parseFloat(T_Saldo.getText()));
        
                    competencia.ListaCompetencia.add(comp);
                try {
                    CompDAO.saveCompetencia(comp);
                } catch (SQLException ex) {
                System.err.println("Erro de inclusão: " + ex);
            }
        JOptionPane.showMessageDialog(null,"Competência incluida com sucesso!");
        }
    }//GEN-LAST:event_BTN_SalvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListadeContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadeContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadeContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadeContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ListadeContas().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ListadeContas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cadastrar;
    private javax.swing.JButton BTN_Salvar;
    private javax.swing.JLabel C_Competencia;
    private javax.swing.JLabel C_DescricaoCadastro;
    private javax.swing.JLabel C_Gastos;
    private javax.swing.JLabel C_Pago;
    private javax.swing.JLabel C_Saldo;
    private javax.swing.JLabel C_Valor;
    private javax.swing.JFormattedTextField FMT_CompetenciaLista;
    private javax.swing.JComboBox<String> JComboBox_Pago;
    private javax.swing.JLabel TITLE_Cadastrar;
    private javax.swing.JTextField T_Descricao;
    private javax.swing.JTextField T_Gastos;
    private javax.swing.JTextField T_Saldo;
    private javax.swing.JTextField T_Valor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable_Cadastro;
    // End of variables declaration//GEN-END:variables
}

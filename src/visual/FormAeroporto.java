package visual;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import  java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import modelo.Aeroporto;
import modelo.DAOAeroporto;

public class FormAeroporto extends javax.swing.JDialog {
    DAOAeroporto objDAOAeroporto = new DAOAeroporto();

    /** Creates new form FormAeroporto */
    public FormAeroporto(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
       
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("nimbusBase", new Color(64,60,68));
            UIManager.put("nimbusBlueGray", new Color(64,60,68));
            UIManager.put("control", new Color(64,60,68));
            UIManager.put("text", new Color(0, 0, 0));
            UIManager.put("nimbusSelectionBackground", new Color(104, 93, 156));
            UIManager.put("nimbusSelection", new Color(104, 93, 156));
            UIManager.put("Table.background", new Color(60, 60, 68)); // #3c3c44
            UIManager.put("Table.alternateRowColor", new Color(200, 200, 200)); // Cinza claro
            UIManager.put("Table.alternateRowColor2", new Color(2, 26, 34)); // Cinza mais escuro
            UIManager.put("TabbedPane.background", new Color(64, 60, 68)); // Cor da aba
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        initComponents();
        atualizaTabela();
        trataEdicao(false);
        formatarBotoes();
        formatarBotoesNav();
    }
    
    private void formatarBotoesNav() {
    for (Component componente : painelNavegacao.getComponents()) {
        if (componente instanceof JButton) {
            JButton botao = (JButton) componente;
            
            botao.setContentAreaFilled(false); 
            botao.setOpaque(true); 
            botao.setBackground(new Color(64,60,68));
            botao.setForeground(new Color(255, 255, 255));
            botao.setBorder(new LineBorder(new Color(7, 29 , 51)));
            Font font = new Font("Arial", Font.PLAIN, 16);
            botao.setFont(font);
            
            botao.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    botao.setBackground(new Color(83, 123, 136));
                }

                @Override
                public void mouseExited(MouseEvent evt) {
                    botao.setBackground(new Color(64,60,68));
                }
            });
        }
    }
}
    
    private void formatarBotoes() {
    for (Component componente : painelAcoes.getComponents()) {
        if (componente instanceof JButton) {
            JButton botao = (JButton) componente;
            
            botao.setContentAreaFilled(false); 
            botao.setOpaque(true); 
            botao.setBackground(new Color(2, 26, 34));
            botao.setForeground(new Color(255, 255, 255));
            botao.setBorder(new LineBorder(new Color(7, 29 , 51)));
            Font font = new Font("Arial", Font.PLAIN, 14);
            botao.setFont(font);
            
            botao.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    botao.setBackground(new Color(3, 39, 51));
                }

                @Override
                public void mouseExited(MouseEvent evt) {
                    botao.setBackground(new Color(2, 26, 34));
                }
            });
        }
    }
}
    
    public void atualizaTabela(){
        listAeroporto.clear();
        listAeroporto.addAll(objDAOAeroporto.getLista());
        int linha = listAeroporto.size()-1;
        if(linha>=0){
            tblAeroporto.setRowSelectionInterval(linha, linha);
      tblAeroporto.scrollRectToVisible(tblAeroporto.getCellRect(linha,linha,true));
        }
    }
    
    private void trataEdicao(boolean editando){
        btnCancelar.setEnabled(editando);
        btnSalvar.setEnabled(editando);
        btnEditar.setEnabled(!editando);
        int linha = listAeroporto.size()-1;
        if(linha<0){
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
            txtCodigo.setText("");
            txtNomeAeroporto.setText("");
        }else{
            btnExcluir.setEnabled(!editando);
        }
        btnNovo.setEnabled(!editando);
        btnFechar.setEnabled(!editando);
        btnPrimeiro.setEnabled(!editando);
        btnProximo.setEnabled(!editando);
        btnAnterior.setEnabled(!editando);
        btnUltimo.setEnabled(!editando);
        txtNomeAeroporto.setEnabled(editando);
        tblAeroporto.setEnabled(editando);
        
    }
    
    public boolean validaCampos(){
        if(!(txtNomeAeroporto.getText().length()>0)){
            JOptionPane.showMessageDialog(null, "Informe o nome da Aeroporto!");
            txtNomeAeroporto.requestFocus();
            return false;
        }
       
        return true;
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        listAeroporto = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Aeroporto>())  ;
        jPanel1 = new javax.swing.JPanel();
        painelNavegacao = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        painelAbas = new javax.swing.JTabbedPane();
        abaListagem = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAeroporto = new javax.swing.JTable();
        abaDados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        painelAcoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtNomeAeroporto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabelNavegacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cidades");
        setBackground(new java.awt.Color(0, 0, 153));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(4, 52, 68));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));

        painelNavegacao.setLayout(new java.awt.GridLayout(1, 0));

        btnPrimeiro.setText("Primeiro");
        btnPrimeiro.setBorder(null);
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });
        painelNavegacao.add(btnPrimeiro);

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        painelNavegacao.add(btnAnterior);

        btnProximo.setText("Próximo");
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });
        painelNavegacao.add(btnProximo);

        btnUltimo.setText("Último");
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        painelNavegacao.add(btnUltimo);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        painelNavegacao.add(btnFechar);

        abaListagem.setLayout(new java.awt.BorderLayout());

        tblAeroporto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblAeroporto.setGridColor(new java.awt.Color(4, 71, 111));
        tblAeroporto.setSelectionBackground(new java.awt.Color(7, 98, 133));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listAeroporto, tblAeroporto);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codAeroporto}"));
        columnBinding.setColumnName("Código");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomeAeroporto}"));
        columnBinding.setColumnName("Aeroporto");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tblAeroporto);
        if (tblAeroporto.getColumnModel().getColumnCount() > 0) {
            tblAeroporto.getColumnModel().getColumn(0).setResizable(false);
            tblAeroporto.getColumnModel().getColumn(1).setResizable(false);
        }

        abaListagem.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        painelAbas.addTab("Listagem", abaListagem);

        abaDados.setBackground(new java.awt.Color(7, 71, 92));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Còdigo:");

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Aeroporto:");

        txtCodigo.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblAeroporto, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codAeroporto}"), txtCodigo, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        painelAcoes.setLayout(new java.awt.GridLayout(1, 0));

        btnNovo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("Novo");
        btnNovo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNovoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNovoMouseExited(evt);
            }
        });
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        painelAcoes.add(btnNovo);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        painelAcoes.add(btnEditar);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        painelAcoes.add(btnCancelar);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        painelAcoes.add(btnSalvar);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        painelAcoes.add(btnExcluir);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblAeroporto, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nomeAeroporto}"), txtNomeAeroporto, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtNomeAeroporto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeAeroportoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ações");

        javax.swing.GroupLayout abaDadosLayout = new javax.swing.GroupLayout(abaDados);
        abaDados.setLayout(abaDadosLayout);
        abaDadosLayout.setHorizontalGroup(
            abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaDadosLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(abaDadosLayout.createSequentialGroup()
                        .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(40, 40, 40)
                        .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNomeAeroporto)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        abaDadosLayout.setVerticalGroup(
            abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaDadosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(painelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaDadosLayout.createSequentialGroup()
                        .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2))
                    .addGroup(abaDadosLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(txtNomeAeroporto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        painelAbas.addTab("Dados", abaDados);

        jLabelNavegacao.setOpaque(true); 
        jLabelNavegacao.setBackground(new Color(4, 52, 68));
        jLabelNavegacao.setForeground(new Color(255, 255, 255));
        jLabelNavegacao.setBackground(new java.awt.Color(7, 71, 92));
        jLabelNavegacao.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelNavegacao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNavegacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNavegacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Icons-menuPrincipal/Icons-BarraCadastro/iconAeroporto.png"))); // NOI18N
        jLabelNavegacao.setText(" NAVEGAÇÃO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelNavegacao, javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(50, Short.MAX_VALUE)
                    .addComponent(painelNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(49, Short.MAX_VALUE)
                    .addComponent(painelAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(51, 51, 51)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(482, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(96, 96, 96)
                    .addComponent(painelNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(417, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(painelAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        // TODO add your handling code here:
        tblAeroporto.setRowSelectionInterval(0, 0);
        tblAeroporto.scrollRectToVisible(tblAeroporto.getCellRect(0, 0, true));
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        // TODO add your handling code here:
        dispose(); // fecha a janela
        
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtNomeAeroportoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeAeroportoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeAeroportoActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        trataEdicao(true);
        listAeroporto.add((Aeroporto)new Aeroporto());// cria um objeto e uma linha na tabela
        int linha = listAeroporto.size()-1;
        tblAeroporto.setRowSelectionInterval(linha, linha);// seleciona a linha
        txtNomeAeroporto.requestFocus();// caixa texto nome recebe o foco
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if(validaCampos()){
        trataEdicao(false);
        int linhaSelecionada = tblAeroporto.getSelectedRow();
        Aeroporto objAeroporto = listAeroporto.get(linhaSelecionada);
        objDAOAeroporto.salvar(objAeroporto);
        atualizaTabela();
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        trataEdicao(true);
        txtNomeAeroporto.requestFocus();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        trataEdicao(false);
        atualizaTabela();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        int opcao= JOptionPane.showOptionDialog(null, "Confirmar exclusão?",
        "Pergunta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, 
        null,new String[]{"Sim","Não"},"Sim");
        if(opcao==0){
          int linhaSelecionada = tblAeroporto.getSelectedRow();
          Aeroporto objAeroporto = listAeroporto.get(linhaSelecionada);
          objDAOAeroporto.remover(objAeroporto);
          atualizaTabela();
          trataEdicao(false);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        int linha = tblAeroporto.getSelectedRow();
        if((linha-1)>=0){
            linha--;
        }
        tblAeroporto.setRowSelectionInterval(linha, linha);
        tblAeroporto.scrollRectToVisible(tblAeroporto.getCellRect(linha, 0, true));
        
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        // TODO add your handling code here:
       int linha = tblAeroporto.getSelectedRow();
        if((linha+1)<=(tblAeroporto.getRowCount())-1){
            linha++;
        }
        tblAeroporto.setRowSelectionInterval(linha, linha);
        tblAeroporto.scrollRectToVisible(tblAeroporto.getCellRect(linha, 0, true));
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        // TODO add your handling code here:
        int linha = tblAeroporto.getRowCount()-1;
        tblAeroporto.setRowSelectionInterval(linha, linha);
        tblAeroporto.scrollRectToVisible(tblAeroporto.getCellRect(linha, 0, true));
  
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoMouseExited
        // TODO add your handling code here:       
        btnNovo.setBackground(new Color(4,52,68));
        
    }//GEN-LAST:event_btnNovoMouseExited

    private void btnNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoMouseEntered
        // TODO add your handling code here:
         btnNovo.setBackground(new Color(7,72,92));
    }//GEN-LAST:event_btnNovoMouseEntered

    
    
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
            java.util.logging.Logger.getLogger(FormAeroporto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAeroporto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAeroporto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAeroporto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormAeroporto dialog = new FormAeroporto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                
                dialog.setVisible(true);
            }
        });
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel abaDados;
    private javax.swing.JPanel abaListagem;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelNavegacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.util.List<Aeroporto> listAeroporto;
    private javax.swing.JTabbedPane painelAbas;
    private javax.swing.JPanel painelAcoes;
    private javax.swing.JPanel painelNavegacao;
    private javax.swing.JTable tblAeroporto;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNomeAeroporto;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}

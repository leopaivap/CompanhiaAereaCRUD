package visual;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import  java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import modelo.Passageiro;
import modelo.DAOPassageiro;

public class FormPassageiro extends javax.swing.JDialog {
    DAOPassageiro objDAOPassageiro = new DAOPassageiro();

    /** Creates new form FormPassageiro */
    public FormPassageiro(java.awt.Frame parent, boolean modal) {
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
        trataEdicao(false);formatarBotoes();
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
        listPassageiro.clear();
        listPassageiro.addAll(objDAOPassageiro.getLista());
        int linha = listPassageiro.size()-1;
        if(linha>=0){
            tblPassageiro.setRowSelectionInterval(linha, linha);
            tblPassageiro.scrollRectToVisible(tblPassageiro.getCellRect(linha,linha,true));
        }
    }
    
    
    private void trataEdicao(boolean editando){
        btnCancelar.setEnabled(editando);
        btnSalvar.setEnabled(editando);
        btnEditar.setEnabled(!editando);
        int linha = listPassageiro.size()-1;
        if(linha<0){
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
            txtCodigo.setText("");
            txtNomePassageiro.setText("");
            txtDataNasc.setText("");
            txtCpf.setText("");
        }else{
            btnExcluir.setEnabled(!editando);
        }
        btnNovo.setEnabled(!editando);
        btnFechar.setEnabled(!editando);
        btnPrimeiro.setEnabled(!editando);
        btnProximo.setEnabled(!editando);
        btnAnterior.setEnabled(!editando);
        btnUltimo.setEnabled(!editando);
        txtNomePassageiro.setEnabled(editando);
        txtCpf.setEnabled(editando);
        txtDataNasc.setEnabled(editando);
        tblPassageiro.setEnabled(editando);
        
    }
    
    public boolean validaCampos(){
        if(!(txtNomePassageiro.getText().length()>0)){
            JOptionPane.showMessageDialog(null, "Informe o nome da Passageiro");
            txtNomePassageiro.requestFocus();
            return false;
        }
        if(!(txtCpf.getText().length()>0)){
            JOptionPane.showMessageDialog(null, "Informe o Cpf!");
            txtCpf.requestFocus();
            return false;
        }
        
        if(!(txtDataNasc.getText().length()>0)){
            JOptionPane.showMessageDialog(null, "Informe a Data de Nascimento!");
            txtDataNasc.requestFocus();
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

        converteData = new modelo.ConverteData();
        listPassageiro = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Passageiro>())  ;
        jPanel3 = new javax.swing.JPanel();
        painelNavegacao = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        painelAbas = new javax.swing.JTabbedPane();
        abaListagem = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPassageiro = new javax.swing.JTable();
        abaDados = new javax.swing.JPanel();
        painelAcoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        javax.swing.text.MaskFormatter maskData = null;  try{  maskData = new javax.swing.text.MaskFormatter("##/##/####");  maskData.setPlaceholderCharacter('_');  } catch(Exception e){  System.out.println("Erro na mascara " + e);  }
        txtDataNasc = new javax.swing.JFormattedTextField(maskData);
        txtNomePassageiro = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabelNavegacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cidades");
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(4, 52, 68));
        jPanel3.setPreferredSize(new java.awt.Dimension(960, 550));

        painelNavegacao.setLayout(new java.awt.GridLayout(1, 0));

        btnPrimeiro.setText("Primeiro");
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

        tblPassageiro.setSelectionBackground(new java.awt.Color(7, 98, 133));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listPassageiro, tblPassageiro);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codPassageiro}"));
        columnBinding.setColumnName("Código");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Passageiro");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cpf}"));
        columnBinding.setColumnName("Cpf");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nascimentoFormatado}"));
        columnBinding.setColumnName("Data Nascimento");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tblPassageiro);
        if (tblPassageiro.getColumnModel().getColumnCount() > 0) {
            tblPassageiro.getColumnModel().getColumn(0).setResizable(false);
            tblPassageiro.getColumnModel().getColumn(1).setResizable(false);
            tblPassageiro.getColumnModel().getColumn(2).setResizable(false);
            tblPassageiro.getColumnModel().getColumn(3).setResizable(false);
        }

        abaListagem.add(jScrollPane1, java.awt.BorderLayout.PAGE_START);

        painelAbas.addTab("Listagem", abaListagem);

        abaDados.setBackground(new java.awt.Color(7, 71, 92));

        painelAcoes.setLayout(new java.awt.GridLayout(1, 0));

        btnNovo.setText("Novo");
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

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Còdigo");

        txtCodigo.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblPassageiro, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codPassageiro}"), txtCodigo, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Passageiro:");

        jLabel16.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("CPF:");

        jLabel17.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Data Nascimento:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblPassageiro, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.dataNascimento}"), txtDataNasc, org.jdesktop.beansbinding.BeanProperty.create("value"));
        binding.setConverter(converteData);
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblPassageiro, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), txtNomePassageiro, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblPassageiro, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.cpf}"), txtCpf, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ações");

        javax.swing.GroupLayout abaDadosLayout = new javax.swing.GroupLayout(abaDados);
        abaDados.setLayout(abaDadosLayout);
        abaDadosLayout.setHorizontalGroup(
            abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(abaDadosLayout.createSequentialGroup()
                        .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(painelAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
                            .addGroup(abaDadosLayout.createSequentialGroup()
                                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(abaDadosLayout.createSequentialGroup()
                                        .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel15))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNomePassageiro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(abaDadosLayout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(abaDadosLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                        .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        abaDadosLayout.setVerticalGroup(
            abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(20, 20, 20)
                .addComponent(painelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtNomePassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        painelAbas.addTab("Dados", abaDados);

        jLabelNavegacao.setOpaque(true); 
        jLabelNavegacao.setBackground(new Color(4, 52, 68));
        jLabelNavegacao.setForeground(new Color(255, 255, 255));
        jLabelNavegacao.setBackground(new java.awt.Color(7, 71, 92));
        jLabelNavegacao.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelNavegacao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNavegacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNavegacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Icons-menuPrincipal/Icons-BarraCadastro/iconPassageiro.png"))); // NOI18N
        jLabelNavegacao.setText("NAVEGAÇÃO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNavegacao, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(painelAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(60, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(57, Short.MAX_VALUE)
                    .addComponent(painelNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(496, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(painelAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(37, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(painelNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(455, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        // TODO add your handling code here:
        tblPassageiro.setRowSelectionInterval(0, 0);
        tblPassageiro.scrollRectToVisible(tblPassageiro.getCellRect(0, 0, true));
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        // TODO add your handling code here:
        dispose(); // fecha a janela
        
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        trataEdicao(true);
        listPassageiro.add((Passageiro)new Passageiro());// cria um objeto e uma linha na tabela
        int linha = listPassageiro.size()-1;
        tblPassageiro.setRowSelectionInterval(linha, linha);// seleciona a linha
        txtNomePassageiro.requestFocus();// caixa texto nome recebe o foco
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if(validaCampos()){
        trataEdicao(false);
        int linhaSelecionada = tblPassageiro.getSelectedRow();
        Passageiro objPassageiro = listPassageiro.get(linhaSelecionada);
        objDAOPassageiro.salvar(objPassageiro);
        atualizaTabela();
 
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        trataEdicao(true);
        txtNomePassageiro.requestFocus();
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
          int linhaSelecionada = tblPassageiro.getSelectedRow();
          Passageiro objPassageiro = listPassageiro.get(linhaSelecionada);
          objDAOPassageiro.remover(objPassageiro);
          atualizaTabela();
          trataEdicao(false);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        int linha = tblPassageiro.getSelectedRow();
        if((linha-1)>=0){
            linha--;
        }
        tblPassageiro.setRowSelectionInterval(linha, linha);
        tblPassageiro.scrollRectToVisible(tblPassageiro.getCellRect(linha, 0, true));
        
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        // TODO add your handling code here:
       int linha = tblPassageiro.getSelectedRow();
        if((linha+1)<=(tblPassageiro.getRowCount())-1){
            linha++;
        }
        tblPassageiro.setRowSelectionInterval(linha, linha);
        tblPassageiro.scrollRectToVisible(tblPassageiro.getCellRect(linha, 0, true));
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        // TODO add your handling code here:
        int linha = tblPassageiro.getRowCount()-1;
        tblPassageiro.setRowSelectionInterval(linha, linha);
        tblPassageiro.scrollRectToVisible(tblPassageiro.getCellRect(linha, 0, true));
  
    }//GEN-LAST:event_btnUltimoActionPerformed

    
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
            java.util.logging.Logger.getLogger(FormPassageiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPassageiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPassageiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPassageiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormPassageiro dialog = new FormPassageiro(new javax.swing.JFrame(), true);
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
    private modelo.ConverteData converteData;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelNavegacao;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.util.List<Passageiro> listPassageiro;
    private javax.swing.JTabbedPane painelAbas;
    private javax.swing.JPanel painelAcoes;
    private javax.swing.JPanel painelNavegacao;
    private javax.swing.JTable tblPassageiro;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JFormattedTextField txtDataNasc;
    private javax.swing.JTextField txtNomePassageiro;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}

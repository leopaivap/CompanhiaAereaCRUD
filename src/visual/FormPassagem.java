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
import modelo.Passagem;
import modelo.DAOPassagem;
import modelo.Voo;
import modelo.DAOVoo;
import modelo.Passageiro;
import modelo.DAOPassageiro;


public class FormPassagem extends javax.swing.JDialog {
    DAOPassagem objDAOPassagem = new DAOPassagem();
    DAOPassageiro objDAOPassageiro = new DAOPassageiro();
    DAOVoo objDAOVoo = new DAOVoo();

    /** Creates new form FormPassagem */
    public FormPassagem(java.awt.Frame parent, boolean modal) {
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
        listPassageiro.clear();
        listPassageiro.addAll(objDAOPassageiro.getLista());
        listVoo.clear();
        listVoo.addAll(objDAOVoo.getLista());
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
        listPassagem.clear();
        listPassagem.addAll(objDAOPassagem.getLista());
        int linha = listPassagem.size()-1;
        if(linha>=0){
            tblPassagem.setRowSelectionInterval(linha, linha);
            tblPassagem.scrollRectToVisible(tblPassagem.getCellRect(linha,linha,true));
        }
    }
    
    
    private void trataEdicao(boolean editando){
        btnCancelar.setEnabled(editando);
        btnSalvar.setEnabled(editando);
        btnEditar.setEnabled(!editando);
        int linha = listPassagem.size()-1;
        if(linha<0){
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
            txtCodigo.setText("");
            txtNumeroPoltronas.setText("");
            txtPesoBagagem.setText("");
            txtValorPassagem .setText("");
        }else{
            btnExcluir.setEnabled(!editando);
        }
        btnNovo.setEnabled(!editando);
        btnFechar.setEnabled(!editando);
        btnPrimeiro.setEnabled(!editando);
        btnProximo.setEnabled(!editando);
        btnAnterior.setEnabled(!editando);
        btnUltimo.setEnabled(!editando);
        txtNumeroPoltronas.setEnabled(editando);
        txtPesoBagagem.setEnabled(editando);
        txtValorPassagem.setEnabled(editando);
        tblPassagem.setEnabled(editando);
        cbPassageiro.setEnabled(editando);
        cbVoo.setEnabled(editando);
        
    }
    
    public boolean validaCampos(){
        if(!( txtNumeroPoltronas.getText().length()>0)){
            JOptionPane.showMessageDialog(null, "Informe o numero de poltronas!");
             txtNumeroPoltronas.requestFocus();
            return false;
        }
        if(!(txtPesoBagagem.getText().length()>0)){
            JOptionPane.showMessageDialog(null, "Informe o peso da bagagem!");
            txtPesoBagagem.requestFocus();
            return false;
        }
        
        if(!(txtValorPassagem.getText().length()>0)){
            JOptionPane.showMessageDialog(null, "Informe o valor da passagem!"); 
            txtValorPassagem.requestFocus();
            return false;
        }
        if(!(cbPassageiro.getSelectedIndex()>=0)){
            JOptionPane.showMessageDialog(null, "Selecione o passageiro!");
            cbPassageiro.requestFocus();
            return false;
        }
        if(!(cbVoo.getSelectedIndex()>=0)){
            JOptionPane.showMessageDialog(null, "Selecione o voo!");
            cbVoo.requestFocus();
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

        listPassagem = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Passagem>())  ;
        listPassageiro = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Passageiro>())
        ;
        listVoo = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Voo>())  ;
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
        tblPassagem = new javax.swing.JTable();
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
        jLabel18 = new javax.swing.JLabel();
        txtNumeroPoltronas = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtPesoBagagem = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtValorPassagem = new javax.swing.JTextField();
        cbVoo = new javax.swing.JComboBox<>();
        cbPassageiro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabelNavegacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cidades");
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(4, 52, 68));
        jPanel3.setPreferredSize(new java.awt.Dimension(900, 500));

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

        tblPassagem.setGridColor(new java.awt.Color(4, 71, 111));
        tblPassagem.setSelectionBackground(new java.awt.Color(7, 98, 133));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listPassagem, tblPassagem);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codPassagem}"));
        columnBinding.setColumnName("Cod Passagem");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${voo}"));
        columnBinding.setColumnName("Voo");
        columnBinding.setColumnClass(modelo.Voo.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pesoBagagem}"));
        columnBinding.setColumnName("Peso Bagagem");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numeroPoltrona}"));
        columnBinding.setColumnName("Numero Poltrona");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valorPassagem}"));
        columnBinding.setColumnName("Valor Passagem");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tblPassagem);
        if (tblPassagem.getColumnModel().getColumnCount() > 0) {
            tblPassagem.getColumnModel().getColumn(0).setResizable(false);
            tblPassagem.getColumnModel().getColumn(1).setResizable(false);
            tblPassagem.getColumnModel().getColumn(2).setResizable(false);
            tblPassagem.getColumnModel().getColumn(3).setResizable(false);
            tblPassagem.getColumnModel().getColumn(4).setResizable(false);
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

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Còdigo");

        txtCodigo.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblPassagem, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codPassagem}"), txtCodigo, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Passageiro:");

        jLabel16.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Voo:");

        jLabel18.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Nº Poltrona:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblPassagem, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.numeroPoltrona}"), txtNumeroPoltronas, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel19.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Peso Bagagem(KG):");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblPassagem, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.pesoBagagem}"), txtPesoBagagem, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtPesoBagagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoBagagemActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Valor Passagem(R$):");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblPassagem, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.valorPassagem}"), txtValorPassagem, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listVoo, cbVoo);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblPassagem, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.voo}"), cbVoo, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listPassageiro, cbPassageiro);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblPassagem, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.passageiro}"), cbPassageiro, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
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
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaDadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painelAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE))
                    .addGroup(abaDadosLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(abaDadosLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPesoBagagem, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(abaDadosLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNumeroPoltronas, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(abaDadosLayout.createSequentialGroup()
                                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15))
                                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(abaDadosLayout.createSequentialGroup()
                                        .addGap(90, 90, 90)
                                        .addComponent(cbPassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaDadosLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(abaDadosLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtValorPassagem, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(abaDadosLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbVoo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        abaDadosLayout.setVerticalGroup(
            abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addComponent(painelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(cbPassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cbVoo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtNumeroPoltronas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesoBagagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorPassagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(47, 47, 47))
        );

        painelAbas.addTab("Dados", abaDados);

        jLabelNavegacao.setOpaque(true);
        jLabelNavegacao.setBackground(new java.awt.Color(7, 71, 92));
        jLabelNavegacao.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelNavegacao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNavegacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNavegacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Icons-menuPrincipal/Icons-BarraCadastro/iconPassagem.png"))); // NOI18N
        jLabelNavegacao.setText("NAVEGAÇÃO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNavegacao, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(40, Short.MAX_VALUE)
                    .addComponent(painelNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(43, 43, 43)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(42, Short.MAX_VALUE)
                    .addComponent(painelAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(43, 43, 43)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(517, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addComponent(painelNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(458, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addGap(142, 142, 142)
                    .addComponent(painelAbas, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        // TODO add your handling code here:
        tblPassagem.setRowSelectionInterval(0, 0);
        tblPassagem.scrollRectToVisible(tblPassagem.getCellRect(0, 0, true));
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        // TODO add your handling code here:
        dispose(); // fecha a janela
        
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        trataEdicao(true);
        listPassagem.add((Passagem)new Passagem());// cria um objeto e uma linha na tabela
        int linha = listPassagem.size()-1;
        tblPassagem.setRowSelectionInterval(linha, linha);// seleciona a linha
        cbPassageiro.requestFocus();// caixa texto nome recebe o foco
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if(validaCampos()){
        trataEdicao(false);
        int linhaSelecionada = tblPassagem.getSelectedRow();
        Passagem objPassagem = listPassagem.get(linhaSelecionada);
        objDAOPassagem.salvar(objPassagem);
        atualizaTabela();
 
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        trataEdicao(true);
        cbPassageiro.requestFocus();
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
          int linhaSelecionada = tblPassagem.getSelectedRow();
          Passagem objPassagem = listPassagem.get(linhaSelecionada);
          objDAOPassagem.remover(objPassagem);
          atualizaTabela();
          trataEdicao(false);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        int linha = tblPassagem.getSelectedRow();
        if((linha-1)>=0){
            linha--;
        }
        tblPassagem.setRowSelectionInterval(linha, linha);
        tblPassagem.scrollRectToVisible(tblPassagem.getCellRect(linha, 0, true));
        
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        // TODO add your handling code here:
       int linha = tblPassagem.getSelectedRow();
        if((linha+1)<=(tblPassagem.getRowCount())-1){
            linha++;
        }
        tblPassagem.setRowSelectionInterval(linha, linha);
        tblPassagem.scrollRectToVisible(tblPassagem.getCellRect(linha, 0, true));
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        // TODO add your handling code here:
        int linha = tblPassagem.getRowCount()-1;
        tblPassagem.setRowSelectionInterval(linha, linha);
        tblPassagem.scrollRectToVisible(tblPassagem.getCellRect(linha, 0, true));
  
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void txtPesoBagagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoBagagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoBagagemActionPerformed

    
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
            java.util.logging.Logger.getLogger(FormPassagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPassagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPassagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPassagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                FormPassagem dialog = new FormPassagem(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbPassageiro;
    private javax.swing.JComboBox<String> cbVoo;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelNavegacao;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.util.List<Passageiro> listPassageiro;
    private java.util.List<Passagem> listPassagem;
    private java.util.List<Voo> listVoo;
    private javax.swing.JTabbedPane painelAbas;
    private javax.swing.JPanel painelAcoes;
    private javax.swing.JPanel painelNavegacao;
    private javax.swing.JTable tblPassagem;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNumeroPoltronas;
    private javax.swing.JTextField txtPesoBagagem;
    private javax.swing.JTextField txtValorPassagem;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}

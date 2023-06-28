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
import modelo.Aeronave;
import modelo.DAOAeronave;

public class FormAeronave extends javax.swing.JDialog {
    DAOAeronave objDAOAeronave = new DAOAeronave();

    /** Creates new form FormAeronave */
    public FormAeronave(java.awt.Frame parent, boolean modal) {
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
        listAeronave.clear();
        listAeronave.addAll(objDAOAeronave.getLista());
        int linha = listAeronave.size()-1;
        if(linha>=0){
            tblAeronave.setRowSelectionInterval(linha, linha);
      tblAeronave.scrollRectToVisible(tblAeronave.getCellRect(linha,linha,true));
        }
    }
    
    
    private void trataEdicao(boolean editando){
        btnCancelar.setEnabled(editando);
        btnSalvar.setEnabled(editando);
        btnEditar.setEnabled(!editando);
        int linha = listAeronave.size()-1;
        if(linha<0){
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
            txtCodigo.setText("");
            txtAeronave.setText("");
        }else{
            btnExcluir.setEnabled(!editando);
        }
        btnNovo.setEnabled(!editando);
        btnFechar.setEnabled(!editando);
        btnPrimeiro.setEnabled(!editando);
        btnProximo.setEnabled(!editando);
        btnAnterior.setEnabled(!editando);
        btnUltimo.setEnabled(!editando);
        txtAeronave.setEnabled(editando);
        txtAutonomia.setEnabled(editando);
        txtAssentos.setEnabled(editando);
        txtCapacidadeCarga.setEnabled(editando);
        tblAeronave.setEnabled(editando);
        
    }
    
    public boolean validaCampos(){
        if(!(txtAeronave.getText().length()>0)){
            JOptionPane.showMessageDialog(null, "Informe o nome da Aeronave");
            txtAeronave.requestFocus();
            return false;
        }
        if(!(txtAssentos.getText().length()>0)){
            JOptionPane.showMessageDialog(null, "Informe a quantidade de assentos!");
            txtAssentos.requestFocus();
            return false;
        }
        if(!(txtAutonomia.getText().length()>0)){
            JOptionPane.showMessageDialog(null, "Informe a autonomia!");
            txtAutonomia.requestFocus();
            return false;
        }
        if(!(txtCapacidadeCarga.getText().length()>0)){
            JOptionPane.showMessageDialog(null, "Informe a capacidade de carga!");
            txtCapacidadeCarga.requestFocus();
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

        listAeronave = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Aeronave>())  ;
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
        tblAeronave = new javax.swing.JTable();
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
        txtAeronave = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtAssentos = new javax.swing.JTextField();
        txtAutonomia = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCapacidadeCarga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabelNavegacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cidades");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(4, 52, 68));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));

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

        tblAeronave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblAeronave.setGridColor(new java.awt.Color(4, 71, 111));
        tblAeronave.setSelectionBackground(new java.awt.Color(7, 98, 133));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listAeronave, tblAeronave);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codAeronave}"));
        columnBinding.setColumnName("Código");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomeAviao}"));
        columnBinding.setColumnName("Aeronave");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${qtdAssento}"));
        columnBinding.setColumnName("Quantidade Assento");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${autonomia}"));
        columnBinding.setColumnName("Autonomia (KM)");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${capacidadeCarga}"));
        columnBinding.setColumnName("Capacidade Carga (KG)");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tblAeronave);

        abaListagem.add(jScrollPane1, java.awt.BorderLayout.CENTER);

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
        jLabel13.setText("Còdigo:");

        txtCodigo.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblAeronave, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codAeronave}"), txtCodigo, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Aeronave:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblAeronave, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nomeAviao}"), txtAeronave, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtAeronave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAeronaveActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Nº Assentos:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblAeronave, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.qtdAssento}"), txtAssentos, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtAssentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAssentosActionPerformed(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblAeronave, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.autonomia}"), txtAutonomia, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtAutonomia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutonomiaActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Autonomia(KM):");

        jLabel14.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Capacidade(KG):");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblAeronave, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.capacidadeCarga}"), txtCapacidadeCarga, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtCapacidadeCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapacidadeCargaActionPerformed(evt);
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
                .addGap(33, 33, 33)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(abaDadosLayout.createSequentialGroup()
                            .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel15))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtAeronave, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaDadosLayout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAssentos, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(abaDadosLayout.createSequentialGroup()
                            .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17)
                                .addComponent(jLabel14))
                            .addGap(36, 36, 36)
                            .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCapacidadeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAutonomia, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(painelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        abaDadosLayout.setVerticalGroup(
            abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaDadosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(painelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaDadosLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaDadosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAeronave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtAssentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaDadosLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel17))
                    .addComponent(txtAutonomia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(abaDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaDadosLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel14))
                    .addComponent(txtCapacidadeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        painelAbas.addTab("Dados", abaDados);

        jLabelNavegacao.setOpaque(true);
        jLabelNavegacao.setBackground(new java.awt.Color(7, 71, 92));
        jLabelNavegacao.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelNavegacao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNavegacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNavegacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Icons-menuPrincipal/Icons-BarraCadastro/iconAeronave.png"))); // NOI18N
        jLabelNavegacao.setText("NAVEGAÇÃO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(35, Short.MAX_VALUE)
                    .addComponent(painelAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(painelNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(30, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabelNavegacao, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(132, Short.MAX_VALUE)
                    .addComponent(painelAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(painelNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(388, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(jLabelNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(441, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        // TODO add your handling code here:
        tblAeronave.setRowSelectionInterval(0, 0);
        tblAeronave.scrollRectToVisible(tblAeronave.getCellRect(0, 0, true));
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        // TODO add your handling code here:
        dispose(); // fecha a janela
        
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        trataEdicao(true);
        listAeronave.add((Aeronave)new Aeronave());// cria um objeto e uma linha na tabela
        int linha = listAeronave.size()-1;
        tblAeronave.setRowSelectionInterval(linha, linha);// seleciona a linha
        txtAeronave.requestFocus();// caixa texto nome recebe o foco
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if(validaCampos()){
            trataEdicao(false);
            int linhaSelecionada = tblAeronave.getSelectedRow();
            Aeronave objAeronave = listAeronave.get(linhaSelecionada);
            objDAOAeronave.salvar(objAeronave);
            atualizaTabela();
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        trataEdicao(true);
        txtAeronave.requestFocus();
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
          int linhaSelecionada = tblAeronave.getSelectedRow();
          Aeronave objAeronave = listAeronave.get(linhaSelecionada);
          objDAOAeronave.remover(objAeronave);
          atualizaTabela();
          trataEdicao(false);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        int linha = tblAeronave.getSelectedRow();
        if((linha-1)>=0){
            linha--;
        }
        tblAeronave.setRowSelectionInterval(linha, linha);
        tblAeronave.scrollRectToVisible(tblAeronave.getCellRect(linha, 0, true));
        
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        // TODO add your handling code here:
       int linha = tblAeronave.getSelectedRow();
        if((linha+1)<=(tblAeronave.getRowCount())-1){
            linha++;
        }
        tblAeronave.setRowSelectionInterval(linha, linha);
        tblAeronave.scrollRectToVisible(tblAeronave.getCellRect(linha, 0, true));
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        // TODO add your handling code here:
        int linha = tblAeronave.getRowCount()-1;
        tblAeronave.setRowSelectionInterval(linha, linha);
        tblAeronave.scrollRectToVisible(tblAeronave.getCellRect(linha, 0, true));
  
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void txtAeronaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAeronaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAeronaveActionPerformed

    private void txtAssentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAssentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAssentosActionPerformed

    private void txtAutonomiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutonomiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutonomiaActionPerformed

    private void txtCapacidadeCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapacidadeCargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapacidadeCargaActionPerformed

    
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
            java.util.logging.Logger.getLogger(FormAeronave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAeronave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAeronave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAeronave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                FormAeronave dialog = new FormAeronave(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelNavegacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.util.List<Aeronave> listAeronave;
    private javax.swing.JTabbedPane painelAbas;
    private javax.swing.JPanel painelAcoes;
    private javax.swing.JPanel painelNavegacao;
    private javax.swing.JTable tblAeronave;
    private javax.swing.JTextField txtAeronave;
    private javax.swing.JTextField txtAssentos;
    private javax.swing.JTextField txtAutonomia;
    private javax.swing.JTextField txtCapacidadeCarga;
    private javax.swing.JTextField txtCodigo;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}

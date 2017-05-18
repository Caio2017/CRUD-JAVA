/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.BuscarPor;
import model.Pessoa;
import util.ManipulateDates;
import util.FilesFoldersImages;
//MyImports
/*
 * @author CAIO
 * 
 * [x]  criar/configurar tabela
 * [x]  conexão com banco de dados
 * [x]  filtros/campo pesquisa
 * [ ]  Validar ao clicar no campo sem seleçao
 * [x]  alterar/excluir/consultar 
 * [x]  gerar relatorio
 */
public final class frmMain extends javax.swing.JFrame {
    
    public final String caminhoPastaFotos;
    private final String caminhoPastaRelatorios;
    public frmCadastro frmcadastro;
    /*
     PROPRIEDADES ALTERADAS VIA JANELA 
        Propriedades, Codigo, Gerar Centralizado.
        Propriedades, Politicas de tamanho de forms, Gerar Código de Redimensionamento
        Definir Layout, Layout Absoluto
    */
    public frmMain() {
        initComponents(); 
        initListeners();
        String nomePastaFotos = "Profile Pictures";
        String nomePastaRelat = "Relatorios";
        //cria pasta de fotos no diretorio do JAR se nao existir, retorna o caminho 
        caminhoPastaFotos = new FilesFoldersImages().createFolderInDirectoryJAR(nomePastaFotos);
        //cria pasta de relatorios
        caminhoPastaRelatorios = new FilesFoldersImages().createFolderInDirectoryJAR(nomePastaRelat); 
        
        adicionarColunasTabela();
        ajustarTamanhosColunasTabela();
        configurarTabela();
        AtualizarDadosTabela();
    }
    
    //Variaveis Globais    
    DefaultTableModel modeloTabela = new DefaultTableModel();/*{
        @Override //Exibir checkbox nas colunas boolean ao inves de true ou false
        public Class<?> getColumnClass(int columnIndex) {
            return getValueAt(0, columnIndex).getClass();
        }
        
        @Override //Implemetação para deixar tabela nao editavel.
        public boolean isCellEditable(int row, int column) {
        //all cells false
        return false;
        } 
    
    };*/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnPesquisar = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        chkSelecionarVarios = new javax.swing.JCheckBox();
        btnGerarRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD Caio S.");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 560, 180));

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });
        getContentPane().add(txtPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, -1));

        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsNovoAlterarConsultarExcluir(evt);
            }
        });
        getContentPane().add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 40));

        btnAlterar.setText("ALTERAR");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsNovoAlterarConsultarExcluir(evt);
            }
        });
        getContentPane().add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, 40));

        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsNovoAlterarConsultarExcluir(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, 40));

        btnConsultar.setText("CONSULTAR");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsNovoAlterarConsultarExcluir(evt);
            }
        });
        getContentPane().add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, 40));

        chkSelecionarVarios.setText("Selecionar Vários");
        chkSelecionarVarios.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkSelecionarVariosStateChanged(evt);
            }
        });
        getContentPane().add(chkSelecionarVarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        btnGerarRelatorio.setText("Gerar Relatorio");
        btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelatorioActionPerformed(evt);
            }
        });
        getContentPane().add(btnGerarRelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 240, -1, 20));

        setSize(new java.awt.Dimension(613, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Eventos Manuais">   
    private void initListeners() {
       
        //Adicionado evento mouseDoubleClick
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    // your valueChanged overridden method 
                    visualizacaoRapida();
                }
            }
        });
        //Adicionado evento SelectChange
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent event) {
            //se tiver mais de um selecionado, desativar os botoes
            boolean moreThanOneSelected = jTable1.getSelectedRowCount() > 1;
            btnAlterar.setEnabled(!moreThanOneSelected);
            btnConsultar.setEnabled(!moreThanOneSelected);
            
        }
    });
   }// </editor-fold>  

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        AtualizarDadosTabela();
    }//GEN-LAST:event_btnPesquisarActionPerformed
    
    private void btnsNovoAlterarConsultarExcluir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsNovoAlterarConsultarExcluir
        javax.swing.JButton btnClicked = (javax.swing.JButton) evt.getSource();
        
        Pessoa pessoa = null;
        
        
        if(btnClicked != btnNovo && jTable1.getSelectedRowCount() == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Selecione alguma pessoa", "Não foi possivel realizar", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(btnClicked == btnExcluir) {
            int[] idSelecionados = obterIdDosSelecionados();
            String[] fotoSelecionados = obterFotoDosSelecionados();
            //Exclui registros no banco
            Pessoa.Excluir(idSelecionados);
            //Exclui fotos
            FilesFoldersImages m = new FilesFoldersImages();
            for(String foto : fotoSelecionados)
                m.deleteFile(caminhoPastaFotos+"\\"+foto);
            
            AtualizarDadosTabela();
        }else{                
            if(btnClicked == btnNovo)
            {

            }else if(btnClicked == btnAlterar || btnClicked == btnConsultar)
            {                
                pessoa = obterPessoaSelecionada();   
                if(btnClicked == btnConsultar)
                    pessoa.setId(pessoa.getId() * -1);
                
            }else {
                JOptionPane.showMessageDialog(rootPane, BuscarPor.Id.getQuery());
                JOptionPane.showMessageDialog(rootPane, "ERRO: este botao está vinculado ao evento, porém não possui ações para ele");
            }
            
            //Se ja existe um formulario aberto
            if(frmcadastro != null && frmcadastro.isVisible()){
                //Da o foco no formulario
                frmcadastro.setState(JFrame.NORMAL);
                frmcadastro.toFront();// or setVisible(true) or requestFocus()                    
            }
            else if(frmcadastro != null) {//n caira nesta condiçao, por conta do evento Closed do frmCadastro
                //Exibe o que estava aberto com as informaçoes de antes
                frmcadastro.setVisible(true);
            }else
            {
                //Cria um novo formulario
                frmcadastro = new frmCadastro(this, pessoa, null);
                frmcadastro.setTitle(btnClicked.getText());
                frmcadastro.setLocationRelativeTo(null);
                frmcadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frmcadastro.setResizable(false);
                frmcadastro.setVisible(true);
            }
        }            
    }//GEN-LAST:event_btnsNovoAlterarConsultarExcluir

    private void chkSelecionarVariosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkSelecionarVariosStateChanged
        if(chkSelecionarVarios.isSelected()){
            jTable1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        }else{
            jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }        
    }//GEN-LAST:event_chkSelecionarVariosStateChanged

    private void btnGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRelatorioActionPerformed
        //pegar o modelo do relatorio
        File f = new File(getClass().getResource("/util/ModeloRelatorio.html").getFile());
        FilesFoldersImages m = new FilesFoldersImages();
        //Armazeno o Texto
        String Texto = m.readFileToString(f);
        //Pego a parte entre LOOP_IN e LOOP_FIM
        String part = Texto.substring(Texto.indexOf("{{LOOP_IN}}"), Texto.lastIndexOf("{{LOOP_FIM}}") + "{{LOOP_FIM}}".length());
        
        //quantidade de linhas
        int rowCount = jTable1.getRowCount();
        //quantidade de colunas
        int columnCount = jTable1.getColumnCount();
        //Array para armazenar cada linha <tr></tr>
        String[] tempTR = new String[rowCount];
        Double total = 0d;
        
        //para cada linha armazena os valores em cada item do array
        for(int row = 0; row < rowCount; row++)
        {
            Object nome = jTable1.getValueAt(row, 1);//return object or null
            Object sexo = jTable1.getValueAt(row, 2);
            Object nasc = jTable1.getValueAt(row, 3);
            Object sala = jTable1.getValueAt(row, 5);
            
            tempTR[row] = part;
            //substitui os texto de controle pelo valor das variaveis
            tempTR[row] = tempTR[row].replace("{{NOME}}", nome != null ? (String)nome : "");
            tempTR[row] = tempTR[row].replace("{{SEXO}}", sexo != null ? (String)sexo : "");
            tempTR[row] = tempTR[row].replace("{{NASCIMENTO}}", nasc != null ? (String)nasc : "");
            tempTR[row] = tempTR[row].replace("{{SALARIO}}", sala != null ? (String)sala : "");
            
            //se salario tiver valor soma com total
            if(sala != null){
                try {
                    //cast string "R$ 3.000,40 to double value 3000.40
                    double salario = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).parse(sala.toString()).doubleValue();
                    total += salario;
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this, "Falha na conversão do Salario\r\nDetalhes:"+ex.getMessage());
                } 
            }
        }
        
        //junto as partes (linhas <tr>) com /r/n
        String completePart = String.join(System.lineSeparator(), tempTR);
        //remove os textos de controle
        completePart = completePart.replace("{{LOOP_IN}}", "").replace("{{LOOP_FIM}}", "");
        //Subistitui a parte antiga pela pela nova 
        Texto = Texto.replace(part, completePart);
        //remove as linhas em brancos
        Texto = Texto.replaceAll("(?m)^[ \t]*\r?\n", "");
        //cast  double value 3000.40 to string "R$ 3.000,40
        Texto = Texto.replace("{{TOTAL_GERAL}}", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(total));
        //Crio um novo arquivo        
        String nomeDoArquivo = new SimpleDateFormat("yyyy-MM-dd HHmmss").format(new Date()) + ".html";
        String endRelatorio = caminhoPastaRelatorios+"\\"+nomeDoArquivo;
        //Cria o arquivo e escreve
        m.writeFile(endRelatorio, Texto, true);
        
        if(new File(endRelatorio).exists())
        {
            int dialogResult = JOptionPane.showConfirmDialog(null, "O relatorio foi criado em: "+System.lineSeparator()+ endRelatorio + System.lineSeparator()+"deseja abrir?", "RELATORIO CRIADO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                try { Desktop.getDesktop().open(new File(endRelatorio)); }
                catch(Exception ex) { }
            }                
        }
    }//GEN-LAST:event_btnGerarRelatorioActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            btnPesquisarActionPerformed(null);
        }

        if(txtPesquisa.getText().trim().isEmpty()){
            btnPesquisar.setText("Pesquisar Todos");
        }else if(ManipulateDates.isValidDate(txtPesquisa.getText(), "dd/MM/yyyy")){
            btnPesquisar.setText("Pesquisar por Data de Nascimento");
        }else if(txtPesquisa.getText().matches("[0-9]+")) {
            btnPesquisar.setText("Pesquisar por ID");
        }else { 
            btnPesquisar.setText("Pesquisar pelo Nome");
        }
    }//GEN-LAST:event_txtPesquisaKeyReleased
       
    private void visualizacaoRapida()//Double click
    {
        int row = jTable1.getSelectedRow();  
        int columnCount = jTable1.getColumnCount();
        String[] orderOfColumns = { "ID: ","NOME: ","SEXO: ","DATA DE NASCIMENTO: ","EMPREGADO: ","SALARIO: ","FOTO :" };
        String result = "";       
        for (int column = 0; column < columnCount; column++) {
            Object value = jTable1.getValueAt(row, column);//return object or null

            if(value != null)
                result += orderOfColumns[column]+value.toString()+"\r\n";
        }
        JOptionPane.showMessageDialog(this, result);    
        jTable1.clearSelection();
    }
    
    private Pessoa obterPessoaSelecionada()
    {
        int row = jTable1.getSelectedRow();        
        Pessoa p = new Pessoa();          
        
        //Pegando valores da linha selecionada
        Object id = jTable1.getValueAt(row, 0);
        Object nome = jTable1.getValueAt(row, 1);
        Object sexo = jTable1.getValueAt(row, 2);
        Object data = jTable1.getValueAt(row, 3);
        Object isEmpregado = jTable1.getValueAt(row, 4);
        Object salario = jTable1.getValueAt(row, 5);
        Object foto = jTable1.getValueAt(row, 6);

        //Fazendo cast e jogando na entidade
        p.setId(id != null ? (Integer)id : 0);
        p.setNome((String)nome);
        p.setSexo(sexo.toString().charAt(0));
        p.setDataNascimento(new ManipulateDates().stringToSqlDate((data == null ? "" : data.toString()), "dd/MM/yyyy"));
        //p.setDataNascimento(data != null ? (Date)data : null);//(case cell type date)
        p.setEmpregado("Sim".equals(isEmpregado.toString()));
        p.setNomeFoto(foto != null ? (String)foto : "");
        
        //cast string "R$ 3.000,40 to double value 3000.40
        try {
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            double myNumber = nf.parse(salario.toString()).doubleValue();
            p.setSalario(myNumber);
        } catch (ParseException ex) {
             JOptionPane.showMessageDialog(this, "Falha na conversão do Salario\r\nDetalhes:"+ex.getMessage());
        }
        
        jTable1.clearSelection();
        return p;
    }
    
    private int[] obterIdDosSelecionados()
    {
        int[] rowsSelected = jTable1.getSelectedRows();
        int columnId = 0;        
        int[] idSelected = new int[rowsSelected.length];
        
        for (int i = 0; i < rowsSelected.length; i++) {
            idSelected[i] = (int) jTable1.getValueAt(rowsSelected[i], columnId);
        }
        return idSelected;     
    } 
    
    private String[] obterFotoDosSelecionados()
    {
        int[] rowsSelected = jTable1.getSelectedRows();
        int columnPhoto = 6;        
        ArrayList<String> photoSelected = new ArrayList<>();   
        
        for (int row : rowsSelected) {
             photoSelected.add((String) jTable1.getValueAt(row, columnPhoto));
        }
        //Casting ArrayList to String[]
        String[] namePhotos = photoSelected.toArray(new String[photoSelected.size()]);
        return namePhotos;
        
    }
    
    private void adicionarColunasTabela()
    {
        String[] Colunas = new String[]{"Id", "Nome", "Sexo", "Nascimento", "Empregado", "Salario", "Foto" };
        modeloTabela.setColumnIdentifiers(Colunas);      
        jTable1.setModel(modeloTabela);
    }
    
    private void ajustarTamanhosColunasTabela()
    {
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            //Coluna Id
            jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
            //Coluna sexo
            jTable1.getColumnModel().getColumn(2).setMinWidth(30);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(50);
            //Coluna Data Nascimento
            jTable1.getColumnModel().getColumn(3).setMinWidth(80);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(140);
            //Coluna Empregado
            jTable1.getColumnModel().getColumn(4).setMaxWidth(80);
            //Coluna Salario
            jTable1.getColumnModel().getColumn(5).setMinWidth(100);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(110);
            //Coluna Foto (Esconder)
            jTable1.getColumnModel().getColumn(6).setMinWidth(0);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
        }
    }
    
    private void configurarTabela()
    {        
        //Desabilitando edição das celulas(caso nao implementado o metodo isCellEditable)
        jTable1.setDefaultEditor(Object.class, null);
        
        //Desabilitando seleçao Multiplas
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Fontes da Tabela
        //jTable1.setFont(new Font("Arial", Font.BOLD, 15));                
        
        //Setando a cor da seleção
        jTable1.setSelectionBackground(new Color(0, 0, 0));
        jTable1.setSelectionForeground(Color.LIGHT_GRAY);
        
        //Distancia das linhas
        jTable1.setRowHeight(20);
        
        //Setando colunas ao centro
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
    }
    
    public void AtualizarDadosTabela()
    {
        BuscarPor busca;
        String valor = txtPesquisa.getText();
        if(ManipulateDates.isValidDate(txtPesquisa.getText(), "dd/MM/yyyy")){
            busca = BuscarPor.DataDeNascimento;
            valor = new ManipulateDates().stringToSqlDate(valor, "dd/MM/yyyy").toString();
            System.out.println(valor);
        }else if(txtPesquisa.getText().matches("[0-9]+")) {
            busca = BuscarPor.Id;
        }else{ 
            busca = BuscarPor.Nome;
        }
        Pessoa.CarregarPessoasTabela(busca, valor, modeloTabela);
    }
    
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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JCheckBox chkSelecionarVarios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}

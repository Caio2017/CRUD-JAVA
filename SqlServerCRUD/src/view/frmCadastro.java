package view;

import java.awt.Cursor;
import java.io.File;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import model.Pessoa;
import util.ManipulateDates;
import util.FilesFoldersImages;
import util.JNumberFormatField;
//MyClassImports
import static util.Reuse.clearAll;

/**
 *
 * @author CAIO
 * 
 * [X] CARREGAR DADOS CONSULTA/ALTERAÇÃO
 * [X] CARREGAR IMAGEM
 * [X] VALIDAR CAMPOS ANTES DE INSERIR OU ALTERAR
 * [X] INSERIR
 * [X] ALTERAR
 * [X] SALVAR IMAGEM
 */
public class frmCadastro extends javax.swing.JFrame {

    /**
     * Creates new form frmCadastro
     */
    frmMain frmPai;
    FilesFoldersImages m = new FilesFoldersImages();
    Integer idAlterar;
    boolean imageIsOpened;
    
    public frmCadastro(frmMain f, Pessoa p, Integer id) {
        initComponents();
        ftxtSalario.setDocument(new JNumberFormatField().getDocument());
        
        frmPai = f;
        
        if(p != null)
        {
            idAlterar = p.getId();
            txtId.setText(String.valueOf(Math.abs(p.getId())));
            txtNome.setText(p.getNome());
            ftxtDataNasc.setText(new ManipulateDates().sqlDateToStringDate(p.getDataNascimento(), "ddMMyyyy"));
            rbtFeminino.setSelected(p.getSexo() == 'F');
            rbtMasculino.setSelected(p.getSexo() == 'M');
            chkEmpregado.setSelected(p.isEmpregado());
            ftxtSalario.setText(p.getSalario()+""); 
            ftxtSalario.setText(new DecimalFormat("#,##0.00").format(p.getSalario())); 
            
            //Carrega a Imagem
            pack();
            if(!p.getNomeFoto().equals("")){
                String localImagem = frmPai.caminhoPastaFotos+ "\\"+ p.getNomeFoto();
                if(new File(localImagem).exists())
                    m.loadImageToLabel(lblImagem, localImagem);
                else
                    JOptionPane.showMessageDialog(null, "A imagem "+p.getNomeFoto()+" não se encontra mais na pasta");
            }
        }else
        {
            txtId.setText(String.valueOf(Pessoa.BuscarProxIdCadastro()));
        }
        
        prepararFormulario();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        ftxtDataNasc = new javax.swing.JFormattedTextField();
        lblDataNasc = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbtFeminino = new javax.swing.JRadioButton();
        rbtMasculino = new javax.swing.JRadioButton();
        chkEmpregado = new javax.swing.JCheckBox();
        lblSalario = new javax.swing.JLabel();
        ftxtSalario = new javax.swing.JFormattedTextField();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblImagem = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnInserirAlterar = new javax.swing.JButton();
        btnRemoveImg = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });
        jPanel2.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, 30));

        lblNome.setText("Nome");
        jPanel2.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        try {
            ftxtDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtDataNasc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftxtDataNascKeyTyped(evt);
            }
        });
        jPanel2.add(ftxtDataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 130, 30));

        lblDataNasc.setText("Data Nascimento");
        jPanel2.add(lblDataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rbtFeminino);
        rbtFeminino.setText("F");
        jPanel1.add(rbtFeminino, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        buttonGroup1.add(rbtMasculino);
        rbtMasculino.setSelected(true);
        rbtMasculino.setText("M");
        jPanel1.add(rbtMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 90, 50));

        chkEmpregado.setText("Empregado");
        chkEmpregado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkEmpregadoStateChanged(evt);
            }
        });
        jPanel2.add(chkEmpregado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        lblSalario.setText("Salario");
        lblSalario.setEnabled(false);
        jPanel2.add(lblSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        ftxtSalario.setEnabled(false);
        ftxtSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftxtSalarioKeyTyped(evt);
            }
        });
        jPanel2.add(ftxtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 90, -1));

        lblId.setText("ID:");
        jPanel2.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, 20));

        txtId.setEnabled(false);
        jPanel2.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 40, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, 260));

        lblImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagem.setText("Imagem");
        lblImagem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblImagem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblImagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagemMouseClicked(evt);
            }
        });
        getContentPane().add(lblImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 110, 130));

        btnFechar.setText("Sair");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, -1));

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 100, -1));

        btnInserirAlterar.setText("Inserir/Alterar");
        btnInserirAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnInserirAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        btnRemoveImg.setText("remover");
        btnRemoveImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveImgActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemoveImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 110, 20));

        setBounds(0, 0, 406, 350);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnInserirAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirAlterarActionPerformed

        if(!validarCampos())
            return;
        
        //prenchendo entidade
        Pessoa p = new Pessoa();
        p.setNome(txtNome.getText());
        java.sql.Date Datesql = new ManipulateDates().stringToSqlDate(ftxtDataNasc.getText(), "dd/MM/yyyy");
        p.setDataNascimento(Datesql);  
        p.setSexo(rbtMasculino.isSelected() ? 'M': 'F');  
        String strSalario = ftxtSalario.getText().replaceAll("\\.", "").replace(",", ".");
        Double salario = strSalario.equals("") ? 0 : Double.parseDouble(strSalario);
        p.setSalario(salario);    
        p.setEmpregado(chkEmpregado.isSelected());
       
        //se tiver imagem na label
        if(lblImagem.getIcon() != null){  
            
            //ajusta nome da foto            
            String primeiroNome;
            if(p.getNome().contains(" "))  
                primeiroNome = p.getNome().substring(0, p.getNome().indexOf(" "));
            else 
                primeiroNome = p.getNome();
            p.setNomeFoto(txtId.getText() + primeiroNome);            
            String endFoto = frmPai.caminhoPastaFotos + "\\"+p.getNomeFoto();
            

            //se for para cadastrar Novo
            if(idAlterar == null)
            {            
                m.saveImage(endFoto); 
            }//se o formulario for alterar
            else if(idAlterar > 0)
            {
                //se a imagem nao é uma nova carregada (click label)
                if(!imageIsOpened)
                {
                    //se o primeiro nome foi modificado (o diretorio nao existirá)
                    if(new File(endFoto).exists() == false)
                    {    
                        //apenas renomeia a foto
                        m.renameFile(m.lastImageLoaded, p.getNomeFoto());
                    }
                }else
                {
                    //apagar imagem antiga
                    m.deleteFile(m.lastImageLoaded);
                    //gravar nova
                    m.saveImage(endFoto);
                }                
            }
        }
          
        if(idAlterar == null)
            p.Inserir(); 
        else if(idAlterar > 0)
        {
            p.setId(idAlterar);
            p.Alterar();
        }
        
        frmPai.AtualizarDadosTabela();
        btnLimparActionPerformed(null);
    }//GEN-LAST:event_btnInserirAlterarActionPerformed
    
    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        clearAll(this);  
        lblImagem.setIcon(null);
        chkEmpregado.setSelected(false);
        rbtMasculino.setSelected(true);
        //setar imagem do Manipular imagem para nullo
    }//GEN-LAST:event_btnLimparActionPerformed

    private void lblImagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagemMouseClicked
        if(!this.getTitle().equals("CONSULTAR"))
            if(m.openDialogAndLoadImageSelectedToLabel(lblImagem))
                imageIsOpened = true;
    }//GEN-LAST:event_lblImagemMouseClicked

    private void ftxtDataNascKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxtDataNascKeyTyped
        char ch = evt.getKeyChar();
        if(!Character.isDigit(ch)) { 
            evt.consume();
        }
    }//GEN-LAST:event_ftxtDataNascKeyTyped

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        char ch = evt.getKeyChar();
        if(!(Character.isLetter(ch) || ch == ' ')) { 
            evt.consume();
        }
    }//GEN-LAST:event_txtNomeKeyTyped

    private void ftxtSalarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxtSalarioKeyTyped
        String caracteresPermitidos="0987654321";
        if(!caracteresPermitidos.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        
    }//GEN-LAST:event_ftxtSalarioKeyTyped
    
    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        frmPai.frmcadastro = null;
        this.dispose(); 
    }//GEN-LAST:event_btnFecharActionPerformed

    private void chkEmpregadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkEmpregadoStateChanged
        lblSalario.setEnabled(chkEmpregado.isSelected());
        ftxtSalario.setEnabled(chkEmpregado.isSelected());
        
        if(!chkEmpregado.isSelected())
            ftxtSalario.setText("");
    }//GEN-LAST:event_chkEmpregadoStateChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        frmPai.frmcadastro = null;
    }//GEN-LAST:event_formWindowClosed

    private void btnRemoveImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveImgActionPerformed
        lblImagem.setIcon(null);        //Ao clickar em alterar,só altera o nome da foto para nulo, mas nao apaga da pasta
    }//GEN-LAST:event_btnRemoveImgActionPerformed
    
    private void prepararFormulario()
    {
        if(idAlterar == null || idAlterar == 0)
        {
            btnInserirAlterar.setText("GRAVAR");
        }else if(idAlterar > 0)
        {
            btnInserirAlterar.setText("ALTERAR");
        }else if(idAlterar < 0) //Consultar
        {
            txtNome.setEditable(false);
            ftxtDataNasc.setEditable(false);
            rbtFeminino.setEnabled(false);
            rbtMasculino.setEnabled(false);
            chkEmpregado.setEnabled(false);
            ftxtSalario.setEditable(false);
            lblImagem.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            btnInserirAlterar.setVisible(false);
            btnLimpar.setVisible(false);
            btnRemoveImg.setEnabled(false);
            //enableComponents(jPanel2, false);
        }        
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
            java.util.logging.Logger.getLogger(frmCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCadastro(null, null, null).setVisible(true);
            }
        });
    }
        
    private boolean validarCampos()
    {
        //validar nome
        String name = txtNome.getText().trim();
        boolean sohLetrasEEspacos = name.matches("[a-zA-Z\\s]+");

         if(name.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nome não pode ser Vazio"); 
            return false;
        } else if (name.length() <= 3){
            JOptionPane.showMessageDialog(null, "Nome curto demais");
            return false;
        }else if (!sohLetrasEEspacos){
            JOptionPane.showMessageDialog(null, "Nome incorreto");
            return false;
        }        

        //validar data
        if(ftxtDataNasc.getText().trim().equals("/  /")){
            return true;
        }else if(!ManipulateDates.isValidDate(ftxtDataNasc.getText(), "dd/MM/yyyy")){
            JOptionPane.showMessageDialog(null, "Data Incorreta");
            return false;
        }
        return true;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnInserirAlterar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnRemoveImg;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkEmpregado;
    private javax.swing.JFormattedTextField ftxtDataNasc;
    private javax.swing.JFormattedTextField ftxtSalario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDataNasc;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JRadioButton rbtFeminino;
    private javax.swing.JRadioButton rbtMasculino;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}

import java.util.ArrayList;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;


public class TelaAdministrador extends JPanel{

    private JPanel telaAdministrador;

    private JLabel lblTitulo;
    private JLabel lblID;
    private JLabel lblFabricante;
    private JLabel lblCategoriaIoT;
    private JLabel lblNome;
    private JLabel lblLocal;

    private JTextField txtNome;
    private JTextField txtLocal;

    private JComboBox<String> cboxID;
    private JComboBox<String> cboxFabricante;
    private JComboBox<String> cboxCategoriaIoT;

    private JButton btnRemover;
    private JButton btnAdicionarAlterar;

    private ArrayList<String> listaComboBoxIDs;
    private ArrayList<String> listaComboBoxFabricantes;
    private ArrayList<String> listaComboBoxCategoriasIoTs;

    private static final int TELA_LARGURA = 500;
    private static final String TEXTO_BOTAO_INCLUIR = "Incluir";
    private static final String TEXTO_BOTAO_SALVAR = "Salvar Alterações";




    public TelaAdministrador (){

        listaComboBoxIDs = new ArrayList<String>();
        listaComboBoxFabricantes = new ArrayList<String>();
        listaComboBoxCategoriasIoTs = new ArrayList<String>();

        this.getListaIDs();
        this.getListaFabricantes();
        this.getListaCategoriasIoTs();
        
        CriarTela();
    }

    private void CriarTela(){

        telaAdministrador = this;
        telaAdministrador.setLayout(null);

        ConstruirLayout();
    }

    private void ConstruirLayout(){


        telaAdministrador.setSize(TELA_LARGURA, 500);


        lblTitulo = new JLabel("Gerenciamento de IoTs");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 30, 500, 25);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(20f));
        telaAdministrador.add(lblTitulo);
        
        lblID = new JLabel("ID");
        lblID.setBounds(80, 95, 200, 25);
        telaAdministrador.add(lblID);

        lblCategoriaIoT = new JLabel("Categoria IoT");
        lblCategoriaIoT.setBounds(80, 130, 200, 25);
        telaAdministrador.add(lblCategoriaIoT);

        lblFabricante = new JLabel("Fabricante");
        lblFabricante.setBounds(80, 165, 200, 25);
        telaAdministrador.add(lblFabricante);

        lblNome = new JLabel("Nome");
        lblNome.setBounds(80, 200, 200, 25);
        telaAdministrador.add(lblNome);

        lblLocal = new JLabel("Localizacao");
        lblLocal.setBounds(80, 235, 200, 25);
        telaAdministrador.add(lblLocal);

        txtNome = new JTextField();
        txtNome.setBounds(190, 200, 200, 25);
        telaAdministrador.add(txtNome);

        txtLocal = new JTextField();
        txtLocal.setBounds(190, 235, 200, 25);
        telaAdministrador.add(txtLocal);

        cboxID = new JComboBox<String>();
        cboxID.setBounds(190, 95, 200, 25);
        cboxID = preencherComboBox(cboxID, listaComboBoxIDs);
        cboxID.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent event){
        
                JComboBox<String> cb = (JComboBox<String>) event.getSource();
                String ID = (String)cb.getSelectedItem();
                AtualizarCampos(ID);
            }
        });
        telaAdministrador.add(cboxID);

        cboxCategoriaIoT = new JComboBox<String>();
        cboxCategoriaIoT.setBounds(190, 130, 200, 25);
        cboxCategoriaIoT = preencherComboBox(cboxCategoriaIoT, listaComboBoxCategoriasIoTs);
        telaAdministrador.add(cboxCategoriaIoT);

        cboxFabricante = new JComboBox<String>();
        cboxFabricante.setBounds(190, 165, 200, 25);
        cboxFabricante = preencherComboBox(cboxFabricante, listaComboBoxFabricantes);
        telaAdministrador.add(cboxFabricante);

        btnAdicionarAlterar = new JButton(TEXTO_BOTAO_INCLUIR);
        btnAdicionarAlterar.setBounds(80, 280, 190, 50);
        btnAdicionarAlterar.setBackground(Color.GREEN.darker());
        btnAdicionarAlterar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                AdicionarAlterarIoT(e.getActionCommand());
            }
        });
        telaAdministrador.add(btnAdicionarAlterar);
        
        btnRemover = new JButton("Remover");
        btnRemover.setBounds(280, 280, 110, 50);
        btnRemover.setBackground(Color.ORANGE);
        btnRemover.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                RemoverIoT();               
            }
        });
        telaAdministrador.add(btnRemover);
        

        telaAdministrador.setVisible(true);
    }



    private JComboBox<String> preencherComboBox(JComboBox<String> campoComboBox, ArrayList<String> listaItens){

        for (String item : listaItens) {

            campoComboBox.addItem(item);            
        }

        return campoComboBox;
    }



    // private ArrayList<String> getListaIDs(){
    private void getListaIDs(){

        ListaIoTs listaIoTs = new ListaIoTs();
        ArrayList<IoTs> lista = listaIoTs.getListaIoTs();

        listaComboBoxIDs.clear();
        listaComboBoxIDs.add("");

        for (IoTs item : lista) {

            listaComboBoxIDs.add(Integer.toString(item.Id));
        }
    }



    private void getListaCategoriasIoTs(){
        // private ArrayList<String> getListaCategoriasIoTs(){

        ListaCategoriasIoTs listaCategoriasIoTs = new ListaCategoriasIoTs();
        ArrayList<CategoriasIoTs> lista = listaCategoriasIoTs.getListaCategoriasIoTs();
        ArrayList<String> listaCategorias = new ArrayList<String>();

        listaCategorias.add("");

        for (CategoriasIoTs item : lista) {

            listaCategorias.add(item.Categoria);
        }

        listaComboBoxCategoriasIoTs.clear();
        listaComboBoxCategoriasIoTs = listaCategorias;
    }



    private void getListaFabricantes(){
        // private ArrayList<String> getListaFabricantes(){

        ListaFabricantes listaFabricantes = new ListaFabricantes();
        ArrayList<Fabricantes> lista = listaFabricantes.getListaFabricantes();
        ArrayList<String> listaNomesFabricantes = new ArrayList<String>();

        listaNomesFabricantes.add("");

        for (Fabricantes item : lista) {

            listaNomesFabricantes.add(item.Fabricante);
        }


        listaComboBoxFabricantes.clear();
        listaComboBoxFabricantes = listaNomesFabricantes;
    }



    private
     void AtualizarCampos(String ID){

        int idIoT = 0;

        try{
            idIoT = Integer.parseInt(ID);
        }
        catch (Exception e){

            this.cboxID.setSelectedItem("");
            this.txtNome.setText("");
            this.txtLocal.setText("");
            this.cboxFabricante.setSelectedIndex(0);
            this.cboxCategoriaIoT.setSelectedIndex(0);
            this.btnAdicionarAlterar.setText(TEXTO_BOTAO_INCLUIR);

            return;
        }



        IoTs itemIoT = new IoTs();
        ListaIoTs listaIoTs = new ListaIoTs();

        itemIoT = listaIoTs.getIoT(idIoT);

        // Altera o Texto do Botão
        this.btnAdicionarAlterar.setText(TEXTO_BOTAO_SALVAR);

        // Altera os Campos de Texto
        this.txtNome.setText(itemIoT.Nome);
        this.txtLocal.setText(itemIoT.Localizacao);


        // Altera ComboBox Fabricante
        if(itemIoT.NomeFabricante != null && itemIoT.NomeFabricante != ""){

            int indice = 0;
            for (String item : listaComboBoxFabricantes) {

                if(item.equals(itemIoT.NomeFabricante)){
                    this.cboxFabricante.setSelectedIndex(indice);
                }
                
                indice++;
            }
        }
        else{
            this.cboxFabricante.setSelectedIndex(0);
        }


        // Altera ComboBox Categoria
        if(itemIoT.NomeCategoria != null && itemIoT.NomeCategoria != ""){
            
            int indice = 0;
            for (String item : listaComboBoxCategoriasIoTs) {

                if(item.equals(itemIoT.NomeCategoria)){

                    this.cboxCategoriaIoT.setSelectedIndex(indice);
                }

                indice++;
            }
        }
        else{
            this.cboxCategoriaIoT.setSelectedIndex(0);
        }

    }



    private void AdicionarAlterarIoT(String acaoExecutada){

        IoTs novoRegistro = new IoTs();

        novoRegistro.Id = 0;
        novoRegistro.CategoriaId = 0;
        novoRegistro.FabricanteId = null;
        novoRegistro.Nome = txtNome.getText();
        novoRegistro.Localizacao = txtLocal.getText();
        novoRegistro.NomeFabricante = cboxFabricante.getSelectedItem().toString();
        novoRegistro.NomeCategoria = cboxCategoriaIoT.getSelectedItem().toString();

        // Obtem o ID da Categoria Selecionada
        ListaCategoriasIoTs listaCategoriasIoTs = new ListaCategoriasIoTs();                     
        for (CategoriasIoTs item : listaCategoriasIoTs.getListaCategoriasIoTs()) {                    
            if(item.Categoria.equals(novoRegistro.NomeCategoria)){
                novoRegistro.CategoriaId = item.Id;
            }
        }


        // Caso o ID não seja encontrado, exibe mensagem de erro.
        if(!(novoRegistro.CategoriaId > 0)){
            JOptionPane.showMessageDialog(this, "O campo Categoria do IoT é Obrigatório.", "Erro !", JOptionPane.ERROR_MESSAGE);
            return;
        }


        // Obtem o ID do Fabricante Selecionado
        if(novoRegistro.NomeFabricante.length() > 0){
            ListaFabricantes listaFabricantes = new ListaFabricantes();                     
            for (Fabricantes item : listaFabricantes.getListaFabricantes()) {                    
                if(item.Fabricante.equals(novoRegistro.NomeFabricante)){
                    novoRegistro.FabricanteId = item.Id;
                }
            }
        }
        

        boolean resultado = false;
        ListaIoTs listaIoTs = new ListaIoTs();

        // ALTERAR REGISTRO JÁ EXISTENTE
        if(acaoExecutada.equals(TEXTO_BOTAO_SALVAR)){
            novoRegistro.Id = Integer.parseInt(cboxID.getSelectedItem().toString());
            resultado = listaIoTs.atualizarIoT(novoRegistro);

            if(resultado){
                JOptionPane.showMessageDialog(this, "Registro Alterado com Sucesso !");
            AtualizarCampos(null);
                return;
            }
    
            JOptionPane.showMessageDialog(this, "Falha ao Alterar o Registro.", "Erro !", JOptionPane.ERROR_MESSAGE);
            return;
        }


        // INCLUIR NOVO REGISTRO
        resultado = listaIoTs.incluirIoT(novoRegistro);

        if(resultado){
            JOptionPane.showMessageDialog(this, "Registro Incluído com Sucesso !");
            RecarregarListaIDs();
            return;
        }

        JOptionPane.showMessageDialog(this, "Falha ao Incluir o Registro.", "Erro !", JOptionPane.ERROR_MESSAGE);
        return; 
    }



    private void RemoverIoT(){

        int idIoT = 0;
        boolean resultado = false;
        ListaIoTs listaIoTs = new ListaIoTs();

        try{

            idIoT = Integer.parseInt(cboxID.getSelectedItem().toString());
            int confirmacao = JOptionPane.showConfirmDialog(
                                                             this
                                                            ,"Confirma Exclusão do Registro ?"
                                                            ,"Excuir Registro"
                                                            ,JOptionPane.YES_NO_OPTION
                                                            ,JOptionPane.ERROR_MESSAGE
                                                            );

            if(confirmacao == JOptionPane.YES_OPTION){

                resultado = listaIoTs.excluirIoT(idIoT);
                if(resultado){
                    JOptionPane.showMessageDialog(this, "Registro Excluído com Sucesso !");
                    RecarregarListaIDs();
                    return;
                }

                JOptionPane.showMessageDialog(this, "Falha ao Excluir o Registro.", "Erro !", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        catch(Exception e){
        }
    }



    private void RecarregarListaIDs(){

        getListaIDs();
        cboxID.removeAllItems();
        cboxID = preencherComboBox(cboxID, listaComboBoxIDs);
        AtualizarCampos(null);
    }



    public JComponent getTelaAdministrador(){

        return telaAdministrador;
    }
    
}

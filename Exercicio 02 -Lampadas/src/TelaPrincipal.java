
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Component;



public class TelaPrincipal extends JFrame implements ActionListener{

    private JMenuBar barraMenu;
    private JPanel painel;
    private Container containerTelaPrincipal;
    private ArrayList<Tela> listaTelas;


    public TelaPrincipal(ArrayList<Tela> listaTelas){

        if(containerTelaPrincipal == null)
        {
            this.listaTelas = listaTelas;
            containerTelaPrincipal = getContentPane();
            // containerTelaPrincipal.setLayout(null);
            // containerTelaPrincipal.setLayout(new BoxLayout(containerTelaPrincipal, BoxLayout.PAGE_AXIS));
            containerTelaPrincipal.setLayout(new BorderLayout());
            
            ConfigurarMenu();
            MontarTela(null);
            ConfigurarJFrame();



            painel = new JPanel();
            ArrayList<String> listaIDs = new ArrayList<String>();
            ArrayList<String> listaTiposIoTs = new ArrayList<String>();
            listaIDs.add("1");
            listaIDs.add("2");
            listaIDs.add("3");
            listaTiposIoTs.add("Lâmpada");
            listaTiposIoTs.add("Sensor Temperatura");
            // TelaAdministrador teste = new TelaAdministrador();
            // MontarTela(teste.getTelaAdministrador());
            TelaLampadas teste = new TelaLampadas();
            MontarTela(teste.getTelaUsuario());
        }
    }



    private void ConfigurarJFrame(){

        setTitle("Gerenciador de IoTs");

        setSize(500, 500);
        setLocationRelativeTo(null); // Centraliza a Tela.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }



    private void ConfigurarMenu(){

        barraMenu = new JMenuBar();
        
        JMenuItem itemMenu = null;

        JMenu menuOpcoes = new JMenu("Opções");
        menuOpcoes.setAlignmentX(Component.LEFT_ALIGNMENT);

        JMenu menuListaIoTs = new JMenu("Monitorar IoTs");
        menuListaIoTs.setAlignmentX(Component.LEFT_ALIGNMENT);

        for (Tela item : listaTelas) {
            
            switch (item.menu){

                case OPCOES:
                    itemMenu = new JMenuItem(item.nomeTela);
                    itemMenu.addActionListener(this);
                    menuOpcoes.add(itemMenu);
                    break;

                case LISTA_IOTS:
                    itemMenu = new JMenuItem(item.nomeTela);
                    itemMenu.addActionListener(this);
                    menuListaIoTs.add(itemMenu);
                    break;
            }
        }
        
        // // Menu Opções
        // JMenu menuOpcoes = new JMenu("Opções"); 

        // JMenuItem menuItemAdministrador = new JMenuItem("Administrador");
        // menuItemAdministrador.addActionListener(this);
        // menuOpcoes.add(menuItemAdministrador);

        // JMenuItem menuItemUsuario = new JMenuItem("Usuário"); 
        // menuItemUsuario.addActionListener(this);
        // menuOpcoes.add(menuItemUsuario);



        // // Menu Lista de IoTs
        // JMenu menuListaIoTs = new JMenu("Lista de IoTs");

        // JMenuItem menuItemLampadas = new JMenuItem("Lâmpadas");
        // menuItemLampadas.addActionListener(this);
        // menuListaIoTs.add(menuItemLampadas);

        // JMenuItem menuItemSensores = new JMenuItem("Sensores");
        // menuItemSensores.addActionListener(this);
        // menuListaIoTs.add(menuItemSensores);

        // JMenuItem menuItemTodos = new JMenuItem("Todos os IoTs");
        // menuItemTodos.addActionListener(this);
        // menuListaIoTs.add(menuItemTodos);


        barraMenu.add(menuOpcoes);
        barraMenu.add(menuListaIoTs);


    }



    private void MontarTela(JComponent tela){

        containerTelaPrincipal.setVisible(false);

        containerTelaPrincipal.removeAll();
        // containerTelaPrincipal.add(BorderLayout.NORTH, barraMenu);
        // containerTelaPrincipal.add(barraMenu, BorderLayout.NORTH);
        // containerTelaPrincipal.add(barraMenu);
        containerTelaPrincipal.add(barraMenu, BorderLayout.PAGE_START);

        if(tela != null){
            // containerTelaPrincipal.add(tela);
            // containerTelaPrincipal.add(tela, BorderLayout.PAGE_END);
            containerTelaPrincipal.add(tela, BorderLayout.CENTER);
        }
        // containerTelaPrincipal.repaint();
        containerTelaPrincipal.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {


        for (Tela item : listaTelas) {

            if(item.nomeTela == e.getActionCommand()){
                System.out.println(e.getActionCommand());
                MontarTela(item.tela);
                return;
            }            
        }


        // switch(e.getActionCommand()){

        //     case "Administrador":
        //         System.out.println(e.getActionCommand());
        //         MontarTela(null);
        //         break;

        //     case "Usuário":
        //         System.out.println(e.getActionCommand());
        //         MontarTela(null);
        //         break;

        //     case "Lâmpadas":
        //         System.out.println(e.getActionCommand());
        //         MontarTela(null);
        //         break;

        //     case "Sensores":
        //         System.out.println(e.getActionCommand());
        //         MontarTela(null);
        //         break;

        //     case "Todos os IoTs":
        //         System.out.println(e.getActionCommand());
        //         MontarTela(null);
        //         break;
        // }
    }
    
}

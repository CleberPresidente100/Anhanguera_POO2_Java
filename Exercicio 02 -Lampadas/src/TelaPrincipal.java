
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.BorderLayout;



public class TelaPrincipal extends JFrame implements ActionListener{

    private JMenuBar barraMenu;
    private Container containerTelaPrincipal;
    private ArrayList<Tela> listaTelas;


    public TelaPrincipal(ArrayList<Tela> listaTelas){
    // public TelaPrincipal(){

        if(containerTelaPrincipal == null)
        {
            this.listaTelas = listaTelas;
            containerTelaPrincipal = getContentPane();
            
            ConfigurarMenu();
            MontarTela(null);
            ConfigurarJFrame();
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
        JMenu menuListaIoTs = new JMenu("Lista de IoTs");

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

        containerTelaPrincipal.removeAll();
        containerTelaPrincipal.add(BorderLayout.NORTH, barraMenu);

        if(tela != null){
            containerTelaPrincipal.add(BorderLayout.AFTER_LAST_LINE, tela);
        }

        containerTelaPrincipal.repaint();
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

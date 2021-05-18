
import javax.swing.*;
import java.awt.event.*;
import java.awt.Container;
import java.awt.BorderLayout;



public class TelaPrincipal extends JFrame implements ActionListener{

    JMenuBar barraMenu = null;
    private TelaPrincipal telaPrincipal = null;
    private JScrollPane painelTelaPrincipal = null;
    private Container containerTelaPrincipal = null;


    // public TelaPrincipal(JFrame telaAdministrador, JFrame telaUsuario, JComponent listaIoTs){
    public TelaPrincipal(){

        if(telaPrincipal == null)
        {
            telaPrincipal = this;
            painelTelaPrincipal = new JScrollPane();
            containerTelaPrincipal = getContentPane();
            // telaUsuario = new TelaUsuario();
            
            ConfigurarMenu();
            MontarTela();
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
        
        // Menu Opções
        JMenu menuOpcoes = new JMenu("Opções"); 

        JMenuItem menuItemAdministrador = new JMenuItem("Administrador");
        menuItemAdministrador.addActionListener(this);
        menuOpcoes.add(menuItemAdministrador);

        JMenuItem menuItemUsuario = new JMenuItem("Usuário"); 
        menuItemUsuario.addActionListener(this);
        menuOpcoes.add(menuItemUsuario);



        // Menu Lista de IoTs
        JMenu menuListaIoTs = new JMenu("Lista de IoTs");

        JMenuItem menuItemLampadas = new JMenuItem("Lâmpadas");
        menuItemLampadas.addActionListener(this);
        menuListaIoTs.add(menuItemLampadas);

        JMenuItem menuItemSensores = new JMenuItem("Sensores");
        menuItemSensores.addActionListener(this);
        menuListaIoTs.add(menuItemSensores);

        JMenuItem menuItemTodos = new JMenuItem("Todos os IoTs");
        menuItemTodos.addActionListener(this);
        menuListaIoTs.add(menuItemTodos);


        barraMenu.add(menuOpcoes);
        barraMenu.add(menuListaIoTs);


    }



    private void MontarTela(){

        containerTelaPrincipal.removeAll();
                System.out.println("Removido");
        containerTelaPrincipal.add(BorderLayout.NORTH, barraMenu);
        containerTelaPrincipal.repaint();
    }



    @Override
    public void actionPerformed(ActionEvent e) {


        switch(e.getActionCommand()){

            case "Administrador":
                MontarTela();
                break;

            case "Usuário":
                System.out.println(e.getActionCommand());
                break;

            case "Lâmpadas":
                System.out.println(e.getActionCommand());
                break;

            case "Sensores":
                System.out.println(e.getActionCommand());
                break;

            case "Todos os IoTs":
                System.out.println(e.getActionCommand());
                break;
        }
    }
    
}

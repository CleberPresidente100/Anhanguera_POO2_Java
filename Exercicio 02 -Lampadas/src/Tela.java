
import javax.swing.JComponent;



public class Tela {

    public String nomeTela;
    public EnumMenus menu;
    public JComponent tela;


    public Tela (String nomeTela, EnumMenus menu, JComponent tela){

        this.nomeTela = nomeTela;
        this.menu = menu;
        this.tela = tela;
    }
}

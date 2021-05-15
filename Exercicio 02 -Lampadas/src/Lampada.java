
public class Lampada implements IoT
{
    private int idLampada;
    private boolean estado;
    private String nome;
    private String localizacao;

    public Lampada()
    {      
        this.idLampada = 0;
        this.estado = false;
        this.nome = null;
        this.localizacao = null;
    }

    @Override
    public void setId(int id) {
        idLampada = id;
    }

    @Override
    public int getId() {
        return idLampada;
    }

    @Override
    public void ligar() {
        estado = true;
    }

    @Override
    public void desligar() {
        estado = false;
    }

    @Override
    public boolean getEstado() {
        return estado;
    }
    
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getLocalizacao() {
        return localizacao;
    }

    @Override
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    
}

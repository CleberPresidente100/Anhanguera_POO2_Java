

// A Interface Comparable é utilizada para realizar a ordenação de objetos da Classe Lampada.
public class Lampada implements IoT, Comparable<Lampada>
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

    // Método da Interface Comparable que realiza a ordenação dos Objetos desta Classe.
    @Override
    public int compareTo(Lampada lampada) {
        return this.idLampada - lampada.getId();
    }
}

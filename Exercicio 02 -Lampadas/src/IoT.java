
public interface IoT
{ 
    int getId();
    void setId(int id);

    void ligar();
    void desligar();
    boolean getEstado();

    String getNome();
    void setNome(String nome);

    String getLocalizacao();
    void setLocalizacao(String localizacao);
}

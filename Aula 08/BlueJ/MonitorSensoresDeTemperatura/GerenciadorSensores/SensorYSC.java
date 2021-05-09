package GerenciadorSensores;


public class SensorYSC implements ISensorTemperatura{

    private int idSensor;
    private String temperatura;
    private GerenciadorTemperatura geradorTemperatura;

    private static final int temperaturaMinima = 0;
    private static final int temperaturaMaxima = 80;



    public SensorYSC(int idSensor){
        
        this.idSensor = idSensor;
        geradorTemperatura = new GerenciadorTemperatura();
    }



    public String getNomeFabricante() {
        return "YSC";
    }



    public String getNomeEscala() {
        return "Celsius";
    }



    public String getTemperatura() {

        String novaTemperatura = geradorTemperatura.lerTemperatura(temperaturaMinima, temperaturaMaxima);

        if(novaTemperatura != null){
            temperatura = novaTemperatura;
        }

        return temperatura;
    }



    public int getIdSensor() {
        return idSensor;
    }
}

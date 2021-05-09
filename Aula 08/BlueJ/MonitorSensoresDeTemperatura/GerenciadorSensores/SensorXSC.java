package GerenciadorSensores;


public class SensorXSC implements ISensorTemperatura{

    private int idSensor;
    private String temperatura;
    private GerenciadorTemperatura geradorTemperatura;

    private static final int temperaturaMinima = -15;
    private static final int temperaturaMaxima = 45;



    public SensorXSC(int idSensor){
        
        this.idSensor = idSensor;
        geradorTemperatura = new GerenciadorTemperatura();
    }



    public String getNomeFabricante() {
        return "XSC";
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

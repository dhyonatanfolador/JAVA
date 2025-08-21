package presencial.class_III.atividade_I.model;

public class CelularCSmart extends Celular {
    public CelularCSmart(String marca, String modelo, String cor) {
        super(marca, modelo, cor);
    }
    public CelularCSmart() {}

    //POLIMORFISMO
    @Override
    public void carregar() {
        System.out.println("Carregando Celular Smart");
    }
    @Override
    public void descarregar() {
        System.out.println("Descarregando Celular Smart");
    }

    //POLIMORFIMO DE SOBRECARGA
    public void bateria(int carga) {
        System.out.println("Carregando " + carga + "% de Bateria");
    }
    public void bateria(double carga) {
        System.out.println("Carregando " + carga + "% de Bateria");
    }

    String internet;
    String aplicativo;
    String fotos;

    //GETTER AND SETTER
    public String getInternet() {
        return internet;
    }
    public void setInternet(String internet) {
        this.internet = internet;
    }
    public String getAplicativo() {
        return aplicativo;
    }
    public void setAplicativo(String aplicativo) {
        this.aplicativo = aplicativo;
    }
    public String getFotos() {
        return fotos;
    }
    public void setFotos(String fotos) {
        this.fotos = fotos;
    }
}

package presencial.class_III.atividade_I.model;

public class CelularConvencional extends Celular {
    public CelularConvencional(String marca, String modelo, String cor) {
        super(marca, modelo, cor);
    }
    public CelularConvencional() {}

    //POLIMORFISMO
    @Override
    public void carregar() {
        System.out.println("Carregando Celular Convencional");
    }
    @Override
    public void descarregar() {
        System.out.println("Descarregando Celular Convencional");
    }

    //POLIMORFISMO DE SOBRECARGA
    public void bateria(int carga) {
        System.out.println("Carregando " + carga + "% de Bateria");
    }
    public void bateria(double carga) {
        System.out.println("Carregando " + carga + "% de Bateria");
    }

    String chamada;
    String mensagem;
    String lanterna;

    //GETTER AND SETTER
    public String getChamada() {
        return chamada;
    }
    public void setChamada(String chamada) {
        this.chamada = chamada;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    public String getLanterna() {
        return lanterna;
    }
    public void setLanterna(String lanterna) {
        this.lanterna = lanterna;
    }
}

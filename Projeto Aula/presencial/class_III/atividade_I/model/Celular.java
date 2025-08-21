package presencial.class_III.atividade_I.model;

public abstract class Celular {
    String marca;
    String modelo;
    String cor;
    String carregar;
    String descarregar;
    String bateria;
    Void carga;

    public Celular(String marca, String modelo, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }
    public Celular() {}

    //GETTER AND SETTER
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    //FUNCOES ABSTRATAS
    public abstract void carregar();
    public abstract void descarregar();
}

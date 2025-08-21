package aulas.class_IV.interfaces;

public class Cachorro extends Animal implements Mamifero{

    public Cachorro(int idade) {
        super(idade);
    }

    void comer() {}
    void dormir() {}
    public void amamentar() {}
}

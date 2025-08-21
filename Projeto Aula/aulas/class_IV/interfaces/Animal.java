package aulas.class_IV.interfaces;

public abstract class Animal {

    int idade;

    Animal(int idade) {
        this.idade = idade;
    }

    //METODOS ABSTRATOS
    abstract void comer();
    abstract void dormir();
}

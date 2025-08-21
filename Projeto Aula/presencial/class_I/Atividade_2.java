package presencial.class_I;

public class Atividade_2 {

    public static void main(String[] args) {
        int[] vetor = new int[10];
        int impar = 1;

        for (int i = 0; i < 10; i++) {
            vetor[i] = impar;
            impar = impar + 2;
        }

        System.out.println("Valores impares no vetor:");
        for (int i = 0; i < 10; i++) {
            System.out.println(vetor[i]);
        }
    }
}

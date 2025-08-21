package situations.SA2;

public class SA2_4 {

	public static void desenhar_linha(int tamanho) {
        for(int i = 0; i < tamanho; ++i) {
            System.out.print("_");
        }

    }

    public static void main(String[] args) {
        desenhar_linha(20);
    }
}

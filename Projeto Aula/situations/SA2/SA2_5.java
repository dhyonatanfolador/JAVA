package situations.SA2;

import java.util.List;

public class SA2_5 {

	public static <T> void imprimir_lista(List<T> lista) {
        for(int i = 0; i < lista.size(); ++i) {
            System.out.println(i + 1 + ": " + String.valueOf(lista.get(i)));
        }

    }

    public static void main(String[] args) {
        List<String> lista = List.of("Um", "Dois", "Tres", "Quatro");
        imprimir_lista(lista);
    }
}

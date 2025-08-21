package situations.SA2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SA2_1 {

	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(5, 7, 2, 9, 4, 1, 3);
		
        System.out.println("Tamanho da lista: " + lista.size());
        System.out.println("Maior valor da lista: " + String.valueOf(Collections.max(lista)));
        System.out.println("Menor valor da lista: " + String.valueOf(Collections.min(lista)));
        
        int soma = lista.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Soma de todos os valores: " + soma);
        
        List<Integer> crescente = lista.stream().sorted().toList();
        System.out.println("Lista em ordem crescente: " + String.valueOf(crescente));
        
        List<Integer> decrescente = lista.stream().sorted(Collections.reverseOrder()).toList();
        System.out.println("Lista em ordem decrescente: " + String.valueOf(decrescente));
	}
}

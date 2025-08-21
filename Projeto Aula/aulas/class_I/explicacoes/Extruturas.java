package aulas.class_I.explicacoes;

public class Extruturas {
    public static void main(String[] args) {

        //ESTRUTURA DE REPETICAO UTILIZANDO 'FOR'
        /*for(int i = 0; i < 5; i++) {
            System.out.println("Bom dia!");
        }*/


        //ESTRUTURA DE 'IF/ELSE'
        /*int resultado = 4;
        if (resultado > 0) {
            System.out.println("Positivo");
        } else {
            System.out.println("Negativo");
        }*/

        //OUTRO METODO DE REALIZAR UM 'IF/ELSE'
        /*int resultado = 4;
        String texto = (resultado > 0) ? "Positivo" : "Negativo";
        System.out.println(texto);*/


        //UTILIZANDO 'ARRAYS'
        /*String nomes[] = {"Joao", "Maria"};
        int total = nomes.length;
        int ponteiro = 0;

        for(ponteiro = 0; ponteiro < total; ponteiro++) {
            System.out.println(nomes[ponteiro]);
        }*/

        //OUTRA MANEIRA
        /*String nomes[] = {"Joao", "Maria"};

        for(String nome : nomes) {
            System.out.println(nome);
        }*/


        //UTILIZANDO SCANNER PARA LEITURA DE DADOS
        /*try (Scanner leitor = new Scanner(System.in)) {
            System.out.print("Digite sua idade: ");
            int idade = leitor.nextInt();

            System.out.println("Ah, sua idade é " + idade);
        }*/
    }
}

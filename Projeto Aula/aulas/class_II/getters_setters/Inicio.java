package aulas.class_II.getters_setters;

//AULA_3
public class Inicio {

    public static void main(String[] args) {

        //DEFINICAO   -   INSTANCIA
        Usuario dhyonatan = new Usuario();
        Usuario lucas = new Usuario();

        //ATRIBUICAO DE CARACTERISTICA
        dhyonatan.setNome("Dhyonatan Folador");
        dhyonatan.setIdade(16);

        lucas.setNome("Lucas Santini");
        lucas.setIdade(17);

        //MENSAGENS
        System.out.println(dhyonatan.getNome() + " - " + dhyonatan.getIdade() + " anos");
        System.out.println("Login: " + dhyonatan.Esta_Logado() + "\n");

        System.out.println(lucas.getNome() + " - " + lucas.getIdade() + " anos");
        System.out.println("Login: " + lucas.Esta_Logado() + "\n");

    }
}

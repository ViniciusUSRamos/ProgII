import java.util.Scanner;
//import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        char opcao;
        Menu menu = new Menu();
        Scanner leitor = new Scanner(System.in);
        
        String[] inputTodos = leitor.nextLine().split("#"); //faz a leitura dos dados, separando por "#" e armazena em uma array de strings

        for(Integer i = 0; i <= inputTodos.length - 1; i++) {
            String[] nomes = new String[500];
            Integer[] idades = new Integer[500];
            
            if(i%2 == 0 || i == 0){
                nomes[i] = inputTodos[i];
            }
            if(i%2 != 0 && i != 0){
                idades[i] = Integer.parseInt(inputTodos[i]);
            }
        }

        for(int i = 0; i <= inputTodos.length - 1; i++){
            System.out.println(inputTodos[i]);
        }

        while (true) {
            opcao = leitor.next().charAt(0);

            switch (opcao) {
                case '1':
                    menu.nomeCrescente(nomes[]);
                    break;
                case '2':
                    menu.nomeDecrescente(nomes[]);
                    break;
                case '3':
                    menu.idadeCrescente(idades[]);
                    break;
                case '4':
                    menu.idadeDecrescente(idades[]);
                    break;
                case '5':
                    String nome = leitor.nextLine();
                    menu.buscaNome(nome, nomes[]);
                case '6':
                    nome = leitor.nextLine();
                    menu.contaNomes(nome, nomes[]);
                case '7':
                    menu.sair();
            
                default:
                    break;
            }
        }


        leitor.close();
    }

}

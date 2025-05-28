//VERSAO FUNCIONANDO (28/05/2025)
import java.util.Arrays;
//import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Menu {

    public static void main(String[] args) {
        int opcao;
        Menu menu = new Menu();
        Scanner leitor = new Scanner(System.in);


        if (args.length == 0) {
            //System.out.println("Informe o nome do arquivo como argumento.");
            return;
        }

        String caminhoArquivo = args[0];
        String conteudoArquivo = "";

        try {
            File arquivo = new File(caminhoArquivo);
            Scanner leitorArquivo = new Scanner(arquivo);

            while (leitorArquivo.hasNextLine()) {
                conteudoArquivo += leitorArquivo.nextLine() + "#"; // Junta tudo em uma linha só
            }

            leitorArquivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + caminhoArquivo);
            return;
        }

        String[] inputTodos = conteudoArquivo.split("#");


        int totalPessoas = inputTodos.length / 2; // Arredonda pra baixo se ímpar
        String[] nomes = new String[totalPessoas];
        int[] idades = new int[totalPessoas];
        int iNome = 0;
        int iIdade = 0;

        for (int i = 0; i < totalPessoas * 2; i++) {
            if (i % 2 == 0) {
                nomes[iNome++] = inputTodos[i];
            } else {
                idades[iIdade++] = Integer.parseInt(inputTodos[i]);
            }
        }

        /*for(int i = 0; i <= inputTodos.length - 1; i++){
            if (nomes[i] != null) {
                System.out.println(nomes[i] + "#" + idades[i]);
            }
        }*/
        

        while (true) {
            System.out.print("1 - Listar ordenado por nome crescente\n" +
                        "2 - Listar ordenado por nome decrescente\n" +
                        "3 - Listar ordenado por idade crescente\n" + 
                        "4 - Listar ordenado por idade decrescente\n" + 
                        "5 - Localizar um nome\n" + 
                        "6 - Contar ocorrências de um primeiro nome\n" + 
                        "7 - Sair\n" + 
                        "Digite sua opcao: ");

            opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    menu.nomeCrescente(nomes, idades);
                    break;
                case 2:
                    menu.nomeDecrescente(nomes, idades);
                    break;
                case 3:
                    menu.idadeCrescente(idades, nomes);
                    break;
                case 4:
                    menu.idadeDecrescente(idades, nomes);
                    break;
                case 5:
                    leitor.nextLine();
                    String nome = leitor.nextLine();
                    System.out.println(menu.buscaNome(nome, nomes));
                    break;
                case 6:
                    leitor.nextLine(); // limpa quebra de linha
                    nome = leitor.nextLine();
                    System.out.println(menu.contaNomes(nome, nomes));
                    break;
                case 7:
                    menu.sair();
                    break;
            }
        }
    }


    public static void nomeCrescente(String[] nomes, int[] idades) {
        for (int i = 0; i < nomes.length - 1; i++) {
            for (int j = 0; j < nomes.length - 1 - i; j++) {
                if (nomes[j].compareTo(nomes[j + 1]) > 0) {
                    // troca nomes
                    String tempNome = nomes[j];
                    nomes[j] = nomes[j + 1];
                    nomes[j + 1] = tempNome;

                    // troca idades para manter a posicao certa
                    int tempIdade = idades[j];
                    idades[j] = idades[j + 1];
                    idades[j + 1] = tempIdade;
                }
            }
        }
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] != null) {
                System.out.println(nomes[i] + "#" + idades[i]);
            }
        }
    }

    public static void nomeDecrescente(String[] nomes, int[] idades) {
        for (int i = 0; i < nomes.length - 1; i++) {
            for (int j = 0; j < nomes.length - 1 - i; j++) {
                if (nomes[j].compareTo(nomes[j + 1]) < 0) {
                    // troca nomes
                    String tempNome = nomes[j];
                    nomes[j] = nomes[j + 1];
                    nomes[j + 1] = tempNome;

                    // troca idades para manter a posicao certa
                    int tempIdade = idades[j];
                    idades[j] = idades[j + 1];
                    idades[j + 1] = tempIdade;
                }
            }
        }
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] != null) {
                System.out.println(nomes[i] + "#" + idades[i]);
            }
        }
    }

    public static void idadeCrescente(int[] idades, String[] nomes) {
        for (int i = 0; i < idades.length - 1; i++) {
            for (int j = 0; j < idades.length - 1 - i; j++) {
                if (idades[j] > idades[j + 1]) {
                    // troca nomes
                    String tempNome = nomes[j];
                    nomes[j] = nomes[j + 1];
                    nomes[j + 1] = tempNome;

                    // troca idades para manter a posicao certa
                    int tempIdade = idades[j];
                    idades[j] = idades[j + 1];
                    idades[j + 1] = tempIdade;
                }
            }
        }
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] != null) {
                System.out.println(nomes[i] + "#" + idades[i]);
            }
        }
    }

    public static void idadeDecrescente(int[] idades, String[] nomes) {
        for (int i = 0; i < idades.length - 1; i++) {
            for (int j = 0; j < idades.length - 1 - i; j++) {
                if (idades[j] < idades[j + 1]) {
                    // troca nomes
                    String tempNome = nomes[j];
                    nomes[j] = nomes[j + 1];
                    nomes[j + 1] = tempNome;

                    // troca idades para manter a posicao certa
                    int tempIdade = idades[j];
                    idades[j] = idades[j + 1];
                    idades[j + 1] = tempIdade;
                }
            }
        }
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] != null) {
                System.out.println(nomes[i] + "#" + idades[i]);
            }
        }
    }

    public String buscaNome(String nomeBusca, String[] listaNomes){
        //com a lista ordenada, usar busca binaria para encontrar o nome desejado
        Arrays.sort(listaNomes);
        String[] ordenada = listaNomes;
        int contIteracoes = 0;
        int inicio = 0;
        int fim = ordenada.length-1;

        //busca binária para encontrar os nomes
        
        while (inicio <= fim) {
            contIteracoes++;
            int meio = (inicio + fim)/2;
            int compara = nomeBusca.compareTo(ordenada[meio]);

            if (compara == 0) {
                return "EXISTENTE " + contIteracoes;
            }
            else if (compara < 0){
                fim = meio - 1;
            }
            else if(compara > 0){
                inicio = meio + 1;
            }         
        }    
        return "INEXISTENTE " + contIteracoes;    
    }

    public String contaNomes(String nomeBusca, String[] listaNomes){
        //fazer a busca e mostrar a quantidade de vezes que um nome com aquele trecho aparece na busca
        int contNomes = 0;
        // int i = 0;

        for(String nome : listaNomes){
            if (nome.contains(nomeBusca)) {
                contNomes ++;
            }
        }
        

        return contNomes + " OCORRENCIAS";
    }

    public void sair(){
        System.exit(0);
    }
}



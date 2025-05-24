import java.util.Arrays;
import java.util.Collections;

public class Menu {

    //private char opcao;


    public String[] nomeCrescente(String[] listaNomes){
        Arrays.sort(listaNomes);
        return listaNomes;
    }

    public String[] nomeDecrescente(String[] listaNomes){
        Arrays.sort(listaNomes, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        return listaNomes;
    }

    public int[] idadeCrescente(int[] idades){
        Arrays.sort(idades);
        return idades;
    }

    public Integer[] idadeDecrescente(int[] idades){
        //metodo sort com comparador nao funciona para int[], converter para integer antes de seguir
        Integer[] idadesInteger = Arrays.stream(idades).boxed().toArray(Integer[]::new);
        Arrays.sort(idadesInteger, Collections.reverseOrder());
        return idadesInteger;
    }

    public String buscaNome(String nomeBusca, String[] listaNomes){
        //com a lista ordenada, usar busca binaria para encontrar o nome desejado
        String[] ordenada = nomeCrescente(listaNomes);
        int contIteracoes = 0;
        int inicio = 0;
        int fim = ordenada.length-1;

        //busca binária para encontrar os nomes
        
        while (true) {
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

            return "INEXISTENTE " + contIteracoes;         
        }        
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
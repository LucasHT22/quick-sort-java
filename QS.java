package quicksort;

public class QS {

    // Variável para contar o número de trocas
    public int trocasNum = 0;

    public static void main(String[] args) {
        // Instanciando o objeto QS para chamar métodos
        QS quickSort = new QS();

        // Vetor inicial
        int[] vetor = {9, 1, 3, 4, 2, 0, 8, 5, 7, 6};

        // Mostrando o vetor antes da sortagem
        System.out.println("Vetor antes do Quick Sort:");
        quickSort.exibirVetor(vetor);

        // Chamando o método varrer para sortagem o vetor
        quickSort.varrer(vetor, 0, vetor.length - 1);

        // Mostrando o vetor depois de sortagem
        System.out.println("Vetor depois do Quick Sort:");
        quickSort.exibirVetor(vetor);

        // Mostrando o número total de trocas feitas
        System.out.println("Número de trocas: " + quickSort.trocasNum);
    }

    // Método para fazer a varredura do Quick Sort
    public void varrer(int[] vetor, int inicio, int fim) {
        // While para percorrer os intervalos
        while (inicio < fim) {
            // Encontrar o índice pivot (serve para dividir o vetor)
            int pindex = quebrar(vetor, inicio, fim);

            // Escolher qual lado do vetor continuar ordenando
            // Decidir se ordena o lado da esquerda ou da direita do pivot
            if (pindex - inicio < fim - pindex) {
                varrer(vetor, inicio, pindex - 1);  // Ordena lado da esquerda
                inicio = pindex + 1;  // Muda o índice de início para lado da direita
            } else {
                varrer(vetor, pindex + 1, fim);  // Ordena à direita
                fim = pindex - 1;  // Muda o índice de fim para o lado da esquerda
            }
        }
    }

    // Método para dividir o vetor e encontrar o índice pivot
    public int quebrar(int[] vetor, int inicio, int fim) {
        // O último elemento é pivot
        int pivo = vetor[fim];
        int i = (inicio - 1); // Índice do menor elemento

        // For para organizar os elementos em relação ao pivot
        for (int j = inicio; j < fim; j++) {
            // Se o elemento for menor ou igual ao pivot, coloca ele para esquerda
            if (vetor[j] <= pivo) {
                i++;
                // Troca vetor[i] com vetor[j]
                trocar(vetor, i, j);
            }
        }

        // Troca o pivot com o elemento na posição i+1
        trocar(vetor, i + 1, fim);

        // Retorna o índice do pivot
        return i + 1;
    }

    // Método para fazer a troca e contar as trocas
    public void trocar(int[] vetor, int i, int j) {
        // Faz a troca dos elementos
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;

        // Incrementa o contador de trocas
        trocasNum++;

        // Exibe a troca
        System.out.println("Trocado " + vetor[j] + " com " + vetor[i]);
    }

    // Método para exibir o vetor
    public void exibirVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    } 
}
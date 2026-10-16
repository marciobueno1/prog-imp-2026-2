public class Exemplo06_Prova_2026_1 {
    public static void inverterTrecho(int[] v, int inicio, int fim) {
        int aux;
        while (inicio < fim) {
            aux = v[inicio];
            v[inicio] = v[fim];
            v[fim] = aux;
            inicio += 1;
            fim -= 1;
        }
    }

    public static void inverterTrechos(int[] v, int tam) {
        int inicio = 0, fim = 0;
        for (int i = 0; i <= tam; i += 1) {
            if (i == tam || v[i] == 0) {
                fim = i - 1;
                inverterTrecho(v, inicio, fim);
                inicio = i + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] v = { 0, 1, 2, 3, 0, 0, 5, 2, 3, 0, 2, 4 };
        System.out.print(".       Vetor original: ");
        imprimirVetor(v, v.length);
        inverterTrechos(v, v.length);
        System.out.print("Vetor inverção trechos: ");
        imprimirVetor(v, v.length);
    }

        public static void imprimirVetor(int[] v, int n) {
        System.out.print("{");
        if (v.length > 0) {
            System.out.printf(" %2d", v[0]);
            for (int i = 1; i < n; i += 1) {
                System.out.printf(" - %2d", v[i]);
            }
        }
        System.out.println(" }");
    }
}

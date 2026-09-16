import java.util.Random;

public class Exemplo04_Vetor_Ordenacao {
    public static Random random = new Random(7);
    public static final int TAM = 13;
    public static void main(String[] args) {
        double[] numeros = new double[TAM];
        preencherVetorAleatorio(numeros);
        System.out.println("ANTES DA ORDENAÇÃO");
        imprimirVetor(numeros, TAM);
        selectionSort(numeros, TAM);
        System.out.println("\n\nAPÓS A ORDENAÇÃO");
        imprimirVetor(numeros, TAM);
    }

    public static void insertionSort(double[] v, int n) {
        double chave;
        int j;
        for (int i = 1; i <= n - 1; i += 1) {
            chave = v[i];
            j = i - 1;
            while (j >= 0 && chave < v[j]) {
                v[j + 1] = v[j];
                j -= 1;
            }
            v[j + 1] = chave;
        }
    }

    public static void selectionSort(double[] v, int n) {
        int menor;
        double aux;
        for (int i = 0; i < n - 1; i += 1) {
            menor = i;
            for (int j = i + 1; j <= n - 1; j += 1) {
                if (v[j] < v[menor]) {
                    menor = j;
                }
            }
            aux = v[i];
            v[i] = v[menor];
            v[menor] = aux;
        }
    }

    public static void preencherVetorAleatorio(double[] v) {
        for (int i = 0; i < v.length; i += 1) {
            v[i] = random.nextDouble(100.0);
        }
    }

    public static void imprimirVetor(double[] v, int n) {
        System.out.print("{");
        if (v.length > 0) {
            System.out.printf(" %5.2f", v[0]);
            for (int i = 1; i < n; i += 1) {
                System.out.printf(" - %5.2f", v[i]);
            }
        }
        System.out.println(" }");
    }
}

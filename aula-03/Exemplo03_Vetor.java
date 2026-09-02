import java.util.Random;

public class Exemplo03_Vetor {
    public static final int TAM = 12;
    public static Random random = new Random(7);
    public static void main(String[] args) {
        double[] numeros = new double[TAM];
        preencherVetorAleatorio(numeros);
        imprimirVetor(numeros, numeros.length);
    }

    public static void preencherVetorAleatorio(double[] v) {
        for (int i = 0; i < v.length; i += 1) {
            inserirOrdenado(v, i, random.nextDouble(100.0));
            imprimirVetor(v, i + 1);
        }
    }

    public static void inserirOrdenado(double[] v, int n, double x) {
        int i = n - 1;
        while (i >= 0 && x < v[i]) {
            v[i + 1] = v[i];
            i -= 1;
        }
        v[i + 1] = x;
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

    // só pode ser utilizada se o vetor estiver ordenado
    public static int buscaMelhorada(double[] v, int n, int x) {
        int i;
        for (i = 0; i < n; i += 1) {
            if (v[i] >= x) {
                break;
            }
        }
        if (i < n && v[i] == x) {
            return i;
        }
        return -1;
    }
}

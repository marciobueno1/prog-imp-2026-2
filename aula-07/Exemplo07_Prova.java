import java.util.Random;
import java.util.Scanner;

public class Exemplo07_Prova {
    public static Scanner sc = new Scanner(System.in);
    public static Random random = new Random(7);
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        int[] b = { 2, 5, 0, 9, 7 };
        int[] dif = new int[10];
        int tamDif = diferenca(a, a.length, b, b.length, dif);
        System.out.print(". Vetor A: ");
        imprimirVetor(a, a.length);
        System.out.print("  Vetor B: ");
        imprimirVetor(b, b.length);
        System.out.print("Vetor Dif: ");
        imprimirVetor(dif, tamDif);

        int n = 10;
        int[][] triangulo = new int[n][n];
        trianguloPascal(triangulo, n);
        imprimirMatriz(triangulo);
    }

    public static int busca(int[] v, int tam, int x) {
        for (int i = 0; i < tam; i += 1) {
            if (v[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int diferenca(int[] a, int tamA, int[] b, int tamB, int[] dif) {
        int tamDif = 0;
        for (int i = 0; i < tamA; i += 1) {
            if (busca(b, tamB, a[i]) == -1) {
                dif[tamDif] = a[i];
                tamDif += 1;
            }
        }
        return tamDif;
    }

    public static void preencherVetorAleatorio(int[] v) {
        for (int i = 0; i < v.length; i += 1) {
            v[i] = random.nextInt(100);
        }
    }

    public static void imprimirVetor(int[] v, int tam) {
        System.out.print("{");
        if (tam > 0) {
            System.out.printf(" %2d", v[0]);
            for (int i = 1; i < tam; i += 1) {
                System.out.printf(", %2d", v[i]);
            }
        }
        System.out.println(" }");
    }
 
    public static void preencherVetorDigitacao(int[] v) {
        for (int i = 0; i < v.length; i += 1) {
            System.out.printf("Digite o %dº valor:\n", i + 1);
            v[i] = sc.nextInt();
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

    public static void trianguloPascal(int[][] m, int n) {
        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < n; j += 1) {
                if (i < j) {
                    m[i][j] = 0;
                } else if (j == 0 || i == j) {
                    m[i][j] = 1;
                } else {
                    m[i][j] = m[i - 1][j - 1] + m[i - 1][j];
                }
            }
        }
    }

    public static void imprimirMatriz(int[][] m) {
        for (int i = 0; i < m.length; i += 1) {
            for (int j = 0; j < m[0].length; j += 1) {
                System.out.printf("%3d ", m[i][j]);
            }
            System.out.println();
        }
    }
}

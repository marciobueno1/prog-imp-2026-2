/*
Faça um programa em Java que peça para o usuário preencher uma matriz
com 5 linhas e 4 colunas, depois imprima: a matriz digitada, o maior 
valor da matriz, a quantidade de pares e o somatório por linha.
 
OBS: cada item solicitado deve ser feito numa função própria.
 */
import java.util.Scanner;

public class Exemplo05_Matriz {
    public static final int QTD_LINHAS = 5;
    public static final int QTD_COLUNAS = 4;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matriz = new int[QTD_LINHAS][QTD_COLUNAS];
        preencherMatriz(matriz);
        imprimirMatriz(matriz);
    }

    public static void preencherMatriz(int[][] m) {
        for (int i = 0; i < m.length; i += 1) {
            for (int j = 0; j < m[0].length; j += 1) {
                System.out.printf("Digite o valor (%d,%d):\n", i + 1, j + 1);
                m[i][j] = sc.nextInt();
            }
        }
    }

    public static void imprimirMatriz(int[][] m) {
        for (int i = 0; i < m.length; i += 1) {
            for (int j = 0; j < m[0].length; j += 1) {
                System.out.printf("%2d ", m[i][j]);
            }
            System.out.println();
        }
    }

    public static int maiorValorMatriz(int[][] m) {
        int maior = m[0][0];
        for (int i = 0; i < m.length; i += 1) {
            for (int j = 0; j < m[0].length; j += 1) {
                if (m[i][j] > maior) {
                    maior = m[i][j];
                }
            }
        }
        return maior;
    }
}

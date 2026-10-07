/*
Faça um programa em Java que peça para o usuário preencher uma matriz
com 5 linhas e 4 colunas, depois imprima: a matriz digitada, o maior 
valor da matriz, a quantidade de pares e o somatório por linha.
 
OBS: cada item solicitado deve ser feito numa função própria.
 */
import java.util.Scanner;

public class Exemplo05_Matriz {
    public static final int QTD_LINHAS = 5;
    public static final int QTD_COLUNAS = 5;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int posMaiorSoma;
        int[][] matriz = new int[QTD_LINHAS][QTD_COLUNAS];
        int[][] transposta;
        preencherMatriz(matriz);
        transposta = criarMatrizTransposta(matriz);
        System.out.println("Matriz Original:");
        imprimirMatriz(matriz);
        posMaiorSoma = linhaMaiorSomatorio(matriz);
        System.out.println("A linha com o maior somatório é " + (posMaiorSoma + 1));
        System.out.println("\nMatriz Transposta:");
        imprimirMatriz(transposta);
        transpostaInPlace(matriz);
        System.out.println("\nMatriz Transposta In Place:");
        imprimirMatriz(matriz);
        zerarAbaixoDiagPrincSemIF(matriz);
        System.out.println("\nMatriz com valores abaixo da diagonal principal zerados:");
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

    public static void zerarAbaixoDiagPrinc(int[][] m) {
        if (m.length != m[0].length) {
            System.out.println("Matriz não é quadrada, operação não disponível!");
            return;
        }
        for (int i = 0; i < m.length; i += 1) {
            for (int j = 0; j < m[0].length; j += 1) {
                if (i > j) {
                    m[i][j] = 0;
                }
            }
        }
    }

    public static int[][] criarMatrizTransposta(int[][] m) {
        int[][] transp = new int[m[0].length][m.length];
        for (int i = 0; i < transp.length; i += 1) {
            for (int j = 0; j < transp[0].length; j += 1) {
                transp[i][j] = m[j][i];
            }
        }
        return transp;
    }

    public static void transpostaInPlace(int[][] m) {
        int aux;
        if (m.length != m[0].length) {
            System.out.println("Matriz não é quadrada, transposta não pode ser feita!");
            return;
        }
        for (int i = 1; i < m.length; i += 1) {
            for (int j = 0; j < i; j += 1) {
                aux = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = aux;
            }
        }
    }

    public static void zerarAbaixoDiagPrincSemIF(int[][] m) {
        for (int i = 1; i < m.length; i += 1) {
            for (int j = 0; j < i; j += 1) {
                m[i][j] = 0;
            }
        }
    }

    public static int linhaMaiorSomatorio(int[][] m) {
        int soma, maiorSoma = Integer.MIN_VALUE, posMaiorSoma = -1;
        for (int i = 0; i < m.length; i += 1) {
            soma = 0;
            for (int j = 0; j < m[0].length; j += 1) {
                soma += m[i][j];
            }
            // System.out.printf("O somatório da linha %d é %d\n", i + 1, soma);
            if (posMaiorSoma == -1 || soma > maiorSoma) {
                maiorSoma = soma;
                posMaiorSoma = i;
            }
        }
        return posMaiorSoma;
    }
}

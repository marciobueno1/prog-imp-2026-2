import java.util.Scanner;

public class Exemplo02_Vetor {
    public static Scanner sc = new Scanner(System.in);
    public static final int TAM = 15;
    public static void main(String[] args) {
        int posMaiorA, posMaiorB;
        int[] va = new int[TAM];
        int[] vb = new int[TAM];
        System.out.println("====== Preenchimento do Vetor A ======");
        preencherVetorDigitacao(va);
        System.out.println("====== Preenchimento do Vetor B ======");
        preencherVetorDigitacao(vb);
        System.out.print("\nA = ");
        imprimirVetor(va);
        System.out.print("B = ");
        imprimirVetor(vb);
        posMaiorA = posMaiorValor(va);
        System.out.printf("\n\n%d é o maior valor do vetor A e está na %da posição\n",
            va[posMaiorA], posMaiorA + 1);
        posMaiorB = posMaiorValor(vb);
        System.out.printf("%d é o maior valor do vetor B e está na %da posição\n",
            vb[posMaiorB], posMaiorB  + 1);

    }

    public static void preencherVetorDigitacao(int[] v) {
        for (int i = 0; i < v.length; i += 1) {
            System.out.printf("Digite o %dº valor:\n", i + 1);
            v[i] = sc.nextInt();
        }
    }

    public static void imprimirVetor(int[] v) {
        System.out.print("{");
        if (v.length > 0) {
            System.out.printf(" %2d", v[0]);
            for (int i = 1; i < v.length; i += 1) {
                System.out.printf(", %2d", v[i]);
            }
        }
        System.out.println(" }");
    }

    public static int posMaiorValor(int[] v) {
        int maior = 0;
        for (int i = 1; i < v.length; i +=1) {
            if (v[i] > v[maior]) {
                maior = i;
            }
        }
        return maior;
    }
}

public class Exemplo04_Vetor {
    public static final int TAM = 10;
    public static void main(String[] args) {   
        int numero = 25372;
        int[] numDecomposto  = new int[TAM];
        decomposicaoNumero(numDecomposto, numero);
        imprimirVetor(numDecomposto, numDecomposto.length);
    }

    public static void decomposicaoNumero(int[] v, int num) {
        for (int i = v.length - 1; i >= 0; i -= 1) {
            v[i] = num % 10;
            num /= 10;
        }
    }

    public static void imprimirVetor(int[] v, int n) {
        System.out.print("{");
        if (v.length > 0) {
            System.out.printf(" %2d", v[0]);
            for (int i = 1; i < n; i += 1) {
                System.out.printf(", %2d", v[i]);
            }
        }
        System.out.println(" }");
    }
}

public class Exemplo06_Media {
    public static void main(String[] args) {
        
    }

    public static double calculaNotaIndividual(double[][] notas, int lin, int colInicio, int colFim) {
        double soma = 0;
        for (int j = colInicio; j <= colFim; j += 1) {
            soma += notas[lin][j];
        }
        return soma;
    }

    public static void calcularMedia(double[][] notas) {
        for (int i = 0; i < notas.length; i += 1) {
            notas[i][4] = (calculaNotaIndividual(notas, i, 0, 1) * 2 + 
                calculaNotaIndividual(notas, i, 2, 3) * 3) / 5;
        }
    }
}

import java.util.Scanner;

class Pessoa {
    String nome;
    int idade;
    double peso;
    double altura;
}

public class Exemplo09_Vetor_Pessoa {
    public static final int TAM = 4;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Pessoa[] pessoas = new Pessoa[TAM];
        preencherPessoas(pessoas);
        imprimirPessoas(pessoas);
    }

    public static void imprimirPessoas(Pessoa[] vp) {
        for (int i = 0; i < vp.length; i += 1) {
            System.out.printf("%d: ", i + 1);
            imprimir(vp[i]);
        }
    }

    public static void imprimir(Pessoa p) {
        System.out.printf("(%s, %d anos, %.1f kg, %.2f m, IMC = %.1f)\n", 
            p.nome, p.idade, p.peso, p.altura, calcularIMC(p));
    }

    public static void preencherPessoas(Pessoa[] vp) {
        for (int i = 0; i < vp.length; i += 1) {
            System.out.printf("Preencher dados da Pessoa %d\n", i + 1);
            vp[i] = new Pessoa();
            preencherDigitacao(vp[i]);
        }
    }

    public static void preencherDigitacao(Pessoa p) {
        System.out.println("Digite o nome: ");
        p.nome = sc.nextLine();
        System.out.println("Digite a idade: ");
        p.idade = sc.nextInt();
        System.out.println("Digite o peso: ");
        p.peso = sc.nextDouble();
        System.out.println("Digite a altura: ");
        p.altura = sc.nextDouble();
        sc.nextLine(); // Limpa o ENTER que sobrou da última digitação
    }

    public static double calcularIMC(Pessoa p) {
        return p.peso / (p.altura * p.altura);
    }
}

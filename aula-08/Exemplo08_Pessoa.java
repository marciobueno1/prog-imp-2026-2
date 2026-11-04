import java.util.Scanner;

class Pessoa {
    String nome;
    int idade;
    double peso;
    double altura;
}

public class Exemplo08_Pessoa {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();
        preencherDigitacao(pessoa1);
        preencherDigitacao(pessoa2);
        imprimir(pessoa1);
        imprimir(pessoa2);
    }

    public static void imprimir(Pessoa p) {
        System.out.printf("(%s, %d anos, %.1f kg, %.1f m)\n", p.nome, p.idade, p.peso, p.altura);
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
}

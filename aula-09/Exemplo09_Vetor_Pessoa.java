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
        System.out.println("IMPRESSÃO SEM ORDENAÇÃO");
        imprimirPessoas(pessoas);
        System.out.println("\n\nIMPRESSÃO COM ORDENAÇÃO DE NOME");
        selectionSortPorNome(pessoas, TAM);
        imprimirPessoas(pessoas);
        System.out.println("\n\nIMPRESSÃO COM ORDENAÇÃO DE IDADE");
        selectionSortPorIdade(pessoas, TAM);
        imprimirPessoas(pessoas);
        executarBuscasBinariasPorIdade(pessoas, TAM);
    }

    public static void executarBuscasBinariasPorIdade(Pessoa[] v, int n) {
        System.out.println("\n\nEXECUTANDO BUSCAS BINÁRIAS");
        char opcao = 's';
        int idade, pos;
        while (opcao == 's') {
            System.out.println("Digite a idade a ser buscada: ");
            idade = sc.nextInt();
            sc.nextLine(); // para remover o ENTER do nextInt() anterior
            pos = buscaBinariaPorIdade(v, n, idade);
            if (pos != -1) {
                System.out.printf("Achou a pessoa na posição %d: ", pos + 1);
                imprimir(v[pos]);
            } else {
                System.out.println("Não tem nenhuma pessoa com a idade digitada");
            }
            System.out.println("Deseja realizar uma nova busca (s/n)?");
            opcao = sc.nextLine().charAt(0);
        }
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

    public static void selectionSortPorNome(Pessoa[] v, int n) {
        int menor;
        Pessoa aux;
        for (int i = 0; i < n - 1; i += 1) {
            menor = i;
            for (int j = i + 1; j <= n - 1; j += 1) {
                if (v[j].nome.compareToIgnoreCase(v[menor].nome) < 0) {
                    menor = j;
                }
            }
            aux = v[i];
            v[i] = v[menor];
            v[menor] = aux;
        }
    }

    public static void selectionSortPorIdade(Pessoa[] v, int n) {
        int menor;
        Pessoa aux;
        for (int i = 0; i < n - 1; i += 1) {
            menor = i;
            for (int j = i + 1; j <= n - 1; j += 1) {
                if (v[j].idade < v[menor].idade) {
                    menor = j;
                }
            }
            aux = v[i];
            v[i] = v[menor];
            v[menor] = aux;
        }
    }

    public static int buscaBinariaPorIdade(Pessoa[] v, int n, int idade) {
        int inicio = 0, fim = n - 1, meio;
        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            if (v[meio].idade == idade) {
                return meio;
            } else if (v[meio].idade < idade) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }
}

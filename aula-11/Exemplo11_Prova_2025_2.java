import java.util.Scanner;

class Conta {
    int id;
    String cliente;
    double saldo;
    double limite;
}

class Operacao {
    int id;
    int idConta;
    char tipo; // {‘‘D’, ‘S, ‘T’}
    double valor;
};

public class Exemplo11_Prova_2025_2 {
    public static Scanner sc = new Scanner(System.in);
    public static final int TAM_CONTAS = 50;
    public static final int TAM_OP = 1000;

    public static void main(String[] args) {
    }

    public static int buscaId(Conta[] v, int tam, int x) {
        for (int i = 0; i < tam; i += 1) {
            if (v[i].id == x) {
                return i;
            }
        }
        return -1;
    }

    public static int cadastrarConta(Conta[] v, int tam) {
        Conta c = new Conta();
        int pos;
        if (tam >= v.length) {
            System.out.println("Vetor cheio! Não pode mais cadastrar contas!");
            return tam;
        }
        System.out.println("Digite o ID da conta: ");
        c.id = sc.nextInt();
        pos = buscaId(v, tam, c.id);
        while (pos != -1) {
            System.out.println("Esse código já existe! Favor digitar outro código:");
            c.id = sc.nextInt();
            pos = buscaId(v, tam, c.id);
        }
        sc.nextLine(); // Joga fora o ENTER da digitação do nextInt()
        System.out.println("Digite o nome do cliente:");
        c.cliente = sc.nextLine();
        c.saldo = leituraNumeroNaoNegativo("Digite o saldo da conta:");
        c.limite = leituraNumeroNaoNegativo("Digite o limite da conta:");
        v[tam] = c;
        return tam + 1;
    }

    public static double leituraNumeroNaoNegativo(String mensagem) {
        double num;
        System.out.println(mensagem);
        num = sc.nextDouble();
        while (num < 0.0) {
            System.out.println("Número inválido! Não pode digitar números negativos!");
            System.out.println(mensagem);
            num = sc.nextDouble();
        }
        return num;
    }

    public static int buscaBinariaCliente(Conta[] v, int tam, String x) {
        int inicio = 0, fim = tam - 1, meio, cmp;
        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            cmp = v[meio].cliente.compareTo(x);
            if (cmp == 0) {
                return meio;
            } else if (cmp < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public static void insertionSortCliente(Conta[] v, int tam) {
        Conta chave;
        int j;
        for (int i = 1; i <= tam - 1; i += 1) {
            chave = v[i];
            j = i - 1;
            while (j >= 0 && chave.cliente.compareTo(v[j].cliente) < 0) {
                v[j + 1] = v[j];
                j -= 1;
            }
            v[j + 1] = chave;
        }
    }

    public static int filtraOperacoes(
        Operacao[] vOp, int tamOp, Operacao[] vOpFiltrado, int x
    ) {
        int novoTam = 0;
        for (int i = 0; i < tamOp; i += 1) {
            if (vOp[i].idConta == x) {
                vOpFiltrado[novoTam] = vOp[i];
                novoTam += 1;
            }
        }
        return novoTam;
    }
    public static void extrato(
        Conta[] vContas, int tamConta, Operacao[] vOp, int tamOp, int idConta
    ) {
        Operacao[] operacoes = new Operacao[vContas.length];
        int tamOperacoes = filtraOperacoes(vOp, tamOp, operacoes, idConta);
        int nUltLanc = Math.min(5, tamOperacoes);
        double saldoAnterior = 0.0;
        for (int i = 0; i < tamOperacoes - nUltLanc; i += 1) {
            saldoAnterior += operacoes[i].valor;
        }
        for (int i = tamOperacoes - nUltLanc - 1; i < tamOperacoes; i += 1) {
            saldoAnterior += operacoes[i].valor;
            System.out.printf("%d | %.2f",
                operacoes[i].id, operacoes[i].tipo, operacoes[i].valor, saldoAnterior);
        }
    }
}

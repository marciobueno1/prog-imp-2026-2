class Produto {
    String nome;
    int qtdEstoque;
    int qtdMinima;
    double precoUnit;
    int categoria;
}

class Categoria {
    int id;
    String nome;
}

public class Exemplo10_Prova_2026_1 {
    public static final int TAM_PROD = 50;
    public static final int TAM_CAT = 30;
    public static void main(String[] args) {
        Produto[] produtos = new Produto[TAM_PROD];
        Categoria[] categorias = new Categoria[TAM_CAT];
    }  
    
    public static int buscaPorNome(Categoria[] v, int tam, String nome) {
        for (int i = 0; i < tam; i += 1) {
            if (v[i].nome.equals(nome)) {
                return i;
            }
        }
        return -1;
    }
    
    public static void listarProdutosCateg(
        Produto[] vp, int tamP, Categoria[] vc, int tamC, String nomeCateg
    ) {
        int pos = buscaPorNome(vc, tamC, nomeCateg);
        if (pos == -1) {
            System.out.println("Categoria não encontrada!");
            return;
        }
        listarProdutosCateg(vp, tamP, vc[pos]);
    }

    public static void listarProdutosCateg(Produto[] vp, int tamP, Categoria categ) {
        boolean achouProduto = false;
        System.out.println("Listagem de Produtos da categoria " + categ.nome);
        for (int i = 0; i < tamP; i += 1) {
            if (vp[i].categoria == categ.id) {
                achouProduto = true;
                System.out.printf("%s - estoq: %d - mínimo: %d - R$ %.2f",
                    vp[i].nome, vp[i].qtdEstoque, vp[i].qtdMinima, vp[i].precoUnit
                );
            }  
        }
        if (!achouProduto) {
            System.out.println("Não há nenhum produto desta categoria!");
        }
    }

    public static int buscaBinariaPorNome(Produto[] vp, int tamP, String nome) {
        int inicio = 0, fim = tamP - 1, meio;
        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            if(vp[meio].nome.equals(nome)) {
                return meio;
            } else if (vp[meio].nome.compareTo(nome) < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public static void bubbleSortPorNome(Produto[] v, int n) {
        Produto aux;
        int fim = n - 2, pos = n - 2;
        boolean trocou = true;
        while (trocou) {
            trocou = false;
            for (int i = 0; i <= fim; i += 1) {
                if (v[i].nome.compareTo(v[i + 1].nome) > 0){
                    aux = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = aux;
                    trocou = true;
                    pos = i;
                }
            }
            fim = pos - 1;
        }
    }
}

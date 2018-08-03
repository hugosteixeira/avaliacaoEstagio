import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static String enderecoArquivo = "D:\\AdVerus\\src\\estoque.csv";

    public static void main(String[] args) throws FileNotFoundException {
        Loja loja = criarLoja(enderecoArquivo);
        printarProdutosMaisCaros(loja);
        printarMediaPrecos(loja);
        printarQuantidades(loja);
    }

    private static void printarProdutosMaisCaros(Loja loja) {
        String resultadoPrint = "Os 2 produtos mais caros são: ";
        for (Produto produto : loja.getProdutosMaisCaros()) {
            resultadoPrint = resultadoPrint + "\n" + produto;
        }
        System.out.println(resultadoPrint);
    }


    public static Loja criarLoja(String nome) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(nome));
        Loja loja = new Loja();
        String[] cabecalho = scanner.nextLine().split(";");
        loja.setCabecalho(cabecalho);
        while (scanner.hasNextLine()) {
            Produto produto = new Produto();
            String[] linha = scanner.nextLine().split(";");
            produto.setDescricao(linha[0]);
            produto.setMarca(linha[1]);
            produto.setPreco(Float.parseFloat(linha[2]));
            produto.setQuantidade(Integer.parseInt(linha[3]));
            loja.addProduto(produto);
        }
        return loja;
    }

    public static void printarMediaPrecos(Loja loja) {
        float resultado = 0;
        for (Produto produto : loja.getProdutos()) {
            resultado = resultado + produto.getPreco();
        }
        resultado = (resultado / loja.getProdutos().size());
        System.out.println("Média de precos da loja: " + Float.toString(round(resultado, 2)));
    }

    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    public static void printarQuantidades(Loja loja) {
        int resultado = 0;
        for (Produto produto : loja.getProdutos()) {
            resultado = resultado + produto.getQuantidade();
        }
        System.out.println("Quantidade de Produtos na Loja: " + Integer.toString(resultado));
    }
}

import java.util.ArrayList;

public class Loja {
    private ArrayList<Produto> produtos = new ArrayList<>();
    private String[] cabecalho;


    public String[] getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(String[] cabecalho) {
        this.cabecalho = cabecalho;
    }


    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public ArrayList<Produto> getProdutosMaisCaros(){
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();
        float maiorValor = 0;
        float maiorValor1 = 0;
        for (Produto produto:this.produtos){
            if (produto.getPreco() > maiorValor){
                maiorValor = produto.getPreco();
                produto2 = produto1;
                produto1 = produto;
            }
            else if(produto.getPreco() > maiorValor1){
                maiorValor1 = produto.getPreco();
                produto2 = produto;
            }
            
        }
        ArrayList<Produto> result =  new ArrayList();
        result.add(produto1);
        result.add(produto2);
        return result;
    }



}

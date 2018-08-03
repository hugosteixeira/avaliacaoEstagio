import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class HTMLMaker {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy às HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    String data = dtf.format(now);
    private String tabelas;
    private String text;

    public void setTabelas(Loja loja){
        String tabelas="";
        for (Produto produto: loja.getProdutos()){
            tabelas = tabelas +"<tr> " +
                    "<td>"+produto.getDescricao()+"</td>"+
                    "<td>"+produto.getMarca()+"</td>"+
                    "               <td>"+Float.toString(produto.getPreco())+"</td>"+
                    "               <td>"+Integer.toString(produto.getQuantidade())+"</td>"+
                    "               </tr>\n";
        }
        this.tabelas = tabelas;
    }

    public void writeFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("estoque.html", "UTF-8");
        writer.println(this.text);
        writer.close();
    }

    public void setText(){
        this.text = "<!DOCTYPE html>"+
                "<html>"+
                "<head>"+
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"+
                "    <title>Produtos</title>"+
                "    <style>"+
                "        html {"+
                "            font-family: Georgia, Cambria, serif;"+
                "            font-size: .875em;"+
                "            background: #fff;"+
                "            color: #373D49;"+
                "        }"+
                "        body { padding: 15px; }"+
                "        table {"+
                "            width: 100%;"+
                "            border: 1px solid #ddd;"+
                "            border-collapse: collapse;"+
                "            border-spacing: 0;"+
                "        }"+
                "            table>thead>tr>th {"+
                "            text-align: left;"+
                "            border-bottom: 2px solid #ddd"+
                "        }"+
                "        th, td { padding: 8px; line-height: 1.4285714; }"+
                "        table>tbody>tr:nth-child(odd)>td { background-color: #f9f9f9 }"+
                "    </style>"+
                "</head>"+
                ""+
                "<body>"+
                "    <h1>Lista de Produtos</h1>"+
                "    <hr>"+
                "    <p>Lista gerada em "+data+
                "    "+
                "    <table>"+
                "        <thead>"+
                "            <tr>"+
                "                <th>Produto</th>"+
                "                <th>Marca</th>"+
                "                <th>Preço</th>"+
                "                <th>Estoque</th>"+
                "            </tr>"+
                "        </thead>"+
                "        <tbody>"+
                "            <!-- Lista de produtos -->"+ tabelas +
                "        </tbody>"+
                "    </table>"+
                ""+
                "</body>"+
                "</html>";
    }
}

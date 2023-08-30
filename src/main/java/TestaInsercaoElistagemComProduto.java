import com.loja.repository.ConnectionFactory;
import dao.ProdutoDAO;
import modelo.Produto;

import java.sql.*;
import java.util.List;

public class TestaInsercaoElistagemComProduto {
    public static void main(String[] args) throws SQLException {

        Produto comoda = new Produto("Playstation", "Console de vídeo game");

        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvarProduto(comoda);
            List<Produto> listaDeProdutos = produtoDAO.listar();

            listaDeProdutos.forEach(System.out::println);
        }
    }
}

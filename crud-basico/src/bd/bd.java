package bd;

import classes.pessoa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class bd {
    //Colocar o nome do banco de dados que você criou
    private static final String URL = "jdbc:mysql://localhost:3308/crud";
    //Colocar o usuario que loga no MySQL Workbench
    private static final String USER = "root";
    //Colocar a senha que loga no MySQL Workbench
    private static final String PASSWORD = "";

    //Método que faz a conexão com o banco de dados
    public static Connection GetConnection() {
        try {
            //Classe importada para usar o banco, sempre será usado no JAVA
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Método para inserir uma nova Pessoa no banco.
    public void create(pessoa pessoinha) {
        // Query SQL para inserção.
        String query = "INSERT INTO Pessoa (cpf, nome, idade) VALUES (?, ?, ?)";
        try (
            // Estabelece uma conexão com o banco.
            Connection conn = GetConnection();
            // Cria um PreparedStatement para executar a query.
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            // Atribui os valores da pessoa para a query.
            stmt.setString(1, pessoinha.getCpf());
            stmt.setString(2, pessoinha.getNome());
            stmt.setInt(3, pessoinha.getIdade());
            // Executa a query.
            stmt.execute();
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        }
    }
    // Método para recuperar todas as pessoas do banco.
    public ArrayList<pessoa> readAll() {
        // Lista para armazenar as pessoas recuperadas.
        ArrayList<pessoa> pessoas = new ArrayList<>();
        // Query SQL para seleção.
        String query = "SELECT * FROM Pessoa";
        try (
            // Estabelece uma conexão com o banco.
            Connection conn = GetConnection();
            // Cria um PreparedStatement para executar a query.
            PreparedStatement stmt = conn.prepareStatement(query);
            // Executa a query e armazena o resultado.
            ResultSet rs = stmt.executeQuery()
        ) {
            // Itera sobre o resultado.
            while (rs.next()) {
                // Adiciona cada pessoa à lista.
                pessoas.add(new pessoa(rs.getString("nome"), rs.getInt("idade"), rs.getString("cpf"),rs.getInt("id")));
            }
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        }
        // Retorna a lista de pessoas.
        return pessoas;
    }
     // Método para atualizar uma pessoa existente no banco.
    public void update(pessoa pessoa, int id) {
        // Query SQL para atualização.
        String query = "UPDATE Pessoa SET nome = ?, idade = ?, cpf = ? WHERE id = ?";
        try (
            // Estabelece uma conexão com o banco.
            Connection conn = GetConnection();
            // Cria um PreparedStatement para executar a query.
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            // Atribui os valores da pessoa para a query.
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setString(3, pessoa.getCpf());
            stmt.setInt(4,id);
            // Executa a query.
            stmt.execute();
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        }
    }
    // Método para deletar uma pessoa pelo seu CPF.
    public void delete(int id) {
        // Query SQL para deleção.
        String query = "DELETE FROM Pessoa WHERE id = ?";
        try (
            // Estabelece uma conexão com o banco.
            Connection conn = GetConnection();
            // Cria um PreparedStatement para executar a query.
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            // Atribui o CPF para a query.
            stmt.setInt(1, id);
            // Executa a query.
            stmt.execute();
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        }
}
}
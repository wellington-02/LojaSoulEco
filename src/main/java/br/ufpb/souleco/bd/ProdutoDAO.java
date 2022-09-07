package br.ufpb.souleco.bd;

import br.ufpb.souleco.classes.Cliente;
import br.ufpb.souleco.classes.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ProdutoDAO {

    public static void inserir(Produto produto) {
        String sql = "INSERT INTO produto (nome, preco, quantidade, foto ) VALUES ( ?, ?, ?,?)";

        try (Connection con = Conexao.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setInt(3, produto.getQuantidadeEmEstoque());
            ps.setString(4,produto.getFoto());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void atualizarQuanti(Produto produto) {
        String sql = "UPDATE produto SET  quantidade = ? WHERE nome = ?";

        try (Connection con = Conexao.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, produto.getQuantidadeEmEstoque());
            ps.setString(2, produto.getNome());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Produto procurarProdutoNome(String nome) {
        String sql = "SELECT  nome, preco, quantidade, foto FROM produto where nome like ?";
        Produto produto = null;
        try(Connection con = Conexao.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                produto = new Produto(rs.getString("nome"), rs.getDouble("preco"), rs.getInt("quantidade"), rs.getString("foto"));
            }
            Conexao.close(con, ps, rs);
            return produto;
        }catch( SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void delete (Produto produto){
        String sql = "DELETE FROM produto where nome = ?";

        try (Connection con = Conexao.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Collection<Produto> todosProdutos() {
        String sql = "SELECT nome, preco, quantidade, foto FROM produto";
        Collection<Produto> listaProdutos = new ArrayList<>();
        try (Connection conn = Conexao.getConexao();){
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaProdutos.add(new Produto(rs.getString("nome"), rs.getDouble("preco"), rs.getInt("quantidade"), rs.getString("foto")));
            }
            return listaProdutos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean atualizarDados(Produto produto){
        String sql = "UPDATE produto SET nome = ?, preco = ?, quantidade = ?, foto = ? WHERE nome = ?;";

        try (Connection con = Conexao.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setInt(3, produto.getQuantidadeEmEstoque());
            ps.setString(4,produto.getFoto());
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }

}

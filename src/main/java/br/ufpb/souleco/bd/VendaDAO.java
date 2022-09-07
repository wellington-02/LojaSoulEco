package br.ufpb.souleco.bd;

import br.ufpb.souleco.classes.Cliente;
import br.ufpb.souleco.classes.Produto;
import br.ufpb.souleco.classes.Venda;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VendaDAO {

    public static void inserir(Produto p, Cliente c){
        String sql = "INSERT INTO venda (nome_produto, cpf_cliente) VALUES (?,?)";

        try (Connection con = Conexao.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getNome());
            ps.setString(2, c.getCpf());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Venda> procurarProdutosDoCliente(String cpfCliente) {
        String sql = "SELECT id, data_venda, nome_produto, cpf_cliente FROM venda where cpf_cliente like ?";
        List<Venda> produtosDoCliente = new ArrayList<>();

        try (Connection con = Conexao.getConexao()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cpfCliente);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                produtosDoCliente.add(new Venda(rs.getInt("id"), rs.getString("data_venda"),
                        rs.getString("nome_produto"), rs.getString("cpf_cliente")));
            }

            Conexao.close(con, ps, rs);
            return produtosDoCliente;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
//    public static List<Venda> procurarProdutosVendidos(String nomeProduto) {
//        String sql = "SELECT id, data_venda, nome_produto, cpf_cliente FROM venda where cpf_cliente like ?";
//        List<Venda> produtosDoCliente = new ArrayList<>();
//
//        try(Connection con = Conexao.getConexao()){
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1,cpfCliente);
//            ResultSet rs = ps.executeQuery();
//
//            while(rs.next()){
//                produtosDoCliente.add(new Venda(rs.getInt("id"), rs.getString("data_venda"),
//                        rs.getString("nome_produto"), rs.getString("cpf_cliente")));
//            }
//
//            Conexao.close(con, ps, rs);
//            return produtosDoCliente;
//        }catch( SQLException e){
//            e.printStackTrace();
//        }
//        return null;
//    }

    public static List<Venda> todasVendas(){
        String sql = "SELECT id, data_venda, nome_produto, cpf_cliente FROM venda";
        List<Venda> listaVendas = new ArrayList<>();
        try (Connection con = Conexao.getConexao();){
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaVendas.add(new Venda(rs.getInt("id"),rs.getString("data_venda"), rs.getString("nome_produto"), rs.getString("cpf_Cliente")));
            }
            return listaVendas;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void delete(Venda venda){
        String sql = "DELETE FROM venda where id = ?";

        try (Connection con = Conexao.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, venda.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

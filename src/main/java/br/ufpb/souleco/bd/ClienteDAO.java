package br.ufpb.souleco.bd;

import br.ufpb.souleco.classes.Cliente;
import br.ufpb.souleco.classes.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClienteDAO {

    public static void inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente (usuario, nome, cpf, cep, senha) VALUES ( ?, ?, ?, ?,?)";

        try (Connection con = Conexao.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, cliente.getNomeDeUsuario());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getCpf());
            ps.setInt(4, cliente.getCep());
            ps.setString(5, cliente.getSenha());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET  logado = ? WHERE cpf = ?";

        try (Connection con = Conexao.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, cliente.isLogado());
            ps.setString(2, cliente.getCpf());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Cliente procurarClienteCpf( String cpf){
        String sql = "SELECT cpf,usuario, nome, cep, senha FROM cliente where cpf like ?";
        Cliente cliente = null;
        try(Connection con = Conexao.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                cliente = new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getInt("cep"),rs.getString("usuario"), rs.getString("senha"));
            }
            Conexao.close(con, ps, rs);
            return cliente;
        }catch( SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<Cliente> procurarClienteNome(String nome) {
        String sql = "SELECT  cpf, usuario, nome, cep, senha FROM cliente where nome like ?";
        List<Cliente> clientesNomesIguais = new ArrayList<>();
        try(Connection con = Conexao.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                clientesNomesIguais.add(new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getInt("cep"),rs.getString("usuario"), rs.getString("senha")));
            }
            Conexao.close(con, ps, rs);
            return clientesNomesIguais;
        }catch( SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Cliente procurarUsuario(String usuario){
        String sql = "SELECT  cpf, usuario, nome, cep, senha, logado FROM cliente where usuario like ?";
        Cliente cliente = null;
        try(Connection con = Conexao.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                cliente = new Cliente(rs.getString("nome"), rs.getString("cpf"),
                        rs.getInt("cep"),rs.getString("usuario"),
                        rs.getString("senha"), rs.getBoolean("logado"));
            }
            Conexao.close(con, ps, rs);
            return cliente;
        }catch( SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static Cliente procurarUsuarioLogado(boolean logado){
        String sql = "SELECT cpf,usuario, nome, cep, senha, logado FROM cliente where logado = true";
        Cliente cliente = null;
        try(Connection con = Conexao.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                cliente = new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getInt("cep"),rs.getString("usuario"), rs.getString("senha"));
            }
            Conexao.close(con, ps, rs);
            return cliente;
        }catch( SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static List<Cliente> todosClientes() {
        String sql = "SELECT cpf,usuario, nome, cep, senha, logado FROM cliente";
        List<Cliente> listaClientes = new ArrayList<>();
        try (Connection conn = Conexao.getConexao();){
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaClientes.add(new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getInt("cep")));
            }
            return listaClientes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void delete (Cliente cliente){
        String sql = "DELETE FROM cliente where cpf = ?";

        try (Connection con = Conexao.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getCpf());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

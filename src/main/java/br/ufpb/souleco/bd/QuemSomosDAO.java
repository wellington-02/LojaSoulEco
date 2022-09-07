package br.ufpb.souleco.bd;

import br.ufpb.souleco.classes.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class QuemSomosDAO {

    public static void atualizar(String descricao) {
        String sql = "UPDATE quesomos SET  descricao = ?";

        try (Connection con = Conexao.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, descricao);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String pegarDescricao() {
        String sql = "SELECT descricao FROM quesomos";
        String textoQuemSomos = "";
        try (Connection conn = Conexao.getConexao();){
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                textoQuemSomos = rs.getString("descricao");
            }
            return textoQuemSomos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOAeroporto {

    public List<Aeroporto> getLista() {
        String sql = "select * from aeroporto";
        List<Aeroporto> listaAeroporto = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Aeroporto objAeroporto = new Aeroporto();
                objAeroporto.setCodAeroporto(rs.getInt("codAeroporto"));
                objAeroporto.setNomeAeroporto(rs.getString("nomeAeroporto"));
                listaAeroporto.add(objAeroporto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no getLista() do DAOAeroporto: " + ex.getMessage());
        }
        return listaAeroporto;
    }

    public boolean incluir(Aeroporto obj) {
        String sql = "insert into aeroporto (nomeAeroporto) values(?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNomeAeroporto());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Aeroporto incluido");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Aeroporto não incluido");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no incluir do DAOAeroporto " + e.getMessage());
        }
        return false;
    }

    public boolean alterar(Aeroporto obj) {
        String sql = "update aeroporto set nomeAeroporto = ? where codAeroporto = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNomeAeroporto());
            pst.setInt(2, obj.getCodAeroporto());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Aeroporto alterado");
                return true;
            } else {

                JOptionPane.showMessageDialog(null, "Aeroporto não alterado");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no alterar do DAOAeroporto " + e.getMessage());
        }
        return false;
    }

    public boolean remover(Aeroporto obj) {
        String sql = "delete from aeroporto where codAeroporto = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodAeroporto());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Aeroporto removido");
                return true;
            } else {

                JOptionPane.showMessageDialog(null, "Aeroporto não removido");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no remover do DAOAeroporto " + e.getMessage());
        }
        return false;
    }

    public boolean salvar(Aeroporto obj) {
        if (obj.getCodAeroporto() == null) {
            return incluir(obj);
        } else {
            return alterar(obj);
        }
    }

    public Aeroporto localizar(Integer id) {
        String sql = "select * from aeroporto where codAeroporto = ?";
        Aeroporto obj = new Aeroporto();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                obj.setCodAeroporto(rs.getInt("codAeroporto"));
                obj.setNomeAeroporto(rs.getString("nomeAeroporto"));
                return obj;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL Localizar" + e.getMessage());
        }
        return null;
    }
}

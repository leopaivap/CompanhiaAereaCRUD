package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOAeronave {

    public List<Aeronave> getLista() {
        String sql = "select * from aeronave";
        List<Aeronave> listaAeronave = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Aeronave objAeronave = new Aeronave();
                objAeronave.setCodAeronave(rs.getInt("codAeronave"));
                objAeronave.setNomeAviao(rs.getString("nomeAviao"));
                objAeronave.setQtdAssento(rs.getInt("qtdAssento"));
                objAeronave.setAutonomia(rs.getDouble("autonomia"));
                objAeronave.setCapacidadeCarga(rs.getDouble("capacidadeCarga"));
                listaAeronave.add(objAeronave);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no getLista() do DAOAeronave: " + ex.getMessage());
        }
        return listaAeronave;
    }

    public boolean incluir(Aeronave obj) {
        String sql = "insert into aeronave (nomeAviao, qtdAssento, autonomia, capacidadeCarga) values(?, ?, ?, ?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNomeAviao());
            pst.setInt(2, obj.getQtdAssento());
            pst.setDouble(3, obj.getAutonomia());
            pst.setDouble(4, obj.getCapacidadeCarga());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Aeronave incluida");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Aeronave não incluida");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no incluir do DAOAeronave " + e.getMessage());
        }
        return false;
    }

    public boolean alterar(Aeronave obj) {
        String sql = "update aeronave set nomeAviao = ?, qtdAssento = ?, autonomia = ?, capacidadeCarga = ? where codAeronave = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNomeAviao());
            pst.setInt(2, obj.getQtdAssento());
            pst.setDouble(3, obj.getAutonomia());
            pst.setDouble(4, obj.getCapacidadeCarga());
            pst.setInt(5, obj.getCodAeronave());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Aeronave alterada");
                return true;
            } else {

                JOptionPane.showMessageDialog(null, "Aeronave não alterada");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no alterar do DAOAeronave " + e.getMessage());
        }
        return false;
    }

    public boolean remover(Aeronave obj) {
        String sql = "delete from aeronave where codAeronave = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodAeronave());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Aeronave removido");
                return true;
            } else {

                JOptionPane.showMessageDialog(null, "Aeronave não removido");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no remover do DAOAeronave " + e.getMessage());
        }
        return false;
    }

    public boolean salvar(Aeronave obj) {
        if (obj.getCodAeronave() == null) {
            return incluir(obj);
        } else {
            return alterar(obj);
        }
    }

    public Aeronave localizar(Integer id) {
        String sql = "select * from aeronave where codAeronave = ?";
        Aeronave obj = new Aeronave();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                obj.setCodAeronave(rs.getInt("codAeronave"));
                obj.setNomeAviao(rs.getString("nomeAviao"));
                obj.setQtdAssento(rs.getInt("qtdAssento"));
                obj.setAutonomia(rs.getDouble("autonomia"));
                obj.setCapacidadeCarga(rs.getDouble("capacidadeCarga"));
                return obj;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL Localizar" + e.getMessage());
        }
        return null;
    }
}

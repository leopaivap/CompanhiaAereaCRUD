package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOPassageiro {
    

    public List<Passageiro> getLista(){
         String sql = "select * from passageiro";
        List<Passageiro> listaPassageiro = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Passageiro objPassageiro = new Passageiro();
                objPassageiro.setCodPassageiro(rs.getInt("codPassageiro"));
                objPassageiro.setNome(rs.getString("nomePassageiro"));
                objPassageiro.setCpf(rs.getInt("cpf"));
                
                java.sql.Date dt = rs.getDate("dataNascimento");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                objPassageiro.setDataNascimento(c); 
                
                listaPassageiro.add(objPassageiro);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no getLista() do DAOPassageiro: " + ex.getMessage());
        }
        return listaPassageiro;
    }

    public boolean incluir(Passageiro obj) {
        String sql = "insert into passageiro (nomePassageiro, cpf, dataNascimento) values(?, ?, ?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setInt(2, obj.getCpf());
            pst.setDate(3, new java.sql.Date(obj.getDataNascimento().getTimeInMillis()));
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Passageiro incluido");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Passageiro não incluido");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no incluir do DAOPassageiro " + e.getMessage());
        }
        return false;
    }

    public boolean alterar(Passageiro obj) {
        String sql = "update passageiro set nomePassageiro = ?, cpf = ?, dataNascimento = ? where codPassageiro = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setInt(2, obj.getCpf());
            pst.setDate(3, new java.sql.Date(obj.getDataNascimento().getTimeInMillis()));   
            pst.setInt(4, obj.getCodPassageiro());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Passageiro alterado");
                return true;
            } else {

                JOptionPane.showMessageDialog(null, "Passageiro não alterado");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no alterar do DAOPassageiro " + e.getMessage());
        }
        return false;
    }

    public boolean remover(Passageiro obj) {
        String sql = "delete from passageiro where codPassageiro = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodPassageiro());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Passageiro removido");
                return true;
            } else {

                JOptionPane.showMessageDialog(null, "Passageiro não removido");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no remover do DAOPassageiro " + e.getMessage());
        }
        return false;
    }

    public boolean salvar(Passageiro obj) {
        if (obj.getCodPassageiro() == null) {
            return incluir(obj);
        } else {
            return alterar(obj);
        }
    }

    public Passageiro localizar(Integer id) {
        String sql = "select * from passageiro where codPassageiro = ?";
        Passageiro obj = new Passageiro();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                obj.setCodPassageiro(rs.getInt("codPassageiro"));
                obj.setNome(rs.getString("nomePassageiro"));
                obj.setCpf(rs.getInt("cpf"));
                
                java.sql.Date dt = rs.getDate("dataNascimento");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                obj.setDataNascimento(c);
                
                return obj;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL Localizar" + e.getMessage());
        }
        return null;
    }
}

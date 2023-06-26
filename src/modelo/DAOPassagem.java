package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.DAOVoo;
import modelo.DAOPassageiro;
import modelo.Passageiro;
import modelo.Voo;

public class DAOPassagem {
    
    DAOPassageiro DAOPassageiro = new DAOPassageiro();
    DAOVoo DAOVoo = new DAOVoo();

     public List<Passagem> getLista(){
         String sql = "select * from passagem";
        List<Passagem> listaPassagem = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Passagem objPassagem = new Passagem();
                objPassagem.setCodPassagem(rs.getInt("codPassagem"));
                objPassagem.setNumeroPoltrona(rs.getInt("numeroPoltrona"));
                objPassagem.setPesoBagagem(rs.getDouble("pesoBagagem"));
                objPassagem.setValorPassagem(rs.getDouble("valorPassagem"));
                
                objPassagem.setPassageiro(DAOPassageiro.localizar(rs.getInt("codPassageiro")));
                objPassagem.setVoo(DAOVoo.localizar(rs.getInt("voo")));
                
                
                listaPassagem.add(objPassagem);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no getLista() do DAOPassagem: " + ex.getMessage());
        }
        return listaPassagem;
    }

    public boolean incluir(Passagem obj) {
        String sql = "insert into passagem (codVoo, codPassageiro, numeroPoltrona, pesoBagagem, valorPassagem) values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getVoo().getCodVoo());
            pst.setInt(2, obj.getPassageiro().getCodPassageiro());
            pst.setDouble(3, obj.getNumeroPoltrona());
            pst.setDouble(4, obj.getPesoBagagem());
            pst.setDouble(5, obj.getValorPassagem());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Passagem incluido");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Passagem não incluido");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no incluir do DAOPassagem " + e.getMessage());
        }
        return false;
    }

    public boolean alterar(Passagem obj) {
        String sql = "update passagem set codVoo = ?, codPassageiro = ?, numeroPoltrona = ?, pesoBagagem = ?, valorPassagem = ? where codPassagem = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getVoo().getCodVoo());
            pst.setInt(2, obj.getPassageiro().getCodPassageiro());
            pst.setDouble(3, obj.getNumeroPoltrona());
            pst.setDouble(4, obj.getPesoBagagem());
            pst.setDouble(5, obj.getValorPassagem()); 
            pst.setInt(6, obj.getCodPassagem());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Passagem alterado");
                return true;
            } else {

                JOptionPane.showMessageDialog(null, "Passagem não alterado");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no alterar do DAOPassagem " + e.getMessage());
        }
        return false;
    }

    public boolean remover(Passagem obj) {
        String sql = "delete from passagem where codPassagem = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodPassagem());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Passagem removido");
                return true;
            } else {

                JOptionPane.showMessageDialog(null, "Passagem não removido");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no remover do DAOPassagem " + e.getMessage());
        }
        return false;
    }

    public boolean salvar(Passagem obj) {
        if (obj.getCodPassagem() == null) {
            return incluir(obj);
        } else {
            return alterar(obj);
        }
    }

    public Passagem localizar(Integer id) {
        String sql = "select * from passagem where codPassagem = ?";
        Passagem obj = new Passagem();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                obj.setCodPassagem(rs.getInt("codPassagem"));
                obj.setNumeroPoltrona(rs.getInt("numeroPoltrona"));
                obj.setPesoBagagem(rs.getDouble("pesoBagagem"));
                obj.setValorPassagem(rs.getDouble("valorPassagem"));
                obj.setPassageiro(DAOPassageiro.localizar(rs.getInt("codPassageiro")));
                obj.setVoo(DAOVoo.localizar(rs.getInt("codVoo")));
                
                return obj;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL Localizar" + e.getMessage());
        }
        return null;
    }
}

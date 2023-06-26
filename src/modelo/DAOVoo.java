package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.DAOAeronave;
import modelo.DAOAeroporto;
import modelo.DAOPiloto;
import modelo.Aeronave;
import modelo.Aeroporto;
import modelo.Piloto;


public class DAOVoo {
    
    DAOAeroporto DAOAeroporto = new DAOAeroporto();
    DAOAeronave DAOAeronave = new DAOAeronave();
    DAOPiloto DAOPiloto = new DAOPiloto();
    
     public List<Voo> getLista(){
         String sql = "select * from voo";
        List<Voo> listaVoo = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Voo objVoo = new Voo();
                objVoo.setCodVoo(rs.getInt("codVoo"));
                objVoo.setAeroporto(DAOAeroporto.localizar(rs.getInt("codAeroporto")));
                objVoo.setAeronave(DAOAeronave.localizar(rs.getInt("codAeronave")));
                objVoo.setPiloto(DAOPiloto.localizar(rs.getInt("codPiloto")));
                  
                listaVoo.add(objVoo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no getLista() do DAOVoo: " + ex.getMessage());
        }
        return listaVoo;
    }

    public boolean incluir(Voo obj) {
        String sql = "insert into voo codPiloto = ?, codAeroporto = ?, codAeronave = ? values(?, ?, ?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getAeronave().getCodAeronave());
            pst.setInt(2, obj.getAeroporto().getCodAeroporto());
            pst.setInt(3, obj.getPiloto().getCodPiloto());
    
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Voo incluido");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Voo não incluido");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no incluir do DAOVoo " + e.getMessage());
        }
        return false;
    }

    public boolean alterar(Voo obj) {
        String sql = "update voo set codPiloto = ?, codAeroporto = ?, codAeronave = ? where codVoo = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getAeronave().getCodAeronave());
            pst.setInt(2, obj.getAeroporto().getCodAeroporto());
            pst.setInt(3, obj.getPiloto().getCodPiloto());
            pst.setInt(5, obj.getCodVoo());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Voo alterado");
                return true;
            } else {

                JOptionPane.showMessageDialog(null, "Voo não alterado");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no alterar do DAOVoo " + e.getMessage());
        }
        return false;
    }

    public boolean remover(Voo obj) {
        String sql = "delete from voo where codVoo = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodVoo());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Voo removido");
                return true;
            } else {

                JOptionPane.showMessageDialog(null, "Voo não removido");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no remover do DAOVoo " + e.getMessage());
        }
        return false;
    }

    public boolean salvar(Voo obj) {
        if (obj.getCodVoo() == null) {
            return incluir(obj);
        } else {
            return alterar(obj);
        }
    }

    public Voo localizar(Integer id) {
        String sql = "select * from voo where codVoo = ?";
        Voo obj = new Voo();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                obj.setCodVoo(rs.getInt("codVoo"));
                obj.setAeronave(DAOAeronave.localizar(rs.getInt("codAeronave")));
                obj.setAeroporto(DAOAeroporto.localizar(rs.getInt("codAeroporto")));
                obj.setPiloto(DAOPiloto.localizar(rs.getInt("codPiloto")));
                
                return obj;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL Localizar" + e.getMessage());
        }
        return null;
    }
}

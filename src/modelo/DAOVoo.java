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

    public List<Voo> getLista() {
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
                objVoo.setOrigem(rs.getString("origem"));
                objVoo.setDestino(rs.getString("destino"));

                listaVoo.add(objVoo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no getLista() do DAOVoo: " + ex.getMessage());
        }
        return listaVoo;
    }

    public boolean incluir(Voo obj) {
        String sql = "insert into voo (codAeroporto, codPiloto, codAeronave, origem, destino) values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
           // pst.setInt(1, obj.getAeroporto(DAOAeroporto.localizar(rs.getInt("codAeroporto"))));
            pst.setInt(1, obj.getAeroporto().getCodAeroporto());
            pst.setInt(2, obj.getPiloto().getCodPiloto());
            pst.setInt(3, obj.getAeronave().getCodAeronave());
            pst.setString(4, obj.getOrigem());
            pst.setString(5, obj.getDestino());
            
            System.out.println("cod piloto: " + obj.getPiloto().getCodPiloto());
            System.out.println("cod aeroporto: " +obj.getAeroporto().getCodAeroporto());
            System.out.println("cod aeronave: " + obj.getAeronave().getCodAeronave());
            System.out.println("origem" +  obj.getOrigem());
            System.out.println("destino" +  obj.getDestino());
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
        String sql = "update voo set codPiloto = ?, codAeroporto = ?, codAeronave = ?, origem = ?, destino = ? where codVoo = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getAeronave().getCodAeronave());
            pst.setInt(2, obj.getAeroporto().getCodAeroporto());
            pst.setInt(3, obj.getPiloto().getCodPiloto());
            pst.setString(4, obj.getOrigem());
            pst.setString(5, obj.getDestino());
            pst.setInt(6, obj.getCodVoo());
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
                obj.setOrigem(rs.getString("origem"));
                obj.setDestino(rs.getString("destino"));

                return obj;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL Localizar" + e.getMessage());
        }
        return null;
    }
}

package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOPiloto {

    public List<Piloto> getLista() {
        String sql = "select * from piloto";
        List<Piloto> listaPiloto = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Piloto objPiloto = new Piloto();
                objPiloto.setCodPiloto(rs.getInt("codPiloto"));
                objPiloto.setNome(rs.getString("nomePiloto"));
                objPiloto.setCpf(rs.getInt("cpf"));
                objPiloto.setSalario(rs.getDouble("salario"));

                java.sql.Date dt = rs.getDate("dataNascimento");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                objPiloto.setDataNascimento(c);

                java.sql.Date dt2 = rs.getDate("dataAdmissao");
                c.setTime(dt2);
                objPiloto.setDataAdmissao(c);

                listaPiloto.add(objPiloto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no getLista() do DAOPiloto: " + ex.getMessage());
        }
        return listaPiloto;
    }

    public boolean incluir(Piloto obj) {
        String sql = "insert into piloto (nomePiloto, cpf, salario, dataNascimento, dataAdmissao) values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setInt(2, obj.getCpf());
            pst.setDouble(3, obj.getSalario());
            pst.setDate(4, new java.sql.Date(obj.getDataNascimento().getTimeInMillis()));
            pst.setDate(5, new java.sql.Date(obj.getDataAdmissao().getTimeInMillis()));

            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Piloto incluido");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Piloto não incluido");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no incluir do DAOPiloto " + e.getMessage());
        }
        return false;
    }

    public boolean alterar(Piloto obj) {
        String sql = "update piloto set nomePiloto = ?, cpf = ?, salario = ?, dataNascimento = ?, dataAdmissao = ? where codPiloto = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setInt(2, obj.getCpf());
            pst.setDouble(3, obj.getSalario());
            pst.setDate(4, new java.sql.Date(obj.getDataNascimento().getTimeInMillis()));
            pst.setDate(5, new java.sql.Date(obj.getDataAdmissao().getTimeInMillis()));
            pst.setInt(6, obj.getCodPiloto());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Piloto alterado");
                return true;
            } else {

                JOptionPane.showMessageDialog(null, "Piloto não alterado");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no alterar do DAOPiloto " + e.getMessage());
        }
        return false;
    }

    public boolean remover(Piloto obj) {
        String sql = "delete from piloto where codPiloto = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodPiloto());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Piloto removido");
                return true;
            } else {

                JOptionPane.showMessageDialog(null, "Piloto não removido");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no remover do DAOPiloto " + e.getMessage());
        }
        return false;
    }

    public boolean salvar(Piloto obj) {
        if (obj.getCodPiloto() == null) {
            return incluir(obj);
        } else {
            return alterar(obj);
        }
    }

    public Piloto localizar(Integer id) {
        String sql = "select * from piloto where codPiloto = ?";
        Piloto obj = new Piloto();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                obj.setCodPiloto(rs.getInt("codPiloto"));
                obj.setNome(rs.getString("nomePiloto"));
                obj.setCpf(rs.getInt("cpf"));
                obj.setSalario(rs.getDouble("salario"));

                java.sql.Date dt = rs.getDate("dataNascimento");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                obj.setDataNascimento(c);

                java.sql.Date dt2 = rs.getDate("dataAdmissao");
                c.setTime(dt2);
                obj.setDataAdmissao(c);

                return obj;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL Localizar do DAOPiloto" + e.getMessage());
        }
        return null;
    }
}

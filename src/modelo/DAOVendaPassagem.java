package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOVendaPassagem {
    
    DAOPassagem daoPassagem = new DAOPassagem();
    DAOVenda daoVenda = new DAOVenda();
    
    public List<VendaPassagem> getListaVendaPassagem(Integer id) {
        String sql = "select * from vendapassagem where VENDA_codVenda = ?";
        List<VendaPassagem> lista = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                VendaPassagem obj = new VendaPassagem();
               // System.out.println("IDVENDA="+rs.getInt("idvenda"));
                obj.getVenda().setCodVenda(rs.getInt("VENDA_codVenda"));
                obj.setCodVendaPassagem(rs.getInt("codVendaPassagem"));
                obj.setPassagem(daoPassagem.localizar(rs.getInt("PASSAGEM_codPassagem")));
                

                lista.add(obj);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no getListaVendaPassagem" + e.getMessage());

        }
        return lista;
    }

    public boolean incluir(VendaPassagem objVendaPassagem) {

        String sql = "insert into vendapassagem (VENDA_codVenda, PASSAGEM_codPassagem) values (?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(2, objVendaPassagem.getPassagem().getCodPassagem());
            pst.setInt(1, objVendaPassagem.getVenda().getCodVenda());

            if (pst.executeUpdate() > 0) {

               // JOptionPane.showMessageDialog(null, "Item de venda cadastrado com sucesso!");

            } else {
                JOptionPane.showMessageDialog(null, "Item de venda não cadastrado!");

            }
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no getListaVendaPassagem" + e.getMessage());

        }
        return false;
    }

    public boolean remover(VendaPassagem objVendaPassagem) {
        String sql = "delete from vendapassagem where codVendaPassagem = ?";
        
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, objVendaPassagem.getCodVendaPassagem());
            if (pst.executeUpdate() > 0) {
                // JOptionPane.showMessageDialog(null, "Item de venda removido com sucesso!");

            } else {
                 JOptionPane.showMessageDialog(null, "Item de venda não removido!");

            }
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no remover do VendaPassagem" + e.getMessage());

        }
        return false;
    }
}

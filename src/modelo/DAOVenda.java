package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DAOVenda {
     ConverteDataWEB converte = new ConverteDataWEB();
    private int lastId;

    public int getLastId() {
        return lastId;
    }

    public boolean incluir(Venda objVenda) {
        
        String sql = "insert into venda (metodoPagamento, data, passageiro_codPassageiro,) values (?, ?, ?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, objVenda.getMetodoPagamento());
            pst.setDate(2, converte.converteBanco(objVenda.getData()));
            pst.setInt(3, objVenda.getPassageiro().getCodPassageiro());

            if (pst.executeUpdate() > 0) {
                 ResultSet rs = pst.getGeneratedKeys();// retorna o último idCaixa cadastrado
                if (rs.next()) {
                    lastId = rs.getInt(1); //armazena o último idCaixa cadastrado
                }
                // JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");

            } else {
                 JOptionPane.showMessageDialog(null, "Venda não cadastrada");
            }
            pst.close();
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro de SQL no incluirVenda" + e.getMessage());

        }
        return false;
    }

    public boolean removeVenda(Venda objVenda) {
        String sql = "delete from venda where codVenda = ?";
        try {
            PreparedStatement stmt = Conexao.getPreparedStatement(sql);
            stmt.setInt(1, objVenda.getCodVenda());
            if (stmt.executeUpdate() > 0) {
                 JOptionPane.showMessageDialog(null, "Venda cancelada");

            } else {
                 JOptionPane.showMessageDialog(null, "Venda não cancelada");

            }
            stmt.close();
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro de SQL no remove venda" + e.getMessage() + "\nComando SQL = " + sql);
        }
        return false;
    }
}

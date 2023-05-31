package modelo;

import java.util.List;
import javax.swing.JOptionPane;

public class DAOPassageiro {
    

    public List<Passageiro> getLista(){
        return Dados.listaPassageiro;
    }
    
    public boolean salvar(Passageiro obj){
        if(obj.getCodPassageiro()== null){
            Integer codigo = Dados.listaPassageiro.size() + 1;
            obj.setCodPassageiro(codigo);
            verificaElegivel(obj);
            Dados.listaPassageiro.add(obj);
        }
        verificaElegivel(obj);
        if(!obj.isElegivel())
            JOptionPane.showMessageDialog(null, "Passageiro " + obj.getNome() + " inserido/modificado, mas não elegível devido ao excesso de peso!");
        return true;
    }
    
    public boolean remover(Passageiro obj){
        Dados.listaPassageiro.remove(obj);
        return true;
    }
    
    public void verificaElegivel(Passageiro obj){
        if(obj.getPesoBagagem() >= 20.0)
            obj.setElegivel(false);
        else
            obj.setElegivel(true);
    }
}

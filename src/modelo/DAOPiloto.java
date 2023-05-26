package modelo;

import java.util.List;

public class DAOPiloto {
    
    public List<Piloto> getLista(){
        return Dados.listaPiloto;
    }
    
    public boolean salvar(Piloto obj){
        if(obj.getCodPiloto() == null){
            Integer codigo = Dados.listaPiloto.size() + 1;
            obj.setCodPiloto(codigo);
            Dados.listaPiloto.add(obj);
        }
        return true;
    }
    
    public boolean remover(Piloto obj){
        Dados.listaPiloto.remove(obj);
        return true;
    }
}

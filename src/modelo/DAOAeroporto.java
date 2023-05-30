package modelo;

import java.util.List;

public class DAOAeroporto {
     public List<Aeroporto> getLista(){
        return Dados.listaAeroporto;
    }
    
    public boolean salvar(Aeroporto obj){
        if(obj.getCodAeroporto() == null){
            Integer codigo = Dados.listaAeroporto.size() + 1;
            obj.setCodAeroporto(codigo);
            Dados.listaAeroporto.add(obj);
        }
        return true;
    }
    
    public boolean remover(Aeroporto obj){
        Dados.listaAeroporto.remove(obj);
        return true;
    }
}

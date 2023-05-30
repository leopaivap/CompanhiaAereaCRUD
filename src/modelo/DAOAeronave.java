
package modelo;

import java.util.List;


public class DAOAeronave {
     public List<Aeronave> getLista(){
        return Dados.listaAeronave;
    }
    
    public boolean salvar(Aeronave obj){
        if(obj.getCodAeronave() == null){
            Integer codigo = Dados.listaAeronave.size() + 1;
            obj.setCodAeronave(codigo);
            Dados.listaAeronave.add(obj);
        }
        return true;
    }
    
    public boolean remover(Aeronave obj){
        Dados.listaAeronave.remove(obj);
        return true;
    }
}

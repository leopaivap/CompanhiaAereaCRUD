package modelo;

import java.io.Serializable;
import java.util.Objects;

public class Voo implements Serializable{
    private Integer codVoo;
    private Piloto piloto;
    private Aeroporto aeroporto;
    private Aeronave aeronave;
    private String origem, destino;

    public Integer getCodVoo() {
        return codVoo;
    }

    public void setCodVoo(Integer codVoo) {
        this.codVoo = codVoo;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Aeroporto getAeroporto() {
        return aeroporto;
    }

    public void setAeroporto(Aeroporto aeroporto) {
        this.aeroporto = aeroporto;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.codVoo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Voo other = (Voo) obj;
        if (!Objects.equals(this.codVoo, other.codVoo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Origem: " + origem + ", Destino:" + destino;
    }
    
    
}

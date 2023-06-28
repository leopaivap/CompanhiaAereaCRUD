package modelo;

import java.io.Serializable;
import java.util.Objects;

public class VendaPassagem implements Serializable{
    private Integer codVendaPassagem;
    private Venda venda;
    private Passagem passagem;

    public Integer getCodVendaPassagem() {
        return codVendaPassagem;
    }

    public void setCodVendaPassagem(Integer codVendaPassagem) {
        this.codVendaPassagem = codVendaPassagem;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Passagem getPassagem() {
        return passagem;
    }

    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.codVendaPassagem);
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
        final VendaPassagem other = (VendaPassagem) obj;
        if (!Objects.equals(this.codVendaPassagem, other.codVendaPassagem)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "Passageiro: " + venda.getPassageiro().getNome() + " | Destino: " + passagem.getVoo().getDestino();
        return passagem + " | Valor: R$" + passagem.getValorPassagem() + " | Peso Máximo: " + passagem.getPesoBagagem() + "kg";
    
    }
    
}

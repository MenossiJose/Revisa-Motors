package Model;

public class Avaliacao {
    private Oficina oficina;
    private Cliente cliente;
    private double nota;
    
    public Avaliacao(Oficina oficina, Cliente cliente, double nota){
        this.oficina = oficina;
        this.cliente = cliente;
        this.nota = nota;
    }
    
    public Avaliacao(){
        
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
}

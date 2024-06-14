package Model;

public class Revisao {
    //private int codigo;
    private Cliente cliente;
    private Oficina oficina;
    private Veiculo veiculo;
    private String data;
    private String horas;
    //private String andamento;
    private String detalhes;
    private boolean finalizado;
    private String servico;
    
    public Revisao(Cliente cliente, Oficina oficina, Veiculo veiculo
                   , String data, String horas, String detalhes,
                   boolean finalizado, String servico)
    {
        this.cliente = cliente;
        this.oficina = oficina;
        this.veiculo = veiculo;
        this.data = data;
        this.horas = horas;
        this.detalhes = detalhes;
        this.finalizado = finalizado;
        this.servico = servico;
        
    }
    
    public Revisao(){
        
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
}

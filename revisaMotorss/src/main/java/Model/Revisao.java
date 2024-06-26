package Model;

public class Revisao {
    //private int codigo;
    private String cliente;
    private String oficina;
    private String veiculo;
    private String data;
    private String horas;
    //private String andamento;
    private String servico;
    
    public Revisao(String cliente, String oficina, String veiculo
                   , String data, String horas, String servico)  
    {
        this.cliente = cliente;
        this.oficina = oficina;
        this.veiculo = veiculo;
        this.data = data;
        this.horas = horas;
        this.servico = servico;
        
    }
    
    public Revisao(){
        
    }


    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
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

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }
    
}

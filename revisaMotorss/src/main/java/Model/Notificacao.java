package Model;

public class Notificacao {
    private Oficina destinatario;
    private Cliente destino;
    private String titulo;
    private String descricao;
    
    public Notificacao(Oficina destinatario, Cliente destino, String titulo, String descricao){
        this.destinatario = destinatario;
        this.destino = destino;
        this.titulo = titulo;
        this.descricao = descricao;
    }
    
    public Notificacao(){
        
    }

    public Oficina getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Oficina destinatario) {
        this.destinatario = destinatario;
    }

    public Cliente getDestino() {
        return destino;
    }

    public void setDestino(Cliente destino) {
        this.destino = destino;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void enviarNotificacao(){
       //Logica
    }
    
    
}

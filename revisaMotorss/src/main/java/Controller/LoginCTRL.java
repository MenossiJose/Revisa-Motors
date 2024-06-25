package Controller;

import View.LoginPanel;

import Model.Cliente;
import Model.Oficina;

public class LoginCTRL {
    
    private Cliente cliente;
    private Oficina oficina;
    private LoginPanel view;
    
       
    public LoginCTRL(LoginPanel view){
        this.view = view;
        
    }
    
    public boolean validaCliente(){
         //Procurar no bd um usuário que tenha o mesmo usuário e senha e atribuir
        cliente = view.getMainView().getCliente();
        cliente.setNome("Jose");
        cliente.setCpf(123);
        cliente.setEmail("teste");
        cliente.setSenha("123");
        //Testando os dados na memoria depois troca pro bd
        String usuario = view.getTextFieldUsuario().getText();
        char[] passwordChars = view.getPasswordField().getPassword();
        String password = new String(passwordChars);
        System.out.println(usuario);
        System.out.println(password);
        //Acho que esse teste é valido
        if(cliente.getNome() != null){
            return true;
        }
        else{
            return false;
        }
        
    }

    public Cliente entrarNoSistemaCliente(){
        return cliente;

    }
    
    public boolean validaOficina(){
         //Procurar no bd um usuário que tenha o mesmo usuário e senha e atribuir
        oficina = new Oficina("a",23, null, null);
        //Testando os dados na memoria depois troca pro bd
        String usuario = view.getTextFieldUsuario().getText();
        char[] passwordChars = view.getPasswordField().getPassword();
        String password = new String(passwordChars);
        System.out.println(usuario);
        System.out.println(password);
        //Acho que esse teste é valido
        if(oficina.getNome() != null){
            return true;
        }
        else{
            return false;
        }
    }
        
    
    public Oficina entrarNoSistemaOficina(){
        return oficina;
    }
    
}

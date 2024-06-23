package Controller;

import Model.Oficina;

import Controller.LoginCTRL;

public class OficinaCTRL {

    private Oficina oficina;
    private LoginCTRL loginCTRL;
    
        public OficinaCTRL(LoginCTRL loginCTRL){
            this.loginCTRL= loginCTRL;
        }
    
        public OficinaCTRL(){
            
        }
    
        public void registrarOficina(Oficina oficina) {
        // Aqui você pode inserir o cliente no banco de dados
        // Para este exemplo, vamos apenas imprimir os dados do cliente
        System.out.println("Oficina registrada: " + oficina.getNome());
        System.out.println(oficina.getCnpj());
        System.out.println(oficina.getEndereco());
        System.out.println(oficina.getSenha());
    }
        
        public void puxarOficina(){
        oficina = loginCTRL.entrarNoSistemaOficina();
        System.out.println(oficina);
        
    }
        
}

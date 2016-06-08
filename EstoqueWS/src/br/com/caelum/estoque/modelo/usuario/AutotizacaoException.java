package br.com.caelum.estoque.modelo.usuario;

import javax.xml.ws.WebFault;

@WebFault(name="AutorizacaoFault")
public class AutotizacaoException extends Exception {
	
	public AutotizacaoException(String mensagem){
		super(mensagem);
	}
	
	public String getFaultInfo(){
		return "Token Inválido";
	}
}

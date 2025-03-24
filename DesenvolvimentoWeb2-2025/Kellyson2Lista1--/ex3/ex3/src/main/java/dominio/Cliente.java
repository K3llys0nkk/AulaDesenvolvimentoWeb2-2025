package dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {
		
	private int codCliente;
	
	public Cliente() {
		this("","",0);
	}
	
	public Cliente(String nome, String idade, int codCliente) {
		super(nome,idade);
		setCodCliente(codCliente);
	}
	
	public int getCodCliente() {
		return this.codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	
	@Override
	public String toString() {
		return "Cliente [idPessoa= " + super.getIdPessoa() + ", nome= " + super.getNome() + ", codCliente= "
		+ getCodCliente() + "]";
	}
	
	public void imprimeDados() {
		System.out.println("Nome: "+ super.getNome());
		System.out.println("IDADE: "+ super.getIdade());
		System.out.println("Cod Cliente: "+ getCodCliente());
	}

}
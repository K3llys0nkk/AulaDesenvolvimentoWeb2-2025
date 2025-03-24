package aplicativo;

import dominio.Pessoa;
import dominio.Cliente;
import dominio.Vendedor;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Principal {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa"); //Instancia o EntityManagerFactory com as configurações de persistencia
		EntityManager em = emf.createEntityManager(); //Intancia o EntityManager
		
		Cliente cliente1 = new Cliente("Rafael", "34", 01);
		Vendedor vendedor1 = new Vendedor("Augusto", "26", 01);
		Pessoa pessoa1 = new Pessoa("Jose", "35");
		
		
		em.getTransaction().begin();// iniciar transação com banco de dados
		
		em.persist(cliente1);
		em.persist(vendedor1);
		em.persist(pessoa1);
		
		Query consultaC = em.createQuery("select cliente from Cliente cliente"); //consulta em jpql
		ArrayList<Cliente> listaC = (ArrayList<Cliente>) consultaC.getResultList();
		
		Query consultaV = em.createQuery("select vendedor from Vendedor vendedor"); //consulta em jpql
		ArrayList<Vendedor> listaV = (ArrayList<Vendedor>) consultaV.getResultList();

		Query consultaP = em.createQuery("select pessoa from Pessoa pessoa"); //consulta em jpql
		ArrayList<Pessoa> listaP = (ArrayList<Pessoa>) consultaP.getResultList();
		
		
		em.getTransaction().commit();//confirmar as alterações realizadas
		
		emf.close();
		em.close();
		
		for(Cliente objC: listaC) {
			System.out.println(objC);
		}
		
		for(Vendedor objV: listaV) {
			System.out.println(objV);
		}

		for(Pessoa objP: listaP) {
			System.out.println(objP);
		}
	}			
}
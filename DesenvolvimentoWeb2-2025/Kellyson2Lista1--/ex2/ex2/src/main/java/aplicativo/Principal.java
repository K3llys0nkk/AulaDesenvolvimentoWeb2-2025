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
		
		// Pessoa pessoa1 = new Pessoa("Lara", "XXX.XXX.XXX-XX");
		// Pessoa pessoa2 = new Pessoa("Cecilia", "XXX.XXX.XXX-XX");
		
		Cliente cliente1 = new Cliente("Rafael", "34", 01);
		Vendedor vendedor1 = new Vendedor("Augusto", "26", 01);
		
		// Cliente cliente2 = new Cliente("Gabriel", "XXX.XXX.XXX-XX", 0001);
		// Vendedor vendedor2 = new Vendedor("Uriel", "XXX.XXX.XXX-XX", 0001);
		
		em.getTransaction().begin();// iniciar transação com banco de dados
		
		// em.persist(pessoa1);
		// em.persist(pessoa2);
		
		em.persist(cliente1);
		em.persist(vendedor1);
		
		// em.persist(cliente2);
		// em.persist(vendedor2);
		
		Query consultaPessoa = em.createQuery("select pessoa from Pessoa pessoa"); //consulta em jpql
		ArrayList<Pessoa> listaPessoa = (ArrayList<Pessoa>) consultaPessoa.getResultList();
		
		Query consultaP = em.createQuery("select cliente from Cliente cliente"); //consulta em jpql
		ArrayList<Cliente> listaP = (ArrayList<Cliente>) consultaP.getResultList();
		
		Query consultaA = em.createQuery("select vendedor from Vendedor vendedor"); //consulta em jpql
		ArrayList<Vendedor> listaA = (ArrayList<Vendedor>) consultaA.getResultList();
		
		em.getTransaction().commit();//confirmar as alterações realizadas
		
		emf.close();
		em.close();
		
		for(Pessoa objPessoa: listaPessoa) {
			System.out.println(objPessoa);
		}
		
		for(Cliente objP: listaP) {
			System.out.println(objP);
		}
		
		for(Vendedor objA: listaA) {
			System.out.println(objA);
		}
	}			
}
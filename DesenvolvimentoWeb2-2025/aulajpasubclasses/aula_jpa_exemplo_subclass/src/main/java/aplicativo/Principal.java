package aplicativo;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import dominio.Pessoa;
import dominio.Professor;
import dominio.Aluno;

public class Principal {
    
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
    EntityManager em = emf.createEntityManager();

    Pessoa pessoa1 = new Pessoa("Nanada", "123123123");
    Pessoa pessoa2 = new Pessoa("Sambas", "123123123");

    Professor professor1 = new Professor("Taiga", "555111555", 1000);
    Professor professor2 = new Professor("TMagican", "555111555", 2000);

    Aluno aluno1 = new Aluno("sei la ", "555111555", 3000);
    Aluno aluno2 = new Aluno("sei linho ", "555111555", 4000);

    em.getTransaction().begin();
    em.persist(pessoa1);
    em.persist(pessoa2);

    em.persist(professor1);
    em.persist(professor2);

    em.persist(aluno1);
    em.persist(aluno2);

    Query ConsultaPessoa = em.createQuery("select pessoa from Pessoa pessoa");
    ArrayList<Pessoa> listaPessoa = (ArrayList) consultaPessoa.getResultList();

    Query ConsultaProfessor = em.createQuery("select professor from Professor professor");
    ArrayList<Professor> listaProfessor = (ArrayList) ConsultaProfessor.getResultList();

    Query ConsultaAluno = em.createQuery("select aluno from Aluno aluno");
    ArrayList<Aluno> listaAluno = (ArrayList) ConsultaAluno.getResultList();

    }
}

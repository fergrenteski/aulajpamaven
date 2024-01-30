package com.educandoweb.aulajpamaven.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.educandoweb.aulajpamaven.domain.Pessoa;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		Pessoa p = em.find(Pessoa.class, 2);

		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();

		System.out.println(p);

		em.close();
		emf.close();
	}

}

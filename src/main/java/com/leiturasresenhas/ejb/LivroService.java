package com.leiturasresenhas.ejb;

import com.leiturasresenhas.model.Livro;
import com.leiturasresenhas.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class LivroService {

    @PersistenceContext
    private EntityManager em;

    public void saveLivro(Livro livro) {
        em.persist(livro);
    }

    public void updateLivro(Livro livro) {
        em.merge(livro);
    }

    public void deleteLivro(Livro livro) {
        em.remove(em.contains(livro) ? livro : em.merge(livro));
    }

    public List<Livro> list() {
        return em.createQuery("SELECT p FROM Livro p ORDER BY p.titulo ASC", Livro.class).getResultList();
    }

    public List<Livro> search(String searchTerm) {
        return em.createQuery("SELECT p FROM Livro p WHERE p.titulo LIKE :searchTerm", Livro.class)
                .setParameter("searchTerm", "%" + searchTerm + "%")
                .getResultList();
    }
}

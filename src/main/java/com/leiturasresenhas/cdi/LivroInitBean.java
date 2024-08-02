package com.leiturasresenhas.cdi;

import com.leiturasresenhas.ejb.LivroService;
import com.leiturasresenhas.model.Livro;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class LivroInitBean {

    private List<Livro> livros;


    @Inject
    private LivroService livroService;

    @PostConstruct
    public void init() {
        livros = new ArrayList<>();
        livros.add(new Livro(null, "Dom Casmurro", "Machado de Assis", "Romance", LocalDateTime.of(1899, 8, 1, 0, 0),
                "Editora A", "5", "Excelente narrativa", true,
                LocalDateTime.of(2024, 7, 1, 0, 0), LocalDateTime.of(2024, 6, 1, 0, 0)));
        livros.add(new Livro(null, "O Alquimista", "Paulo Coelho", "Ficção", LocalDateTime.of(1988, 4, 1, 0, 0),
                "Editora B", "4", "Inspirador", true,
                LocalDateTime.of(2024, 7, 2, 0, 0), LocalDateTime.of(2024, 6, 2, 0, 0)));
        livros.add(new Livro(null, "Capitães da Areia", "Jorge Amado", "Drama", LocalDateTime.of(1937, 12, 1, 0, 0),
                "Editora C", "5", "Profundo e comovente", false,
                LocalDateTime.of(2024, 7, 3, 0, 0), LocalDateTime.of(2024, 6, 3, 0, 0)));
        livros.add(new Livro(null, "Memórias Póstumas de Brás Cubas", "Machado de Assis", "Romance", LocalDateTime.of(1881, 3, 1, 0, 0),
                "Editora D", "5", "Irônico e brilhante", true,
                LocalDateTime.of(2024, 7, 4, 0, 0), LocalDateTime.of(2024, 6, 4, 0, 0)));
        livros.add(new Livro(null, "A Hora da Estrela", "Clarice Lispector", "Drama", LocalDateTime.of(1977, 10, 1, 0, 0),
                "Editora E", "5 ", "Emocionante e reflexivo", false,
                LocalDateTime.of(2024, 7, 5, 0, 0), LocalDateTime.of(2024, 6, 5, 0, 0)));

        List<Livro> livrosDatabase = livroService.list();
        if (livrosDatabase.size() > 0) {
            return;
        }
        livros.forEach(livro -> livroService.saveLivro(livro));

    }
}
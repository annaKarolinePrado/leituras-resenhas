package com.leiturasresenhas.cdi;

import com.leiturasresenhas.ejb.LivroService;
import com.leiturasresenhas.ejb.PersonService;
import com.leiturasresenhas.model.Livro;
import com.leiturasresenhas.model.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Named
@RequestScoped
public class LivroBean {

    private Livro livro = new Livro();
    private String searchTerm = "";
    private List<Livro> filteredLivros;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Inject
    private LivroService livroService;

    private void loadLivros() {
        filteredLivros = livroService.list();
    }

    public void save() {
        System.out.println(livro.getId());
        if (livro.getId() == null) {
            livroService.saveLivro(livro);
        } else {
            livroService.updateLivro(livro);
        }
        livro = new Livro();
        loadLivros();
    }

    public Livro getLivro() {
        return livro;
    }

    public void edit(Livro livro) {
        this.livro = livro;
    }

    public void delete(Livro livro) {
        livroService.deleteLivro(livro);
        loadLivros();
    }

    public void cancel() {
        livro = new Livro();
    }

    public void search() {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            loadLivros();
        } else {
            filteredLivros = livroService.search(searchTerm);
        }
    }

    public List<Livro> getLivros() {
        search();
        return filteredLivros;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public String getFormattedDataLeitura(Livro livro) {
        if (livro.getDataLeitura() != null) {
            return livro.getDataLeitura().format(formatter);
        } else {
            return "";
        }
    }

    public String getFormattedDataPrevistaLeitura(Livro livro) {
        if (livro.getDataPrevistaLeitura() != null) {
            return livro.getDataPrevistaLeitura().format(formatter);
        } else {
            return "";
        }
    }
}

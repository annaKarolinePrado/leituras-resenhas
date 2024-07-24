package com.leiturasresenhas.cdi;

import com.leiturasresenhas.ejb.LivroService;
import com.leiturasresenhas.model.Livro;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
        try {
            livroService.deleteLivro(livro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Livro excluído com sucesso", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir o livro", e.getMessage()));
            e.printStackTrace();
        }
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

    public String getFormattedDataPublicacao(Livro livro) {
        if (livro.getDataPublicacao() != null) {
            return livro.getDataPublicacao().format(formatter);
        } else {
            return "";
        }

    }public String getFormattedDataLeitura(Livro livro) {
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

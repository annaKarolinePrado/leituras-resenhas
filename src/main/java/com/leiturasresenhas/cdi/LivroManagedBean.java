package com.leiturasresenhas.cdi;

import com.leiturasresenhas.model.Livro;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class LivroManagedBean {

    @EJB
    private LivroInitBean livroInitBean;

    private List<Livro> livros;

    @PostConstruct
    public void init() {
        livroInitBean.init();
    }
}
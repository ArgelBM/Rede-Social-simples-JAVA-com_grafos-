package negocio.beans;

import dados.RepositorioGeral;
import negocio.beans.Vertex;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Usuario implements Serializable {

    private String nomeUsuario;
    private String login;
    private String senha;
    private Vertex id;
    private String cpf;
    private ArrayList<Posts> posts;

    public Usuario(String nomeUsuario, String login, String senha, String cpf,Vertex vertice) {
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.id = vertice;
        this.posts = new ArrayList<>();

    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void addPosts(Posts post){
        posts.add(post);
        RepositorioGeral.getInstance().salvar();
    }

    public ArrayList<Posts> getPosts() {
        return posts;
    }

    public Vertex getId() {
        return id;
    }
}

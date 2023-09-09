package negocio;

import dados.RepositorioGeral;
import negocio.beans.Posts;
import negocio.beans.Usuario;

import java.io.Serializable;

public class ControladorUsuarios implements Serializable {

    private Usuario usuarioAtivo;
    private RepositorioGeral repositorio;
    private static ControladorUsuarios instance;

    public ControladorUsuarios(){
        repositorio = RepositorioGeral.getInstance();
    }
    public static ControladorUsuarios getInstance(){
        if(instance == null){
            instance = new ControladorUsuarios();
        }
        return instance;
    }

    public Usuario getUsuarioAtivo() {
        return usuarioAtivo;
    }

    public void fazerLogin(String login, String senha) throws NullPointerException, IllegalArgumentException {
        if (login == null || senha == null) {
            throw new NullPointerException("Credenciais inválidas");
        }
        usuarioAtivo = repositorio.fazerLogin(login,senha);
        if (usuarioAtivo ==  null) {
            throw new IllegalArgumentException("Usuario ou senha incorretos");
        }
    }


    public void adicionar(Usuario usuario) throws NullPointerException, IllegalArgumentException  {

        repositorio.adicionarUser(usuario);
    }

    public void sair(){
        usuarioAtivo = null;
    }
    public void remover(Usuario usuario) {
        repositorio.removerUser(usuario);
    }

    public RepositorioGeral getRepositorio() {
        return repositorio;
    }

    public void salvarMudancas(){
        repositorio.salvar();
    }



}

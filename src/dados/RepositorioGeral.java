package dados;

import negocio.beans.Usuario;
import negocio.beans.Graph;
import negocio.beans.Vertex;

import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioGeral implements Serializable {

    private String fileName;

    private Graph graph;
    private ArrayList<Usuario> userList;
    private static RepositorioGeral repositorioGeral;



    public static RepositorioGeral getInstance(){
        if (repositorioGeral == null){
            repositorioGeral = new RepositorioGeral("DATA");
        }
        return repositorioGeral;
    }

    public RepositorioGeral(String fileName) {
        this.fileName = fileName;
        Object instancia = RepositorioFileUtil.lerDoArquivo(fileName);
        if(instancia != null && instancia instanceof RepositorioGeral){
            RepositorioGeral dadosCarregados = (RepositorioGeral) instancia;
            this.graph = dadosCarregados.getGraph();
            this.userList = dadosCarregados.getUserList();
        }
        else{
            this.graph = new Graph();
            this.userList = new ArrayList<>();


        }
        System.out.println(fileName);
    }

    public Usuario fazerLogin(String login, String senha) throws NullPointerException, IllegalArgumentException {

        for (Usuario usuario : userList) {

            System.out.println(usuario.getNomeUsuario() +","+ usuario.getCpf());
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                salvar();
                return usuario;
            }
        }
        return null;
    }

    public void adicionarUser(Usuario user){

        for(Usuario a : userList){
            if (a.getLogin().equals(user.getLogin()) || a.getCpf().equals(user.getCpf())){
                throw new IllegalArgumentException();
            }
        }
        userList.add(user);
        System.out.println("adicionou");
        salvar();

    }

    public void removerUser(Usuario user){
        userList.remove(user);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public ArrayList<Usuario> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<Usuario> userList) {
        this.userList = userList;
    }

    public static RepositorioGeral getRepositorioGeral() {
        return repositorioGeral;
    }

    public static void setRepositorioGeral(RepositorioGeral repositorioGeral) {
        RepositorioGeral.repositorioGeral = repositorioGeral;
    }

    public void salvar(){
        RepositorioFileUtil.salvarArquivo(repositorioGeral, fileName);
    }


    public Usuario findByVertex(Vertex vertex){
        for(Usuario usuario : userList){
            if (usuario.getId() == vertex){
                return usuario;
            }
        }
        return null;
    }

}

package dados;

import negocio.beans.Usuario;
import negocio.beans.Graph;
import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioGeral implements Serializable {

    private String fileName;
    private ArrayList<Graph> graphList;
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
            this.graphList = dadosCarregados.getGraphList();
            this.userList = dadosCarregados.getUserList();
        }
        else{
            this.graphList = new ArrayList<>();
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

    public ArrayList<Graph> getGraphList() {
        return graphList;
    }

    public void setGraphList(ArrayList<Graph> graphList) {
        this.graphList = graphList;
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
}

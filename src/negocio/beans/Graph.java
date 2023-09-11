package negocio.beans;

import dados.RepositorioGeral;
import negocio.ControladorUsuarios;

import java.io.Serializable;
import java.util.ArrayList;

public class Graph implements Serializable {

    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;

    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Vertex source, Vertex destination) {
        edges.add(new Edge(source, destination));
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public Vertex getVertex(int index) {
        return vertices.get(index);
    }

    public Edge getEdge(Vertex source, Vertex destination) {
        for (Edge edge : edges) {
            if (edge.getSource() == source && edge.getDestination() == destination) {
                return edge;
            }
        }

        return null;
    }

    public ArrayList<Vertex> getSeguindo(Vertex usuario){

        ArrayList<Vertex> seguindo = new ArrayList<>();

        for( Edge edge : edges){
            if (edge.getSource() == usuario){
                seguindo.add(edge.getDestination());
            }
        }
        return seguindo;
    }

    public ArrayList<Vertex> getSeguidores(Vertex usuario){

        ArrayList<Vertex> seguidores = new ArrayList<>();

        for( Edge edge : edges){
            if (edge.getSource() == usuario){
                seguidores.add(edge.getDestination());
            }
        }
        return seguidores;
    }

    public ArrayList<Vertex> getSeguindoEmComum(Vertex usuario1, Vertex usuario2){

        ArrayList<Vertex> comuns = new ArrayList<>();

        for(Vertex vertex1 : getSeguindo(usuario1)){
            for(Vertex vertex2 : getSeguindo(usuario2)){
                if(vertex1 == vertex2){
                    comuns.add(vertex1);
                }
            }
        }
        return comuns;
    }

    public ArrayList<Vertex> getSugestoesDePessoaEspecifica(Vertex usuario1, Vertex usuarioAlvo){

        ArrayList<Vertex> sugestoes = new ArrayList<>();

        ArrayList<Vertex> comuns_1e2 = getSeguindoEmComum(usuario1, usuarioAlvo);

        for( Vertex vertex: comuns_1e2){
            for( Vertex vertex1 : getSeguindoEmComum(usuarioAlvo, vertex)){
                sugestoes.add(vertex1);

            }
        }

        return sugestoes;
    }

    public ArrayList<Posts> getPostagens(Vertex usuario){

        return new ArrayList<>(RepositorioGeral.getInstance().findByVertex(usuario).getPosts());

    }

    public ArrayList<Posts> getFeedByUser(){
        ArrayList<Posts> posts = new ArrayList<>();
        for(Vertex vertex : getSeguidores(ControladorUsuarios.getInstance().getUsuarioAtivo().getId())) {
            posts.addAll(RepositorioGeral.getInstance().findByVertex(vertex).getPosts());
        }
        posts.addAll(ControladorUsuarios.getInstance().getUsuarioAtivo().getPosts());
        return posts;
    }
}

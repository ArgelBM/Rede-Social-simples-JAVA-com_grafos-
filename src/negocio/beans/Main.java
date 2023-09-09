package negocio.beans;


public class Main {
    public static void main(String[] args) {
        // Cria um novo grafo
        Graph graph = new Graph();

        // Adiciona vértices
        Vertex v1 = new Vertex("A","123");
        Vertex v2 = new Vertex("B", "123");
        Vertex v3 = new Vertex("C", "123");
        Vertex v4 = new Vertex("D", "123");

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        // Adiciona arestas
        graph.addEdge(v3, v1);
        graph.addEdge(v4, v1);
        graph.addEdge(v2, v3);
        graph.addEdge(v2, v4);
        graph.addEdge(v3, v4);

        // Exibe os vértices
        System.out.println("Vértices:");
        for (Vertex vertex : graph.getVertices()) {
            System.out.println(vertex);
        }
        System.out.println();

        // Exibe as arestas
        System.out.println("Arestas:");
        for (Edge edge : graph.getEdges()) {
            System.out.println(edge);
        }
        System.out.println();


        // exibe seguindo

        System.out.println("seguindo de v1:");
        for (Vertex vertex: graph.getSeguindo(v1)){
            System.out.println(vertex);
        }
        System.out.println();


        //exibe seguidores

        System.out.println("seguimores de v1");
        for ( Vertex vertex : graph.getSeguidores(v1)){
            System.out.println(vertex);
        }
        System.out.println();

        //seguidores comuns entre c,b

        System.out.println("comuns(c,b): ");
        for ( Vertex vertex : graph.getSeguindoEmComum(v2,v3)){
            System.out.println(vertex);
        }
        System.out.println();



        // sugestoes de a para c

        System.out.println("sugestoes de a para c: ");
        for ( Vertex vertex : graph.getSugestoesDePessoaEspecifica(v2,v3)){
            System.out.println(vertex);
        }




    }
}
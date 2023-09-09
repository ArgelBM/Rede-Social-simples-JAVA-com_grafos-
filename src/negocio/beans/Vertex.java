package negocio.beans;

import java.io.Serializable;

public class Vertex implements Serializable {

    private String label;
    private String cpf;

    public Vertex(String label, String cpf) {
        this.label = label;
        this.cpf = cpf;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return label;
    }
}

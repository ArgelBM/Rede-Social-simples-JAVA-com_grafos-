package negocio.beans;

import negocio.ControladorUsuarios;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Posts implements Serializable {

    public Posts(String conteudo) {
        this.conteudo = conteudo;
        this.horario = LocalDateTime.now();
        this.usuario = ControladorUsuarios.getInstance().getUsuarioAtivo().getNomeUsuario(); ///CUIDADO ALERTA ALERTA
    }

    private String usuario;
    private String conteudo;
    private LocalDateTime horario;

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public String getUsuario() {
        return usuario;
    }
}

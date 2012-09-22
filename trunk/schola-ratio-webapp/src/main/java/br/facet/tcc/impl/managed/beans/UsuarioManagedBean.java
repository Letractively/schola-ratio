package br.facet.tcc.impl.managed.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import br.facet.tcc.enums.Status;
import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.datamodel.UsuarioDataModel;
import br.facet.tcc.impl.service.GestaoUsuarioImpl;
import br.facet.tcc.pojo.UserLogin;
import br.facet.tcc.pojo.Usuario;

/**
 * 
 * User Managed Bean
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
@ManagedBean(name = "userMB")
@ViewScoped
public class UsuarioManagedBean extends ConstantsMB implements Serializable {

    private static final Logger log = Logger
            .getLogger(UsuarioManagedBean.class);

    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{usurioService}")
    private GestaoUsuarioImpl usurioService;

    @ManagedProperty("#{usuarioDataModel}")
    private UsuarioDataModel usuarioDataModel;

    private List<Usuario> listaUsuarios;

    private Usuario usuarioSalvar;

    private Usuario usuarioPesquisar = new Usuario();

    private Usuario usuarioSelecionado;

    public UsuarioManagedBean() {
        this.listaUsuarios = new ArrayList<Usuario>();
        this.reset();
    }

    /**
     * Add User
     * 
     * @return String - Response Message
     */
    public String salvarUsuario() {
        try {
            this.usurioService.salvarUsuario(this.usuarioSalvar);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Usuario salvo com sucesso.", "Código : "
                            + this.usuarioSalvar.getId());
            FacesContext.getCurrentInstance().addMessage("message", message);
            this.reset();
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }

        return null;
    }

    /**
     * Update User
     * 
     * @return String - Response Message
     */
    public String atualizarUsuario() {
        try {
            this.usurioService.alterarUsuario(this.usuarioSelecionado);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Usuario atualizado com sucesso.", "Código : "
                            + this.usuarioSalvar.getId());
            FacesContext.getCurrentInstance().addMessage("message", message);
            this.reset();
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }
        return null;
    }

    /**
     * Search user
     * 
     * @return
     * @since 0.0.1
     */
    public String pesquisarUsuarios() {

        listaUsuarios = new ArrayList<Usuario>();
        if ("".equals(usuarioPesquisar.getNome())) {
            usuarioPesquisar.setNome(null);
        }

        if (usuarioPesquisar.getCpf() == 0) {
            usuarioPesquisar.setCpf(null);
        }

        if ("".equals(usuarioPesquisar.getUserLogin().getUsername())) {
            usuarioPesquisar.setUserLogin(null);
        }

        try {
            listaUsuarios = usurioService.consultarUsuario(usuarioPesquisar);
            this.usuarioDataModel.setWrappedData(listaUsuarios);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Busca realizada com sucesso.", this.listaUsuarios.size()
                            + " usuários encontrado.");
            FacesContext.getCurrentInstance().addMessage("message", message);
            this.reset();
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }

        return null;
    }

    /**
     * List users
     * 
     * @return
     * @since schola-ratio-webapp 0.0.1
     */
    public String listarUsuarios() {
        try {
            this.listaUsuarios = this.usurioService
                    .listarUsuario(Usuario.class);
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }

        return null;
    }

    public String removerUsuario() {

        try {
            this.usurioService.removerUsuario(usuarioSelecionado);
            this.listaUsuarios.remove(usuarioSelecionado);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Usuario removido com sucesso.", "");
            FacesContext.getCurrentInstance().addMessage("message", message);
            this.reset();
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }
        return null;
    }

    /**
     * Reset Fields
     * 
     */
    public void reset() {
        usuarioSalvar = new Usuario();
        usuarioPesquisar = new Usuario();
        usuarioSalvar.setUserLogin(new UserLogin());
        usuarioPesquisar.setUserLogin(new UserLogin());
        usuarioSalvar.setStatus(Status.ATIVO);
    }

    /**
     * Get User List
     * 
     * @return List - User List
     */
    public List<Usuario> getListaUsuarios() {

        return listaUsuarios;
    }

    /**
     * @return the usuarioDataModel
     */
    public UsuarioDataModel getUsuarioDataModel() {
        return usuarioDataModel;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuarioSalvar() {
        return usuarioSalvar;
    }

    /**
     * @return the usuarioSelecionado
     */
    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    /**
     * @return the usuarioPesquisar
     */
    public Usuario getUsuarioPesquisar() {
        return usuarioPesquisar;
    }

    /**
     * @param usurioService
     *            the usurioService to set
     */
    public void setUsurioService(GestaoUsuarioImpl usurioService) {
        this.usurioService = usurioService;
    }

    /**
     * @param usuario
     *            the usuario to set
     */
    public void setUsuarioSalvar(Usuario usuario) {
        this.usuarioSalvar = usuario;
    }

    /**
     * @param usuarioDataModel
     *            the usuarioDataModel to set
     */
    public void setUsuarioDataModel(UsuarioDataModel usuarioDataModel) {
        this.usuarioDataModel = usuarioDataModel;
    }

    /**
     * @param usuarioSelecionado
     *            the usuarioSelecionado to set
     */
    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    public void setUsuarioPesquisar(Usuario usuarioPesquisar) {
        this.usuarioPesquisar = usuarioPesquisar;
    }
}
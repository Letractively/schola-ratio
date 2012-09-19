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
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

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

    private static final String SUCCESS = "success";

    private static final String ERROR = "error";

    @ManagedProperty("#{usurioService}")
    private GestaoUsuarioImpl usurioService;

    private List<Usuario> listaUsuarios;

    private Usuario usuarioSalvar;

    private Usuario usuarioPesquisar;

    @ManagedProperty("#{usuarioDataModel}")
    private UsuarioDataModel usuarioDataModel;

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
        if ("".equals(usuarioSalvar.getNome())) {
            log.info("UsuarioManagedBean.usuario.nome é vazio.");
            usuarioSalvar.setNome(null);
        }

        if (usuarioSalvar.getCpf() == 0) {
            log.info("UsuarioManagedBean.usuario.cpf é vazio.");
            usuarioSalvar.setCpf(null);
        }

        if ("".equals(usuarioSalvar.getUserLogin().getUsername())) {
            log.info("UsuarioManagedBean.usuario.login é vazio.");
            usuarioSalvar.setUserLogin(null);
        }

        try {
            listaUsuarios = usurioService.consultarUsuario(usuarioSalvar);
            log.info("UsuarioManagedBean.lista carregada.");
            this.usuarioDataModel.setWrappedData(listaUsuarios);
            log.info("UsuarioManagedBean.datamodel criado.");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    this.listaUsuarios.size() + " usuários encontrado.", "");
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
        UserLogin userLogin = new UserLogin();
        usuarioSalvar = new Usuario();
        usuarioSalvar.setStatus(Status.ATIVO);
        usuarioSalvar.setUserLogin(userLogin);
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Usuario selecionado:", ((Usuario) event.getObject()).getNome());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
                ((Usuario) event.getObject()).getNome());

        FacesContext.getCurrentInstance().addMessage(null, msg);
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

    public Usuario getUsuarioPesquisar() {
        return usuarioPesquisar;
    }

    public void setUsuarioPesquisar(Usuario usuarioPesquisar) {
        this.usuarioPesquisar = usuarioPesquisar;
    }

}
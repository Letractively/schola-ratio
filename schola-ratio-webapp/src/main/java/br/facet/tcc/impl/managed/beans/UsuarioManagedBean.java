package br.facet.tcc.impl.managed.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.facet.tcc.exception.ServiceException;
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
@RequestScoped
public class UsuarioManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String SUCCESS = "success";

    private static final String ERROR = "error";

    @ManagedProperty("#{usurioService}")
    private GestaoUsuarioImpl usurioService;

    private List<Usuario> listaUsuarios;

    private Usuario usuario;

    public UsuarioManagedBean() {
        this.reset();
    }

    /**
     * Add User
     * 
     * @return String - Response Message
     */
    public String addUser() {
        return SUCCESS;
    }

    /**
     * Reset Fields
     * 
     */
    public void reset() {
        UserLogin userLogin = new UserLogin();
        usuario = new Usuario();
        usuario.setUserLogin(userLogin);

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
     * @return
     * @since TODO: class_version
     */
    public String pesquisarUsuarios() {
        listaUsuarios = new ArrayList<Usuario>();
        if ("".equals(usuario.getNome())) {
            usuario.setNome(null);
        }

        if (usuario.getCpf() == 0) {
            usuario.setCpf(null);
        }

        if ("".equals(usuario.getUserLogin().getUsername())) {
            usuario.setUserLogin(null);
        }

        try {
            listaUsuarios = usurioService.consultarUsuario(usuario);
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return null;
    }

    /**
     * @param usurioService
     *            the usurioService to set
     */
    public void setUsurioService(GestaoUsuarioImpl usurioService) {
        this.usurioService = usurioService;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario
     *            the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
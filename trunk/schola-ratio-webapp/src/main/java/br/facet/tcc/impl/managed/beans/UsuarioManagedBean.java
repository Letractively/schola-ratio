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
        this.usuario = new Usuario();
    }

    /**
     * Get User List
     * 
     * @return List - User List
     */
    public List<Usuario> getListaUsuarios() {
        listaUsuarios = new ArrayList<Usuario>();
        try {

            listaUsuarios.addAll(usurioService.listarUsuario(Usuario.class));

        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                    .getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return listaUsuarios;
    }

    /**
     * @param usurioService
     *            the usurioService to set
     */
    public void setUsurioService(GestaoUsuarioImpl usurioService) {
        this.usurioService = usurioService;
    }

}
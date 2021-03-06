/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Usuario;



/**
 * REST Web Service
 *
 * @author ACER
 */
@Path("fazenda")
public class WS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FazendaWS
     */
    public WS() {
    }

    /**
     * Retrieves representation of an instance of ws.FazendaWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/text")
    public String getJson() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return "Meu primeiro WS RestFull";
    }

    @GET
    @Produces("application/json")
    @Path("Usuario/get/{login}")
    
    public String getUsuario(@PathParam("login")String login) {
        
        Usuario u=new Usuario();
        u.setLogin(login);
        
        UsuarioDAO dao= new UsuarioDAO();
        u=dao.buscar(u);
      
        //Converter para Gson
        Gson g=new Gson();
        return g.toJson(u);
        
        //return "Milton Lima, Login: 123";
    }
    
    @GET
    @Produces("application/json")
    @Path("Usuario/list")
    public String listUsuario() {
        
        List<Usuario>lista;
        
       //UsuarioDAO dao=new UsuarioDAO();
      // lista=dao.listar();
        UsuarioDAO dao = new UsuarioDAO();
       
        lista=dao.listar();
        //Converter para Gson
        Gson g=new Gson();
        
        return g.toJson(lista);
        
        //return "Milton Lima, Login: 123";
    }
    
    /**
     * PUT method for updating or creating an instance of FazendaWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import modelo.Usuario;

/**
 * REST Web Service
 *
 * @author ACER
 */
@Path("fazenda")
public class FazendaWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FazendaWS
     */
    public FazendaWS() {
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
    @Path("Usuario/get")
    public String getUsuario() {
        
        Usuario u=new Usuario();
        
        u.setEmail("mlima@gmail.com");
        u.setLogin("MMM");
        u.setSenha("123");
        u.setPerfil("Admin");
        
        //Converter para Gson
        Gson g=new Gson();
        
        return g.toJson(u);
        
        //return "Milton Lima, Login: 123";
    }
    
     @GET
    @Produces("application/json")
    @Path("Usuario/list")
    public String listUsuario() {
        
        List<Usuario>lista=new ArrayList<Usuario>();
        Usuario u=new Usuario();
        
        u.setEmail("mlima@gmail.com");
        u.setLogin("MMM");
        u.setSenha("123");
        u.setPerfil("Admin");
        
        lista.add(u);
        
        u.setEmail("mgomes@gmail.com");
        u.setLogin("GGG");
        u.setSenha("1234");
        u.setPerfil("Usuario");
        
        lista.add(u);
        
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

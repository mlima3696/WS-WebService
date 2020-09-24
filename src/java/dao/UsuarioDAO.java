/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author marcelosiedler
 */
public class UsuarioDAO {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
    public UsuarioDAO()
    {
    
    }
    
    public boolean inserir(Usuario usuario)
    {
        String sql = "INSERT INTO  zy (login,codigo,desc_produto,preco) VALUES(?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, usuario.getLogin());
            pst.setInt(2, usuario.getCodigo());
            pst.setString(3, usuario.getDesc_produto());
            pst.setDouble(4, usuario.getPreco());
            
            
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    public boolean atualizar(Usuario usuario)
    {
        String sql = "UPDATE  zy set login=? codigo=?,desc_produto=?,preco=? where codigo=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
          
            pst.setString(1, usuario.getLogin());
            pst.setInt(2, usuario.getCodigo());
            pst.setString(3, usuario.getDesc_produto());
            pst.setDouble(4, usuario.getPreco());
            
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    
    /*public boolean excluir(Usuario usuario)
    {
        String sql = "DELETE FROM usuario where login=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
          
           
            pst.setString(1, usuario.getLogin());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }*/
    
    public List<Usuario> listar()
    {
         String sql = "SELECT * FROM zy";
        List<Usuario> retorno = new ArrayList<>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Usuario item = new Usuario();
                item.setLogin(res.getString("login"));
                item.setCodigo(res.getInt("codigo"));
                item.setDesc_produto(res.getString("desc_produto"));
                item.setPreco(res.getDouble("preco"));
                
                
                retorno.add(item);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }
    public Usuario buscar(Usuario usuario)
    {
         String sql = "SELECT * FROM zy where login=?";
        Usuario retorno = new Usuario();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            pst.setString(1, usuario.getLogin());
            ResultSet res = pst.executeQuery();
            
            if(res.next())
            {
                retorno = new Usuario();
               retorno.setLogin(res.getString("login"));
                retorno.setCodigo(res.getInt("codigo"));
                retorno.setDesc_produto(res.getString("desc_produto"));
                retorno.setPreco(res.getDouble("preco"));
                
                
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }


}

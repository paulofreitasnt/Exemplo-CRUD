package com.ifpb.login.controle;

import com.ifpb.login.modelo.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDao {
    
    public Usuario read(String email) throws ClassNotFoundException, SQLException, IOException;
    public List<Usuario> list() throws ClassNotFoundException, SQLException, IOException;
    public boolean create(Usuario usuario) throws ClassNotFoundException, SQLException, IOException;
    public boolean delete(String email) throws ClassNotFoundException, SQLException, IOException;
    public boolean update(Usuario usuario) throws ClassNotFoundException, SQLException, IOException;    
    
}

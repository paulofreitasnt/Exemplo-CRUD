package com.ifpb.login.controle;

import com.ifpb.login.modelo.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoBinario {

    private File arquivo;

    public UsuarioDaoBinario() throws IOException {
        arquivo = new File("Usuarios.bin");

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
    }

    public List<Usuario> list() throws IOException, ClassNotFoundException {

        if (arquivo.length() > 0) {
            ObjectInputStream input = new ObjectInputStream(
                    new FileInputStream(arquivo));

            return (List<Usuario>) input.readObject();

        } else {
            return new ArrayList<>();
        }
    }

    public Usuario read(String email) throws IOException, ClassNotFoundException {

        List<Usuario> usuarios = list();

        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public boolean create(Usuario u) throws IOException, ClassNotFoundException {

        List<Usuario> usuarios = list();

        for (Usuario user : usuarios) {
            if (user.getEmail().equals(u.getEmail())) {
                return false;
            }
        }

        usuarios.add(u);

        atualizarArquivo(usuarios);

        return true;

    }

    public boolean delete(Usuario u) throws IOException, ClassNotFoundException {

        List<Usuario> usuarios = list();

        if (usuarios.remove(u)) {
            atualizarArquivo(usuarios);
            return true;

        } else {
            return false;
        }
    }

    public boolean update(Usuario u) throws IOException, ClassNotFoundException {

        List<Usuario> usuarios = list();

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getEmail().
                    equals(u.getEmail())) {
                usuarios.set(i, u);

                atualizarArquivo(usuarios);

                return true;
            }
        }
        return false;
    }

    private void atualizarArquivo(List<Usuario> usuarios) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(arquivo));

        out.writeObject(usuarios);
        out.close();
    }

}

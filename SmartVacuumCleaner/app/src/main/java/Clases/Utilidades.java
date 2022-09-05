package Clases;

import static android.os.Environment.*;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;

public class Utilidades {

    /**public static ArrayList<Usuario> listaDeUsuarios() {


        BufferedReader bufferLectura = null;
        try {

            bufferLectura = new BufferedReader(new FileReader("usuarios.txt"));
            String linea = bufferLectura.readLine();
            while (linea != null) {
                String[] datos = linea.split(";");
                Usuario user = new Usuario(datos[0],datos[1],datos[2],datos[3],datos[4]);
                usuarios.add(user);
                linea = bufferLectura.readLine();
            }
            return usuarios;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return usuarios;
    }*/


}

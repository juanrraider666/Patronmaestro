package com.example.usuario.patronmaestro;

import java.util.ArrayList;

public class extraccion {


    private  int imagen;
    private String titulo;
    public  extraccion(){
        imagen =0;
        titulo = "";
    }

        public extraccion(int imagen, String titulo) {
        this.imagen = imagen;
        this.titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



public ArrayList<extraccion>listademenu(){

        extraccion Extraccion;
        ArrayList<extraccion>lista= new ArrayList<extraccion>();
        Integer[]idImagen=new Integer[]{R.drawable.sitio3,R.drawable.sitio4,R.drawable.sitio5};
        String[]titulo = new String[]{"sitio1 ","sitio2","sitio3"};

        for (int i = 0 ; i<idImagen.length; i++){
            Extraccion = new extraccion(idImagen[i],titulo[i]);

            lista.add(Extraccion);
        }

        return lista;
}

}

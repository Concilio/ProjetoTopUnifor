package br.unifor.ilikemyheadphone;

/**
 * Created by labm4 on 10/07/2015.
 */
public class FeedUsuario {

    private String comentario, modelo, marca;
    private int foto;
    private float nota;


    public FeedUsuario(String comentario, String marca, String modelo, float nota, int foto) {
        this.comentario = comentario;
        this.marca = marca;
        this.modelo = modelo;
        this.nota = nota;
        this.foto = foto;
    }


//    public FeedUsuario(String comentario, String marca, String foto, int nota) {
//        this.comentario = comentario;
//        this.marca = marca;
//        this.foto = foto;
//        this.nota = nota;
//    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public FeedUsuario(String comentario, int foto) {
        this.comentario = comentario;
        this.foto = foto;

    }

//    public FeedUsuario(String comentario) {
//        this.comentario = comentario;
//
//
//
//    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public float getNota() {
        return nota;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

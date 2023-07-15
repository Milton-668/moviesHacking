package service;

import model.Movie;

import java.util.List;

public class MoviesProcess {

    //Lista todos os filmes
    public static void moviesProcessLoadedCVS() {
        List<Movie> movies = new MoviesLoadService().moviesLoadCVS();

        System.out.println("Filmes" + movies);
    }
    //Pesquisa por nome
    //Pesquisa por Id
    //Ordenar por ano
    //Ordernar por Id
    //Eliminar Dados duplicados
    //


    public static void main(String[] args) {
        MoviesProcess.moviesProcessLoadedCVS();
    }
}



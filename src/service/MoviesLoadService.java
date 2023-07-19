package service;

import model.Movie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoviesLoadService {

    public static String PATH_FILE = "src/resources/hacking.csv";
    public static String PATH_FILE3 = "src/resources/hacking3.csv";

    public List<Movie> moviesLoadCVS() {
        List<Movie> movies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PATH_FILE3))) {

            br.readLine(); // Remover o cabeçalho

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                int id = Integer.parseInt(dados[0].trim());
                String nome = dados[1].trim();
                String ano = dados[2].trim();

                Movie movie = new Movie(id, nome, ano);
                movies.add(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;

    }

}

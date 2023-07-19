package service;

import model.Movie;
import model.MovieFull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MoviesProcess {

    private final DataIn reading;
    public static String PATH_FILE3 = "src/resources/hacking3.csv";
    public static String PATH_FILE = "src/resources/hacking.csv";


    public MoviesProcess(DataIn reading) {
        this.reading = reading;
    }

    //Pesquisa por todos os filmes
    public void findAll() throws IOException {
        Files.lines(Paths.get(PATH_FILE))
                .skip(1)
                .map(line -> line.split(";"))
                .map(col -> new Movie(Integer.parseInt(col[0]), col[1], col[2]))
                .forEach(System.out::println);
    }

    public void findByIdInputOrElse() throws IOException {
        Integer id = reading.obterEntradaAsInt();
        Files.lines(Paths.get(PATH_FILE))
                .skip(1)
                .map(line -> line.split(";"))
                .map(col -> new Movie(Integer.parseInt(col[0]), col[1], col[2]))
                .filter(str -> str.id() == id)
                .forEach(System.out::println);
    }

    private void findByNameIgnoreContaining() throws IOException {
        String nome = reading.obterEntrada();
        Files.lines(Paths.get(PATH_FILE), StandardCharsets.UTF_8)
                .skip(1)
                .map(line -> line.split(";"))
                .map(col -> new Movie(Integer.parseInt(col[0]), col[1], col[2]))
                .filter(str -> str.nome().contains(nome))
                .forEach(System.out::println);
    }

    private void findByAgeLanca() throws IOException {
        String ano = reading.obterEntrada();
        Files.lines(Paths.get(PATH_FILE))
                .skip(1)
                .map(line -> line.split(";"))
                .map(col -> new Movie(Integer.parseInt(col[0]), col[1], col[2]))
                .filter(str -> str.ano().contains(ano))
                .forEach(System.out::println);
    }

    public void findByIdRange() throws IOException {
        Integer ano = reading.obterEntradaAsInt();
        Files.lines(Paths.get(PATH_FILE))
                .skip(1)
                .map(line -> line.split(";"))
                .map(col -> new MovieFull(Integer.parseInt(col[0]), col[1], Integer.parseInt(col[2])))
                .mapToInt(MovieFull::ano).sorted().limit(20)
                //.map(x -> -x).sorted().limit(20)
                //.filter(str -> str.ano() == ano).sorted().limit(10)
                .forEach(System.out::println);
    }


    private void optionsOfInput(String options) throws IOException {
        switch (options) {
            case "1":
                findAll();

                pularLinha(2);
                break;
            case "2":
                findByNameIgnoreContaining();
                pularLinha(2);
                break;
            case "3":
                findByIdInputOrElse();
                pularLinha(2);
                break;
            case "4":
                //findByAgeLanca();
                findByIdRange();
                break;
            case "0":
                break;
        }
    }


    public void processOptions() throws IOException {

        String options = entradaDoUsuario(reading);

        while (!escolheuSair(options)) {
            optionsOfInput(options);
            options = entradaDoUsuario(reading);
        }
        System.out.println("Até mais ver!");
    }

    private boolean escolheuSair(String options) {
        return options.equals("0");
    }

    private String entradaDoUsuario(DataIn reading) {
        menuOptions();
        System.out.println("Digite a opção desejada: ");
        return reading.obterEntrada().toLowerCase();
    }

    private void menuOptions() {
        System.out.println("-----Digite a opção desejada-----");
        System.out.println("Pesquisa por todos os filmes: 1 ");
        System.out.println("Pesquisa por nome: 2");
        System.out.println("Pesquisa por ID: 3");
        System.out.println("Pesquisa por ano de lançamento: 4");
        System.out.println("-----Digite 0(zero) para sair-----");
    }

    public void pularLinha(int numeroDeLinhas) {
        for (int i = 1; i <= numeroDeLinhas; i++) {
            System.out.println();
        }
    }

}



package service;

import java.util.Locale;
import java.util.Scanner;

public class DataIn implements AutoCloseable {

    private Scanner scanner;

    public DataIn() {
        scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
    }

    public String obterEntrada() {
        return scanner.nextLine();
    }

    public Integer obterEntradaAsInt() {
        Integer retorno = scanner.nextInt();
        scanner.nextLine(); // limpar buffer
        return retorno;
    }

    @Override
    public void close() {
        scanner.close();
    }
}

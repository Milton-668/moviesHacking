package com.company;

import service.DataIn;
import service.MoviesProcess;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try (DataIn reading = new DataIn()) {
            new MoviesProcess(reading).processOptions();
        } catch (IOException e) {

        }
    }
}

package kea.pokedexbackend;

import kea.pokedexbackend.Console.PokedexConsolePrinter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokedexBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokedexBackendApplication.class, args);
        var printer = new PokedexConsolePrinter();
        printer.print();
    }

}

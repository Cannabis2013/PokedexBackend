package kea.pokedexbackend.Console;

public class PokedexConsolePrinter {
    public void print(){
        printIntro();
        printEndpoints();
    }

    private void printIntro(){
        System.out.println("""
                
                Hello and welcome to Pokedex API
                
                The server is up and running :-D
                
                Listenening on port 8080 on a non-secure connection
                """);
    }

    private void printEndpoints(){
        System.out.println("""
                Endpoints:
                
                Get all pokemons: http://localhost:8080/getAll
                """);
    }
}

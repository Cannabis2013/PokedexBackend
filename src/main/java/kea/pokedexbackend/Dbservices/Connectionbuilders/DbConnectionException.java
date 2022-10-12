package kea.pokedexbackend.Dbservices.Connectionbuilders;

public class DbConnectionException extends Exception{
    public DbConnectionException(Exception e){
        internalMessage = e.getMessage();
    }

    @Override
    public String getMessage() {
        return "Database error. Internal error message: "
                + internalMessage;
    }

    private final String internalMessage;
}

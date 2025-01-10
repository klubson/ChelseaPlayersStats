package klubson.chelseapoland.ChelseaPlayersStats.exception;

public class CompetitionAlreadyExistsException extends RuntimeException{
    private String message;
    public CompetitionAlreadyExistsException() {}
    public CompetitionAlreadyExistsException(String message){
        super(message);
        this.message = message;
    }
}

package klubson.chelseapoland.ChelseaPlayersStats.exception;

import lombok.Getter;

@Getter
public class TeamAlreadyExistsException extends RuntimeException{
    private String message;
    public TeamAlreadyExistsException() {}
    public TeamAlreadyExistsException(String message){
        super(message);
        this.message = message;
    }
}

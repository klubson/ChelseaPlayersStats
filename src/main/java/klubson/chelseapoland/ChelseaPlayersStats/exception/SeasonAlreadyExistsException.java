package klubson.chelseapoland.ChelseaPlayersStats.exception;

import lombok.Getter;

@Getter
public class SeasonAlreadyExistsException extends RuntimeException{
    private String message;
    public SeasonAlreadyExistsException() {}
    public SeasonAlreadyExistsException(String message){
        super(message);
        this.message = message;
    }
}

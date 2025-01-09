package klubson.chelseapoland.ChelseaPlayersStats.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ObjectAlreadyExistsError {
    private String errorHeader;
    private String errorMessage;
    private String backToPreviousPageButtonText;
}

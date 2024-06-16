package lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.User;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {         //это поджо класс
    private User data;

}


package kadehar;

import lombok.User;
import models.UserData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    void singleUser() {  // гет запрос на одного пользователя, используем спеки запросы
        Specs.request
                .when()
                .get("/users/2")
                .then()
                .log().body();
    }

    @Test
    void listOfUsers() {  // смотрим всех пользователей со 2 страницы
        Specs.request
                .when()
                .get("users?page=2")
                .then()
                .log().body();
    }

    @Test
    void listOfUsersFormatOff() {  // смотрим всех пользователей со 2 страницы
        //@formatter:off
        Specs.request
                .when()
                .get("users?page=2")
                .then()
                    .log().body();
        //@formatter:on
    }

    @Test
    void checkUser() {  // используем спеки запросы и ответа
        Specs.request
                .when()
                .get("/users/2")
                .then()
                .spec(Specs.responseSpec)  // спек-ответ
                .log().body();
    }
// урл : https://reqres.in/api/users/2
//  тело ответа: { "data": { "id": 2, "email": "janet.weaver@reqres.in", "first_name": "Janet",
// "last_name": "Weaver", "avatar": "https://reqres.in/img/faces/2-image.jpg" },

    @Test
        // гет запрос на одного пользователя, используем спеки запросы и модель
    void singleUserWithModel() {
// создаём объект класса и вкладываем в него цепочкой спеки запроса и ответа
        UserData userData = Specs.request
                .when()
                .get("/users/2")
                .then()
                .spec(Specs.responseSpec)  // выполняется проверка спецификации
                .log().body()
                .extract().as(UserData.class);
// использование builder()
//        User user = User.builder().id(2).email("").lastName("").build();
//        вместо этого:
//        user.setId(2);
//        user.setEmail("");

        // проверка через утверждение 2 ==2 ?
        assertEquals(2, userData.getData().getId());
    }
}

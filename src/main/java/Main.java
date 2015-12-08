/**
 * Created by ARM on 4/12/2558.
 */

import static spark.Spark.*;
import com.model.Products;
import com.google.gson.*;

public class Main {
    public static void main(String[] args){
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello World");

        get("/products", (req, res) -> new Gson().toJson(new Products().getAll()));


    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}

/**
 * Created by ARM on 4/12/2558.
 */

import static spark.Spark.*;
import com.model.Products;
import com.google.gson.*;

public class Main {
    public static void main(String[] args){
        get("/", (req, res) -> "Hello World");

        get("/products", (req, res) -> new Gson().toJson(new Products().getAll()));
    }
}

package demoQA.utils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import demoQA.models.Book;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {


    public static JsonReader getJSONFromFile(String pathToFile){
        try
        {
            JsonReader reader = new JsonReader(new FileReader(pathToFile));
            return reader;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}

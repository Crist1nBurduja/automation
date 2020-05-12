package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonSimpleWriteExample {
    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("name", "ExampleName");
        obj.put("author", "ExampleAuthor");

        JSONArray list = new JSONArray();
        list.add("example1");
        list.add("example2");
        list.add("example3");

        obj.put("messages", list);

        try (FileWriter file = new FileWriter("music.json")) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }

}

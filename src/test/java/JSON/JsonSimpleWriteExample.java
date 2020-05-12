package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonSimpleWriteExample {
    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("name", "So What");
        obj.put("author", "Miles Davis");

        JSONArray list = new JSONArray();
        list.add("Kind of Blue");
        list.add("msg 2");
        list.add("msg 3");

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

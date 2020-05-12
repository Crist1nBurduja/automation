package json;
import org.json.simple.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonEncodeDemo {
    public static void main(String[] args) {
//     ******vyvod NE po poreadku*******
        JSONObject obj = new JSONObject();

        obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));

        System.out.print(obj);
//     ******vyvod  po poreadku*******
//        Map<Object, Object> map = new LinkedHashMap<>();
//        map.put("name", "foo");
//        map.put("num", new Integer(100));
//        map.put("balance", new Double(1000.21));
//        map.put("is_vip", new Boolean(true));
//
//        JSONObject obj = new JSONObject();
//        System.out.print(obj.toJSONString(map));


    }
}

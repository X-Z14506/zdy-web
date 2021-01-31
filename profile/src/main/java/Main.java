import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.json.model.Message;

import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-11
 * Time:20:51
 */

//反序列化
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        /*
        //两个对象
        String s = "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"who\": \"张丁玉\",\n" +
                "    \"when\": \"2020-12-11 20:47:00\",\n" +
                "    \"what\": \"滚去学习javaWEB\"\n" +
                "  },\n" +
                "  {\n" +
                "\n" +
                "    \"id\": 2,\n" +
                "    \"who\": \"张丁玉\",\n" +
                "    \"when\": \"2020-12-11 20:47:00\",\n" +
                "    \"what\": \"滚去学习javaWEB\"\n" +
                "  }\n" +
                "]";
        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructParametricType(List.class, Message.class);
        List<Message> messages = mapper.readValue(s,type);
        System.out.println(messages);
        */

        //一个对象
        String s = "  {\n" +
                "    \"id\": 1,\n" +
                "    \"who\": \"张丁玉\",\n" +
                "    \"when\": \"2020-12-11 20:47:00\",\n" +
                "    \"what\": \"滚去学习javaWEB\"\n" +
                "  },";
        ObjectMapper mapper = new ObjectMapper();
        Message message = mapper.readValue(s,Message.class);
        System.out.println(message);
    }
}


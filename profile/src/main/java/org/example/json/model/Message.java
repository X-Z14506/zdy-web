package org.example.json.model;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-11
 * Time:18:47
 */
public class Message {
    public int id;

    public String who;
    public String what;
    public String when;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", who='" + who + '\'' +
                ", what='" + what + '\'' +
                ", when='" + when + '\'' +
                '}';
    }
}


/*

✅ When to Use

Use Observer when:

One object changes state

Many objects need to be notified automatically

📘 Scenario

A YouTube Channel notifies all subscribers when a new video is uploaded.
*/

import java.util.*;

// Observer
interface Subscriber {
    void update();
}

// Concrete Observer
class User implements Subscriber {
    public void update() {
        System.out.println("New video notification received");
    }
}

// Subject
class Channel {
    List<Subscriber> subs = new ArrayList<>();

    void subscribe(Subscriber s) {
        subs.add(s);
    }

    void uploadVideo() {
        for (Subscriber s : subs) {
            s.update();
        }
    }
}

// Client
public class ObserverPattern {
    public static void main(String[] args) {
        Channel channel = new Channel();
        channel.subscribe(new User());
        channel.uploadVideo();
    }
}

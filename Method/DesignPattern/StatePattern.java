// State Pattern

/*
✅ When to Use

Use State when:

Object behavior changes based on state

Avoid many if-else

📘 Scenario

A Traffic Light changes behavior based on color.

*/

interface LightState {
    void show();
}

class RedLight implements LightState {
    public void show() {
        System.out.println("STOP");
    }
}

class GreenLight implements LightState {
    public void show() {
        System.out.println("GO");
    }
}

class TrafficLight {
    LightState state;

    void setState(LightState state) {
        this.state = state;
    }

    void display() {
        state.show();
    }
}

// Client
public class StatePattern {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        light.setState(new RedLight());
        light.display();
    }
}

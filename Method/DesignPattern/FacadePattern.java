
/*

✅ When to Use

Use Facade when:

System is complex

You want one simple interface

📘 Scenario

A Computer needs CPU, Memory, and Hard Drive to start.
Facade provides a StartComputer() method.
*/

class CPU {
    void start() { System.out.println("CPU started"); }
}

class Memory {
    void load() { System.out.println("Memory loaded"); }
}

class HardDrive {
    void read() { System.out.println("Hard drive reading"); }
}

// Facade
class ComputerFacade {
    CPU cpu = new CPU();
    Memory memory = new Memory();
    HardDrive hd = new HardDrive();

    void startComputer() {
        cpu.start();
        memory.load();
        hd.read();
    }
}

// Client
public class FacadePattern {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}

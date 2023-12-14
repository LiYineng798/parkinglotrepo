package text;

import java.util.Scanner;

public class InputThread extends Thread {
    private volatile boolean inputReceived;
    private volatile String input;

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        inputReceived = true;
    }

    public boolean isInputReceived() {
        return inputReceived;
    }

    public String getInput() {
        return input;
    }

    public void stopInputThread() {
        interrupt();
    }
}

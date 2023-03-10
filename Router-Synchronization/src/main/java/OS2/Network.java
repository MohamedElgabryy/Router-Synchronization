package OS2;


import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Thread.sleep;

public class Network {
    public static void main(String[] args) throws InterruptedException 
    {
        int  connectionNum, deviceNum;
        ArrayList<Device> devices = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        System.out.println("What is number of WI-FI Connections? ");
        connectionNum = input.nextInt();
        Router router = new Router(connectionNum);

        System.out.println("What is number of devices Clients want to connect? ");
        deviceNum = input.nextInt();


        for (int i = 0; i < deviceNum; i++) 
        {
            Device newDevice = new Device(input.next(),input.next(), router);
            devices.add(newDevice);
        }

        for (int i = 0; i < deviceNum; i++) 
        {
            sleep(100);
            devices.get(i).start();
        }
    }
}
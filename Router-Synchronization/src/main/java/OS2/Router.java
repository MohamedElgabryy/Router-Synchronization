package OS2;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Router {
    public boolean[] state;
    public int maxDevices, currentConnectedDevices;
    public Semaphore semaphore;

    Router(int maxDevices) 
    {
        this.maxDevices = maxDevices;
        semaphore = new Semaphore(maxDevices);
        state = new boolean[maxDevices];
    }

    public synchronized int connect(Device device) throws InterruptedException 
    {
        for (int i = 0; i < maxDevices; i++) 
        {
            if(!state[i])
            {
                currentConnectedDevices++;
                device.connectionID = i + 1;
                state[i] = true;
                sleep(100);
                break;
            }
        }
        return device.connectionID;
    }

    public synchronized void disconnect(Device device)
    {
        try 
        {
            currentConnectedDevices--;
            state[device.connectionID-1] = false;
            notify();
            System.out.println("Connection " + device.connectionID + ": " + device.name + " Logged out");
            
            String outR1 = "Connection " + device.connectionID + ": " + device.name + " Logged out";
            Filee fileeR1 = new Filee(outR1 + " ");
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Router.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void arrived(Device device)
    {
     
    }
}


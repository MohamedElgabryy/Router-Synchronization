package OS2;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Device extends Thread {
   public String name, type;
   public int connectionID;
   public  Router router;

   public Device(String name, String type, Router router) 
   {
        this.name = name;
        this.type = type;
        this.router = router;
        connectionID = 1;
   }

    @Override
    public void run() {
        try 
        {
            router.arrived(this);
            router.semaphore.wait(this);
            connectionID = router.connect(this);
            System.out.println("Connection " + connectionID + ": " + name + " Occupied");
            
            String outD1 = "Connection " + connectionID + ": " + name + " Occupied";
            Filee fileeD1 = new Filee(outD1 + " ");
            
            activity();
            router.disconnect(this);
            router.semaphore.V();

        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException ex) 
        {
           Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void activity() throws InterruptedException 
    {
       try 
       {
           System.out.println("Connection " + connectionID + ": " + name + " Performs online activity");
           
           String outD2 = "Connection " + connectionID + ": " + name + " Performs online activity";
           Filee fileeD2 = new Filee(outD2 + " ");
           
           sleep(2000);
       } 
       catch (IOException ex) 
       {
           Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}



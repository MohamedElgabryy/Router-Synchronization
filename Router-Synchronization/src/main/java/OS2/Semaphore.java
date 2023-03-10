package OS2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Semaphore {
    int value;

    public Semaphore(int value) 
    {
        this.value = value;
    }

    public synchronized void wait(Device d) throws InterruptedException 
    {
        value--;
        if (value < 0) 
        {
            try 
            {
                
                System.out.println(d.name + " (" + d.type + ")" + " arrived and waiting");
                wait();
                
                String outF1 = d.name + " (" + d.type + ")" + " arrived and waiting";
                Filee fileeF1 = new Filee(outF1 + " ");
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(Semaphore.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else
        {
            try 
            { 
                System.out.println( d.name +" (" + d.type + ")" +" arrived");
                
                String outF2 =d.name +" (" + d.type + ")" +" arrived" ;
                Filee fileeF2 = new Filee(outF2 + " ");
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(Semaphore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        d.router.connect(d);
    }

    public synchronized void V() 
    {
        value++;
        if (value <= 0) 
        {
            notify();
        }
    }
}
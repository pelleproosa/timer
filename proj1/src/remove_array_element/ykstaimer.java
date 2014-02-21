package remove_array_element;


	import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

	/**
	 * Simple demo that uses java.util.Timer to schedule a task to execute once 5
	 * seconds have passed.
	 */

	public class ykstaimer {
	  Toolkit toolkit;

	  Timer timer;

	  public ykstaimer(int seconds) {
	    toolkit = Toolkit.getDefaultToolkit();
	    timer = new Timer();
	    timer.schedule(new RemindTask(), seconds * 1000);
	  }

	  class RemindTask extends TimerTask {
	    public void run() {
	   //   System.out.println("Time's up!");
	   //   toolkit.beep();
	      
	      try {
			url_ping.ping(Global.url, Global.timeout);
			System.out.println(Global.pingtagastus);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     // new ykstaimer(1);
	      //timer.cancel(); //Not necessary because we call System.exit
	      //System.exit(0); //Stops the AWT thread (and everything else)
	    }
	  }

	  public static void alusta(String args[]) {
	    System.out.println("About to schedule task.");
	    new ykstaimer(10);
	    System.out.println("Task scheduled.");
	  }
	}
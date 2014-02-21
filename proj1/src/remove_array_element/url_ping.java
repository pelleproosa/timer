package remove_array_element;

import java.io.IOException;
import java.awt.Toolkit;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class url_ping {





public static void ping(String url, int timeout) throws Exception {
    url = url.replaceFirst("https", "http"); // Otherwise an exception may be thrown on invalid SSL certificates.

    // Using relative clock time

    try {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setConnectTimeout(timeout);
        connection.setReadTimeout(timeout);
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();
        if(200 <= responseCode && responseCode <= 399){
       // return (200 <= responseCode && responseCode <= 399);
        Global.pingtagastus="OK";}else{
   
            
            // display time and date using toString()
        	Date date = new Date();
        	Global.pingtagastus=(date.toString());
        	
        	Global.pingtagastus=Global.pingtagastus+" FAIL!";
        }} catch (IOException exception) {
  
    	Date date = new Date();
    //	String str=(date.toString());
    //	System.out.print(str+"   ");
    //	System.out.println("FAIL!");
    	Global.pingtagastus=(date.toString());
    	
    	Global.pingtagastus=Global.pingtagastus+" FAIL!";
    	    	
    	//return false;
    }


}

}
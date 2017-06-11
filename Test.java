
import org.alicebot.ab.*;
import java.io.*;

public class Test{
    public static void main( String[] args){
        Bot bot = new Bot("alice2", "/Users/Kodak/Developer/java/program-ab");
        String customerId = "kota";
        System.out.println( bot.log_path );
        String logFile = bot.log_path+"/log_"+customerId+".txt";
        try {
            BufferedWriter bw = null;
            //Construct the bw object
            bw = new BufferedWriter(new FileWriter(logFile, false)) ;
            Chat chat = new Chat( bot, true, customerId);
            String request="SING";
//            System.out.println( "user => " + request );

            String response = chat.multisentenceRespond(request);
//            System.out.println( "bot => " + response );
            bw.write( customerId + " => "+request);
            bw.newLine();
            bw.write("bot => " + response);
            bw.newLine();
//            while (!request.equals("quit")) {
//                System.out.print("Human: ");
////                request = IOUtils.readInputTextLine();
//                response = multisentenceRespond(request);
//                System.out.println("Robot: "+response);
//                bw.write("Human: "+request);
//                bw.newLine();
//                bw.write("Robot: "+response);
//                bw.newLine();
//                bw.flush();
//            }
//            String[] matchTraceArray = chat.matchTrace.split("\\|\\|\\|");
            String matchTraceCleaned = chat.matchTrace.replace("|||", "\n");
            System.out.println( "Match Trace => \n" + matchTraceCleaned );
            bw.write( "Match Trace => " + matchTraceCleaned );
            bw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
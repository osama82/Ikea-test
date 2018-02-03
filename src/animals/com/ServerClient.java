package animals.com;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @author osama
 * @project Ikea Test
 * the client sends list of Animals
 * snd the server display it on the console
 */
public class ServerClient {
    public static final Logger logger = Logger.getLogger(AnimalFactory.class);
    static int i = 0;

    public void startSender(List<Animal> list) {
        (new Thread() {
            @Override
            public void run() {
                try {
                    Socket s = new Socket("localhost", 60010);
                    BufferedWriter out = new BufferedWriter(
                            new OutputStreamWriter(s.getOutputStream()));

                    while (true) {
                        for (Animal p : list) {
                            out.append("\n");
                            out.append(p.getType());
                            out.append(",");
                            out.append(p.getName());
                            out.append(",");
                            out.append(p.getBirthYear());
                            i++;
                        }

                        Thread.sleep(3000);
                        out.append("\n ------------------------");
                        out.flush();
                    }

                } catch (InterruptedException | UnknownHostException e1) {
                    logger.error(e1);
                } catch (IOException e1) {
                    logger.error("IOexception", e1);
                }


            }
        }).start();
    }

    public void startServer() {
        (new Thread() {
            @Override
            public void run() {
                ServerSocket ss;
                try {
                    ss = new ServerSocket(60010);

                    Socket s = ss.accept();

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(s.getInputStream()));
                    String line = null;
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                        logger.debug("sever is printing entries sent from client");
                    }
                } catch (IOException e) {
                    logger.error("error in the server", e);
                }
            }
        }).start();
    }
}




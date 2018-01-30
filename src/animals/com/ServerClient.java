package animals.com;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @author osama
 * the client sends list of Animals
 * snd the server display it on the console
 *
 */
public class ServerClient {



        /*public static void main(String[] args) throws IOException {

            List<Animal> lol =new ArrayList<>();
            lol.add(new Fish("fish","goly","12"));
            lol.add(new Fish("fish","huoly","16"));

            startServer();
            startClient(lol);
        }*/

        public  void startClient(List<Animal> lis) {
            (new Thread() {
                @Override
                public void run() {
                    try {
                        Socket s = null;
                        try {
                            s = new Socket("localhost", 60010);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        BufferedWriter out = null;
                        try {
                            out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        while (true) {


                            //out.write("Hello World!");
                            for (Animal p : lis) {
                                out.append("\n");
                                out.append(p.getType());
                                out.append(",");
                                out.append(p.getName());
                                out.append(",");
                                out.append(p.getBirthYear());
                                //out.newLine();
                                out.flush();

                                Thread.sleep(200);
                            }
                        }

                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        public  void startServer() {
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
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }



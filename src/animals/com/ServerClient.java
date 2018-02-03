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
 *
 */
public class ServerClient {
    public static final Logger logger=Logger.getLogger(AnimalFactory.class);
    static int i =0;

      /* public static void main(String[] args) throws IOException {

            List<Animal> lol =new ArrayList<>();
            lol.add(new Duck("goly","12"));
            lol.add(new Duck("huoly","16"));

            startServer();
            startClient(lol);
        }
*/



    /**
     * @author osama
     * @Project Ikea test
     */


       /* public static void main(String[] args) throws IOException {
            List<Animal> lol =new ArrayList<>();
            lol.add(new Duck("goly","12"));
            lol.add(new Duck("huoly","16"));

            startServer();
            startSender(lol);
        }*/

        public  void startSender(List<Animal> list) {
            (new Thread() {
                @Override
                public void run() {
                    try {
                        Socket s = new Socket("localhost", 60010);
                        BufferedWriter out = new BufferedWriter(
                                new OutputStreamWriter(s.getOutputStream()));

                            while (true) {
                              for (Animal p:list){
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

                        } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    } catch (UnknownHostException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
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
                            logger.debug("sever is printing entries sent from client");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }


         /*void startClient(List<Animal> lis) {
            (new Thread(() -> {
                try {
                    Socket s = null;

                        s = new Socket("localhost", 60010);

                    BufferedWriter out = null;

                        out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    while (i<1) {


                        //out.write("Hello World!");
                        BufferedWriter finalOut = out;
                        synchronized (this){for (Animal p : lis) {
                            out.append("\n");
                            out.append(p.getType());
                            out.append(",");
                            out.append(p.getName());
                            out.append(",");
                            out.append(p.getBirthYear());
                            //out.newLine();
                            out.flush();}

                            Thread.sleep(200);
                        }
                        i++;
                    }

                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            })).start();
        }

        static   void startServer() {
            (new Thread(() -> {
                ServerSocket ss;
                try {
                    ss = new ServerSocket(60010);

                    Socket s = ss.accept();

                    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    String line = null;
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            })).start();
        }
    }*/



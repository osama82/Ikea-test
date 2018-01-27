package animals.com;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class converter {
    protected DocumentBuilderFactory domFactory = null;
    protected DocumentBuilder domBuilder = null;

    public static void main(String[] args) {


        ArrayList<String> busStopInfo = new ArrayList<String>(7);

        File file = new File("src/start.txt");
        BufferedReader readFile = null;
        try {
            DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = df.newDocumentBuilder();

            Document document = db.newDocument();

            Element rootElement = document.createElement("animals");

            document.appendChild(rootElement);
            readFile = new BufferedReader(new FileReader(file));
            int line = 0;

            String information = null;
            while ((information = readFile.readLine()) != null) {

                String[] rowValues = information.split(",");

                if (line == 0) {
                    for (String columnInfo : rowValues) {
                        busStopInfo.add(columnInfo);
                    }
                } else {
                    Element childElement = document.createElement("animal");
                    rootElement.appendChild(childElement);


                    for (int columnInfo = 0; columnInfo < busStopInfo.size(); columnInfo++) {

                        String header = busStopInfo.get(columnInfo);
                        String value = null;

                        if (columnInfo < rowValues.length) {
                            value = rowValues[columnInfo];
                        } else {
                            value = " ";
                        }

                        Element current = document.createElement(header);
                        current.appendChild(document.createTextNode(value));
                        childElement.appendChild(current);
                       // System.out.println(value);
                    }
                }
                line++;
            }
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            Writer output = new StringWriter();
            tf.transform(new DOMSource(document), new StreamResult(output));
            PrintWriter writer = new PrintWriter("src/result.xml", "UTF-8");
            writer.println(output.toString());
            writer.close();
            //System.out.println(output.toString());
        } catch (Exception e) {

        }
    }}
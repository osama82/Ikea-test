package animals.com;

import org.apache.log4j.Logger;
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

/**
 * @author osama
 * @Project Ikea test
 *class responsible of converting from CSV file TO XML file
 */
public class ToXMLConverter {

    protected DocumentBuilderFactory domFactory = null;
    protected DocumentBuilder domBuilder = null;
    public static final Logger logger=Logger.getLogger(CSVReader.class);
    /**
     * convert the CSV file in the path
     * @param csvFilePath to XML file in the path
     * @param xmlFilePath
     *
     */

    public  void convertToXml(String csvFilePath, String xmlFilePath)  {

        ArrayList<String> animalsInfo = new ArrayList<>();
        File file = new File(csvFilePath);

        if(!(file.exists())){
            logger.error("no file found");
          //System.err.println("no file found");
        return;
        }

        BufferedReader readFile = null;
        try {
            // initialize the builder of XML structure
            DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = df.newDocumentBuilder();
            Document document = db.newDocument();

            // the root Element of the whole XML file
            Element rootElement = document.createElement("animals");
            document.appendChild(rootElement);
            readFile = new BufferedReader(new FileReader(file));

            int line = 0;// csv file lines
            String information = null; // info extracted from csv file as Strings
            while ((information = readFile.readLine()) != null) {
                // splitting every line with ","
                String[] rowValues = information.split(",");
                // the first line supposed to have the info
                // about types of data stored  in the csv file
                if (line == 0) {
                    for (String columnInfo : rowValues) {
                        animalsInfo.add(columnInfo);
                    }
                } else {
                    // the inside elements of the XML file represents Animal objects
                    Element childElement = document.createElement("animal");
                    rootElement.appendChild(childElement);


                    for (int columnInfo = 0; columnInfo < animalsInfo.size(); columnInfo++) {

                        String header = animalsInfo.get(columnInfo);
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
            // transform the info about the elements of the file into XML
            // structure to the @param xmlFilePath the path to the output XML file
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            Writer output = new StringWriter();
            tf.transform(new DOMSource(document), new StreamResult(output));
            PrintWriter writer = new PrintWriter(xmlFilePath, "UTF-8");
            writer.println(output.toString());
            writer.close();
            //System.out.println(output.toString());
        } catch (Exception e) {
            e.getStackTrace();

        }
        logger.info("an XML File have been created in");

    }
}
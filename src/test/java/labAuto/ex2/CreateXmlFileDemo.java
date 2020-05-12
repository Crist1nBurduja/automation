package labAuto.ex2;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class CreateXmlFileDemo {

    public static void main(String argv[]) {

        try {

            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("films");
            doc.appendChild(rootElement);

            Element originalNetwork = doc.createElement("originalNetwork");
            rootElement.appendChild(originalNetwork);
            Attr attr0 = doc.createAttribute("name");
            attr0.setValue("Netflix");
            originalNetwork.setAttributeNode(attr0);


            Element originalNetwork1 = doc.createElement("originalNetwork1");
            rootElement.appendChild(originalNetwork);
            Attr attr01 = doc.createAttribute("name");
            attr01.setValue("Telewizja Polska");
            originalNetwork.setAttributeNode(attr01);





            // release element
            Element release = doc.createElement("release");
            originalNetwork.appendChild(release);

            // setting attribute to element
            Attr attr = doc.createAttribute("Data");
            attr.setValue("20.12.2019");
            release.setAttributeNode(attr);

            
            
            // title element
            Element title = doc.createElement("title");
            title.appendChild(doc.createTextNode("The End's Beginning"));
            release.appendChild(title);


            Element directed = doc.createElement("Directed");
            Attr attr2 = doc.createAttribute("by");
            attr2.setValue("Alik Sakharov");
            directed.setAttributeNode(attr2);
            release.appendChild(directed);


            Element written = doc.createElement("Written");
            Attr attr3 = doc.createAttribute("by");
            attr3.setValue("Lauren Schmidt Hissrich");
            written.setAttributeNode(attr3);
            release.appendChild(written);

            // setting attribute to element
            Attr attr22 = doc.createAttribute("Data");
            attr22.setValue("20.12.2019");
            release.setAttributeNode(attr22);




            // title element
            Element title2 = doc.createElement("title2");
            title2.appendChild(doc.createTextNode("The End's Beginning"));
            release.appendChild(title2);


            Element directed2 = doc.createElement("Directed");
            Attr attr21 = doc.createAttribute("by");
            attr21.setValue("Alik Sakharov");
            directed.setAttributeNode(attr21);
            release.appendChild(directed);


            Element written2 = doc.createElement("Written");
            Attr attr32 = doc.createAttribute("by");
            attr32.setValue("Lauren Schmidt Hissrich");
            written.setAttributeNode(attr32);
            release.appendChild(written);

















            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\films.xml"));
            transformer.transform(source, result);


            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
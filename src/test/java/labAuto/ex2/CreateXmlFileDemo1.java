package labAuto.ex2;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CreateXmlFileDemo1 {
    public static void main(String argv[]) {

        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();


            Element rootElement = doc.createElement("movies");
            doc.appendChild(rootElement);

            Element genre = doc.createElement("genre");
            rootElement.appendChild(genre);

            Element adventure = doc.createElement("adventure");
            genre.appendChild(adventure);

            Attr attr = doc.createAttribute("platform");
            attr.setValue("Netflix");
            adventure.setAttributeNode(attr);

            Element title = doc.createElement("title");
            title.appendChild(doc.createTextNode("I am Legend"));
            adventure.appendChild(title);

            Element starring = doc.createElement("starring");
            starring.appendChild(doc.createTextNode("Will Smith, Alice Braga, Charlie Tahan"));
            adventure.appendChild(starring);

            Element rating = doc.createElement("rating");
            rating.appendChild(doc.createTextNode("+13"));
            adventure.appendChild(rating);

            Element year = doc.createElement("year");
            year.appendChild(doc.createTextNode("2007"));
            adventure.appendChild(year);





            Element adventure1 = doc.createElement("adventure");
            genre.appendChild(adventure1);

            Attr attr1 = doc.createAttribute("platform");
            attr1.setValue("Netflix");
            adventure1.setAttributeNode(attr1);

            Element title1 = doc.createElement("title");
            title1.appendChild(doc.createTextNode("Venom"));
            adventure1.appendChild(title1);

            Element starring1 = doc.createElement("starring");
            starring1.appendChild(doc.createTextNode("Tom Hardy, Michelle Williams, Riz Ahmed"));
            adventure1.appendChild(starring1);

            Element rating1 = doc.createElement("rating");
            rating1.appendChild(doc.createTextNode("13+"));
            adventure1.appendChild(rating1);

            Element year1 = doc.createElement("year");
            year1.appendChild(doc.createTextNode("2019"));
            adventure1.appendChild(year1);



            Element genre1 = doc.createElement("genre");
            rootElement.appendChild(genre1);

            Element adventure2 = doc.createElement("comedies");
            genre1.appendChild(adventure2);

            Attr attr3 = doc.createAttribute("platform");
            attr3.setValue("DreamWorks");
            adventure2.setAttributeNode(attr3);

            Element title3 = doc.createElement("title");
            title3.appendChild(doc.createTextNode("Madagascar"));
            adventure2.appendChild(title3);

            Element starring3 = doc.createElement("starring");
            starring3.appendChild(doc.createTextNode("Ben Stiller, Chris Rock, David Schwimmer"));
            adventure2.appendChild(starring3);

            Element rating3 = doc.createElement("rating");
            rating3.appendChild(doc.createTextNode("7+"));
            adventure2.appendChild(rating3);

            Element year3 = doc.createElement("year");
            year3.appendChild(doc.createTextNode("2005"));
            adventure2.appendChild(year3);






            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("movies.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

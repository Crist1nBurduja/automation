package Practice1.ex2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomParserDemo1 {
    public static void main(String[] args) {

        try {
            File inputFile = new File("movies.xml");    //Reads a file in "inputFile" object
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    //
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();                  //
            Document doc = dBuilder.parse(inputFile);                                   //Creates the document file with all data
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("adventure");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Platform : "
                            + eElement.getAttribute("platform"));
                    System.out.println("Title : "
                            + eElement
                            .getElementsByTagName("title") //elementS - Takes a list of elements
                            .item(0)                     //element from the list of elements
                            .getTextContent());                //Text-type content
                    System.out.println("Starring : "
                            + eElement
                            .getElementsByTagName("starring")
                            .item(0)
                            .getTextContent());
                    System.out.println("Rating : "
                            + eElement
                            .getElementsByTagName("rating")
                            .item(0)
                            .getTextContent());
                    System.out.println("Year : "
                            + eElement
                            .getElementsByTagName("year")
                            .item(0)
                            .getTextContent());
                    if(eElement.getElementsByTagName("status").getLength()>0){
                        System.out.println("Status : "
                                +eElement.getElementsByTagName("status")
                                .item(0)
                                .getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("Something went wrong! Press %s",'F');
        }
    }
}

package BNM;

import com.thoughtworks.xstream.XStream;
public class DeserialBNM {
    public static void main(String[] args) {
        XStream xstream = new XStream();
        xstream.processAnnotations(Valute.class);
        xstream.processAnnotations(ValCurs.class);
//        xstream.alias("Valute",Valute.class);

        String xml;
        xml = "<ValCurs Date=\"01.02.1994\" name=\"Official exchange rate\"><Valute ID=\"44\"><NumCode>840</NumCode><CharCode>USD</CharCode><Nominal>1</Nominal><Name>US Dollar</Name><Value>3.7900</Value></Valute><Valute ID=\"43\"><NumCode>804</NumCode><CharCode>UAK</CharCode><Nominal>0</Nominal><Name>Ukrainian Karbovanets</Name><Value>0.0000</Value></Valute></ValCurs>";

        ValCurs valCurs = (ValCurs)xstream.fromXML(xml);

        for(Object currentVal : valCurs.getValutes()) {
            System.out.println(currentVal);
        }
    }
}

package by.epam.task.main;

import by.epam.task.build.Soft;
import by.epam.task.soft.Browser;
import by.epam.task.soft.Driver;
import by.epam.task.soft.OS;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.epam.task.calc.Calculation.*;
import static by.epam.task.main.DOMparser.setNewComputer;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder(); // DOM
        Document PC = builder.parse(ClassLoader.getSystemClassLoader().getResourceAsStream("PC.xml"));
        //парсим документ в древовидную структуру

        List<DOMparser> parserTypeList = new ArrayList<>();
        NodeList nodeList = PC.getDocumentElement().getChildNodes();
        //итерация и извлечение данных
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                NodeList insideNodes = node.getChildNodes();
                DOMparser typeList = new DOMparser();
                for (int j = 0; j < insideNodes.getLength(); j++) {
                    Node insideNode = insideNodes.item(j);

                    //работаем с вложенными тегами
                    if (insideNode instanceof Element) {
                        String content = insideNode.getLastChild().getTextContent().trim();
                        switch (insideNode.getNodeName()) {
                            case "type":
                                typeList.setType(content);
                                break;
                            case "name":
                                typeList.setName(content);
                                break;
                            case "size":
                                typeList.setSize(Integer.parseInt(content));
                                break;
                            case "price":
                                typeList.setPrice(Integer.parseInt(content));
                                break;
                        }
                    }
                }
                parserTypeList.add(typeList);
            }
        }

        OS os = new OS("", 0, 0);
        Driver driver = new Driver("", 0, 0);
        Browser browser = new Browser("", 0, 0);
        Soft computer = new Soft.Builder(os, driver).browser(browser).build();

        computer = setNewComputer(parserTypeList, computer);
        int overallSize = overallSize(computer);
        int overallPrice = overallPrice(computer);


        Document  overallSizeAndPrice= builder.newDocument();
        Element calc = overallSizeAndPrice.createElement("CALCULATION");
        overallSizeAndPrice.appendChild(calc);
        Element size=overallSizeAndPrice.createElement("Size");
        size.appendChild(overallSizeAndPrice.createTextNode(String.valueOf(overallSize)));
        calc.appendChild(size);
        Element price=overallSizeAndPrice.createElement("Price");
        price.appendChild(overallSizeAndPrice.createTextNode(String.valueOf(overallPrice)));
        calc.appendChild(price);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(overallSizeAndPrice);
        StreamResult file = new StreamResult(new File("overallSizeAndPrice.xml"));
        transformer.transform(source, file);

    }
}
package com.jga.lectures.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MoviesXmlDao {

	private String baseDir = "src/main/java/com/jga/lectures/xml/";
	private static MoviesXmlDao instance = null;
	private MoviesXmlDao() {}
	public static MoviesXmlDao getInstance() {
		if(instance == null) {
			instance = new MoviesXmlDao();
		}
		return instance;
	}
	
	public void writeLibraryOfMoviesToXmlFileUsingJaxB(Library library, String xmlFileName) {
		try {
			JAXBContext jaxbContext =
			          JAXBContext.newInstance(Library.class);
			  Marshaller jaxbMarshaller = 
			          jaxbContext.createMarshaller();
			  jaxbMarshaller.setProperty(Marshaller
			          .JAXB_FORMATTED_OUTPUT, true);
			  File xFile = new File(baseDir + xmlFileName);
			  jaxbMarshaller.marshal(library, xFile);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeMovieObjectToXmlFileUsingJaxB(Movie movie, String xmlFileName) {
		try {
			JAXBContext jaxbContext = 
					JAXBContext.newInstance(Movie.class);
			Marshaller jaxbMarshaller = 
					jaxbContext.createMarshaller();
			jaxbMarshaller
			    .setProperty(Marshaller
			      .JAXB_FORMATTED_OUTPUT, true);
			File xmlFile = new File(baseDir + xmlFileName);
			jaxbMarshaller.marshal(movie, xmlFile);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void parseXmlFile(String xmlFileName) {
		DocumentBuilderFactory dbFactory = 
				DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = 
					dbFactory.newDocumentBuilder();
			File xmlFile = new File(baseDir + xmlFileName);
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			String r = doc.getDocumentElement().getNodeName();
			System.out.println(r); // --> "movies"
			NodeList movies;
			movies = doc.getElementsByTagName("movie");
			int movieCount = movies.getLength();
			for (int i=0; i<movieCount; i++) {

			    Node movieNode = movies.item(i);
			    short nodeType = movieNode.getNodeType();
			    if (nodeType == Node.ELEMENT_NODE) {
			        Element movie = (Element) movieNode;
			        String imdbId = movie.getAttribute("imdbId");

			        Node titleNode   = movie
			        .getElementsByTagName("title").item(0);
			        Node plotNode   = movie
			        .getElementsByTagName("plot").item(0);
			        Node posterNode = movie
			        .getElementsByTagName("poster").item(0);
			        
			        Element titleElm   = (Element) titleNode;
			        Element plotElm    = (Element) plotNode;
			        Element posterElm  = (Element) posterNode;

			        String titleStr  = titleElm.getTextContent();
			        String plotStr   = plotElm.getTextContent();
			        String posterStr = posterElm.getTextContent();

			        System.out.println(titleStr);
			        System.out.println(plotStr);
			        System.out.println(posterStr);

			    }			    
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

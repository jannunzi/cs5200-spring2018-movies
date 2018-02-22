package com.jga.experiments.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.jga.experiments.models.Movie;
import com.jga.experiments.models.Movies;

public class MovieXmlDao {
	private static MovieXmlDao instance = null;
	private MovieXmlDao() {}
	public static MovieXmlDao getInstance() {
		if(instance == null) {
			instance = new MovieXmlDao();
		}
		return instance;
	}
	
	private String xmlBasePath = "src/main/java/com/jga/experiments/dao/";
	
	public void transformMovies(String xslFileName, String xmlInputFileName, String xmlOutputFileName) {
		StreamSource xslcode = new StreamSource(new File(xmlBasePath+xslFileName));
		StreamSource input = new StreamSource(new File(xmlBasePath+xmlInputFileName));
		StreamResult output = new StreamResult(new File(xmlBasePath+xmlOutputFileName));
		TransformerFactory tf = TransformerFactory.newInstance();
		try {
			Transformer trans = tf.newTransformer(xslcode);
			trans.transform(input, output);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Movies unmarshalMoviesFromXmlFile(String xmlFileName) {
		Movies movieList = null;
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Movies.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			File xmlFile = new File(xmlBasePath + xmlFileName);

			movieList = (Movies)jaxbUnmarshaller.unmarshal(xmlFile);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movieList;
	}
	
	public void writeMoviesToXmlFile(Movies movies, String xmlFileName) {
		  JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Movies.class);
			  Marshaller jaxbMarshaller = 
			          jaxbContext.createMarshaller();
			  jaxbMarshaller.setProperty(Marshaller
			          .JAXB_FORMATTED_OUTPUT, true);
			  File xFile = new File("src/main/java/com/jga/experiments/dao/" + xmlFileName);
			  jaxbMarshaller.marshal(movies, xFile);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void writeMovieToXmlFile(Movie movie, String xmlFileName) {
		  try {
			JAXBContext jaxbContext = 
					JAXBContext.newInstance(Movie.class);
			Marshaller jaxbMarshaller = 
					jaxbContext.createMarshaller();
			jaxbMarshaller
				.setProperty(Marshaller
						.JAXB_FORMATTED_OUTPUT, true);
			  File xmlFile = new File("src/main/java/com/jga/experiments/dao/" + xmlFileName);
			  jaxbMarshaller.marshal(movie, xmlFile);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Movie> readMoviesFromXmlFile() {
		List<Movie> movieList = new ArrayList<Movie>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			File xmlFile = new File("src/main/java/com/jga/experiments/dao/movies.xml");
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			String r=doc.getDocumentElement().getNodeName();
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

			        Node titleNode  = movie.getElementsByTagName("title").item(0);
			        Node plotNode   = movie.getElementsByTagName("plot").item(0);
			        Node posterNode = movie.getElementsByTagName("poster").item(0);

			        Element titleElm   = (Element) titleNode;
			        Element plotElm    = (Element) plotNode;
			        Element posterElm  = (Element) posterNode;

			        String titleStr  = titleElm.getTextContent();
			        String plotStr   = plotElm.getTextContent();
			        String posterStr = posterElm.getTextContent();

			        Movie movieObj = new Movie(imdbId, titleStr, plotStr, posterStr);
			        movieList.add(movieObj);
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
		return movieList;
	}
}

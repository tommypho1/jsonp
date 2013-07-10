/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datnguyen.testRestful.service;

import com.datnguyen.testRestful.entity.Users;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Jersey REST client generated for REST resource:UsersFacadeREST
 * [com.datnguyen.testrestful.entity.users]<br>
 * USAGE:
 * <pre>
 *        testRestfulClient client = new testRestfulClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author AsusVM
 */
public class testRestfulClient {
    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/testRestfulService_1/webresources";

    public testRestfulClient() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("com.datnguyen.testrestful.entity.users");
    }

    public void remove(String id) throws UniformInterfaceException {
        webResource.path(java.text.MessageFormat.format("{0}", new Object[]{id})).delete();
    }

    public String countREST() throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path("count");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public <T> T findAll_XML(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = webResource;
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findAll_JSON(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = webResource;
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void edit_XML(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).put(requestEntity);
    }

    public void edit_JSON(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(requestEntity);
    }

    public void create_XML(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).post(requestEntity);
    }

    public void create_JSON(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(requestEntity);
    }

    public <T> T findRange_XML(Class<T> responseType, String from, String to) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findRange_JSON(Class<T> responseType, String from, String to) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T find_XML(Class<T> responseType, String id) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T find_JSON(Class<T> responseType, String id) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.destroy();
    }
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, InterruptedException {
        testRestfulClient t = new testRestfulClient();
        System.out.println(t.countREST());
        System.out.println(t.findAll_XML(String.class));
        System.out.println(t.find_XML(String.class, "dat"));
        
      //  System.out.println("Users class "+d.getUsername());
        System.out.println(t.findAll_XML(File.class));
        
        File xmlFile = t.findAll_XML(File.class);
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = (Document) dBuilder.parse(xmlFile);
 
	 // get the first element
         Element element = doc.getDocumentElement();

         // get all child nodes
         NodeList nodes = element.getChildNodes();

         // print the text content of each child
         for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(" " + nodes.item(i).getTextContent());
         }
         
        doc.getDocumentElement().normalize();
 
	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
	NodeList nList = doc.getElementsByTagName("users");
 
	System.out.println("----------------------------");
 
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
 
			System.out.println("username : " + eElement.getElementsByTagName("username").item(0).getTextContent());
			System.out.println("lat: " + eElement.getElementsByTagName("latitude").item(0).getTextContent());
			System.out.println("long : " + eElement.getElementsByTagName("longtitude").item(0).getTextContent());
	
		}
	}
        
        for (int i = 0; i<50; i++){
            Users d = (Users) t.find_XML(Users.class, "dat");
        d.setLatitude(d.getLatitude()+0.0001);
        t.edit_XML(d);
        
        Users anna = (Users) t.find_XML(Users.class, "anna");
        anna.setLatitude(anna.getLatitude()+0.0002);
        anna.setLongtitude(anna.getLongtitude()+0.0002);
        t.edit_XML(anna);
            Thread.sleep(1000);
        }
        
    }
    
}

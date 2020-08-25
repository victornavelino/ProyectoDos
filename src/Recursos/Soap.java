/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.FileRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

/**
 *
 * @author hugo
 */
public class Soap implements Runnable {

    private final String cadena;



    public Soap(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public void run() {

        try {

            // Get target URL
            String strURL = "http://somosmas.club/Webservice/wsvac.php?wsdl";
            // Get SOAP action
            String strSoapAction = "consulta";
            // Get file to be posted
            String strXMLFilename = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://somosmas.club/Webservice/\">\n"
                    + "   <soapenv:Header/>\n"
                    + "   <soapenv:Body>\n"
                    + "      <web:ingreso soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n"
                    + "         <cadena xsi:type=\"xsd:string\">" + cadena + "</cadena>\n"
                    + "      </web:ingreso>\n"
                    + "   </soapenv:Body>\n"
                    + "</soapenv:Envelope>";

            File tempFile = File.createTempFile("mificherotemporal", null);
            tempFile.deleteOnExit();
            BufferedWriter out = new BufferedWriter(new FileWriter(tempFile));
            out.write(strXMLFilename);
            out.close();

//        File input = new File(strXMLFilename);
//        // Prepare HTTP post
            PostMethod post = new PostMethod(strURL);
            // Request content will be retrieved directly
            // from the input stream
            RequestEntity entity = new FileRequestEntity(tempFile, "text/xml; charset=ISO-8859-1");
            post.setRequestEntity(entity);
            // consult documentation for your web service
            post.setRequestHeader("SOAPAction", strSoapAction);
            // Get HTTP client
            HttpClient httpclient = new HttpClient();
            // Execute request
            try {
                int result = httpclient.executeMethod(post);
                // Display status code
                System.out.println("Response status code: " + result);
                // Display response
                System.out.println("Response body: ");
                System.out.println(post.getResponseBodyAsString());
                
            } finally {
                // Release current connection to the connection pool once you are done
                post.releaseConnection();
            }

        } catch (Exception e) {
            System.out.println("Error Conectado a la base de datos" + e);
        }

    }
}

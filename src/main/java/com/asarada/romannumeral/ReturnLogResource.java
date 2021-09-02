package com.asarada.romannumeral;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;



@Path("/getLog")
public class ReturnLogResource {
    @GET
    @Produces("application/xml")
    public String getLog() throws IOException {
        boolean header = false;
        File fileObj = new File("../logs/IntegerToRoman1.xml");
        StringBuffer returnString = new StringBuffer();
        Scanner myReader = new Scanner(fileObj);
        String temp;
        while (myReader.hasNext()){
            temp=myReader.nextLine();
            if(header && temp.equals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>") || temp.equals("<!DOCTYPE log SYSTEM \"logger.dtd\">"))
                continue;
            returnString=returnString.append(temp);
            //if (temp.equals("<!DOCTYPE log SYSTEM \"logger.dtd\">"))
                header=true;
        }
        returnString.append("</log>");
        return returnString.toString();
    }

}

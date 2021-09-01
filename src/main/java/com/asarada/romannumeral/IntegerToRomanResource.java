package com.asarada.romannumeral;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/")
public class IntegerToRomanResource {

    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    FileHandler fh;

    public void initLogFile() {
        try {
            fh = new FileHandler("../logs/IntegerToRoman.xml",true);
            LOGGER.addHandler(fh);
        }catch(Exception e){
            System.out.println("Logging Exception....");
        }

        LOGGER.setLevel(Level.ALL);
    }

    @GET
    @Produces("application/json")
    public String getQueryResults(@Context UriInfo info){
        this.initLogFile();
        String query=info.getQueryParameters().getFirst("query");
        if (query != null)
          return this.getIntToRoman(query);
        else {
            LOGGER.severe("Missing query parameters in url, Eg. Usage: http://localhost:8080/romannumeral/?query=123");
            return "{\"Error\":\"Missing query parameters in url, Eg. Usage: http://localhost:8080/romannumeral/?query=123\"}";
        }
    }

    @Produces("application/json")
    public String getIntToRoman(String input) {

        HashMap<Number, String> hashVal = new HashMap<>();
        hashVal.put(1, "I");
        hashVal.put(4, "IV");
        hashVal.put(5, "V");
        hashVal.put(9, "IX");
        hashVal.put(10, "X");
        hashVal.put(40, "XL");
        hashVal.put(50, "L");
        hashVal.put(90, "XC");
        hashVal.put(100, "C");
        hashVal.put(400, "CD");
        hashVal.put(500, "D");
        hashVal.put(900, "CM");
        hashVal.put(1000, "M");

        StringBuffer output = new StringBuffer();
        int inputValue;
        try {
            inputValue = Integer.parseInt(input);
        }catch(NumberFormatException e){
            LOGGER.log(Level.SEVERE,"Invalid Integer, passed parameter \""+input+"\"is not a number");
            return "{\"Warning\":\"Invalid Integer, passed parameter '"+input+"' is not a number\"}";
        }

        LOGGER.log(Level.INFO,"Processing Number:"+input);

        if (inputValue <= 0 || inputValue > 3999) {
            LOGGER.log(Level.WARNING,"Invalid Integer "+inputValue+", Number should be between 0 and 3999");
            return "{\"WARNING\":\"Invalid Integer, Number should be between 0 and 3999\"}";
        }

        int temp = 0;
        int d=1000;

        while (d > 0) {

            temp = inputValue / d - 5;
            if (temp == -5) { //check of there is no 1000s/100s/10s/1s and continue
                inputValue = inputValue % d;
                d = d / 10;
                continue;
            }
            //Check if value is 4, 40, 400 if so get corresponding value from hash
            if (temp == -1) {
                output = output.append(hashVal.get(4 * d));
            } else if (temp < -1) {  //Check if values in increments of  1/10/100 if so get value for 1/10/100/1000 and append to the output
                for (int i = 0; i < temp + 5; i++) {
                    output = output.append(hashVal.get(d));
                }
            }
            else if(temp==4){
                output = output.append(hashVal.get(9 * d)); //check for 9/90/900
            }
            //else if (temp >= 1) { //Check if value is > 5/50/500
            else{ //if value is > 5/50/500

                output = output.append(hashVal.get(5 * d)); //append 5/50/500
                for (int i = 0; i < temp; i++) output = output.append(hashVal.get(d)); //append remaining 1s/10s/100s
            }
            inputValue = inputValue % d;
            d = d / 10;
        }
        return "{\n   "+"\"input\" : "+"\""+input+"\",\n   "+"\"output\" : "+"\""+output.toString()+"\"\n}";
    }
}

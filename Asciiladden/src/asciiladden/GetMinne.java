package asciiladden;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

public class GetMinne {
    
    private String respons = "";
    
    public GetMinne(String id) {
        if (id.contains("-")) {
            respons = getEnkSparqlQuery(id);
        } else {
            respons = getLokSparqlQuery(id);
        }        
    }
    
    public String getRespons() {
        return respons;
    }
    
    public String getLokSparqlQuery(String lokId) {
        String query = "https://sparql.kulturminne.no/?default-graph-uri=&query=select+"
                + "*%0D%0Awhere+%7B%0D%0A%7B%3Chttps%3A%2F%2Fdata.kulturminne.no%2Faskeladden"
                + "%2Flokalitet%2F"
                + lokId
                + "%3E+%3Fp+%3Fo+.%7D%0D%0AOPTIONAL%0D%0A%7B%3Fo+rdfs%3Alabel+%3Flab+.%7D%0D%0A%7D&"
                + "format=application%2Fsparql-results%2Bjson&timeout=0&debug=on";
        return query;
    }
    
    public String getEnkSparqlQuery(String enkId) {
        String query = "https://sparql.kulturminne.no/?default-graph-uri=&query=select+"
                + "*%0D%0Awhere+%7B%0D%0A%7B%3Chttps%3A%2F%2Fdata.kulturminne.no%2Faskeladden"
                + "%2Fenkeltminne%2F"
                + enkId
                + "%3E+%3Fp+%3Fo+.%7D%0D%0AOPTIONAL%0D%0A%7B%3Fo+rdfs%3Alabel+%3Flab+.%7D%0D%0A%7D&"
                + "format=application%2Fsparql-results%2Bjson&timeout=0&debug=on";
        return query;
    }
    
    public void getInfo(String query) throws Exception {
        URL url = new URL(query);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
    
}

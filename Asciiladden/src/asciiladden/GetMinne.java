package asciiladden;

import java.net.URL;
import java.net.HttpURLConnection;

public class GetMinne {
    
    public GetMinne(String id) {
        if (id.contains("-")) {
            getEnkSparql(id);
        }
        
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
    
}

package windpark.windengine;

import org.springframework.web.bind.annotation.*;

import windpark.model.WindengineData;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class WindengineController {

    @Autowired
    private WindengineService service;

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping("/")
    public String windengineMain() {
    	String mainPage = "This is the windengine application! (DEZSYS_GK72_WINDPARK) <br/><br/>" +
                          "<a href='http://localhost:8080/windengine/001/xml?mediaType=xml'>Link to windengine/001/xml</a><br/>" +
                          "<a href='http://localhost:8080/windengine/001/json?mediaType=json'>Link to windengine/001/json</a><br/>"+
                "<a href='http://localhost:8080/consumer'>See data as consumer</a><br/>";
        return mainPage;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value="/windengine/{windengineID}/xml",produces = { "application/xml" } )
    public WindengineData windengineDataXML( @PathVariable String windengineID ) {
        return service.getWindengineData( windengineID );
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value="/windengine/{windengineID}/json",produces = { "application/json" })
    public WindengineData windengineDataJSON( @PathVariable String windengineID ) {
        return service.getWindengineData(windengineID);
    }

}
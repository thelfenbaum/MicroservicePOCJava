package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication
// following 2 decorators are Spring MVC annotations and not specific to spring boot
@RestController // tells Spring to render the resulting string directly back to the caller
@EnableAutoConfiguration // tells Spring Boot to “guess” how you want to configure Spring, based on the jar dependencies
                            // that you have added. since has tomcat and MVC, assumes we are building web and sets up for that
public class DemoApplication {
    // need to verify whether storing these variables here or elsewhere
    String WEATHER_API_URL = "http://api.openweathermap.org/data/2.5/weather";
    String WEATHER_API_KEY = "51feb6438334e6502cf871203e59a9af";
    int PORT = 8080;

    void check(Exception e) {
        //intake ___ and check if error field is empty
        if (e != null) {
            // if it is then exit the program
            System.exit(-1); //need to make sure this is what we want since it will leave half finished tasks in docker
            // also need to double check which status code want to use here
        }
    }


    String infoRequestHandler(){
        return info();
    }

    //handler for the weather request - responds with json
    void weatherRequestHandler() {

        // backend service properties
        String serviceUrl = WEATHER_API_URL;
        String apiKey = "&appid=" + WEATHER_API_KEY;

        // request parameters used when calling the weather service
        // others could be added - optional ones could have a default set here
        String unit = "&units=metric";
        // the query is going to be a function with @RequestParams annotation. probably
        //@RequestParam(value = "city")
        public String cityName(@RequestParam String city) {
            return "?q=" + city; // need to initialize city?
        }
        // does @RequestParams need to come afer a @GetMapping or @ResponseBody?
        //String cityName = "?q=" + @RequestParam(String city); // this is where we get the request object getparams following format mentioned in raml

        // request url is created dynamically
        String askUrl = serviceUrl + city + apiKey + unit;
        // do we want to print this or put this on the web?
        // @putMapping
        sys out print("Ask requested: ", askUrl);

        // get askUrl and check for errors

    }

    // get method for each subpage
    @GetMapping ("/info") //would ideally want this to call on infoRequestHandler method
    String info() {return "Welcome to the Weather App microservice.";}

    @GetMapping ("/weather")
    String weather() {
        // issue httpclient get request here to get 200 ok response from google
        // next swap in google for the API, adding in parameters (key, city, units)
        // eventually return json file instead
        return "weather";}

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    } // calls run


}



//    //handler for the info request - responds with text
//    infoRequest_Handler(c *gin.Context) {
//


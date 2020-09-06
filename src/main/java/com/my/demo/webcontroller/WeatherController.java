package com.my.demo.webcontroller;

import com.my.demo.models.Condition;
import com.my.demo.models.Current;
import com.my.demo.models.Location;
import com.my.demo.models.Weather;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Controller
public class WeatherController {

    @RequestMapping("/weather")
    public String getWeatherPage(
            @RequestParam(value = "city") String city,
            Model model
    ) {
        RestTemplate template = new RestTemplate();
        String url = "http://api.weatherapi.com/v1/current.json?key=f31d78264ea244d6a6a52452200609&q={city}";
        HashMap<String, String> params = new HashMap<>();
        params.put("city", city);
        ResponseEntity<Weather> responseEntity;
        try {
            responseEntity = template.getForEntity(url, Weather.class, params);
        } catch (Exception e) {
            if (e instanceof HttpClientErrorException){
                HttpClientErrorException exception= (HttpClientErrorException) e;
                if (exception.getRawStatusCode()==400){
                    model.addAttribute("message","No matching location found");
                }
            }else {
                model.addAttribute("message", "Something went wrong!");
            }
            return "failure";
        }
        if (responseEntity.getStatusCodeValue() == 200) {
            Weather weather = responseEntity.getBody();
            if (weather == null) {
                return "failure";
            }
            Location location = weather.getLocation();
            if (location != null) {
                model.addAttribute("city", location.getName());
                model.addAttribute("lat", location.getLat());
                model.addAttribute("aLong", location.getLon());
                model.addAttribute("country", location.getCountry());
                model.addAttribute("localTime", location.getLocaltime());
            }
            Current current = weather.getCurrent();
            if (current != null) {
                model.addAttribute("lastUpdated", current.getLast_updated());
                model.addAttribute("temp", current.getTemp_c());
                Condition condition = current.getCondition();
                if (condition != null) {
                    model.addAttribute("text", condition.getText());
                    model.addAttribute("icon", condition.getIcon());
                }

            }
            return "weather-info";
        } else if (responseEntity.getStatusCodeValue() == 400) {
            model.addAttribute("message", "No matching location found");
        } else {
            model.addAttribute("message", "something went wrong!");
        }
        return "failure";
    }
}

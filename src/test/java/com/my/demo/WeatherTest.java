package com.my.demo;

import com.my.demo.webcontroller.WeatherController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class WeatherTest {

    @Autowired
    private WeatherController weatherController;

    @MockBean
    private Model model;

    @Test
    public void contexLoads() throws Exception {
        assertThat(weatherController).isNotNull();
    }


    @Test
    public void validPlace() throws Exception {
        assertThat(weatherController.getWeatherPage("Delhi", model)).isNotEqualTo("failure");
    }
}

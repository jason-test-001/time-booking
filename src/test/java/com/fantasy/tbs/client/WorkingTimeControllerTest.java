package com.fantasy.tbs.client;

import com.testo.timebooking.TimeBookingApplication;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * WorkingTimeController test
 *
 * @author:heyaolei
 * @create: 2023-02-22
 */
public class WorkingTimeControllerTest {

    private RestTemplate restTemplate = new RestTemplate();

    /**
     * run this method to start server
     * before all the test
     */
    @BeforeAll
    public static void beforeAll() {
        SpringApplication.run(TimeBookingApplication.class);
    }

    /**
     * calculate 001 worker's working time:
     */
    @Test
    public void queryWorkingTime() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("personalNumber", "001");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(map, httpHeaders);

        String requestUrl = "http://localhost:8080/queryWorkingTime";
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(requestUrl, requestEntity, String.class);
    }


}

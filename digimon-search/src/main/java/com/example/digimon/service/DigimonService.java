package com.example.digimon.service;

import com.example.digimon.model.Digimon;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DigimonService {
    private final String API_URL = "https://digimon-api.vercel.app/api/digimon";

    public Digimon[] getAllDigimons() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(API_URL, Digimon[].class);
    }

    public Digimon[] getDigimonByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + "/name/" + name;
        return restTemplate.getForObject(url, Digimon[].class);
    }

    public Digimon[] getDigimonByLevel(String level) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + "/level/" + level;
        return restTemplate.getForObject(url, Digimon[].class);
    }
}

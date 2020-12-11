package com.lizza;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 *
 */
public class RestTemplate_1 {

    public static void main(String[] args){
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("X-Auth-Token", "f8aaff4ceb7b4c4faba2db0d25819094");
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        String url = "http://localhost:9004/netCollectController/getNextIdByRecordIdAndType?record_id=123&type=1";

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    ResponseEntity<String> result = template.exchange(url, HttpMethod.GET, entity, String.class);
                    System.out.println(result.getBody());
                }
            }, "T-" + i).start();
        }

    }
}

package Service;

import DTO.Response;
import DTO.SessionValue;
import DTO.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static AppUtil.URI.CREATE_SESSION;
import static AppUtil.URI.GET_LOGGED_USER;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class JiraUserService {
    @Autowired
    RestTemplate restTemplate;

    SessionValue session = new SessionValue();

    @Value("")
    private String username;

    @Value("")
    private String password;

    public Response getSession() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        //httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        Map<String, String> body = new HashMap<>();
        body.put("username", username);
        body.put("password", password);
        if (body.isEmpty()) {
            try {
                throw new Exception("Please sign up!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        HttpEntity httpEntity = new HttpEntity<>(body, httpHeaders);
        session.setSession(restTemplate.postForObject(CREATE_SESSION, httpEntity, Response.class).getSession().getValue());
        return restTemplate.postForObject(CREATE_SESSION, httpEntity, Response.class);
    }


    public String getSession(final String url) throws Exception {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add(HttpHeaders.USER_AGENT, "Mozilla/5.0");
        headers.add(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.8");
        HttpEntity<?> entity = new HttpEntity<Object>(headers);
        HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());
        session.setSession(restTemplate.exchange(CREATE_SESSION, HttpMethod.GET, entity, Response.class).getBody().getSession().getValue());
        return response.getBody();
    }

    public ResponseEntity<User> getUser() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.set("Cookie", "JSESSIONID=" + session.getSession());
        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(GET_LOGGED_USER, HttpMethod.GET, httpEntity, User.class);
    }
}

package Service;

import DTO.SessionValue;
import Issue.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static AppUtil.URI.*;

@Service
public class IssueService {
    @Autowired
    private JiraUserService jiraUserService;

    @Autowired
    private RestTemplate restTemplate;

    public Object createIssue(Issue issue) {
        jiraUserService.getSession();
        SessionValue sessionValue = jiraUserService.session;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("cookie", "JSESSIONID=" + sessionValue.getSession());
        HttpEntity httpEntity = new HttpEntity(issue, httpHeaders);
        return restTemplate.exchange(CREATE_ISSUE, HttpMethod.POST, httpEntity, GetIssueResponse.class);
    }

    public String deleteIssue(String id) {
        jiraUserService.getSession();
        SessionValue sessionValue = jiraUserService.session;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("cookie", "JSESSIONID=" + sessionValue.getSession());
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        restTemplate.exchange(DELETE_ISSUE_BY_ID.concat(id), HttpMethod.DELETE, httpEntity, String.class);
        return "Done!";
    }

    public ResponseEntity<GetIssueResponse> updateIssue(Issue issue,String id) {
        jiraUserService.getSession();
        SessionValue sessionValue = jiraUserService.session;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("cookie", "JSESSIONID=" + sessionValue.getSession());
        HttpEntity httpEntity = new HttpEntity(issue, httpHeaders);
        return restTemplate.exchange(UPDATE_ISSUE_BY_ID.concat(id), HttpMethod.PUT, httpEntity, GetIssueResponse.class);
    }

    public ResponseEntity<String > getAssignedIssues(String username) {
        jiraUserService.getSession();
        SessionValue sessionValue = jiraUserService.session;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("cookie", "JSESSIONID=" + sessionValue.getSession());
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        return restTemplate.exchange(ASSIGNEE.concat(username), HttpMethod.GET, httpEntity, String.class);
    }
}

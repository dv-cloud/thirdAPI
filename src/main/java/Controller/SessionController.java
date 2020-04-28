package Controller;


import DTO.Response;
import DTO.User;
import Service.JiraUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Autowired
    private JiraUserService jiraUserService;


    private Response response;

    @PostMapping("/auth")
    public ResponseEntity<Object> userAuth() {
        response = jiraUserService.getSession();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/currentUser")
    public ResponseEntity<User> getLoggedUser() {
        return jiraUserService.getUser();
    }
}

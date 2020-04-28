package Controller;

import Issue.Issue;
import Service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/issue")
@RequiredArgsConstructor
public class IssueController {
    private IssueService issueService;

    @PostMapping("/create")
    public Object createIssue(@RequestBody Issue issue) {
        return issueService.createIssue(issue);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteIssue(@PathVariable String id) {
        return issueService.deleteIssue(id);
    }

    @PutMapping("/update/{id}")
    public Object updateIssue(@PathVariable String id, @RequestBody Issue issue) {
        return issueService.updateIssue(issue, id);
    }

    @GetMapping("/lookfor/{username}")
    public ResponseEntity<String> getAssignedIssues(@PathVariable String username) {
        return issueService.getAssignedIssues(username);
    }
}

package ru.job4j.github.analysis.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.github.analysis.model.Commit;
import ru.job4j.github.analysis.model.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@AllArgsConstructor
public class GitHubService {

    @Autowired
    private final RestTemplate restTemplate;


    public List<Repository> fetchRepositories(String username) {
        String url = "https://api.github.com/users/" + username + "/repos";
        return restTemplate.getForObject(url, List.class);
    }

    public List<Commit> fetchCommits(String repoName) {
        String url = "https://api.github.com/repos/" + repoName + "/commits";
        return restTemplate.getForObject(url, List.class);
    }
}
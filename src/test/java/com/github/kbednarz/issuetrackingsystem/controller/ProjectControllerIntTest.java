package com.github.kbednarz.issuetrackingsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kbednarz.issuetrackingsystem.domain.Project;
import com.github.kbednarz.issuetrackingsystem.repository.ProjectRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class ProjectControllerIntTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    ProjectRepository projectRepository;

    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getProject() throws Exception {
        // given
        Project project = createProject("Test title");

        // when
        this.mockMvc.perform(get("/api/project?id=" + project.getId()))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(project.getId())));

    }

    @Test
    public void saveProject() throws Exception {
        // given
        Project project = new Project();
        project.setTitle("Test title");
        assert projectRepository.count() == 0;

        // when
        this.mockMvc.perform(post("/api/project")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(project))
        )
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.title", equalTo("Test title")));

        // then
        assertEquals(1, projectRepository.count());
    }

    @Test
    public void listProjects() throws Exception {
        Project project1 = createProject("Test title 1");
        Project project2 = createProject("Test title 2");
        assert projectRepository.count() == 2;

        // when
        this.mockMvc.perform(get("/api/project/list"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$[*].id", containsInAnyOrder(project1.getId().intValue(), project2.getId().intValue())));
    }

    private Project createProject(String title) {
        Project project = new Project();
        project.setTitle(title);
        project.setTimestamp(new Date());
        return projectRepository.save(project);
    }
}
                        package at.bitmedia.schoolreader;


import at.bitmedia.schoolreader.controller.TaskController;
import at.bitmedia.schoolreader.entity.Task;
import at.bitmedia.schoolreader.service.TaskServiceBean;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
              private TaskServiceBean taskService;

    @Test
    public void testAll()throws Exception{
        List<Task> list = taskService.findAll();

mvc.perform(get("/all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].description").value(list.get(0).getDescription()))
        .andExpect(jsonPath("$[0].taskId").value(list.get(0).getTaskId()));


    }

}

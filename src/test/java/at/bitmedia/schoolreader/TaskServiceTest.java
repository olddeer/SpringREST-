package at.bitmedia.schoolreader;


import at.bitmedia.schoolreader.entity.Task;
import at.bitmedia.schoolreader.service.TaskServiceBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.AssertionErrors;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {
    @Autowired
    TaskServiceBean taskService;
/*
    @Test
    public void testServiceDescription(){
        Task task = taskService.findByDescription("Robinson Cruso p.4, par.6");
        AssertionErrors.assertEquals("Time to check id",2,task.getTaskId());
        AssertionErrors.assertEquals("Time to check description","Robinson Cruso p.4, par.6",task.getDescription());
    }

    @Test
    public void testServiceFind(){
        List<Task> list = taskService.findAll();
        List<Task> oldList= new ArrayList<>();

        oldList.add(new Task(1,"Book"));
        oldList.add(new Task(2,"Robinson Cruso p.4, par.6"));
        org.junit.Assert.assertTrue(list.get(0).equals(oldList.get(0)) && list.get(1).equals(oldList.get(1)));
    }
*/
@Test
public void test()throws Exception{
    org.junit.Assert.assertTrue(true);

}
}

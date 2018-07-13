package at.bitmedia.schoolreader;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import at.bitmedia.schoolreader.service.TaskServiceBean;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = at.bitmedia.schoolreader.Version1Application.class)
@Log4j2
public class OAuthTest {

    @Autowired
    TaskServiceBean task;

    @Autowired
    WebApplicationContext webApplicationContext;
    @Autowired
    FilterChainProxy fcp;

    private MockMvc moc;


    @Before
    public void setUp() {
        this.moc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilter(fcp).build();
        Mockito.reset(task);
    }

    private String obtainAccessToken(String username, String password) throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("spring-security-oauth2-read-write-client",
                "spring-security-oauth2-read-write-client-password1234");
        params.add("username", username);
        params.add("password", password);
        ResultActions result = moc
                .perform(post("http://localhost:8080/oauth/token")
                        .params(params)
                        .with(httpBasic("spring-security-oauth2-read-write-client",
                                "spring-security-oauth2-read-write-client-password1234"))
                        .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
        String resultString = result.andReturn().getResponse().getContentAsString();
        JacksonJsonParser jsonParser = new JacksonJsonParser();

        return jsonParser.parseMap(resultString).get("access_token").toString();
    }

    @MockBean
    private TaskServiceBean taskService;

    @Test
    public void test() throws Exception {
        org.junit.Assert.assertTrue(true);

    }
    /*
     * @Test public void testAll()throws Exception{ List<Task> list = taskService.findAll(); String
     * accessToken = obtainAccessToken("alex","admin1234");
     * moc.perform(get("http://localhost:8080/secured/tasks/all").contentType(MediaType.
     * APPLICATION_JSON).header("Authorization", "Bearer " + accessToken))
     * .andExpect(status().isOk())
     * .andExpect(content().contentType("application/json;charset=UTF-8")) .andDo(print())
     * .andExpect(jsonPath("$[0].description").value(list.get(0).getDescription()))
     * .andExpect(jsonPath("$[0].taskId").value(list.get(0).getTaskId())); }
     */


}

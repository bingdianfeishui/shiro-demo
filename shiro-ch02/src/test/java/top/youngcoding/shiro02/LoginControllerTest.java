package top.youngcoding.shiro02;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import top.youngcoding.shiro02.config.RootConfig;
import top.youngcoding.shiro02.config.WebAppInitializer;
import top.youngcoding.shiro02.config.WebMvcConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * @author liy
 * @date 2018/4/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppInitializer.class, WebMvcConfig.class, RootConfig.class})
public class LoginControllerTest {
    @Autowired
    WebApplicationContext wac;
    MockMvc mockMvc;

    @Before
    public void init(){
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void loginTest() throws Exception {
        mockMvc.perform(get("/login")).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void retryTimes() throws Exception {
        mockMvc.perform(post("/login").requestAttr("username","admin").requestAttr("password","123")).andExpect(status().isOk()).andDo(print());
    }
}

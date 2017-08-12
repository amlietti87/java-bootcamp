package com.globant.meetings.test.controllers;

import com.globant.meetings.controllers.AttendeeRestController;
import com.globant.meetings.model.Attendee;
import com.globant.meetings.test.utils.JsonConverterUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class AttendeeRestControllerTest {

    private static final String BASE_URL_LIST = "/attendee/list";
    private MockMvc mvcMocked;
    private JsonConverterUtil<Attendee> converter;
    private Attendee attendee;

    private static final String BASE_URL_ADD = "/attendee/add";
    private static final String BASE_URL_REMOVE = "/attendee/remove/{id}";
    private static final String CONTENT_TYPE = "application/json";

    private static final String PATH = "/Users/andreslietti/IntelliJ/java-bootcamp/meetings/src/test/resources/attendee.json";

    @Mock
    private AttendeeRestController attendeeRestController;

    @Before
    public void setUp(){
        mvcMocked = MockMvcBuilders.standaloneSetup(attendeeRestController).build();
        converter = new JsonConverterUtil<>();
        attendee = converter.convert(PATH, Attendee.class);
    }

    @Test
    public void shouldReturnIsCreated() throws Exception{
        mvcMocked.perform(post(BASE_URL_ADD)
                .content(PATH)
                .contentType(CONTENT_TYPE))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturnStatusOK() throws Exception {
        mvcMocked.perform(get(BASE_URL_LIST).contentType(CONTENT_TYPE))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnStatusOK1() throws Exception {
        mvcMocked.perform(get(BASE_URL_REMOVE).contentType(CONTENT_TYPE))
                .andExpect(status().isOk());
    }
    
}

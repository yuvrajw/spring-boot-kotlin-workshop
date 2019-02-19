package nl.eonics.hacknight.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.eonics.hacknight.model.LombokValueObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WorkshopController.class)
public class WorkshopControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testWithJavaPojo() throws Exception {
        validateEndpoint(WorkshopController.JAVA);
    }

    @Test
    public void testWithKotlinPojo() throws Exception {
        validateEndpoint(WorkshopController.KOTLIN);
    }


    private void validateEndpoint(final String path) throws Exception {
        final ResultActions result = mockMvc.perform(post(path).content(objectMapper.writeValueAsString(new LombokValueObject())));
        result.andExpect(status().isOk());

        final LombokValueObject expected = new LombokValueObject();
        expected.setValue(WorkshopController.MODIFIED);

        final LombokValueObject output = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(),
                LombokValueObject.class);

        assertThat(output).isEqualTo(expected);
    }


}

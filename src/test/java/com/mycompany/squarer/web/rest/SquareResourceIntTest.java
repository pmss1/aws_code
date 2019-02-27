package com.mycompany.squarer.web.rest;

import com.mycompany.squarer.SquarerApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the SquareResource REST controller.
 *
 * @see SquareResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SquarerApp.class)
public class SquareResourceIntTest {

    private MockMvc restMockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        SquareResource squareResource = new SquareResource();
        restMockMvc = MockMvcBuilders
            .standaloneSetup(squareResource)
            .build();
    }

    /**
     * Test square
     */
    @Test
    public void testSquare() throws Exception {
        restMockMvc.perform(get("/api/square/2"))
            .andExpect(status().isOk())
            .andExpect(content().string("4"));
    }
}

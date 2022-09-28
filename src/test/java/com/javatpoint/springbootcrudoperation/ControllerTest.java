package com.javatpoint.springbootcrudoperation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatpoint.controller.BooksController;
import com.javatpoint.model.Books;
import com.javatpoint.service.BooksService;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BooksController.class)
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BooksService booksService;

    @Test
    public void test1() throws Exception {
        Books book =Books.builder()
                .bookid(1000)
                .bookname("your head is houseboat")
                .author("ab")
                .price(1200)
                .color("red")
                .build();
        String inputInJson = this.mapToJson(book);
        String URI = "/book";
        Mockito.when(booksService.saveOrUpdate(Mockito.any(Books.class))).thenReturn(book);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputInJson = response.getContentAsString();
//        assertEquals(inputInJson ,outputInJson );
        assertEquals("1000" ,outputInJson );
        assertEquals(HttpStatus.OK.value(),response.getStatus());

    }
private String mapToJson(Object object) throws JsonProcessingException{
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(object);
}
}

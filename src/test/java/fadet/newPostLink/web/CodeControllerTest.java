package fadet.newPostLink.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import fadet.newPostLink.TestData;
import fadet.newPostLink.domain.Code;
import fadet.newPostLink.repository.CodeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CodeControllerTest {

    @Autowired
    CodeController codeController;
    @Autowired
    CodeRepository codeRepository;

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    int port;

    @Autowired
    MockMvc mvc;


//    @Test
//    public void 테스트용인덱스_로딩() {
//        //when
//        String body = this.restTemplate.getForObject("/", String.class);
//
//        //then
//        assertThat(body).contains("테스트 인덱스 h2");
//    }

    @BeforeEach
    public void setup() throws Exception{
//        mvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .build();
    }

//    @Test
//    public void input_로딩(){
//        //when
//        String body = this.restTemplate.getForObject("/", String.class);
//
//        //then
//        assertThat(body).contains("input");
//    }

    @Test
    public void input_post정상() throws Exception{

        //given
        InputForm form = new InputForm(TestData.testAllCode, TestData.testTitleHtmlKeyword, TestData.testIndexHtmlKeyword);

        String url = "http://localhost:" + port + "/";

        //when

        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(form)))
                .andExpect(status().is3xxRedirection());

        //then
        Code savedOne = codeRepository.findLastOne();
        assertThat(savedOne.getAllCode()).isEqualTo(TestData.testAllCode);

    }

    @Test
    public void valid_get_일반텍스트출력정상() throws Exception{
        //given
        InputForm form = new InputForm(TestData.testAllCode, TestData.testTitleHtmlKeyword, TestData.testIndexHtmlKeyword);

        String url = "http://localhost:" + port + "/";

        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(form)))
                .andExpect(status().is3xxRedirection());

        //when
        String body = this.restTemplate.getForObject("/valid", String.class);

        //then
        assertThat(body).contains("입력된");
        assertThat(body).contains("유효성 검증");
    }

    @Test
    public void valid_get_input정보출력정상(){

    }
}
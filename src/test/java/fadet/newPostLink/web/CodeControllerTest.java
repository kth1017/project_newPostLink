package fadet.newPostLink.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import fadet.newPostLink.domain.Code;
import fadet.newPostLink.repository.CodeRepository;
import org.assertj.core.api.Assertions;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

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

    @Autowired
    WebApplicationContext context;

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
        InputForm form = new InputForm();
        form.setAllCode("allCode");
        form.setTitleHtmlKeyword("THK");
        form.setIndexHtmlKeyword("IHK");

        String url = "http://localhost:" + port + "/";

        //when
        // perform 중 npe발생
        // 디버그로 원인 파악 중
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                       .content(new ObjectMapper().writeValueAsString(form)))
                        .andExpect(status().isOk());

        //then
        Code savedOne = codeRepository.findLastOne();
        assertThat(savedOne.getAllCode()).isEqualTo("allCode");

    }

}
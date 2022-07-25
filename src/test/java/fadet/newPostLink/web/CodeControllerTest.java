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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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


//    @Test
//    public void input_get_로딩(){
//        //when
//        String body = this.restTemplate.getForObject("/", String.class);
//
//        //then
//        assertThat(body).contains("input");
//    }

    @Test
    public void input_post_code입력_정상() throws Exception{

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
    public void valid_get_일반텍스트출력_정상() throws Exception{
        //given
        InputForm form = new InputForm(TestData.testAllCode, TestData.testTitleHtmlKeyword, TestData.testIndexHtmlKeyword);

        String url = "http://localhost:" + port + "/";

        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(form)))
                .andExpect(status().is3xxRedirection())
                .andDo(log());


        //when
        String body = this.restTemplate.getForObject("/valid", String.class);

        //then
        assertThat(body).contains("입력된");
        assertThat(body).contains("유효성 검증");
    }

    @Test
    public void valid_get_code출력_정상() throws Exception{
        //given
        InputForm form = new InputForm(TestData.testAllCode, TestData.testTitleHtmlKeyword, TestData.testIndexHtmlKeyword);

        String url = "http://localhost:" + port + "/";

        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(form)))
                .andExpect(status().is3xxRedirection())
                .andDo(log());

        //when
        String body = this.restTemplate.getForObject("/valid", String.class);

        //then
        assertThat(body).contains("&lt;p data-ke-size=&quot;size16&quot;&gt;&lt;span style=&quot;color: #555555; font-family: &#39;Noto Serif KR&#39;;&quot;&gt;* &lt;span style=&quot;color: #555555;&quot;&gt;테스트 서론1&lt;");

        assertThat(body).contains("<p>타이틀 개수</p><p>2</p>");
        assertThat(body).contains("<p>중복 없음</p>");

    }

    @Test
    public void valid_post_updateCode입력_정상() throws Exception{
        //given
        codeRepository.save(new Code(TestData.testAllCode, TestData.testTitleHtmlKeyword, TestData.testIndexHtmlKeyword));

        ValidForm form = new ValidForm(TestData.testValidAllCode, TestData.testValidTitleHtmlKeyword, TestData.testValidIndexHtmlKeyword);
        String url = "http://localhost:" + port + "/valid";

        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(form)))
                .andExpect(status().is3xxRedirection())
                .andDo(log());

        //then
        Code savedOne = codeRepository.findLastOne();
        assertThat(savedOne.getAllCode()).isEqualTo(TestData.testValidAllCode);

    }


    @Test
    public void valid_post_updateCode출력_정상() throws Exception{
        //given
        codeRepository.save(new Code(TestData.testAllCode, TestData.testTitleHtmlKeyword, TestData.testIndexHtmlKeyword));

        ValidForm form = new ValidForm(TestData.testValidAllCode, TestData.testValidTitleHtmlKeyword, TestData.testValidIndexHtmlKeyword);
        String url = "http://localhost:" + port + "/valid";

        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(form)))
                .andExpect(status().is3xxRedirection())
                .andDo(log());

        //when
        String body = this.restTemplate.getForObject("/valid", String.class);

        //then
        assertThat(body).contains("&lt;p data-ke-size=&quot;size16&quot;&gt;&lt;span style=&quot;color: #555555; font-family: &#39;Noto Serif KR&#39;;&quot;&gt;* &lt;span style=&quot;color: #555555;&quot;&gt;Valid 테스트 서론1&lt;");

        assertThat(body).contains("<p>타이틀 개수</p><p>1</p>");
        assertThat(body).contains("<p>중복 없음</p>");

    }

    @Test
    public void result_get_결과code출력_정상() throws Exception {
        //given
        InputForm form = new InputForm(TestData.testAllCode, TestData.testTitleHtmlKeyword, TestData.testIndexHtmlKeyword);

        String url = "http://localhost:" + port + "/";

        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(form)))
                .andExpect(status().is3xxRedirection())
                .andDo(log());
        //when
        String body = this.restTemplate.getForObject("/result", String.class);

        //then
        assertThat(body).contains("&lt;p data-ke-size=&quot;size16&quot;&gt;&lt;span style=&quot;color: #555555; font-family: &#39;Noto Serif KR&#39;;&quot;&gt;* &lt;span style=&quot;color: #555555;&quot;&gt;테스트 서론1&lt;/span&gt;&lt;/span&gt;&lt;/p&gt; &lt;span&gt;테스트 서론2&lt;/span&gt;&lt;blockquote data-ke-style=&quot;style2&quot;&gt;Index&lt;br /&gt;&lt;a href=&quot;#1&quot;&gt;1 테스트 목차1&lt;/a&gt;&lt;br /&gt;&lt;a href=&quot;#2&quot;&gt;2 테스트 목차2&lt;/a&gt;&lt;/blockquote&gt;");

    }
}
package fadet.newPostLink.service;

import fadet.newPostLink.domain.Code;
import fadet.newPostLink.repository.CodeRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CodeServiceTest {

    @Autowired
    private CodeServiceImpl codeService;
    private CodeRepositoryImpl codeRepository;

    @Test
    void 코드저장() {
        //given
        Code newOne = new Code("allCode1", "titleHtmlKeyword1", "indexHtmlKeyword1");

        //when
        codeService.saveCode(newOne);

        //then
        Code savedOne = codeRepository.findLastOne();

        assertThat(savedOne.getAllCode()).isEqualTo("allCode1");
        assertThat(savedOne.getTitleHtmlKeyword()).isEqualTo("titleHtmlKeyword1");
        assertThat(savedOne.getIndexHtmlKeyword()).isEqualTo("indexHtmlKeyword1");

    }

    @Test
    void 마지막코드불러오기() {
        //given
        //when
        //then
    }

    @Test
    void 코드수정() {
        //given
        //when
        //then
    }

    @Test
    void 코드변환() {
        //given
        //when
        //then
    }


}
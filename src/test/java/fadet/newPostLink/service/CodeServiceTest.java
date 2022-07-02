package fadet.newPostLink.service;

import fadet.newPostLink.TestData;
import fadet.newPostLink.domain.Code;
import fadet.newPostLink.domain.ResultCode;
import fadet.newPostLink.repository.CodeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CodeServiceTest {

    @Autowired
    private CodeService codeService;
    @Autowired
    private CodeRepository codeRepository;

    @AfterEach
    void 후처리(){
        codeRepository.clear();
    }

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
        Code newOne = new Code("allCode1", "titleHtmlKeyword1", "indexHtmlKeyword1");
        codeService.saveCode(newOne);

        //when
        Code savedOne = codeService.findLastOne();

        //then
        assertThat(savedOne.getId()).isEqualTo(1);
        assertThat(savedOne.getAllCode()).isEqualTo("allCode1");
    }

    @Test
    void 코드수정() {
        //given
        Code newOne = new Code("allCode1", "titleHtmlKeyword1", "indexHtmlKeyword1");
        codeService.saveCode(newOne);

        Code updateOne = new Code("newAllCode", "newTHK", "newIHK");

        //when
        Code savedUpdateOne = codeService.updateCode(updateOne);

        //then
        assertThat(savedUpdateOne.getId()).isEqualTo(1);
        assertThat(savedUpdateOne.getAllCode()).isEqualTo("newAllCode");
    }

    @Test
    void 코드변환실패1_THK오류() {
        //given
        Code newOne = new Code(TestData.testFailTAllCode, TestData.testTitleHtmlKeyword, TestData.testIndexHtmlKeyword);

        codeService.saveCode(newOne);

        //when
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> codeService.modifyCode());

        //then
        assertThat(e.getMessage()).isEqualTo("타이틀 리스트 없음");

    }

    @Test
    void 코드변환실패2_IHK오류() {
        //given
        Code newOne = new Code(TestData.testFailIAllCode, TestData.testTitleHtmlKeyword, TestData.testIndexHtmlKeyword);

        codeService.saveCode(newOne);

        //when
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> codeService.modifyCode());

        //then
        assertThat(e.getMessage()).isEqualTo("인덱스 중복");

    }

    @Test
    void 코드변환성공() {
        //given
        Code newOne = new Code(TestData.testAllCode, TestData.testTitleHtmlKeyword, TestData.testIndexHtmlKeyword);
        codeService.saveCode(newOne);

        //when
        ResultCode resultCode = codeService.modifyCode();

        //then
        assertThat(resultCode.getResultAllCode()).isEqualTo(TestData.testResultCode);
    }


}
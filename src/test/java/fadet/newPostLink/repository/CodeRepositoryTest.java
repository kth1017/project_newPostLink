package fadet.newPostLink.repository;

import fadet.newPostLink.TestData;
import fadet.newPostLink.domain.Code;
import fadet.newPostLink.domain.ResultCode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CodeRepositoryTest {

    @InjectMocks
    private CodeRepositoryImpl codeRepository;

    @Test
    void 테스트양식() {
        //given
        //when
        //then
    }
    @Test
    void 코드입력() {
        //given
        Code newOne = new Code(TestData.testAllCode, TestData.testTitleHtmlKeyword, TestData.testIndexHtmlKeyword);

        //when
        Code savedCode = codeRepository.save(newOne);

        //then
        assertThat(savedCode.getId()).isNotNull();

        assertThat(savedCode.getAllCode()).isEqualTo(TestData.testAllCode);
        assertThat(savedCode.getTitleHtmlKeyword()).isEqualTo(TestData.testTitleHtmlKeyword);
        assertThat(savedCode.getIndexHtmlKeyword()).isEqualTo(TestData.testIndexHtmlKeyword);

        assertThat(savedCode.getTitleList().get(0)).isEqualTo("테스트 목차1");
        assertThat(savedCode.getIndexOver()).isEqualTo(2);
    }

    @Test
    void 마지막저장데이터불러오기() {
        //given
        Code newOne1 = new Code("allCode1", "titleHtmlKeyword1", "indexHtmlKeyword1");
        Code newOne2 = new Code("allCode2", "titleHtmlKeyword2", "indexHtmlKeyword2");

        codeRepository.save(newOne1);
        codeRepository.save(newOne2);
        //when
        Code savedCode = codeRepository.findLastOne();

        //then
        assertThat(savedCode.getId()).isEqualTo(2);
        assertThat(savedCode.getAllCode()).isEqualTo("allCode2");
    }

    @Test
    void 수정된코드덮어쓰기() {
        //given
        Code oldOne = new Code("allCode1", "titleHtmlKeyword1", "indexHtmlKeyword1");
        codeRepository.save(oldOne);

        Code newOne = new Code("allCode2", "titleHtmlKeyword2", "indexHtmlKeyword2");
        //when
        Code savedNewOne = codeRepository.update(newOne);

        //then
        assertThat(savedNewOne.getId()).isEqualTo(1);
        assertThat(savedNewOne.getAllCode()).isEqualTo("allCode2");
    }

    @Test
    void 결과코드생성() {
        //given
        Code newOne = new Code(TestData.testAllCode, TestData.testTitleHtmlKeyword, TestData.testIndexHtmlKeyword);
        codeRepository.save(newOne);

        //when
        ResultCode resultCode = codeRepository.modify();

        //then
        assertThat(resultCode.getResultAllCode()).isEqualTo(TestData.testResultCode);
    }
}
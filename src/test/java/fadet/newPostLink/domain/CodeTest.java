package fadet.newPostLink.domain;

import fadet.newPostLink.TestData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CodeTest {

    @Test
    void 검증사항계산() {
        //given
        Code newOne = new Code(TestData.testAllCode, TestData.testTitleHtmlKeyword, TestData.testIndexHtmlKeyword);
        //when
        newOne.init();
        //then
        assertThat(newOne.getTitleList().get(0)).isEqualTo("테스트 목차1");
        assertThat(newOne.getTitleList().get(1)).isEqualTo("테스트 목차2");
        assertThat(newOne.getIndexOver()).isEqualTo(2);
    }

}
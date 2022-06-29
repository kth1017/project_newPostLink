package fadet.newPostLink.repository;

import fadet.newPostLink.domain.Code;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CodeRepositoryTest {

    @InjectMocks
    private CodeRepositoryImpl codeRepository;

    @Test
    void 코드입력() {
        //given
        Code newOne = new Code("allCode1", "titleHtmlKeyword1", "indexHtmlKeyword1");

        //when
        Code savedCode = codeRepository.save(newOne);

        //then
        assertThat(savedCode.getId()).isNotNull();

        assertThat(savedCode.getAllCode()).isEqualTo("allCode1");
        assertThat(savedCode.getTitleHtmlKeyword()).isEqualTo("titleHtmlKeyword1");
        assertThat(savedCode.getIndexHtmlKeyword()).isEqualTo("indexHtmlKeyword1");

    }

}
package fadet.newPostLink.service;

import fadet.newPostLink.repository.CodeRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CodeServiceTest {

    @InjectMocks
    private CodeService codeService;

    @Test
    void 서비스존재(){
        assertThat(codeService).isNotNull();
    }


}
package fadet.newPostLink.service;

import fadet.newPostLink.domain.Code;
import fadet.newPostLink.repository.CodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {

    private final CodeRepository codeRepository;

    @Override
    public Code saveCode(Code newOne) {
        return codeRepository.save(newOne);
    }
}

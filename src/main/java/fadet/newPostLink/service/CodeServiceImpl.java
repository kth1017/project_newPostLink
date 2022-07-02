package fadet.newPostLink.service;

import fadet.newPostLink.domain.Code;
import fadet.newPostLink.domain.ResultCode;
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

    @Override
    public Code findLastOne() {
        return codeRepository.findLastOne();
    }

    @Override
    public Code updateCode(Code newOne) {
        return codeRepository.update(newOne);
    }

    @Override
    public void validateTitleHtmlKeyword() {
        Code savedOne = codeRepository.findLastOne();
        if (savedOne.getTitleList().size() == 0) {
            throw new IllegalStateException("타이틀 리스트 없음");
        }
    }

    @Override
    public void validateIndexHtmlKeyword() {
        Code savedOne = codeRepository.findLastOne();
        if (savedOne.getIndexOver() != 2) {
            throw new IllegalStateException("인덱스 중복");
        }
    }

    @Override
    public ResultCode modifyCode() {
        validateTitleHtmlKeyword();
        validateIndexHtmlKeyword();
        return codeRepository.modify();
    }
}

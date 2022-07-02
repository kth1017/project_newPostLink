package fadet.newPostLink.service;

import fadet.newPostLink.domain.Code;
import fadet.newPostLink.domain.ResultCode;

public interface CodeService {

    Code saveCode(Code code);
    Code findLastOne();

    Code updateCode(Code newOne);

    void validateTitleHtmlKeyword();
    void validateIndexHtmlKeyword();
    ResultCode modifyCode();

}

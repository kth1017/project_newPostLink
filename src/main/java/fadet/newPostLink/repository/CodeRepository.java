package fadet.newPostLink.repository;

import fadet.newPostLink.domain.Code;
import fadet.newPostLink.domain.ResultCode;

public interface CodeRepository {

    void clear();

    Code save(Code code);
    Code findLastOne();

    Code update(Code newOne);

    ResultCode modify();

}

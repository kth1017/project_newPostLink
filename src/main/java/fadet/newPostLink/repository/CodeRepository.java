package fadet.newPostLink.repository;

import fadet.newPostLink.domain.Code;

public interface CodeRepository {

    Code save(Code code);
    Code update(Code newOne);
    Code findLastOne();

}

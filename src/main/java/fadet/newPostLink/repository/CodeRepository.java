package fadet.newPostLink.repository;

import fadet.newPostLink.domain.Code;

public interface CodeRepository {

    Code save(Code newOne);
    Code update();
    Code findOne();

}

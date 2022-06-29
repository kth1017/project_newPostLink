package fadet.newPostLink.repository;

import fadet.newPostLink.domain.Code;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CodeRepositoryImpl implements CodeRepository {

    private static Map<Long, Code> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Code save(Code newOne) {
        newOne.setId(++sequence);
        store.put(newOne.getId(), newOne);
        return newOne;
    }

    @Override
    public Code update() {
        return null;
    }

    @Override
    public Code findOne() {
        return null;
    }
}

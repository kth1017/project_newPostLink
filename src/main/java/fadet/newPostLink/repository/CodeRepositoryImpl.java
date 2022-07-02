package fadet.newPostLink.repository;

import fadet.newPostLink.domain.Code;
import fadet.newPostLink.domain.ResultCode;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CodeRepositoryImpl implements CodeRepository {

    private static Map<Long, Code> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Code save(Code code) {
        code.setId(++sequence);
        code.init();
        store.put(code.getId(), code);
        return code;
    }

    @Override
    public Code update(Code newOne) {
        Long size = (long)store.size();
        store.remove(size);

        newOne.setId(size);
        newOne.init();
        store.put(newOne.getId(), newOne);
        return newOne;
    }

    @Override
    public Code findLastOne() {
        Long size = (long)store.size();
        return store.get(size);
    }

    @Override
    public ResultCode modify() {
        Long size = (long)store.size();
        Code savedLastOne = store.get(size);

        ResultCode resultCode = new ResultCode();
        resultCode.init(savedLastOne.getAllCode(), savedLastOne.getTitleHtmlKeyword(), savedLastOne.getIndexHtmlKeyword()
                , savedLastOne.getTitleList());
        return resultCode;
    }

    public void clear(){
        sequence = 0L;
        store.clear();
    }
}

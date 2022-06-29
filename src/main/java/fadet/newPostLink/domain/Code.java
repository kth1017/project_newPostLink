package fadet.newPostLink.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Code {

    private Long id;

    // 필수 입력
    private String allCode;
    private String titleHtmlKeyword;
    private String indexHtmlKeyword;

    // 검증 사항
    private List<String> titleList;
    private int indexOver;

    public Code(String allCode, String titleHtmlKeyword, String indexHtmlKeyword) {
        this.allCode = allCode;
        this.titleHtmlKeyword = titleHtmlKeyword;
        this.indexHtmlKeyword = indexHtmlKeyword;
    }

    /*
        init method
         */
    public void init() {

        // 여기서 타이틀을 추출하기위해 <로 나눴기때문에 이후 <를 고려해서 작성해야함
        String[] startTextArrByBracket = this.allCode.split("<");
        int textLen = startTextArrByBracket.length;

        Long count = 0L;
        List<String> oldList = new ArrayList<>();

        //여기서 위에서 <를 잘랐기에 <를 빼줌
        String addBracketKeyword = this.titleHtmlKeyword.substring(1);

        for (int i = 0; i < textLen; i++) {
            if (startTextArrByBracket[i].equals(addBracketKeyword)) {
                count++;
                // 타이틀명 스트림으로 저장
                oldList.add(startTextArrByBracket[i+1]);
            }
        }

        // 기존에 있던 set 삭제

        // titleList init

        List<String> titleList = new ArrayList<>();

        // 임시로 글씨체를 포함하도록 로직을 짬(이후 고쳐야함)
        for (int i = 0; i < oldList.size(); i++) {
            titleList.add(oldList.get(i).split(">")[1]);;
        }

        setTitleList(titleList);

        // indexOver init(2가 정상)

        String[] resultArr = allCode.split(this.indexHtmlKeyword);

        setIndexOver(resultArr.length);

    }
}

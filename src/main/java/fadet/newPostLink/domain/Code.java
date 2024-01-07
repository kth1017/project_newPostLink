package fadet.newPostLink.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class Code {

    private Long id;

    // 필수 입력
    private String allCode;
    private String titleHtmlKeyword;
    private String indexHtmlKeyword;

    // 검증 사항(init() 이후 set)
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


        // ! 타이틀 구분 키워드는 <를 구분해서 인식하기에 타이틀은 <blockquote ...><span>타이틀</></>꼴로 작성 

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
                System.out.println(startTextArrByBracket.length);
                System.out.println(textLen);
                oldList.add(startTextArrByBracket[i+1]);
                System.out.println(oldList);
            }
        }

        // titleList init



        /*
         임시로 타이틀 키워드 이후의 글씨체(span tag)를 포함하도록 로직을 짬(이후 고쳐야함)
         아래 주석은 for문 사용
         */
//        List<String> titleList = new ArrayList<>();
//        for (int i = 0; i < oldList.size(); i++) {
//            titleList.add(oldList.get(i).split(">")[1]);;
//        }
        List<String> titleList = oldList.stream()
                .map((str) -> str.split(">")[1])
                .collect(Collectors.toList());


        this.titleList = titleList;

        // indexOver init(2가 정상)

        String[] resultArr = allCode.split(this.indexHtmlKeyword);

        this.indexOver = resultArr.length;

    }
}

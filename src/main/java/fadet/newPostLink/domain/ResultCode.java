package fadet.newPostLink.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class ResultCode {
    private String resultAllCode;

    /*
    init method
     */


    public void init(String allCode, String titleHtmlKeyword, String indexHtmlKeyword, List<String> titleList) {
        // 기능1 타이틀별 링크

        // 1 타이틀 키워드 기준으로 기존 코드를 나누는 스트링 배열 생성
        String[] oldCodeArrByKeyword = allCode.split(titleHtmlKeyword);
        // 2 생성한 배열을 활용해 수정 내용이 담길 빌더 작성
        StringBuilder addTitleTextBuilder = new StringBuilder();
        // 3 빌더에 기존 코드 배열의 머리말을 추가
        addTitleTextBuilder.append(oldCodeArrByKeyword[0]);
        // 4 타이틀 키워드를 공백 기준으로 나누는 스트링 배열 생성
        String[] modiTitleKeywordArr = titleHtmlKeyword.split(" ");
        // 5 빌더에 링크가 수정된 코드로 채워넣음
        int arrLen = oldCodeArrByKeyword.length;
        for (int i = 1; i < arrLen; i++) {
            addTitleTextBuilder.append(modiTitleKeywordArr[0])
                    .append(" id=\"").append(i).append("\" ")
                    .append(modiTitleKeywordArr[1]).append(" ").append(modiTitleKeywordArr[2]);
            addTitleTextBuilder.append(oldCodeArrByKeyword[i]);
        }

        // 기능2 인덱스 자동완성

        // 1 빌더.toString
        String addTitleText = addTitleTextBuilder.toString();

        // 2 인덱스 키워드 기준으로 배열 생성
//        String[] resultArr = addTitleText.split("<blockquote data-ke-style=\"style2\">Index</blockquote>");
        String[] resultArr = addTitleText.split(indexHtmlKeyword);
//        String resultText = resultArr[0]+"<blockquote data-ke-style=\"style2\">Index";

        // 3 인덱스 키워드에 포함된 <를 기준으로 나누는 배열 생성
        String[] modifiedIndexKeywordArr = indexHtmlKeyword.split("<");

        // 4 인덱스 키워드
        String modiIndexKeyword = "<"+modifiedIndexKeywordArr[0]+modifiedIndexKeywordArr[1];

        // 5 생성한 배열을 활용해 수정 내용이 담길 빌더 작성
        StringBuilder resultTextBuilder = new StringBuilder();
        resultTextBuilder.append(resultArr[0]+modiIndexKeyword);

        for (int i = 0; i < titleList.size(); i++) {
            int j = i+1;
            resultTextBuilder.append("<br /><a href=\"#")
                    .append(j).append("\">").append(j).append(" ")
                    .append(titleList.get(i)).append("</a>");
        }
        resultTextBuilder.append("<").append(modifiedIndexKeywordArr[2]).append(resultArr[1]);


        this.setResultAllCode(resultTextBuilder.toString());

    }
}

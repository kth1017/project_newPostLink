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

        String[] oldCodeArrByKeyword = allCode.split(titleHtmlKeyword);
        String addTitleText = oldCodeArrByKeyword[0];

        String[] modiTitleKeywordArr = titleHtmlKeyword.split(" ");

        int arrLen = oldCodeArrByKeyword.length;
        for (int i = 1; i < arrLen; i++) {
            addTitleText += modiTitleKeywordArr[0] + " id=\""+i+"\" "+modiTitleKeywordArr[1]+" "+modiTitleKeywordArr[2];
            addTitleText += oldCodeArrByKeyword[i];
        }

        // 기능2 인덱스 자동완성

//        String[] resultArr = addTitleText.split("<blockquote data-ke-style=\"style2\">Index</blockquote>");
        String[] resultArr = addTitleText.split(indexHtmlKeyword);
//        String resultText = resultArr[0]+"<blockquote data-ke-style=\"style2\">Index";

        String[] modiIndexKeywordArr = indexHtmlKeyword.split("<");

        String modiIndexKeyword = "<"+modiIndexKeywordArr[0]+modiIndexKeywordArr[1];

        String resultText = resultArr[0]+modiIndexKeyword;

        for (int i = 0; i < titleList.size(); i++) {
            int j = i+1;
            resultText += "<br /><a href=\"#"+j+"\">"+j+" "+titleList.get(i)+"</a>";
        }
        resultText += "<"+modiIndexKeywordArr[2]+resultArr[1];

        this.setResultAllCode(resultText);

    }
}

package fadet.newPostLink.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Code {

    private Long id;

    // 필수 입력
    private String allCode;
    private String titleHtmlKeyword;
    private String indexHtmlKeyword;

    public Code(String allCode, String titleHtmlKeyword, String indexHtmlKeyword) {
        this.allCode = allCode;
        this.titleHtmlKeyword = titleHtmlKeyword;
        this.indexHtmlKeyword = indexHtmlKeyword;
    }
}

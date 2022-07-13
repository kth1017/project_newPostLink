package fadet.newPostLink.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class InputForm {
    private Long id;

    private String allCode;
    private String titleHtmlKeyword;
    private String indexHtmlKeyword;

    public InputForm(String allCode, String titleHtmlKeyword, String indexHtmlKeyword) {
        this.allCode = allCode;
        this.titleHtmlKeyword = titleHtmlKeyword;
        this.indexHtmlKeyword = indexHtmlKeyword;
    }
}

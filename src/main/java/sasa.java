import fadet.newPostLink.TestData;
import fadet.newPostLink.domain.Code;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class sasa {
    public static void main(String[] args) {
        Code code1 = new Code(TestData.testAllCode, TestData.testTitleHtmlKeyword, TestData.testIndexHtmlKeyword);
        code1.init();
    }

}

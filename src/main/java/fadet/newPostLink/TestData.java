package fadet.newPostLink;

public class TestData {

    public static String testAllCode = "<p data-ke-size=\"size16\"><span style=\"color: " +
            "#555555; font-family: 'Noto Serif KR';\">* <span style=\"color: #555555;\">" +
            "테스트 서론1</span></span></p> " +
            "<span>테스트 서론2</span>" +
            "<blockquote data-ke-style=\"style2\">Index</blockquote> <p data-ke-size=\"size16\">&nbsp;</p>" +
            "<blockquote data-ke-size=\"size16\" data-ke-style=\"style1\"><span style=\"font-family: 'Noto Serif KR';\">테스트 목차1</span></blockquote>" +
            "<span>테스트 내용1</span>" +
            "<blockquote data-ke-size=\"size16\" data-ke-style=\"style1\"><span style=\"font-family: 'Noto Serif KR';\">테스트 목차2</span></blockquote>" +
            "<span>테스트 내용2</span>";

    public static String testTitleHtmlKeyword = "<blockquote data-ke-size=\"size16\" data-ke-style=\"style1\">";

    public static String testIndexHtmlKeyword = "<blockquote data-ke-style=\"style2\">Index</blockquote>";

    public static String testResultCode = "<p data-ke-size=\"size16\"><span style=\"color: #555555; font-family: 'Noto Serif KR';\">* <span style=\"color: #555555;\">테스트 서론1</span></span></p> <span>테스트 서론2</span><blockquote data-ke-style=\"style2\">Index<br /><a href=\"#1\">1 테스트 목차1</a><br /><a href=\"#2\">2 테스트 목차2</a></blockquote> <p data-ke-size=\"size16\">&nbsp;</p><blockquote id=\"1\" data-ke-size=\"size16\" data-ke-style=\"style1\"><span style=\"font-family: 'Noto Serif KR';\">테스트 목차1</span></blockquote><span>테스트 내용1</span><blockquote id=\"2\" data-ke-size=\"size16\" data-ke-style=\"style1\"><span style=\"font-family: 'Noto Serif KR';\">테스트 목차2</span></blockquote><span>테스트 내용2</span>";


    public static String testFailTAllCode = "<p data-ke-size=\"size16\"><span style=\"color: " +
            "#555555; font-family: 'Noto Serif KR';\">* <span style=\"color: #555555;\">" +
            "테스트 서론1</span></span></p> " +
            "<span>테스트 서론2</span>" +
            "<blockquote data-ke-style=\"style2\">Index</blockquote> <p data-ke-size=\"size16\">&nbsp;</p>" +
            "<생략><span style=\"font-family: 'Noto Serif KR';\">테스트 목차1</span></blockquote>" +
            "<span>테스트 내용1</span>" +
            "<생략><span style=\"font-family: 'Noto Serif KR';\">테스트 목차2</span></blockquote>" +
            "<span>테스트 내용2</span>";

    public static String testFailIAllCode = "<p data-ke-size=\"size16\"><span style=\"color: " +
            "#555555; font-family: 'Noto Serif KR';\">* <span style=\"color: #555555;\">" +
            "테스트 서론1</span></span></p> " +
            "<span>테스트 서론2</span>" +
            "<생략> <p data-ke-size=\"size16\">&nbsp;</p>" +
            "<blockquote data-ke-size=\"size16\" data-ke-style=\"style1\"><span style=\"font-family: 'Noto Serif KR';\">테스트 목차1</span></blockquote>" +
            "<span>테스트 내용1</span>" +
            "<blockquote data-ke-size=\"size16\" data-ke-style=\"style1\"><span style=\"font-family: 'Noto Serif KR';\">테스트 목차2</span></blockquote>" +
            "<span>테스트 내용2</span>";

    public static String testValidAllCode = "<p data-ke-size=\"size16\"><span style=\"color: " +
            "#555555; font-family: 'Noto Serif KR';\">* <span style=\"color: #555555;\">" +
            "Valid 테스트 서론1</span></span></p> " +
            "<span>테스트 서론2</span>" +
            "<Valid blockquote data-ke-style=\"style2\">Index</blockquote> <p data-ke-size=\"size16\">&nbsp;</p>" +
            "<Valid blockquote data-ke-size=\"size16\" data-ke-style=\"style1\"><span style=\"font-family: 'Noto Serif KR';\">테스트 목차1</span></blockquote>" +
            "<span>테스트 내용1</span>";

    public static String testValidTitleHtmlKeyword = "<Valid blockquote data-ke-size=\"size16\" data-ke-style=\"style1\">";

    public static String testValidIndexHtmlKeyword = "<Valid blockquote data-ke-style=\"style2\">Index</blockquote>";

    public static String testValidResultCode = "<p data-ke-size=\"size16\"><span style=\"color: #555555; font-family: 'Noto Serif KR';\">* <span style=\"color: #555555;\">테스트 서론1</span></span></p> <span>테스트 서론2</span><blockquote data-ke-style=\"style2\">Index<br /><a href=\"#1\">1 테스트 목차1</a><br /><a href=\"#2\">2 테스트 목차2</a></blockquote> <p data-ke-size=\"size16\">&nbsp;</p><blockquote id=\"1\" data-ke-size=\"size16\" data-ke-style=\"style1\"><span style=\"font-family: 'Noto Serif KR';\">테스트 목차1</span></blockquote><span>테스트 내용1</span><blockquote id=\"2\" data-ke-size=\"size16\" data-ke-style=\"style1\"><span style=\"font-family: 'Noto Serif KR';\">테스트 목차2</span></blockquote><span>테스트 내용2</span>";

}



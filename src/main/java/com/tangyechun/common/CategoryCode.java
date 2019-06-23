package com.tangyechun.common;

/**
 * @author Administrator
 * @since 2019/6/18 18:14
 */
public enum CategoryCode {
    JIAOYU("教育"), WENXUE("文学"), LIUXING("流行"), ZHEXUE("哲学"),
    YIYAO("医药"), JUNSHI("军事"), JINGJI("经济"), YUYAN("语言"),
    YISHU("艺术"), ZIRAN("自然科学"), GONGYEJISHU("工业技术"), ZHENGFA("政治、法律"),
    LIDI("历史、地理");

    private final String name;

    CategoryCode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

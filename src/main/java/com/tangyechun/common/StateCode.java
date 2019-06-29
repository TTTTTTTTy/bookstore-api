package com.tangyechun.common;

/**
 * @author Administrator
 * @since 2019/6/16 19:21
 */
public enum StateCode {

    SUCCESS(100000, "execute opetation successsfully", "执行操作成功"),

    //通用错误 1xxxxx
    UNKNOWN(100001, "System error, please contact Administrator.", "系统错误，请联系系统管理员"),
    INVALID_PARAMETER(100002, "Invalid parameter.", "参数错误"),
    INVALID_CONFIG(100003, "Invalid Config.", "配置错误"),
    PARAMETER_VALUE_NOT_PROVIDE(100004, "Parameter cannot be null.", "参数不能为空"),

    USERNAME_EXISTS(200001, "username exists", "用户名已存在"),
    EMAIL_EXISTS(200002, "email used", "邮箱已被占用"),

    ISBN_NOT_FOUND(300001, "isbn not found", "未查询到该ISBN"),

    BOOK_SOLD_OUT(400001, "This book has been sold out.", "该书籍已被购买");

    private final int value;
    private final String reasonEnPhrase;
    private final String reasonChPhrase;

    StateCode(int value, String reasonEnPhrase, String reasonChPhrase) {
        this.value = value;
        this.reasonEnPhrase = reasonEnPhrase;
        this.reasonChPhrase = reasonChPhrase;
    }

    public int value() {
        return this.value;
    }



    public String getReasonEnPhrase() {
        return this.reasonEnPhrase;
    }

    public String getReasonChPhrase() {
        return reasonChPhrase;
    }

    public String toString() {
        return Integer.toString(this.value);
    }

    public static StateCode valueOf(int statusCode) {
        StateCode[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            StateCode status = var1[var3];
            if (status.value == statusCode) {
                return status;
            }
        }

        throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
    }
}

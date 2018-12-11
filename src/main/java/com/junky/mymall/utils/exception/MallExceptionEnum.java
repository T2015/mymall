package com.junky.mymall.utils.exception;

/**
 * Class MallExceptionEnum
 * Effect
 * Created by junky
 * on 2018/7/13
 */
public enum MallExceptionEnum {

    /******用户******/

    USER_ERROR_EXITACCOUNT(0, "用户已存在"),
    USER_ERROR_NOEXITACCOUNT(0, "用户不存在"),
    USER_ERROR_PASSWORD(0, "密码错误"),
    USER_ERROR_USERIDEMPTY(0, "用户id不能为空"),
    USER_ERROR_ACCOUNTEMPTY(0, "账号不能为空"),
    USER_ERROR_PASSWORDEMPTY(0, "密码不能为空"),
    USER_ERROR_PHONEEMPTY(0, "手机号不能为空"),
    USER_ERROR_USERNAMEEMPTY(0, "用户名不能为空"),


    /******商品******/
    PRODUCT_ERROR_EXIT(0, "商品已存在"),
    PRODUCT_ERROR_NOEXIT(0, "商品不存在"),
    PRODUCT_ERROR_PAGENO(0, "参数pageNo错误"),
    PRODUCT_ERROR_PAGESIZE(0, "参数pageSize错误"),
    PRODUCT_ERROR_IDEMPTY(0, "商品id为空"),
    PRODUCT_ERROR_NAMEEMPTY(0, "商品名称为空"),
    PRODUCT_ERROR_PRICEEMPTY(0, "商品价格为空"),
    PRODUCT_ERROR_ICONEMPTY(0, "商品icon为空"),
    PRODUCT_ERROR_DESCEMPTY(0, "商品DESC为空"),
    PRODUCT_ERROR_DISCOUNTEMPTY(0, "商品discount为空"),


    /******商品类目******/
    CATEGORY_ERROR_ID(0, "商品类目id值不对"),
    CATEGORY_ERROR_NAMEEMPTY(0, "商品类目名称为空"),
    CATEGORY_ERROR_SELLERID(0, "商品类目卖家id为空"),


    /******卖家******/
    SELLER_ERROR_EXITACCOUNT(0, "用户已存在"),
    SELLER_ERROR_NOEXITACCOUNT(0, "用户不存在"),
    SELLER_ERROR_PASSWORD(0, "密码错误"),
    SELLER_ERROR_IDEMPTY(0, "卖家id不能为空"),
    SELLER_ERROR_PHONEEMPTY(0, "卖家电话不能为空"),
    SELLER_ERROR_NAMEEMPTY(0, "卖家名字不能为空"),
    SELLER_ERROR_PASSWORDEMPTY(0, "卖家密码不能为空"),
    SELLER_ERROR_ICONEMPTY(0, "卖家icon不能为空"),
    SELLER_ERROR_DESCEMPTY(0, "卖家描述不能为空"),
    SELLER_ERROR_ADDRESSEMPTY(0, "卖家地址不能为空"),


    /******订单******/
    ORDER_ERROR_EXIT(0, "订单已存在"),
    ORDER_ERROR_NOEXIT(0, "订单不存在"),
    ORDER_ERROR_IDEMPTY(0, "订单ID为空"),
    ORDER_ERROR_STATUSEMPTY(0, "订单状态为空"),
    ORDER_ERROR_BUYERIDEMPTY(0, "订单买家ID为空"),
    ORDER_ERROR_SELLERIDEMPTY(0, "订单卖家ID为空"),
    ORDER_ERROR_SUMEMPTY(0, "订单总额不对"),
    ORDER_ERROR_ADDRESSEMPTY(0, "订单地址为空"),


    /******订单item******/
    ORDERITEM_ERROR_EXIT(0, "订单item已存在"),
    ORDERITEM_ERROR_NOEXIT(0, "订单item不存在"),
    ORDERITEM_ERROR_ID(0, "订单item ID为空"),
    ORDERITEM_ERROR_PRODUCTID(0, "订单item 商品ID为空"),
    ORDERITEM_ERROR_PRODUCTQUILITY(0, "订单item 商品数量错误"),
    ORDERITEM_ERROR_SUM(0, "订单item 商品小结错误"),
    ORDERITEM_ERROR_ORDERID(0, "订单item 订单ID错误"),


    /******地址******/
    ADDRESS_ERROR_NOEXIT(0, "地址不存在"),
    ADDRESS_ERROR_IDEMPTY(0, "地址ID为空"),
    ADDRESS_ERROR_NAMEEMPTY(0, "地址收件人为空"),
    ADDRESS_ERROR_PHONEEMPTY(0, "地址收件人电话为空"),
    ADDRESS_ERROR_DETAILEMPTY(0, "地址详细为空"),
    ADDRESS_ERROR_USERIDEMPTY(0, "地址用户ID为空"),


    /***********其他***********/
    PARAM_ERROR_PARAM(0, "参数错误"),
    PARAM_ERROR_PAGENO(0, "参数pageNo错误"),
    PARAM_ERROR_PAGESIZE(0, "参数pageSize错误"),


    /******数据库操作******/
    SQL_ERROR_INSERT(0, "数据库插入失败"),
    SQL_ERROR_UPDATE(0, "数据库更新失败"),
    SQL_ERROR_DELETE(0, "数据库删除失败"),;


    private Integer code;

    private String message;


    MallExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

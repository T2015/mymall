package com.junky.mymall.vo.request;

/**
 * Class ProductListParam
 * Effect
 * Created by junky
 * on 2018/7/13
 */
public class ProductListParam {


    Integer pageNo;

    Integer pageSize;

    String sellerId;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNum) {
        this.pageNo = pageNum;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

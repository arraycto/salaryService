///:PageInfo.java
package com.weyoung.wxapp.common.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author icechen1219
 * @date 2019/08/13
 */
public class PageInfo<T> {
    /**
     * 每页显示条数
     */
    public static final int SHOW_LINES = 10;

    /**
     * list : []
     * current_page : 1
     * has_more : true
     */

    @JSONField(name = "current_page")
    private int currentPage;
    @JSONField(name = "has_more")
    private boolean hasMore;
    private List<T> list;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
///:PageInfo.java

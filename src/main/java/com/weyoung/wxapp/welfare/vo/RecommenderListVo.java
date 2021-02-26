package com.weyoung.wxapp.welfare.vo;

import com.weyoung.wxapp.welfare.domain.User;

import java.io.Serializable;
import java.util.List;

/**
 * @author li
 * @date 2020-2-18
 */
public class RecommenderListVo implements Serializable {
    /**
     * 已完成
     */
    private List<RecommenderVo> finsh;
    /**
     * 未完成
     */
    private List<RecommenderVo> unfinsh;

    public List<RecommenderVo> getFinsh() {
        return finsh;
    }

    public void setFinsh(List<RecommenderVo> finsh) {
        this.finsh = finsh;
    }

    public List<RecommenderVo> getUnfinsh() {
        return unfinsh;
    }

    public void setUnfinsh(List<RecommenderVo> unfinsh) {
        this.unfinsh = unfinsh;
    }
}

package com.lianhe.jiudaili.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 酒代理联合项目后端开发小组——龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞
 * @since 2019-05-04
 */
@TableName("news_recommend")
public class NewsRecommend extends Model<NewsRecommend> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("news_adstract")
    private String newsAdstract;
    @TableField("news_url")
    private String newsUrl;
    /**
     * 1 表示新闻推荐 2 表示产品推荐
     */
    @TableField("news_type")
    private Integer newsType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewsAdstract() {
        return newsAdstract;
    }

    public void setNewsAdstract(String newsAdstract) {
        this.newsAdstract = newsAdstract;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

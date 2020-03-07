package edu.ynmd.tools;

/**
 * @Author:lb
 * @date:2020/3/5 10:59
 * @description:分页
 */

import java.util.ArrayList;
import java.util.List;

public class PageData<T> {
    private int pageNo;
    private int pageSize;
    private int pages;
    private long total;
    private int num;
    private List<T> result;

    public PageData(int pageNo, int pageSize, long total, List<T> result) {
        if (result == null) {
            result = new ArrayList();
        }

        this.pageNo = pageNo;
        this.pageSize = pageSize;
        int appendNum = total % (long)pageSize > 0L ? 1 : 0;
        this.pages = (int)(total / (long)pageSize) + appendNum;
        this.total = total;
        this.result = (List)result;
        this.num = ((List)result).size();
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getPages() {
        return this.pages;
    }

    public long getTotal() {
        return this.total;
    }

    public List<T> getResult() {
        return this.result;
    }

    public int getNum() {
        return this.num;
    }
}

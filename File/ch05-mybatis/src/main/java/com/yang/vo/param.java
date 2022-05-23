package com.yang.vo;

public class param {
    private String pname;
    private Integer page;

    @Override
    public String toString() {
        return "param{" +
                "pname='" + pname + '\'' +
                ", page=" + page +
                '}';
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}

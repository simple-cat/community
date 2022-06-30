package com.nowcoder.community.entity;
/*
封装分页相关的信息
*/
public class Page {

    // 1 当前页码
    private int current=1;
    //2 显示上限，一页最多显示10条，可根据需要修改
    private int limit=10;
    //3 数据总数，服务端向数据库查出来(用于计算页总数)
    private int rows;
    //4 查询路径（用于复用分页链接）
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current>=1) {    //此处为了避免用户传递的数为复数等，先进行判断再记录，以防出错
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit>=1 && limit<=100) {   //同setCurrent（）
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows>=0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //除set和get方法外，还需要补充：
    //通过当前页，算出起始行
    public int getOffset(){
        return (current-1)*limit;
    }
    //获取总页数，因为显示的页码不能超出实际有的页数
    public int getTotal(){
        if(rows%limit==0){
            return rows/limit;
        }else {
            return rows/limit+1;
        }
    }

    //显示从第几页到第几页，根据当前页计算前后几页显示
    //获取起始页码
    public int getFrom(){
        int from=current-2;   //当前页左两页
        return from<1?1:from;  //如果当前页是第一页，则没有前页
    }

    public int getTo(){
        int to=current+2;
        int total=getTotal();
        return to>total?total:to;  //同getFrom()
    }
}

package test;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtiecai
 * Date: 2016/1/26
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */
public class TestBean {
    private int id;
    private String name;
    private String cid;

    public TestBean() {
    }

    public TestBean(int id, String name, String cid) {
        this.id = id;
        this.name = name;
        this.cid = cid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TestBean)) return false;
        TestBean topic = (TestBean) obj;
        if (this.getName().equalsIgnoreCase(topic.getName()) ) return true;
        else return false;
    }
}

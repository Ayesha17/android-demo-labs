package com.example.socket.im.vo;


import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 名称     类型             默认             填写                 读取             描述
 * 1     id                 string         客户端             客户端/服务端    32字符例:6F9619FF8B86D011B42D00C04FC964FF, 使用系统的GUID算法来生成
 * 2     mtype             int             客户端             客户端/服务端    系统]
 * 3     to                 string         客户端             客户端/服务端     例如:@huanhuan 指定消息队列, *1010901 指定用户群, 50544 单个指定用户, 50544, 50552, 50553指定多个用户
 * 4     body             string         客户端             客户端             内容 最大字节数4*1024
 * 5     echo             boolean         客户端             服务端             服务器在收到消息之后是否发送确认回执给客户端
 * 6     store             boolean         客户端             服务端             服务器是否永久保存消息
 * 7     etime             long         客户端             服务端             消息过期时间, 用户端负责指定离开当前多少秒过期, 由服务器计算绝对时间, 0表示永远不过期
 * 8     stime             long         发送服务端         客户端             发送时间(相对于1970年1月1日，到现在过了多少秒)
 * 9     rtime             long         接收服务端         客户端             接收时间(相对于1970年1月1日，到现在过了多少秒)
 * 10     ctime             long         数据库服务端         客户端             消息在服务器数据库创建的时间(相对于1970年1月1日，到现在过了多少秒)
 * 11     sender             string         发送服务端         服务端             发送者
 * 12     receiver         string         发送或转发服务    服务端             接收者
 * 13     sender_host    string         发送服务端         服务端             发送者宿主主机地址 "10.9.2.23"
 * 14     receiver_host    string         接收服务端         服务端             接收者所在主机'10.9.1.20'
 * 15     flag             long         服务端             服务端             消息系统标志
 * 16   priority       int             客户端            服务端            优先级 当前只有两个优先级别 0 和 > 0
 *
 * @author changgb
 */
public class Message implements Serializable {

    private static final long serialVersionUID = -6771949780393967417L;
    private String id = "";
    private int mtype = 0;
    private String to = "";
    private String body = "";
    private boolean echo = true;
    private boolean store = true;
    private long etime = Constant.MESSAGE_DEFAULT_EXPTIME;
    private long stime = 0;
    private long rtime = 0;
    private long ctime = 0;
    private String sender = "";
    private String receiver = "";
    private int flag = 0;
    private int type = Constant.MESSAGE_TYPE_USER;

    public static final Message newMessage(String body) {
        return newMessage(Constant.MESSAGE_MTYPE_USER_MSG, body);
    }

    public static final Message newMessage(int mtype, String body) {
        Message m = new Message();
        m.setBody(body);
        m.setMtype(mtype);
        return m;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMtype() {
        return mtype;
    }

    public void setMtype(int mtype) {
        this.mtype = mtype;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isEcho() {
        return echo;
    }

    public void setEcho(boolean echo) {
        this.echo = echo;
    }

    public boolean isStore() {
        return store;
    }

    public void setStore(boolean store) {
        this.store = store;
    }

    public long getEtime() {
        return etime;
    }

    public void setEtime(long etime) {
        this.etime = etime;
    }

    public long getStime() {
        return stime;
    }

    public void setStime(long stime) {
        this.stime = stime;
    }

    public long getRtime() {
        return rtime;
    }

    public void setRtime(long rtime) {
        this.rtime = rtime;
    }

    public long getCtime() {
        return ctime;
    }

    public void setCtime(long ctime) {
        this.ctime = ctime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        Field[] fields = ((Object) this).getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder(200);
        for (Field field : fields) {
            field.setAccessible(true);
            if (Modifier.isFinal(field.getModifiers()))
                continue;
            try {
                sb.append(field.getName() + ":" + field.get(this) == null ? "" : field.get(this).toString() + ",");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String str = sb.toString();
        return str.substring(0, str.length() - 1);
    }
}

package com.example.socket.im.client;


import com.example.socket.im.vo.Constant;
import com.example.socket.im.vo.Id;
import com.example.socket.im.vo.Message;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by kurten on 14-10-27.
 */
public class PacketUtil {
    public static Packet unpack(byte[] bytes) {
        Packet packet = new Packet();
        int len = bytes.length;
        int idx = 0;
        if (len > 0) {
            try {
                packet.setVer(bytes[idx++]);
                packet.setCmd(readTwoInt(bytes, idx));
                idx += 2;
                packet.setUsertag(readTwoInt(bytes, idx));
                idx += 2;
                packet.setSystag(readTwoInt(bytes, idx));
                idx += 2;
                if (len > 7) {
                    switch (packet.getCmd()) {
                        case Constant.CMD_LOGIN:
                        case Constant.CMD_FORCE_LOGOUT:
                            packet.setObj(unpackObj(bytes, idx, new Ticket()));
                            break;
                        case Constant.CMD_RECEIVE_OK:
                            packet.setObj(unpackObj(bytes, idx, new Id()));
                            break;
                        default:
                            packet.setObj(unpackObj(bytes, idx, new Message()));
                            break;
                    }
                }
                return packet;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] pack(Packet packet) {
        byte[] ret = null;
        int len = getObjectLength(packet.getObj());
        int idx = 0;
        try {
            ret = new byte[len + 7];
            convertOneBytes(ret, idx, packet.getVer());
            idx++;
            convertTwoBytes(ret, idx, packet.getCmd());
            idx += 2;
            convertTwoBytes(ret, idx, packet.getUsertag());
            idx += 2;
            convertTwoBytes(ret, idx, packet.getSystag());
            idx += 2;
            packObj(ret, idx, packet.getObj());
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Packet receiveOk(String id) {
        return receiveOk(id, Constant.MESSAGE_TYPE_USER);
    }

    public static Packet receiveOk(String id, int type) {
        Packet packet = new Packet();
        packet.setCmd(Constant.CMD_RECEIVE_OK);
        Id ii = new Id(id);
        ii.setType(type);
        packet.setObj(ii);

        return packet;
    }

    public static byte[] convertFourBytes(byte[] b, int idx, int i) {
        b[idx++] = (byte) ((i & 0xff000000) >> 24);
        b[idx++] = (byte) ((i & 0xff0000) >> 16);
        b[idx++] = (byte) ((i & 0xff00) >> 8);
        b[idx++] = (byte) (i & 0xff);
        return b;
    }

    public static byte[] convertTwoBytes(byte[] b, int idx, int i) {
        b[idx++] = (byte) ((i & 0xff00) >> 8);
        b[idx++] = (byte) (i & 0xff);
        return b;
    }

    public static byte[] convertOneBytes(byte[] b, int idx, int i) {
        b[idx++] = (byte) (i & 0xff);
        return b;
    }

    public static byte[] stringToBytes(String s) {
        if (s != null)
        {
            try
            {
                return s.getBytes("UTF-8");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static int readFourInt(byte[] b, int idx)
    {
        int ch1 = b[idx++];
        int ch2 = b[idx++];
        int ch3 = b[idx++];
        int ch4 = b[idx++];
        return (((0x000000FF&ch1) << 24) + ((0x000000FF&ch2) << 16) + ((0x000000FF&ch3) << 8) + (0x000000FF&ch4));
    }

    public static int readTwoInt(byte[] b, int idx)
    {
        int ch1 = b[idx++];
        int ch2 = b[idx++];
        return 0x0000FFFF & (((0x000000FF&ch1) << 8) + ((0x000000FF&ch2) << 0));
    }

    public static byte[] readBytes(byte[] b, int idx, int len)
    {
        byte[] ret = new byte[len];
        System.arraycopy(b, idx, ret, 0, len);
        return ret;
    }


    public static String readString(byte[] b, int idx, int len)
    {
        return readString(readBytes(b, idx, len));
    }

    public static String readString(byte[] bytes)
    {
        if (bytes != null && bytes.length > 0)
        {
            try {
                return new String(bytes, "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static byte[] packObj(byte[] b, int idx, Object obj) {
        if (null == obj) {
            return b;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (Modifier.isFinal(field.getModifiers()))
                continue;
            String name = field.getName();
            try {
                Object val = field.get(obj);
                if (null != val) {
                    String str = val.toString();
                    if (str.length() > 0) {
                        convertTwoBytes(b, idx, name.length());
                        idx += 2;
                        System.arraycopy(name.getBytes("UTF-8"), 0, b, idx, name.length());
                        idx += name.length();
                        byte[] bts = str.getBytes("UTF-8");
                        convertFourBytes(b, idx, bts.length);
                        idx += 4;
                        System.arraycopy(bts, 0, b, idx, bts.length);
                        idx += bts.length;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return b;
    }

    public static Object unpackObj(byte[] b, int idx, Object obj) {
        int len = 0;
        while (idx < b.length) {
            len = readTwoInt(b, idx);
            idx += 2;
            String key = readString(b, idx, len);
            idx += len;
            len = readFourInt(b, idx);
            idx += 4;
            if (len != 0) {
                String val = readString(b, idx, len);
                idx += len;
                if (null != val) {
                    try {
                        Field field = obj.getClass().getDeclaredField(key);
                        field.setAccessible(true);
                        Class type = field.getType();
                        if ("int".equalsIgnoreCase(type.getName()) || type.equals(Integer.class)) {
                            field.setInt(obj, Integer.valueOf(val));
                        } else if ("double".equalsIgnoreCase(type.getName()) || type.equals(Double.class)) {
                            field.setDouble(obj, Double.valueOf(val));
                        } else if ("string".equalsIgnoreCase(type.getName()) || type.equals(String.class)) {
                            field.set(obj, val);
                        } else if ("long".equalsIgnoreCase(type.getName()) || type.equals(Long.class)) {
                            field.setLong(obj, Long.valueOf(val));
                        } else if ("boolean".equalsIgnoreCase(type.getName()) || type.equals(Boolean.class)) {
                            field.setBoolean(obj, Boolean.valueOf(val));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return obj;
    }

    /**
     * 计算object对象的byte长度
     * @param obj
     * @return length
     */
    public static int getObjectLength(Object obj) {
        if (null == obj) {
            return 0;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        int sum = 0;
        for (Field field : fields) {
            field.setAccessible(true);
            if (Modifier.isFinal(field.getModifiers()))
                continue;
            String name = field.getName();
            try {
                Object val = field.get(obj);
                if (null != val) {
                    int len = 0;
                    String str = val.toString();
                    Class type = field.getType();
                    if ("string".equalsIgnoreCase(type.getName()) || type.equals(String.class)) {
                        if (str.length() > 0) {
                            len = str.getBytes("UTF-8").length;
                        }
                    } else {
                        len = val.toString().length();
                    }
                    if (len > 0) {
                        sum += name.length() + 2;
                        sum += len + 4;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sum;
    }
}

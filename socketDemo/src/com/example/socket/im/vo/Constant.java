package com.example.socket.im.vo;

/**
 * 
 * rc公共类
 * 
 * @author buqi
 * @version 1.0 2011-6-20
 */
public class Constant {

	public static final int DSN_PROTOCOL_TCP = 1;
	public static final int DSN_PROTOCOL_HTTP = 2;
	public static final int TICK_TYPE_SEND = 1;
	public static final int TICK_TYPE_LISTEN = 2;

	public static final int CMD_PING = 0;
	public static final int CMD_LOGIN = 1;
	public static final int CMD_LOGOUT = 2;
	public static final int CMD_SEND_MESSAGE = 3;
	public static final int CMD_RECEIVE_MESSAGE = 4;
	public static final int CMD_RECEIVE_OK = 5;
	public static final int CMD_FORCE_LOGOUT = 6;

	public static final int PROTOCOL_VERION = 3;

	public static final int RESPONSE_OK = 200;
	public static final int RESPONSE_BAD_REQUEST = 400;
	public static final int RESPONSE_ACCESS_DENIED = 401;
	public static final int RESPONSE_INTERNAL_SERVER_ERROR = 500;
	public static final int RESPONSE_SERVER_BUSY = 503;

	// 确省过期时间 单位:秒 2592000 = 30 天
	public static final int MESSAGE_DEFAULT_EXPTIME = 2592000;
	// 内容最大长度,单位:字节
	public static final int MESSAGE_BODY_MAX_LENGTH = 8092;
	public static final int MESSAGE_TYPE_USER = 1;
	public static final int MESSAGE_TYPE_SYSTEM = 2;
	public static final int MESSAGE_TYPE_LOGIN = 3;
	public static final int MESSAGE_TYPE_LOGOUT = 4;
	public static final int MESSAGE_TYPE_RECEIVE_OK = 5;
	public static final int MESSAGE_TYPE_GET_OFFLINE = 6;
	public static final int MESSAGE_TYPE_KILL = 7;
	public static final int MESSAGE_TYPE_STOP_GET_OFFLINE = 8;
	public static final int MESSAGE_TYPE_GROUP = 9;
	public static final int MESSAGE_TYPE_LOAD_MSG = 10;
    public static final int MESSAGE_TYPE_RECEIVE_FAIL = 11;

	public static final int MESSAGE_MTYPE_GROUP_MSG = 0;
	public static final int MESSAGE_MTYPE_GROUP_MSG_TIME = 20;
	public static final int MESSAGE_MTYPE_GROUP_MSG_NOTICE = -1;
	public static final int MESSAGE_MTYPE_GROUP_CREATE = 1;
	public static final int MESSAGE_MTYPE_GROUP_USERINVATE = 2;
	public static final int MESSAGE_MTYPE_GROUP_USEREXIT = 3;

	public static final int MESSAGE_MTYPE_USER_MSG = 0;
	public static final int MESSAGE_MTYPE_USER_MSG_TIME = 20;
	public static final int MESSAGE_MTYPE_USER_MSG_NOTICE = -1;
	public static final int MESSAGE_MTYPE_USER_LOC_NOW = 4;
	public static final int MESSAGE_MTYPE_USER_GROUPEXIT = 3;
    public static final int MESSAGE_MTYPE_USER_ONLINE = 6;
    public static final int MESSAGE_MTYPE_USER_OFFLINE = 7;
    public static final int MESSAGE_MTYPE_USER_FRIENDS_ONLINE = 8;

	public static final int MESSAGE_MTYPE_MSG_IMG = 12;
	public static final int MESSAGE_MTYPE_MSG_LOC = 13;
	public static final int MESSAGE_MTYPE_MSG_CONTACT = 14;
	public static final int MESSAGE_MTYPE_MSG_RECORD = 15;
	public static final int MESSAGE_MTYPE_MSG_IMGTXT = 16;
	public static final int MESSAGE_MTYPE_MSG_CERFITICATE = 17;
	public static final int MESSAGE_MTYPE_MSG_VEDIO = 18;

    public static final int MESSAGE_MTYPE_MSG_VERIFIED_REPLY = 21;

	public static final int MESSAGE_MTYPE_MSG_CARBIND = 30;
	public static final int MESSAGE_MTYPE_MSG_FLEETINVITE = 31;
	public static final int MESSAGE_MTYPE_MSG_LOGOUT = 32;

    public static final int MESSAGE_MTYPE_MSG_LOC_SETTING = 39;
    public static final int MESSAGE_MTYPE_MSG_LOC_REAL_TIME_START = 5;
	public static final int MESSAGE_MTYPE_MSG_LOC_REAL_TIME_STOP = 34;

    // 货源相关消息类型
    public static final int MESSAGE_MTYPE_MSG_NEW_LOAD = 33;
	public static final int MESSAGE_MTYPE_MSG_NEW_LOAD_APPLY = 35;
	public static final int MESSAGE_MTYPE_MSG_NEW_LOAD_UNAPPLY = 36;
	public static final int MESSAGE_MTYPE_MSG_LOAD_FINISH = 38;
    public static final int MESSAGE_MTYPE_MSG_LOAD_SEEN = 41;
    public static final int MESSAGE_MTYPE_MSG_LOAD_CANCELED = 60;
    public static final int MESSAGE_MTYPE_MSG_LOAD_DISPATCHED = 61;
	public static final int MESSAGE_MTYPE_MSG_FORWARD_LOAD = 62;

	public static final int MESSAGE_MTYPE_USER_NEW_FRIEND = 10;
	public static final int MESSAGE_MTYPE_USER_ACCEPT_FRIEND = 11;

    // 司机被动移除车队
    public static final int MESSAGE_MTYPE_USER_REMOVE_VEHICLE_FROM_FLEET = 50;

    // 司机主动退出车队
    public static final int MESSAGE_MTYPE_USER_EXIT_FROM_FLEET = 51;

    // 车队共享通知
    public static final int MESSAGE_MTYPE_USER_SHARE_FLEET_ADD = 54;

    // 取消车队共享通知
    public static final int MESSAGE_MTYPE_USER_SHARE_FLEET_REMOVE = 55;

    public static final int MESSAGE_MTYPE_USER_LOC_NOW_RECEIVE = 101;
    public static final int MESSAGE_MTYPE_USER_LOC_DEFAULT_RECEIVE = 102;

    public static final int MESSAGE_MTYPE_USER_LOAD_APPLY = 1002;
    public static final int MESSAGE_MTYPE_USER_LOAD_ORDERED = 1001;
    public static final int MESSAGE_MTYPE_USER_LOAD_PUSH_RECEIVE = 1003;
    public static final int MESSAGE_MTYPE_USER_LOAD_PUSH_SEND = 1004;

    public static final int MESSAGE_MTYPE_DEPOSIT_COLLECT_REQUEST = 1100;
    public static final int MESSAGE_MTYPE_DEPOSIT_COLLECT_SUCCESS = 1101;
    public static final int MESSAGE_MTYPE_DEPOSIT_APPLY_REFUND_REQUEST = 1103;
    public static final int MESSAGE_MTYPE_DEPOSIT_REFUND_SUCCESS = 1104;
    public static final int MESSAGE_MTYPE_DEPOSIT_APPLY_DETAIN_REQUEST = 1105;
    public static final int MESSAGE_MTYPE_DEPOSIT_DETAIN_SUCCESS = 1106;

    public static final int MESSAGE_TYPE_RADAR_MANUAL = 1201;
    public static final int MESSAGE_TYPE_PUBLISH_MANUAL = 1202;
    public static final int MESSAGE_TYPE_NEW_LOAD_SOURCE = 1203;
    public static final int MESSAGE_TYPE_NEW_VEHICLE_SOURCE = 1204;


    public static final int MESSAGE_TYPE_ADD_VEHICLE_DIRECT = 56;



}

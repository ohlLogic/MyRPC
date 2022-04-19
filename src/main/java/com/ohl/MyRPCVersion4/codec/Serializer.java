package com.ohl.MyRPCVersion4.codec;

public interface Serializer {
    //把对象序列化成字节数组
    byte[] serialize(Object obj);

    //字节数组反序列化成消息，指定消息格式
    Object deserialize(byte[] bytes, int messageType);

    //返回使用的序列化器，
    //0：java自带序列化方式，1：json自带序列化方式
    int getType();

    //根据序号取出序列化器
    static Serializer getSerializerByCode(int code){
        switch (code)
        {
            case 0:
                return new ObjectSerializer();
            case 1:
                return new JsonSerializer();
            default:
                return null;
        }
    }
}

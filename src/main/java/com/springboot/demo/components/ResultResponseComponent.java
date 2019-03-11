package com.springboot.demo.components;

import com.springboot.demo.entity.RegResponse;
import org.springframework.stereotype.Component;

/**
 * 工厂模式
 * 接口信息生成工具
 */
@Component
public class ResultResponseComponent {

    private RegResponse regResponse = new RegResponse();

    /**
     * 响应成功  不附带额外数据
     * @return  响应实体类
     */
    public RegResponse getSuccessResult(String message){
        regResponse.setStatus(200);
        regResponse.setRegMsg(message);
        return regResponse;
    }

    /**
     * 请求成功并且带有数据
     * @param data
     * @return  响应实体类
     */
    public RegResponse getSuccessResult(Object data){
        regResponse.setStatus(200);
        regResponse.setRegMsg("SUCCESS");
        regResponse.setData(data);
        return  regResponse;
    }

    /**
     * 响应成功 并且自定义返回数据以及消息
     * @param data
     * @param message
     * @return  响应实体类
     */
    public RegResponse getSuccessResult( String message,Object data ){
        regResponse.setStatus(200);
        regResponse.setRegMsg(message);
        regResponse.setData(data);
        return  regResponse;
    }

    /**
     * 响应失败 自定义响应码以及响应信息
     * @return  响应实体类
     */
    public RegResponse getFailResult(Integer code ,String message){
        regResponse.setStatus(code);
        regResponse.setRegMsg(message);
        return regResponse;
    }

    /**
     * 响应失败 并且带有数据
     * @param data
     * @return  响应实体类
     */
    public RegResponse getFailResult(Object data,String message){
        regResponse.setStatus(201);
        regResponse.setRegMsg(message);
        regResponse.setData(data);
        return regResponse;
    }

    /**
     * 响应失败 并且带有错误码 数据以及消息
     * @param code
     * @param data
     * @param message
     * @return  响应实体类
     */
    public RegResponse getFailResult(Integer code , String message,Object data ){
        regResponse.setStatus(code);
        regResponse.setRegMsg(message);
        regResponse.setData(data);
        return regResponse;
    }

}

package com.lianhe.jiudaili.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.json.JSONObject;

import java.util.Objects;

public class AliyunSmsUtil {
    public static boolean sendSms(String phone, int code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAINNQ6bYlaxLkq", "MSpVZjqXqeT0MZWtVTEiXks0ZUNNd4");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "好雨知时节");
        request.putQueryParameter("TemplateCode", "SMS_164475214");
        request.putQueryParameter("TemplateParam", "{\"code\":" + code + "}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            String json = response.getData();
            System.out.println(json);
            JSONObject jsonObject = new JSONObject(json);

            if (Objects.equals(jsonObject.getString("Code"), "OK")) {
                return true;
            }

        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }
}

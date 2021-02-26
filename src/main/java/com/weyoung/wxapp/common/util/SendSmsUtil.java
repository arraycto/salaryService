package com.weyoung.wxapp.common.util;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发送短信
 * @author li
 * @date 2020-1-16
 */
public class SendSmsUtil {
    static Logger logger = LoggerFactory.getLogger(SendEmailUtil.class);
    public static void Send(String repair, String name, String tel, String address){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FxRXKMowFcg3mfZJpiM", "PB19iTfyyMf4VZUaa7MNd91HPzozCm");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "19922388838");
        request.putQueryParameter("SignName", "集力合创");
        request.putQueryParameter("TemplateCode", "SMS_195724221");
        request.putQueryParameter("TemplateParam", "{\"repair\":\"" +"的"+ repair + "\",\"name\":\"" + name + "\",\"phone\":\"" + tel + "\",\"address\":\"" + address + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println("repair:" + repair + "name:"+name+response.getData());
            logger.info(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
            logger.error("repair:" + repair + "name:"+name+String.valueOf(e));
        } catch (ClientException e) {
            e.printStackTrace();
            logger.error("repair:" + repair + "name:"+name+String.valueOf(e));
        }
    }
}

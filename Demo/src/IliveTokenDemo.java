import com.huawei.factory.tokenFactory.RtcUidTokenProduct;
import com.huawei.factory.tokenFactory.RtcUserAccountTokenProduct;
import com.huawei.rtc.RtcTokenBuilder;
import com.huawei.rtc.model.RtcUidTokenReq;
import com.huawei.rtc.model.RtcUserAccountTokenReq;

public class IliveTokenDemo {

    /**
     * 应用程序开发者签名的appId
     */
    private  static String appId = "4e1f09718cee40ba8846402b663ec59a";

    /**
     * 应用程序开发者签发的 App 证书
     */
    private static String appCertificate = "25f4b7d49cfd4f9891cd6038f2a3a6a3";

    /**
     * 标识通话的频道名称
     */
    private static String channelName = "hw-ilive-demo";

    /**
     * 用户名
     */
    private static String userAccount = "bossien01/aiqingwei";

    /**
     * 用户id
     */
    private static int uid = 0;

    /**
     * 过期时间单位为秒
     */
    private static int expirationTimeInSeconds = 3600;

    /**
     * 角色
     */
    RtcTokenBuilder.Role role = RtcTokenBuilder.Role.Role_Publisher;

    /**
     * 使用用户id（uid）方式生成token
     */
    public void productUidToken(){
        RtcUidTokenProduct rtcUidTokenProduct = new RtcUidTokenProduct();
        RtcUidTokenReq rtcUidTokenReq = new RtcUidTokenReq(appId,appCertificate,channelName,expirationTimeInSeconds,uid,role);
        String token = rtcUidTokenProduct.productToken(rtcUidTokenReq);
        System.out.println(token);
    }

    /**
     * 使用用户账号（userAccount ）方式生成token
     */
    public void productUserAccountToken(){
        RtcUserAccountTokenProduct rtcUserAccountTokenProduct = new RtcUserAccountTokenProduct();
        RtcUserAccountTokenReq rtcUserAccountTokenReq = new RtcUserAccountTokenReq();
        rtcUserAccountTokenReq.setUserAccount(userAccount);
        rtcUserAccountTokenReq.setAppCertificate(appCertificate);
        rtcUserAccountTokenReq.setAppId(appId);
        rtcUserAccountTokenReq.setChannelName(channelName);
        rtcUserAccountTokenReq.setExpirationTimeInSeconds(expirationTimeInSeconds);
        rtcUserAccountTokenReq.setRole(role);
        String token = rtcUserAccountTokenProduct.productToken(rtcUserAccountTokenReq);
        System.out.println(token);
    }

    public static void main(String[] args) {
        IliveTokenDemo iliveTokenDemo = new IliveTokenDemo();
        iliveTokenDemo.productUidToken();
        iliveTokenDemo.productUserAccountToken();
    }


}

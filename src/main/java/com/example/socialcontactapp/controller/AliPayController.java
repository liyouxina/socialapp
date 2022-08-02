package com.example.socialcontactapp.controller;

import cn.hutool.http.server.HttpServerRequest;
import cn.hutool.http.server.HttpServerResponse;
import com.example.socialcontactapp.utils.JWTUtil;
import com.example.socialcontactapp.utils.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.factory.Factory.Payment;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;

@CrossOrigin
@RestController
@RequestMapping("alipay")
public class AliPayController {

    @RequestMapping("callback")
    public void callback(HttpServerRequest request, HttpServerResponse response) {
        System.out.printf("支付回掉");
        System.out.printf(request.getBody());
        response.send(200);
    }
    @RequestMapping("pay")
    public R pay(String token, String goods) {
        Long userId = JWTUtil.getUserId(token);

        return R.ok();
    }

//    @PostMapping("pay")
//    public R pay() {
//        Factory.setOptions(getOptions());
//        try {
//            // 2. 发起API调用（以创建当面付收款二维码为例）
//            AlipayTradePrecreateResponse response = Payment.FaceToFace()
//                    .preCreate("Apple iPhone11 128G", "2234567890", "0.1");
//            // 3. 处理响应或异常
//            if (ResponseChecker.success(response)) {
//                System.out.println("调用成功");
//                return R.ok().data("msg", "调用支付成功");
//            } else {
//                System.err.println("调用失败，原因：" + response.msg + "，" + response.subMsg);
//                return R.error().data("msg", "调用支付失败");
//            }
//        } catch (Exception e) {
//            System.err.println("调用遭遇异常，原因：" + e.getMessage());
//            return R.error().data("msg", "调用支付异常");
//        }
//    }

    private static Config getOptions() {
        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = "openapi.alipay.com";
        config.signType = "RSA2";

        config.appId = "2021003129694510";

        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDFjhiucNbBE54xPZ4AerNtfUtpK62qdhs5WEWqlaDyPuddR3FaUfeFZLa0gJZZcJufL9flTneKox1STtecteC11gOAEdTZazCr5jkzHEnVQCaXTpmGqy7NW02WKaZHr/YkI2b0Fd6986oa9okIsSIeyWtq/0mMOIgoimYEAmrQ9KbVsbkq8IuMnl7rzRmAjXev7SxzVyuA6LZB+bjQW3o8NTfQihtX1HPcOPSlCUqses7+3PDcihe4L1PJkzfBqwJp5EqZEOcAG/8PTMM0jL35+hjJjfw5Ld70Z6kopYZuTosAKzPWR/RwBeKJpctAVkvt0X4g/+HxxNkBu/pnz/23AgMBAAECggEAaA6owXl+JMUIljc2elonGIzeo8718suzG0l7qJaX6AFqLJ/s/P4fuouKERmKGCJQVlEFDyt9m/C/CROuTkUez6iiv1qlGsBzKphhmKJV4ZWgviIQi/au+EwXWfkmNKxiojZjjD3YzYUDHKCvHXzv0/eUNQ+y1cERNwlvIr2DNfw5h5WZPRGZ8d8xWLG4a5KAJIo8USZAvC/fn4L3cC+R6XvtlyzY4m4N92nTImAejI0O2q3QWMsyGuuO/JVWscc/szdtnBLSwK3mW2CCAo2I3bqqad2U1hrU8GL/KVLhleTYs/s/7hMhEQJc9zZQLdB+9NUfKMBdVoArw7mglICLAQKBgQD5+sAR6eXYpDvldWfQ7+s9KesKQFzsWExtUPMlk6j9KEZegOV5HU67GEdFCUi0Gk/x/xhirdpFMsbyqRVvpvEWl1pSsmnZcJImqIFXMyFvI4OM8PIsfy/x1HfTEf9QXiOtdmt5WU7HHnrNC8HcYUnSWa/Vo9KV/Jqw8dyESwgWsQKBgQDKUB+B+fIk+Dd/Rwd6TUZchoZPUpSLb65K2DUYlTjKnJTLwuYwzIlHSjRpNt7l25ayOcGB2jylNWRFidNeF4mtNpKBZauhQuHGxYy7TeVwVXU9cLm46tI9A/5vLosTpa95RIsTWgGq02L+SGlduX04z/aOdbSE68AAhU1dNWTE5wKBgQCwqReR0VWA+9fkektK6jK5v+T+EqxYzrH8U0fyV18Gwa6xXLBPHnokWK0NSdlahnnXEKtAGZL2ckMM/JdMl5MrnvzTEokhhJ+UuGLnqBfJvjRap3DOJ3hPlBK2VLK1LkJSdSzQzl+Q8qZgQB3Zy9tqz70m4yaQnrsHr3Vi/M+TkQKBgEqg2a6Jc8Ada+NgYSrFPJI+8WZrUO5KiSGEtblWujdLITw0rdMMcAtDHSg+nGRv5xvhYDc1OK+8jTt1humrhxbFDa/7wB7hXAWFs88YAe25KGE8ptXGkTz+ryl2IslhkeQK276MshbAmUCxl2SCWuXNGOceFjP9/rpyccJTQtO7AoGAekFsrZhUZsjn/l8WsbocTns8wrOUaMY/3HObvoBkzqYkpZrdjFqhzj/M+8wXujTmoB5Q4oAnvnoFj4Hb0gzUGK19fyX102bTdCMDymYpLxEazxaZ7ruX62X22Knzyn9a2rXLeFORHO4d+0WLhscreBb5QhfDLL0c1h+Zt0JtneM=";

        //注：证书文件路径支持设置为文件系统中的路径或CLASS_PATH中的路径，优先从文件系统中加载，加载失败后会继续尝试从CLASS_PATH中加载
//        config.merchantCertPath = "<-- 请填写您的应用公钥证书文件路径，例如：/foo/appCertPublicKey_2019051064521003.crt -->";
//        config.alipayCertPath = "<-- 请填写您的支付宝公钥证书文件路径，例如：/foo/alipayCertPublicKey_RSA2.crt -->";
//        config.alipayRootCertPath = "<-- 请填写您的支付宝根证书文件路径，例如：/foo/alipayRootCert.crt -->";

        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
        config.alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqKWF884JKuOv8iQwKpdOKWUlAXoBwnhslYL3Z8mJD6XdRe9C24BTfwH2zJd7UsIW6FZ85yJ2jUgR6JUnm0URjYgGOH8W1th1yM+I77mno3HblZXM4H3etM2cBWxhxi93xS25CCI4SkHwJnQwLMs582suUfHQMeCW1q+dzh/2kLHRh90Fm158b1KUqPv+qjCyjMhVY7WT20yMYHZdJLcm8ia/STZPLctExZe077yVFEMuwG2qrkHbGspDu1zTzuXg9MUWqKcgXKliZZDUBrGv+capEd2GA4qP1H594H2KeFuqlIMGlQtm8DmOvVOoF7JyW6RubahevdpsghxVKfNWtQIDAQAB";

        //可设置异步通知接收服务地址（可选）
        config.notifyUrl = "http://180.76.98.70:18023/alipay/callback";

        //可设置AES密钥，调用AES加解密相关接口时需要（可选）
       // config.encryptKey = "<-- 请填写您的AES密钥，例如：aa4BtZ4tspm2wnXLb1ThQA== -->";

        return config;
    }
}

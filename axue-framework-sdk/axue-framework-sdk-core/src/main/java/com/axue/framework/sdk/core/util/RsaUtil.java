package com.axue.framework.sdk.core.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Java RSA 加密工具类
 */
public class RsaUtil {

    /**
     * 密钥长度 于原文长度对应 以及越长速度越慢
     */
    private final static int KEY_SIZE = 1024;
    /**
     * 用于封装随机产生的公钥与私钥
     */
    private static final Map<Integer, String> KEY_MAP = new HashMap<>();

    /**
     * 随机生成密钥对
     */
    public static void genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器
        keyPairGen.initialize(KEY_SIZE, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // 得到私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        // 得到公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        // 得到私钥字符串
        String privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        // 将公钥和私钥保存到Map
        //0表示公钥
        KEY_MAP.put(0, publicKeyString);
        //1表示私钥
        KEY_MAP.put(1, privateKeyString);
    }

    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public static String encrypt(String str, String publicKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = Base64.getDecoder().decode(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @return 明文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception {
        //64位解码加密后的字符串
        byte[] inputByte = Base64.getDecoder().decode(str);
        //base64编码的私钥
        byte[] decoded = Base64.getDecoder().decode(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        return new String(cipher.doFinal(inputByte));
    }

    public static void main(String[] args) {
        String data = "我是一段测试adasuhdajkshdajskhdasjkldhjkcbnsdkjhfuwfjksdbandsmfbhjdskhcvjxnzbmcjshfdlajshkdjsfghdsgfsdhnjbvmzUashdksjfahdkshafsdf字符串";
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK/f+mkApWspu8UNrFAvxF8jiuzwilvMFRpTvN4fZ96A4CPk6/Aawsc8meG28X3+h0djPWOaCOX4T4vtK3E6n6hV02EIslXYcw/Ne3aqla+3wOnVvwcWN0DLUQVUyzmaUbeeNfBfX//F74wrwhoCMVxEIBkENMos8idJe3sVHZNVAgMBAAECgYEAgMRdQ+m8M0S//JtxMNh4TyvnuGi49FLslHUA0CRwWSFEeiNOd2Iwf80n4XGfSB9GDodjV/xcTXvLSeigqOtCHreVY1DmUC0FdsGP9liX4uvOjPW2g5H/muJxoI3VbxZnbUjbLWBCJ1duJMI2oV3b3iF+zkxP8OxVbq1ywjZgnfUCQQDdJScFbrbtTQHpxH11lCzMo8SJj5eFrUPeTClTUkoUibq9VVraumk7jduRMIKQ0g7kzzGr2inm/wVMSH7rrNgTAkEAy5g++9AUrl8oiJG9S3y/OVzwsN59AFUURyItLGI3+yn9/0/wiOQOErcdzv2UJ1xeL+AlFW19exTRvhuaP8ej9wJBAM0pKopfrFV6m8vD/qCWVvmC9VKpZGkf1VbmUXB7Zz6miBgel6tURUx6zrhjyL2SIz8i+XH1c+pZrRCYMSdzswECQDzOAnmIYrTVPLDU/fjuj9nc9RGN0T1pK343KdCooNmFaBN5V3g6zC0wvVlViIrc3lBkHA8zPRemVyH08nN7928CQECEmMkER7iP91sznwN40lq+g9De6BN2tqp4uvD+Arrja8ZBpWW+3EVkl+GMqmQQvvh/vJETd3/XqhZIatuTSso=";
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCv3/ppAKVrKbvFDaxQL8RfI4rs8IpbzBUaU7zeH2fegOAj5OvwGsLHPJnhtvF9/odHYz1jmgjl+E+L7StxOp+oVdNhCLJV2HMPzXt2qpWvt8Dp1b8HFjdAy1EFVMs5mlG3njXwX1//xe+MK8IaAjFcRCAZBDTKLPInSXt7FR2TVQIDAQAB";
        byte[] countersign = countersign(data, privateKey, publicKey);
        System.out.println(Arrays.toString(countersign));
        boolean checkSign = checkSign(countersign, data, privateKey, publicKey);
        System.out.println(checkSign);
    }

    public static byte[] countersign(String data, String privateKey, String publicKey) {
        Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKey, publicKey);
        // 签名
        return sign.sign(data.getBytes(StandardCharsets.UTF_8));
    }


    public static boolean checkSign(byte[] signed, String data, String privateKey, String publicKey) {
        Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKey, publicKey);
        return sign.verify(data.getBytes(StandardCharsets.UTF_8), signed);
    }

}


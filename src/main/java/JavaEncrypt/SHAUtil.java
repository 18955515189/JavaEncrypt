package JavaEncrypt;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA安全哈希算法 数字签名等密码学应用中重要的工具
 * 被广泛用于电子商务等信息安全领域。虽然 SHA 和 MD5通过碰撞法都被破解了
 * 但SHA仍然是工人的安全加密算法，较之 MD5更为安全。
 */
public class SHAUtil {
    public static final String KEY_SHA="SHA";

    public static String getResult(String inputStr){
        BigInteger sha =null;
        System.out.println("加密前数据："+inputStr);
        byte[] bytes = inputStr.getBytes();

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance(KEY_SHA);
            digest.update(bytes);
            sha = new BigInteger(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("加密后数据："+sha.toString(32));
        return sha.toString(32);
    }

    public static void main(String[] args) {
        getResult("123456");
    }
}

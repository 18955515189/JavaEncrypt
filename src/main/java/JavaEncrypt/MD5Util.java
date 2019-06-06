package JavaEncrypt;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 用于确保信息传输完整一致，是计算机广泛使用的算法之一 （摘要算法，哈希算法）
 * 主流编程语言普遍已有MD5实现。将数 据（如汉字）运算为另一固定长度值，是杂凑算法的基础原理
 *
 *
 * 通常我们不直接使用上述MD5加密。通常将MD5产生的字节数组交给BASE64再加密一把，得到相应的字符串
 *
 * 特点：
 * 压缩性：任意长度的数据，算出的MD5值长度都是固定的。
 * 容易计算：从原数据计算出MD5值很容易。
 * 抗修改性：对原数据进行任何改动，哪怕只修改1个字节，所得到的MD5值都有很大区别。
 * 抗碰撞：已知原数据和其MD5值，想找到一个具有相同MD5值的数据（即伪造数据）是非常困难的。
 * 强抗碰撞：想找到两个不同的数据，使它们具有相同的MD5值，是非常困难的。
 */
public class MD5Util {
    public static final String KEY_MD5 = "MD5";

    public static String getResult(String inputStr){
        System.out.println("加密前的数据======"+inputStr);
        BigInteger bigInteger=null;

        try {
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            byte[] inputStrBytes = inputStr.getBytes();
            md.update(inputStrBytes);
            bigInteger = new BigInteger(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        System.out.println("MD5加密后的："+bigInteger.toString());
        return bigInteger.toString();
    }

    public static void main(String[] args) {
        getResult("123456");
    }
}

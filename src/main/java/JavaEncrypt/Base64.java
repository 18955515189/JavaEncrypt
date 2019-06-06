package JavaEncrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * BASE64 的加密是双向的，可以求反解
 * BASE64Encoder 和 BASE64Decoder 是非官方JDK实现类，虽然可以在JDK里找到并使用，但是在API里找不到
 * JRE 中 sun 和 com.sun 开头的类都是未被文档化的，他们属于 java ，javax 类库的基础，其中的实现大多数与底层平台有关
 *
 * 一般来说，不推荐使用
 * BASE64 严格来说，属于编码格式，而非加密算法
 * 主要的就是BASE64Encoder 和 BASE64Decoder 两个类，我们只需要道使用的方法即可
 * 另外，BASE64加密的后产生的字节位数是 8 的倍数，如果不够位数，以 = 符号填充
 *
 * 常见于邮件、http加密、截取http信息，你就会发现登陆操作的用户名、密码字段通过 BASE64加密
 */
public class Base64 {

    /**
     * BASE64 解密方法
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64 加密方法
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception{
        return (new BASE64Encoder()).encodeBuffer(key);
    }
    
    
    public static void main(String[] args) throws Exception {
        String password = "123456";
        String encryptBASE64 = Base64.encryptBASE64(password.getBytes());
        System.out.println("BASE64加密数据："+encryptBASE64);

        byte[] bytes = Base64.decryptBASE64(encryptBASE64);
        String result =new String(bytes);
        System.out.println("BASE64解密数据："+result);

    }
}

package Method;

/**
 * 一些简单的二进制计算
 */
public class MyBinary {
    /**
     * 二进制求和
     * @param BinaryA
     * @param BinaryB
     * @return
     */
    public String AddB(String BinaryA,String BinaryB){
        int lena = BinaryA.length() - 1;
        int lenb = BinaryB.length() - 1;
        int nowa = lena,nowb = lenb;
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        while(nowa >= 0 && nowb >= 0){
            int chara = BinaryA.charAt(nowa--) - '0';
            int charb = BinaryB.charAt(nowb--) - '0';
            int sum = chara + charb + carry;
            carry = sum / 2;
            sum = sum%2;
            sb.append(sum);
        }
        while(nowa >= 0){
            int chara = BinaryA.charAt(nowa--) - '0';
            int sum = chara + carry;
            carry = sum / 2;
            sum = sum%2;
            sb.append(sum);
        }
        while(nowb >= 0){
            int charb = BinaryB.charAt(nowb--) - '0';
            int sum = charb + carry;
            carry = sum / 2;
            sum = sum%2;
            sb.append(sum);
        }
        if(carry > 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    /**
     * 将字符串数字转为二进制数字
     * @param BinaryS
     * @return
     */
    public String ChangeBinary(String BinaryS) {
        Integer aInt = new Integer(BinaryS);
        StringBuffer sb = new StringBuffer();
        while(aInt!=0){
            int t = aInt%2;
            aInt = aInt/2;
            sb.append(t);
        }
        return sb.reverse().toString();
    }
}

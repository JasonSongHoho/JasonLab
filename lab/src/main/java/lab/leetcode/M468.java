package lab.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * 468. 验证IP地址
 * 给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither" 。
 * <p>
 * 有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。例如: “192.168.1.1” 、 “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址; “192.168.1.00” 、 “192.168@1.1” 为无效IPv4地址。
 * <p>
 * 一个有效的IPv6地址 是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中:
 * <p>
 * 1 <= xi.length <= 4
 * xi 是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
 * 在 xi 中允许前导零。
 * 例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址，而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：queryIP = "172.16.254.1"
 * 输出："IPv4"
 * 解释：有效的 IPv4 地址，返回 "IPv4"
 * 示例 2：
 * <p>
 * 输入：queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * 输出："IPv6"
 * 解释：有效的 IPv6 地址，返回 "IPv6"
 * 示例 3：
 * <p>
 * 输入：queryIP = "256.256.256.256"
 * 输出："Neither"
 * 解释：既不是 IPv4 地址，又不是 IPv6 地址
 * <p>
 * <p>
 * 提示：
 * <p>
 * queryIP 仅由英文字母，数字，字符 '.' 和 ':' 组成。
 *
 * @author Jason/XiaoJie
 * @date 2022/5/22
 */
@Slf4j
public class M468 {
    public static void main(String[] args) {
        log.info("{}", new M468().validIPAddress("172.16.254.1"));
        log.info("{}", new M468().validIPAddress("2001:0db8:85a3::8A2E:037j:7334"));
        log.info("{}", new M468().validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        log.info("{}", new M468().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }

    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".") && checkIpv4(queryIP)) {
            return "IPv4";
        } else if (queryIP.contains(":") && checkIpv6(queryIP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean checkIpv4(String queryIP) {
        String[] ipArr;
        if (queryIP.startsWith(".") || queryIP.endsWith(".")) {
            return false;
        }
        if ((ipArr = queryIP.split("\\.")).length != 4) {
            return false;
        }
        for (String ip : ipArr) {
            int ipNum;
            try {
                ipNum = Integer.parseInt(ip);
            } catch (Exception e) {
                return false;
            }
            if (ipNum < 0 || ipNum > 255) {
                return false;
            }
            if (ipNum == 0) {
                if (ip.length() > 1) {
                    return false;
                }
            } else {
                if (ip.startsWith("0")) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkIpv6(String queryIP) {
        String[] ipArr;
        if (queryIP.startsWith(":") || queryIP.endsWith(":")) {
            return false;
        }
        if ((ipArr = queryIP.split(":")).length != 8) {
            return false;
        }
        for (String ip : ipArr) {
            if (!checkNum(ip)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkNum(String ipStr) {
        int len = ipStr.length();
        if (len == 0 || len > 4) {
            return false;
        }
        char c;
        for (int i = 0; i < len; i++) {
            c = ipStr.charAt(i);
            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                return false;
            }
        }
        return true;
    }
}

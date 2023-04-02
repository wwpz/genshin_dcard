package top.xc27.util;

public class ConvertUrlUtil {

    public static String parset(String urlInfo, String poolType, Long endId) {
        urlInfo = "https://hk4e-api.mihoyo.com/event/gacha_info/api/getGachaLog?" + urlInfo.substring(urlInfo.indexOf("?") + 1);
        urlInfo = urlInfo.replaceAll("#/log", "&gacha_type=" + poolType + "&page=1&size=20&end_id=" + endId);
        urlInfo = urlInfo.replaceAll("(\\r\\n|\\n|\\s)", "");
        return urlInfo;
    }
}

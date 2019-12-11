package tv.huan.tencentAuth.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class AssetUtil {
    public static String getAssetsFileToString(Context context, String name) {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(name);
            StringBuffer buffer = new StringBuffer();
            int len;
            byte[] b = new byte[1024];
            while((len=inputStream.read(b)) != -1) {
                buffer.append(new String(b, 0, len));
            }
            return buffer.toString();
        } catch (IOException e) {
            throw new UnsupportedOperationException(e.getLocalizedMessage());
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

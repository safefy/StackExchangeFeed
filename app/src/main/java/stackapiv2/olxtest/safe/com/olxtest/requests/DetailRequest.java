package stackapiv2.olxtest.safe.com.olxtest.requests;

import android.content.Context;

import stackapiv2.olxtest.safe.com.olxtest.utils.Constants;

/**
 * @author Pudit Prasert
 * safefy@gmail.com
 **/
public class DetailRequest extends BaseRequest {
    private static final String URL = "https://api.stackexchange.com/2.2/posts?site=stackoverflow&key="+ Constants.API_KEY;

    public DetailRequest(Context context, ResponseCallback callback) {
        execute(context, URL, callback);
    }
}

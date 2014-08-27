package stackapiv2.olxtest.safe.com.olxtest.requests;

import android.content.Context;

import stackapiv2.olxtest.safe.com.olxtest.utils.Constants;

/**
 * @author Pudit Prasert
 * safefy@gmail.com
 **/
public class BrowseRequest extends BaseRequest {
    private static final String URL = "https://api.stackexchange.com/2.2/questions?site=stackoverflow&key="+ Constants.API_KEY;

    public BrowseRequest(Context context, ResponseCallback callback) {
        execute(context, URL, callback);
    }
}

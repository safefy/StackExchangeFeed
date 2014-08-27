package stackapiv2.olxtest.safe.com.olxtest.requests;

import android.content.Context;

import stackapiv2.olxtest.safe.com.olxtest.utils.Constants;

/**
 * @author Pudit Prasert
 * safefy@gmail.com
 **/
public class SearchRequest extends BaseRequest {
    public SearchRequest(Context context, String text, ResponseCallback callback) {
        String URL = "https://api.stackexchange.com/2.2/search/advanced?q="+ text +"&site=stackoverflow&key="+ Constants.API_KEY;
        execute(context, URL, callback);
    }
}

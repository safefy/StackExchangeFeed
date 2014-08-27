package stackapiv2.olxtest.safe.com.olxtest.requests;

import android.content.Context;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONObject;

import stackapiv2.olxtest.safe.com.olxtest.utils.Constants;

/**
 * @author Pudit Prasert
 * safefy@gmail.com
 **/
public abstract class BaseRequest {
    private AQuery mAQuery;

    protected void execute(Context context, String url, final ResponseCallback callback){
        mAQuery = new AQuery(context);
        mAQuery.ajax(url, JSONObject.class, new AjaxCallback<JSONObject>() {

            @Override
            public void callback(String url, JSONObject json, AjaxStatus status) {
                if (json != null) {
                    callback.onComplete(json);
                } else {
                   callback.onError(status.getMessage());
                }
            }
        });
    }

    public interface ResponseCallback {
        public void onComplete(JSONObject jsonObject);
        public void onError(String error);
    }
}

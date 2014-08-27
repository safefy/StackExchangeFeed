package stackapiv2.olxtest.safe.com.olxtest.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import junit.framework.Assert;

import java.util.List;

import stackapiv2.olxtest.safe.com.olxtest.R;
import stackapiv2.olxtest.safe.com.olxtest.models.ItemModel;

/**
 * @author Pudit Prasert
 * safefy@gmail.com
 **/
public class BrowseAdapter extends BaseAdapter {
    private Context mContext;
    private List<ItemModel> mModels;

    public BrowseAdapter(Context context, List<ItemModel> models){
        mContext = context;
        mModels = models;

        Assert.assertNotNull(mContext);
        Assert.assertNotNull(mModels);
    }

    @Override
    public int getCount() {
        return mModels.size();
    }

    @Override
    public Object getItem(int i) {
        return mModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(convertView==null){
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.row_browse, null, false);
            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.row_browse_title_tv);
            viewHolder.owner = (TextView) convertView.findViewById(R.id.row_browse_owner_tv);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if(mModels != null) {
            viewHolder.title.setText(mModels.get(i).title);
            viewHolder.owner.setText(mModels.get(i).owner.display_name);
        }

        return convertView;
    }

    static class ViewHolder {
        TextView title;
        TextView owner;
    }

}

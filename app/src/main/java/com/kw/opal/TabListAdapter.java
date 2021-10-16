package com.kw.opal;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kakao.usermgmt.response.model.User;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public class TabListAdapter extends RecyclerView.Adapter<TabListAdapter.ItemViewHolder>
        implements ItemTouchHelperListener{
    Context context;
    private ArrayList<TabItem> items = new ArrayList<>();
    private DbOpenHelper helper;
    public TabListAdapter(){}
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.tab_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(items.get(position),position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<TabItem> itemList){
        items = itemList;
        notifyDataSetChanged();
    }

    @Override
    public boolean onItemMove(int form_position, int to_position) {
        TabItem item = items.get(form_position);
        items.remove(form_position);

        items.add(to_position,item);
        item.setNumber(to_position);
        notifyItemMoved(form_position, to_position);
        return true;
    }

    @Override
    public void onItemSwipe(int position) {

        helper = new DbOpenHelper(context);

        items.remove(position);
        System.out.println(items.get(position).getName());
        helper.deleteColumn(items.get(position).getName());
        notifyItemRemoved(position);
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tabName;
        ImageView tabimage;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tabName = itemView.findViewById(R.id.name);
            tabimage = itemView.findViewById(R.id.tabimage);

        }


        public void onBind(TabItem item, int position) {
            new DownloadFilesTask().execute(item.getImage());
            tabName.setText(item.getName());
            item.setNumber(position);

        }

        private class DownloadFilesTask extends AsyncTask<String, Void, Bitmap> {
            @Override
            protected Bitmap doInBackground(String... strings) {
                Bitmap bmp = null;
                try {
                    String img_url = strings[0]; //url of the image
                    URL url = new URL(img_url);
                    bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return bmp;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(Bitmap result) {
                // doInBackground 에서 받아온 total 값 사용 장소
                tabimage.setImageBitmap(result);
            }


        }
    }
}

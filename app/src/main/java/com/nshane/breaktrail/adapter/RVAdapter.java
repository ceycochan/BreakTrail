package com.nshane.breaktrail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nshane.breaktrail.R;
import com.nshane.breaktrail.ui.CustomViewRevision;
import com.nshane.breaktrail.ui.JavaReview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bryan on 2018-6-23.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.FunctionVH> {

    private Context mContext;
    private List<String> mInfo = new ArrayList<>();


    public RVAdapter(Context mContext, List<String> mInfo) {
        this.mContext = mContext;
        this.mInfo = mInfo;
    }


    @Override
    public FunctionVH onCreateViewHolder(ViewGroup parent, int viewType) {
        FunctionVH vh = new FunctionVH(LayoutInflater.from(mContext).inflate(R.layout.item_function, parent, false));
        return vh;
    }

    @Override
    public void onBindViewHolder(final FunctionVH holder, final int position) {
        holder.function.setText(mInfo.get(position));


        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mOnItemClickListener.onItemClick(holder.itemView, position);
//                    Toast.makeText(mContext, "xX点击了"+position, Toast.LENGTH_SHORT).show();

                    if (position == 0) {
                        JavaReview.startActivity(mContext);
                    } else if (holder.function.getText().toString().equalsIgnoreCase(mInfo.get(position))) {
                        CustomViewRevision.intentTo(mContext);

                    }

                }
            });


            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onItemLongClick(holder.itemView, position);

//                    if (position == 0) {
//                        JavaReview.startActivity(mContext);
//                    } else if (holder.function.getText().toString().equalsIgnoreCase(mInfo.get(position))) {
//                        CustomViewRevision.intentTo(mContext);
//
//                    }

                    /**
                     * return false: 会再次吊起一次短按事件, 表示未处理完该事件继续回调其他函数
                     * return true:  只执行长按事件, 时间执行完毕, 不会再调用其他函数
                     */
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mInfo.size();
    }

    class FunctionVH extends RecyclerView.ViewHolder {
        TextView function;


        FunctionVH(View itemView) {
            super(itemView);

            function = (TextView) itemView.findViewById(R.id.tv_content);

        }

    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}

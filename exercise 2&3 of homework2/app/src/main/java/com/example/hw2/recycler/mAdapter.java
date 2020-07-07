package com.example.hw2.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hw2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息列表适配器
 */
public class mAdapter extends RecyclerView.Adapter<mAdapter.MyViewHolder>{

    private List<mydata> mData=new ArrayList<>();
    private IOnItemClickListener mItemClickListener;
    public mAdapter(List<mydata> data,IOnItemClickListener listener) {
        this.mData = data;
        this.mItemClickListener = listener;

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvDescription;
        public TextView tvTime;
        public ImageView tvIcon;
        public ImageView tvOff;
        public View contentView;
        public int tvindex;

        public MyViewHolder(View v) {
            super(v);
            contentView = v;
            tvTitle = v.findViewById(R.id.tv_title);
            tvTime = v.findViewById(R.id.tv_time);
            tvDescription = v.findViewById(R.id.tv_description);
            tvIcon = v.findViewById(R.id.iv_avatar);
            tvOff = v.findViewById(R.id.robot_notice);

        }

        public void onBind(int position, mydata data) {
            tvindex = position;
            tvTitle.setText(data.title);
            tvTime.setText(data.time);
            tvDescription.setText(data.description);
            tvIcon.setImageResource(getIconByType(data.icon));
            if (data.isOfficial==false){
                tvOff.setVisibility(View.INVISIBLE);
            }
        }
        public int getIconByType(String icon) {
            int resId = 0;
            switch (icon){
                case "TYPE_ROBOT":
                    resId = R.drawable.session_robot;
                    break;
                case "TYPE_GAME":
                    resId = R.drawable.icon_micro_game_comment;
                    break;
                case "TYPE_SYSTEM":
                    resId = R.drawable.session_system_notice;
                    break;
                case "TYPE_STRANGER":
                    resId = R.drawable.session_stranger;
                    break;
                case "TYPE_USER":
                    resId = R.drawable.icon_girl;
                    break;
                default:
                    break;
            }
            return resId;
        }

        public void setOnClickListener(View.OnClickListener listener) {
            if (listener != null) {
                contentView.setOnClickListener(listener);
            }
        }

        /*
                public void setOnLongClickListener(View.OnLongClickListener listener) {
                    if (listener != null) {
                        contentView.setOnLongClickListener(listener);
                    }
                }
                */
      }

        public mAdapter(List<mydata> myDataset) {
            mData.addAll(myDataset);
        }

        public void setOnItemClickListener(IOnItemClickListener listener) {
            mItemClickListener = listener;
        }

        @Override
        public mAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.onBind(position, mData.get(position));
            holder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemClickListener != null) {
                        mItemClickListener.onItemCLick(position, mData.get(position));
                    }
                }
            });
            /*
            holder.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (mItemClickListener != null) {
                        mItemClickListener.onItemLongCLick(position, mDataset.get(position));
                    }
                    return false;
                }

            });
            */
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mData.size();
        }

        public interface IOnItemClickListener {

            void onItemCLick(int position, mydata data);

            void onItemLongCLick(int position, mydata data);
        }


    }

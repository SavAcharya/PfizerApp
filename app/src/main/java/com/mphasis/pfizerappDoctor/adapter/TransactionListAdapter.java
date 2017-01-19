package com.mphasis.pfizerappDoctor.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mphasis.pfizerappDoctor.R;
import com.mphasis.pfizerappDoctor.activity.TransactionDetails;
import com.mphasis.pfizerappDoctor.model.TransactionListModel;
import com.mphasis.pfizerappDoctor.util.Constant;

import java.util.List;

/**
 * Created by Sourav.Bhattacharya on 1/17/2017.
 */

public class TransactionListAdapter extends RecyclerView.Adapter<TransactionListAdapter.ViewHolder> {
    private final Context mContext;
    private List<TransactionListModel.TransactionsBean> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView transactionNo;
        public TextView recipientName;
        public TextView recipientAddress;
        public TextView comment;
        public TextView timeStamp;
        public TextView blockNo;
public RelativeLayout rootLayout;

        public ViewHolder(View v) {
            super(v);
            transactionNo = (TextView) v.findViewById(R.id.txt_transaction);
            recipientName = (TextView) v.findViewById(R.id.txt_recipientName);
            recipientAddress = (TextView) v.findViewById(R.id.txt_recipientAddress);
            comment = (TextView) v.findViewById(R.id.txt_transactionComment);
            timeStamp = (TextView) v.findViewById(R.id.txt_timestamp);
            blockNo = (TextView) v.findViewById(R.id.txt_blockNo);
            rootLayout = (RelativeLayout) v.findViewById(R.id.rootLayoutTransaction);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TransactionListAdapter(Context context, List<TransactionListModel.TransactionsBean> myDataset) {
       this.mDataset =  myDataset;
        this.mContext=context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TransactionListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_transaction, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.transactionNo.setText(mDataset.get(position).getTxid());
        holder.recipientAddress.setText(mDataset.get(position).getFrom());
        holder.comment.setText(mDataset.get(position).getDescription());
        holder.timeStamp.setText((mDataset.get(position).getTimestamp()));
        holder.rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, TransactionDetails.class);
                i.putExtra(Constant.TXID,mDataset.get(position).getTxid());
                mContext.startActivity(i);

            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}


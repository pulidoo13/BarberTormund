package com.macguffinco.barbertormund.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.macguffinco.barbertormund.R;
import com.macguffinco.barbertormund.fragments.AppointmentFragment;
import com.macguffinco.barbertormund.fragments.dummy.DummyContent;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class LastCustomerAppointmentRecyclerAdapter extends RecyclerView.Adapter<LastCustomerAppointmentRecyclerAdapter.ViewHolderLastAppointment> {


    public interface OnItemClickListener {
        void onItemClick(DummyContent.DummyItem item);
    }

    private final List<DummyContent.DummyItem> mValues;
    private LastCustomerAppointmentRecyclerAdapter.OnItemClickListener listener;
    //private final DetailBarberActivity.onClick mListener;

    public LastCustomerAppointmentRecyclerAdapter(List<DummyContent.DummyItem> items, LastCustomerAppointmentRecyclerAdapter.OnItemClickListener listener ) {

        mValues = items;
        this.listener = listener;
    }

    @Override
    public LastCustomerAppointmentRecyclerAdapter.ViewHolderLastAppointment onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customer_comments_item, parent, false);
        return new LastCustomerAppointmentRecyclerAdapter.ViewHolderLastAppointment(view);
    }

    @Override
    public void onBindViewHolder(final LastCustomerAppointmentRecyclerAdapter.ViewHolderLastAppointment holder, int position) {
        holder.bind(mValues.get(position));
        //holder.mItem = mValues.get(position);
        // holder.mIdView.setText(mValues.get(position).id);
        // holder.mContentView.setText(mValues.get(position).content);

        /*holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);

                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolderLastAppointment extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mIdView;
        public final TextView date_appointment;
        public DummyContent.DummyItem mItem;
        public final TextView comment;

        public ViewHolderLastAppointment(View view) {
            super(view);
            mView = view;
            mIdView = (ImageView) view.findViewById(R.id.item_number);
            comment=view.findViewById(R.id.comment);
            date_appointment = (TextView) view.findViewById(R.id.date_appointment);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + date_appointment.getText() + "'";
        }

        public void bind(final DummyContent.DummyItem item) {

        date_appointment.setText("20/Ago/2017");
                    comment.setText("Le gusta lavarse el cabello");

        }

    }

}



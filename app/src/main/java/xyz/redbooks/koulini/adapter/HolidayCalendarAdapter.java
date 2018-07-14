package xyz.redbooks.koulini.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import xyz.redbooks.koulini.R;

public class HolidayCalendarAdapter extends RecyclerView.Adapter<HolidayCalendarAdapter.HolidayCalendarViewHolder> {

    @NonNull
    @Override
    public HolidayCalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holiday_calendar_item,parent,false);
        return new HolidayCalendarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolidayCalendarViewHolder holder, int position) {
        holder.holidayDate.setText(R.string.holiday_date_string);
        holder.holidayDescription.setText(R.string.holiday_description_string);
    }

    @Override
    public int getItemCount() {
        return 24;
    }

    public class HolidayCalendarViewHolder extends RecyclerView.ViewHolder {

        TextView holidayDate;
        TextView holidayDescription;

        public HolidayCalendarViewHolder(View itemView) {

            super(itemView);
            holidayDate = itemView.findViewById(R.id.holiday_date);
            holidayDescription = itemView.findViewById(R.id.holiday_description);

        }
    }
}

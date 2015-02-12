package com.quemb.qmbform.view;

import com.quemb.qmbform.R;
import com.quemb.qmbform.descriptor.RowDescriptor;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TimePicker;

import org.joda.time.LocalDateTime;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by tonimoeckel on 15.07.14.
 */
public class FormTimeDialogFieldCell extends FormTimeFieldCell implements
        TimePickerDialog.OnTimeSetListener {

    private Calendar mCalendar;

    public FormTimeDialogFieldCell(Context context,
            RowDescriptor rowDescriptor) {
        super(context, rowDescriptor);
    }

    @Override
    protected void initDatePicker(Calendar calendar) {

        mCalendar = calendar;
    }

    @Override
    public void onCellSelected() {
        super.onCellSelected();

        TimePickerDialog dialog = new TimePickerDialog(getContext(),TimePickerDialog.THEME_HOLO_LIGHT,this,getCalendar().get(Calendar.HOUR_OF_DAY), mCalendar.get(Calendar.MINUTE),true);
        dialog.show();

    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        LocalDateTime localDateTime = new LocalDateTime().withHourOfDay(hourOfDay).withMinuteOfHour(minute);
        onDateChanged(localDateTime.toDate());

    }

    public Calendar getCalendar() {
        return mCalendar;
    }
}

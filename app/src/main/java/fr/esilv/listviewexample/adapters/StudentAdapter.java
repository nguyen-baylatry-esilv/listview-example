package fr.esilv.listviewexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.esilv.listviewexample.R;
import fr.esilv.listviewexample.models.Student;

public class StudentAdapter extends ArrayAdapter<Student> {

    private final LayoutInflater layoutInflater;

    public StudentAdapter(Context context, List<Student> objects) {
        super(context, 0, objects);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        //The convertView is null when the view is inflated for the first time
        if (convertView == null) {
            //In that case, we create the view and we hold the sub views in a ViewHolder for an easier, more efficient access
            convertView = layoutInflater.inflate(R.layout.student_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.lastNameTextView = (TextView) convertView.findViewById(R.id.lastNameTextView);
            viewHolder.firstNameTextView = (TextView) convertView.findViewById(R.id.firstNameTextView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Finally, we get the current item, and we set the View according to the data we wish to display
        Student student = getItem(position);
        viewHolder.lastNameTextView.setText(student.getLastName());
        viewHolder.firstNameTextView.setText(student.getFirstName());
        return convertView;
    }

    static class ViewHolder {
        private TextView firstNameTextView;
        private TextView lastNameTextView;
    }
}

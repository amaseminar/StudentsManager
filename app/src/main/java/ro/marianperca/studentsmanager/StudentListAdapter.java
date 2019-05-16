package ro.marianperca.studentsmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentViewHolder> {

    private final LayoutInflater mInflater;
    private List<Student> mStudents = Collections.emptyList();

    StudentListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.student_list_item, parent, false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Student current = mStudents.get(position);
        holder.nameView.setText(current.getName());
        holder.emailView.setText(current.getEmail());
        holder.ageView.setText(current.getAge() + "");
    }

    void setStudents(List<Student> students) {
        mStudents = students;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameView;
        private final TextView emailView;
        private final TextView ageView;

        private StudentViewHolder(View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.name);
            emailView = itemView.findViewById(R.id.email);
            ageView = itemView.findViewById(R.id.age);
        }
    }
}
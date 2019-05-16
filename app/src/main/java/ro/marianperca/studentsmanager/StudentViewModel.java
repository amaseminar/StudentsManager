package ro.marianperca.studentsmanager;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class StudentViewModel extends AndroidViewModel {
    private StudentRepository mRepository;
    private LiveData<List<Student>> mAllStudents;

    public StudentViewModel(@NonNull Application application) {
        super(application);

        mRepository = new StudentRepository(application);
        mAllStudents = mRepository.getAllStudents();
    }

    LiveData<List<Student>> getAllStudents() {
        return mAllStudents;
    }

    void insert(Student student) {
        mRepository.insert(student);
    }
}

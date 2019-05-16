package ro.marianperca.studentsmanager;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class StudentRepository {
    private StudentDao mStudentDao;
    private LiveData<List<Student>> mAllStudents;

    public StudentRepository(Application application) {
        StudentRoomDatabase db = StudentRoomDatabase.getDatabase(application);
        mStudentDao = db.studentDao();

        mAllStudents = mStudentDao.getAllStudents();
    }

    public LiveData<List<Student>> getAllStudents() {
        return mAllStudents;
    }

    void insert(Student student) {
        new InsertAsyncTask(mStudentDao).execute(student);
    }

    private static class InsertAsyncTask extends AsyncTask<Student, Void, Void> {
        private StudentDao mAsyncDao;

        public InsertAsyncTask(StudentDao mAsyncDao) {
            this.mAsyncDao = mAsyncDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            mAsyncDao.insert(students[0]);
            return null;
        }
    }
}

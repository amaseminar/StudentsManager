package ro.marianperca.studentsmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mName;
    EditText mEmail;
    EditText mAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        mName = findViewById(R.id.name);
        mEmail = findViewById(R.id.email);
        mAge = findViewById(R.id.age);

        findViewById(R.id.btn_save).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String name = mName.getText().toString();
        String email = mEmail.getText().toString();
        Integer age = Integer.parseInt(mAge.getText().toString());

        Intent replyIntent = new Intent();
        replyIntent.putExtra("name", name);
        replyIntent.putExtra("email", email);
        replyIntent.putExtra("age", age);
        setResult(RESULT_OK, replyIntent);

        finish();
    }
}

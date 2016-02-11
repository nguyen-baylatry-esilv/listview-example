package fr.esilv.listviewexample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fr.esilv.listviewexample.R;
import fr.esilv.listviewexample.adapters.StudentAdapter;
import fr.esilv.listviewexample.models.Student;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind the XML ListView to the Java ListView
        listView = (ListView) findViewById(R.id.listView);

        //Populate the ListView with Dummy Content
        List<Student> students = createDummyStudentList();
        StudentAdapter studentAdapter = new StudentAdapter(this, students);
        listView.setAdapter(studentAdapter);
    }

    private List<Student> createDummyStudentList() {
        List<Student> dummyStudentList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Student student = new Student(getString(R.string.lastName, i), getString(R.string.firstName, i));
            dummyStudentList.add(student);
        }
        return dummyStudentList;
    }
}

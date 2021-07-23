package sg.edu.rp.c346.id19047433.petboardingapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText etName, etNumberOfDays, etBoardingDate;
    Spinner spn;
    CheckBox cbIsVaccinated;
    Button btnSend;

    private FirebaseFirestore db;
    private CollectionReference colRef;
    private DocumentReference docRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextName);
        etNumberOfDays = findViewById(R.id.editTextNumberOfDays);
        etBoardingDate = findViewById(R.id.editTextBoardingDate);
        spn = findViewById(R.id.spinner);
        cbIsVaccinated = findViewById(R.id.cbIsVaccinated);
        btnSend = findViewById(R.id.buttonSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                int NumberOfDays = Integer.parseInt(etNumberOfDays.getText().toString());
                String petType = spn.getSelectedItem().toString();

                String boardingDate = etBoardingDate.getText().toString();
                Date boardDate = null;
                try {
                    boardDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(boardingDate);
                }catch (ParseException e) {
                    e.printStackTrace();
                }
                Boolean vaccinated = cbIsVaccinated.isChecked();
                petBoarding msg = new petBoarding(boardDate, name, NumberOfDays, petType, vaccinated);
                //To set
                docRef.set(msg);

            }
        });

        db = FirebaseFirestore.getInstance();

        colRef = db.collection("petBoarding");
        docRef = colRef.document("petBoarding");
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    return;
                }

                if (snapshot != null && snapshot.exists()) {
                    petBoarding msg = snapshot.toObject(petBoarding.class);//use POJO

                }
            }
        });
    }
}
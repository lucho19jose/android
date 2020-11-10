package com.example.session04_barbozagonzalesjoseluis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    //...declare atributes
    private EditText aDni, aName, aLastName, aSex, aCivilState;
    private TextView aShow;
    private cPerson aP;
    ArrayList<cPerson> personlist = new ArrayList<cPerson>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //... establish link to xml
        aDni = findViewById(R.id.etDni);
        aName = findViewById(R.id.etName);
        aLastName = findViewById(R.id.etLastName);
        aSex = findViewById(R.id.etSex);
        aCivilState = findViewById(R.id.etECivil);
        aShow = findViewById(R.id.tvPerson);
        //... build the class
        aP = new cPerson();

    }
    //... private methods
    public void cleanWindow(){
        //aDni.setText("");
        aName.setText("");
        aLastName.setText("");
        aSex.setText("");
        aCivilState.setText("");
    }
    //... register
    public void register(View view){
        if (validate()){
            aP.mDni(aDni.getText().toString());
            aP.mName(aName.getText().toString());
            aP.mLastName(aLastName.getText().toString());
            aP.mSex(aSex.getText().toString());
            aP.mCivilState(aCivilState.getText().toString());
            //... adding person list
            personlist.add(aP);
            //... show success
            Toast.makeText(this, "success...", Toast.LENGTH_LONG).show();
            cleanWindow();
        }
        else{
            Toast.makeText(this, "hay fallas revisa.", Toast.LENGTH_LONG).show();
        }

    }
    //... show
    public void show(View view){
        if (validateshow()){
            String person = "Persona:\n";
            person =person + "Dni: " +aP.sDni() +"\n";
            person =person + "Name: " +aP.sName() +"\n";
            person =person + "Last Name: " +aP.sLastName() +"\n";
            person =person + "Sex: " +aP.sSex() +"\n";
            person =person + "Civil State: " +aP.sCivilState() +"\n";
            aShow.setText(person);
        }else{
            aDni.setError("este dni no esta registrado");
            aShow.setText("No exist that DNI");
        }
    }
    //... validations
    public boolean validate(){
        boolean atribute = true;
        if(aDni.getText().toString().length() != 8){
            aDni.setError("este campo debe ser de 8 dijitos");
            atribute = false;
        }
        if(aName.getText().toString().isEmpty()){
            aName.setError("este campo no puede quedar vacio o numerico");
            atribute = false;
        }
        if(aLastName.getText().toString().isEmpty()){
            aLastName.setError("este campo no puede quedar vacio");
            atribute = false;
        }
        if(aSex.getText().toString().isEmpty()){
            aSex.setError("este campo no puede quedar vacio");
            atribute = false;
        }
        if(aCivilState.getText().toString().isEmpty()){
            aCivilState.setError("este campo no puede quedar vacio");
            atribute = false;
        }
        return atribute;
    }
    public boolean validateshow(){
        boolean ret = false;
        for(int i = 0; i < personlist.size(); i++){
            if(personlist.get(i).sDni().equals(aDni.getText().toString())){
                ret = true;
            }
        }
        //Toast.makeText(this, "success...", Toast.LENGTH_LONG).show();
        return ret;
    }
    public boolean isnumeric(String data){
        return data.matches("[a-zA-Z]*");
    }

}
package com.example.session04_barbozagonzalesjoseluis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    //...declare atributes
    private EditText aDni, aName, aLastName;
    private RadioButton aMasculino, aFemenino;
    private Spinner aCivilState;
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
        aMasculino = findViewById(R.id.rbMasculino);
        aFemenino = findViewById(R.id.rbFemenino);
        aCivilState = findViewById(R.id.spEcivil);
        aShow = findViewById(R.id.tvPerson);
        //... build the class
        aP = new cPerson();
        //... load spinner
        loadObjects();
    }
    //... private methods
    public void cleanWindow(){
        //aDni.setText("");
        aName.setText("");
        aLastName.setText("");
        aMasculino.setChecked(true);
        aCivilState.setSelection(0);
    }
    private void loadObjects(){
        String []eCivil = new String[]{"Soltero (a)", "Casado (a)", "Viudo (a)", "Divorciado (a)"};
        ArrayAdapter<String> ec= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, eCivil);
        aCivilState.setAdapter(ec);
    }
    private int Ecivil(String pEcivil){
        int ec= 0;
        if(pEcivil.equals("Casado (a)"))
            ec= 1;
        if(pEcivil.equals("Viudo (a)"))
            ec= 2;
        if(pEcivil.equals("Divorciado (a)"))
            ec= 3;
        return ec;
    }
    //... register
    public void register(View view){
        if (validate()){
            aP.mDni(aDni.getText().toString());
            aP.mName(capitalizeWord(aName.getText().toString()));
            aP.mLastName(capitalizeWord(aLastName.getText().toString()));
            if(aMasculino.isChecked())
                aP.mSex(1);
            if(aFemenino.isChecked())
                aP.mSex(0);
            aP.mCivilState(Ecivil(aCivilState.getSelectedItem().toString()));
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
            //...show in the textfields
            aDni.setText(aP.sDni());
            aName.setText(aP.sName());
            aLastName.setText(aP.sLastName());
            if(aP.sSex()==1)
                aMasculino.setChecked(true);
            if(aP.sSex()==0)
                aFemenino.setChecked(true);
            aCivilState.setSelection(aP.sCivilState());
            aShow.setText(person);
        }else{
            aDni.setError("este dni no esta registrado");
            aShow.setText("No exist that DNI");
            cleanWindow();
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
            aName.setError("este campo no puede quedar vacio");
            atribute = false;
        }
        if(aLastName.getText().toString().isEmpty()){
            aLastName.setError("este campo no puede quedar vacio");
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
    public static String capitalizeWord(String str){
        String words[]=str.split("\\s");
        String capitalizeWord="";
        for(String w:words){
            String first=w.substring(0,1);
            String afterfirst=w.substring(1);
            capitalizeWord+=first.toUpperCase()+afterfirst+" ";
        }
        return capitalizeWord.trim();
    }

}
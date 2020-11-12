package com.example.persona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class formulario extends AppCompatActivity {
    //... declarar atributos
    private EditText aDNI, aApellidos, aNombres, aCodigo, aSingreso;
    private RadioButton aMasculino, aFemenino;
    private Spinner aEcivil, aEprofesional;
    private cEstudiante aE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);
        //... establecer enlace persona
        aDNI= findViewById(R.id.etDNI);
        aApellidos= findViewById(R.id.etApellidos);
        aNombres= findViewById(R.id.etNombre);
        aMasculino= findViewById(R.id.rbMasculino);
        aFemenino= findViewById(R.id.rbFemenino);
        aEcivil= findViewById(R.id.spEcivil);
        //... establecer enlace estudiante
        aCodigo= findViewById(R.id.etCodigo);
        aEprofesional= findViewById(R.id.spEprofesional);
        aSingreso= findViewById(R.id.etSingreso);
        //... construir clase
        aE= new cEstudiante();
        //... cargar objetos
        cargarObjetos();
    }
    //... metodos privados
    private void limpiarVentana(){
        //... limpiar persona
        //aDNI.setText("");
        aApellidos.setText("");
        aNombres.setText("");
        aMasculino.setChecked(true);
        aEcivil.setSelection(0);
        //... limpiar estudiante
        aCodigo.setText("");
        aEprofesional.setSelection(0);
        aSingreso.setText("");
    }
    private void cargarObjetos(){
        //... cargar estado civil
        String []eCivil= new String[]{"Soltero (a)", "Casado (a)", "Viudo (a)", "Divorsiado (a)"};
        ArrayAdapter<String> ec= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, eCivil);
        aEcivil.setAdapter(ec);
        //... cargar escuela profesional
        ArrayAdapter<String> ep= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        ep.add("Administración"); ep.add("Agroindustrial"); ep.add("Ambiental"); ep.add("Contabilidad");
        ep.add("Educación"); ep.add("Sistemas");
        aEprofesional.setAdapter(ep);
    }
    private int sexo(boolean pMasculino, boolean pFemenino){
        int s= -1;
        if(pMasculino)
            s= 1;
        if(pFemenino)
            s= 0;
        return s;
    }
    private int Ecivil(String pEcivil){
        int ec= 0;
        if(pEcivil.equals("Casado (a)"))
            ec= 1;
        if(pEcivil.equals("Viudo (a)"))
            ec= 2;
        if(pEcivil.equals("Divorsiado (a)"))
            ec= 3;
        return ec;
    }
    //... registrar
    public void registrar(View view){
        if(validate()){
            //... registrar persona
            aE.mDNI(aDNI.getText().toString());
            aE.mApellidos(aApellidos.getText().toString());
            aE.mNombres(aNombres.getText().toString());
            aE.mSexo(sexo(aMasculino.isChecked(), aFemenino.isChecked()));
            //aE.mEcivil(aEcivil.getItemAtPosition(aEcivil.getSelectedItemPosition()).toString());
            aE.mEcivil(Ecivil(aEcivil.getSelectedItem().toString()));
            //... registrar estudiante
            aE.mCodigo(aCodigo.getText().toString());
            aE.mEprofesional(aEprofesional.getSelectedItemPosition());
            aE.mSingreso(aSingreso.getText().toString());
            //... mostrar ventana de registro
            Toast.makeText(this, "Registro satisfactorio...", Toast.LENGTH_LONG).show();
            //... limpiar ventana
            limpiarVentana();
        }
        else{
            Toast.makeText(this, "hay fallas revisa.", Toast.LENGTH_LONG).show();
        }
    }
    //... mostrar
    public void mostrar(View view){
        if(aDNI.getText().toString().equals(aE.sDNI())){
            //... mostrar persona
            aDNI.setText(aE.sDNI());
            aApellidos.setText(aE.sApellidos());
            aNombres.setText(aE.sNombres());
            if(aE.sSexo()==1)
                aMasculino.setChecked(true);
            if(aE.sSexo()==0)
                aFemenino.setChecked(true);
            aEcivil.setSelection(aE.sEcivil());
            //... mostrar estudiante
            aCodigo.setText(aE.sCodigo());
            aEprofesional.setSelection(aE.sEprofesional());
            aSingreso.setText(aE.sSingreso());
        }else {
            aDNI.setError("este dni no esta registrado");
            limpiarVentana();
        }

    }

    //..validation
    public boolean validate(){
        boolean atribute = true;
        //...atributes to validate
        String apellido, nombre, ingreso;
        apellido = aApellidos.getText().toString();
        nombre = aNombres.getText().toString();
        ingreso = aSingreso.getText().toString();
        //...validate
        if(aDNI.getText().toString().length() != 8){
            aDNI.setError("debe poner 8 dijitos");
            atribute = false;
        }
        if(apellido.isEmpty() || nombre.isEmpty() || ingreso.isEmpty()){
            EditText message = apellido.isEmpty() ? aApellidos : nombre.isEmpty() ? aNombres: aSingreso;
            message.setError("Este campo no puede quedar vacio");
            atribute = false;
        }
        return atribute;
    }
}
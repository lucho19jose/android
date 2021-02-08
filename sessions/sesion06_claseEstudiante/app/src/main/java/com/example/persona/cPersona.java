package com.example.persona;

public class cPersona {
    //... atributos
    private String aDNI, aApellidos, aNombres;
    private int aSexo, aEcivil;
    //... constructores
    protected cPersona(){ aDNI= ""; aApellidos= ""; aNombres= ""; aSexo= -1; aEcivil= -1; }
    //... modifiers
    public void mDNI(String pDNI){ aDNI= pDNI; }
    public void mApellidos(String pApellidos){ aApellidos= pApellidos; }
    public void mNombres(String pNombres){ aNombres= pNombres; }
    public void mSexo(int pSexo){ aSexo= pSexo; }
    public void mEcivil(int pEcivil){ aEcivil= pEcivil; }
    //... selectores
    public String sDNI(){ return aDNI; }
    public String sApellidos(){ return aApellidos; }
    public String sNombres(){ return aNombres; }
    public int sSexo(){ return aSexo; }
    public int sEcivil(){ return aEcivil; }
}
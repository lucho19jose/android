package com.example.persona;

public class cEstudiante extends cPersona{
    //... atributo
    private String aCodigo, aSingreso;
    private int aEprofesional;
    //... constructor
    protected cEstudiante(){
        super();
        aCodigo= ""; aSingreso= ""; aEprofesional= -1;
    }
    //... modificador
    public void mCodigo(String pCodigo){ aCodigo= pCodigo; }
    public void mEprofesional(int pEprofesional){ aEprofesional= pEprofesional; }
    public void mSingreso(String pSingreso){ aSingreso= pSingreso; }
    //... selector
    public String sCodigo(){ return aCodigo; }
    public int sEprofesional(){ return aEprofesional; }
    public String sSingreso(){ return aSingreso; }
}
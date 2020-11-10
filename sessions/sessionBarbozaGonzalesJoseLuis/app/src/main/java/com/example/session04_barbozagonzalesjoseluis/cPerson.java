package com.example.session04_barbozagonzalesjoseluis;

public class cPerson {
    //... atributes
    private String aDni, aName, aLastName;
    private int aSex,aCivilState;
    //...builders
    protected  cPerson()
    {
        aDni = "";
        aName = "";
        aLastName = "";
        aSex = -1;
        aCivilState = -1;
    }
    //...modifiers
    public void mDni(String pDni)
    {
        aDni = pDni;
    }
    public void mName(String pName)
    {
        aName = pName;
    }
    public void mLastName(String pLastName)
    {
        aLastName = pLastName;
    }public void mSex(int pSex)
    {
        aSex = pSex;
    }public void mCivilState(int pCivilState)
    {
        aCivilState = pCivilState;
    }
    //... selectors
    public String sDni(){ return aDni; }
    public String sName(){ return aName; }
    public String sLastName(){ return aLastName; }
    public int sSex(){ return aSex; }
    public int sCivilState(){ return aCivilState; }
}

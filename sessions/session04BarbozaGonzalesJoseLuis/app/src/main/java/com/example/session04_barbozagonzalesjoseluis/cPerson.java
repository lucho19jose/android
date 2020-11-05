package com.example.session04_barbozagonzalesjoseluis;

public class cPerson {
    //... atributes
    private String aDni, aName, aLastName, aSex,aCivilState;
    //...builders
    protected  cPerson()
    {
        aDni = "";
        aName = "";
        aLastName = "";
        aSex = "";
        aCivilState = "";
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
    }public void mSex(String pSex)
    {
        aSex = pSex;
    }public void mCivilState(String pCivilState)
    {
        aCivilState = pCivilState;
    }
    //... selectors
    public String sDni(){ return aDni; }
    public String sName(){ return aName; }
    public String sLastName(){ return aLastName; }
    public String sSex(){ return aSex; }
    public String sCivilState(){ return aCivilState; }
}

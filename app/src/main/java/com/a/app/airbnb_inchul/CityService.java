package com.a.app.airbnb_inchul;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb2017 on 2016-08-04.
 */
public interface CityService {

    public void regist(CityBean mBean);
    public CityBean findByAddr(String id);
    public boolean login(CityBean mBean);
    public void logOut(CityBean mBean);
    public CityBean getSession();
    public int count();
    public ArrayList<CityBean> list();
    public List<CityBean> findBy(String word);

}
package com.a.app.airbnb_inchul;

import android.content.Context;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by hb2017 on 2016-08-04.
 */
public class CityServiceImpl implements CityService{
    private Map<String, CityBean> map;
    CityDAO dao;
    CityBean session;

    public CityServiceImpl(Context context) {
        dao = new CityDAO(context);
    }

    private static CityServiceImpl instance = new CityServiceImpl();

    private CityServiceImpl() {

    }

    public static CityServiceImpl getInstance() {
        return instance;
    }

    public void regist(CityBean mem) {
        dao.insert(mem);
    }

    public int count() {
        return map.values().size();
    }

    public CityBean findByAddr(String id) {
        return dao.findByAddr(id);
    }

    public List<CityBean> findBy(String word) {
        List<CityBean> findList = new ArrayList<CityBean>();
        Set<?> keys = map.keySet();
        Iterator<?> it = keys.iterator();
        while (it.hasNext()) {
            CityBean tempBean = (CityBean) map.get(it.next());
            if (tempBean.getAddress().equals(word)) {
                findList.add(tempBean);
            }
        }
        return findList;
    }

    @Override
    public boolean login(CityBean mBean) {
        return false;
    }

    public ArrayList<CityBean> list() {
        return dao.list();
    }

    public CityBean getSession() {
        return session;
    }

    public void logOut(CityBean mBean) {
        if (mBean.getId().equals(session.getId()) && mBean.getPw().equals(session.getPw())) {
            this.session = null;
        }
    }
}
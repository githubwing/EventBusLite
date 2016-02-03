package com.wingsofts.eventbuslite;

import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/2/3.
 */
public class EventBusLite {

    private static EventBusLite mEventBus;
    private Object mObj;
    private EventBusLite(){

    }

    public static EventBusLite getDefault(){
        if(mEventBus == null){
            mEventBus = new EventBusLite();
        }
        return mEventBus;
    }

    public void register(Object obj){

        mObj = obj;
    }

    public void post(String str){
        try {
            Class clazz = Class.forName(mObj.getClass().toString().substring(6));
            Method method = clazz.getMethod("onEvent",String.class);
            method.invoke(mObj,str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

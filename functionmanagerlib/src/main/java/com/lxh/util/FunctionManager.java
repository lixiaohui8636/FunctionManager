package com.lxh.util;

import android.text.TextUtils;
import android.util.Log;

import com.lxh.util.function.HasParamHasResultFunction;
import com.lxh.util.function.HasParamNoResultFunction;
import com.lxh.util.function.NoParamHasResultFunction;
import com.lxh.util.function.NoParamNoResultFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lee
 * @date 2019-06-26
 * @desc todo
 */
public class FunctionManager {
    public String TAG = "FunctionManager";
    private static FunctionManager sFunctionManager;

    private Map<String, HasParamHasResultFunction> mHasParamHasResultMap;
    private Map<String, HasParamNoResultFunction> mHasParamNoResultMap;
    private Map<String, NoParamHasResultFunction> mNoParamHasResultMap;
    private Map<String, NoParamNoResultFunction> mNoParamNoResultMap;

    private FunctionManager() {
        mHasParamHasResultMap = new HashMap<>();
        mHasParamNoResultMap = new HashMap<>();
        mNoParamHasResultMap = new HashMap<>();
        mNoParamNoResultMap = new HashMap<>();
    }

    public static FunctionManager getInstance(){
        if(sFunctionManager == null){
            synchronized (FunctionManager.class){
                if(sFunctionManager == null){
                    sFunctionManager = new FunctionManager();
                }
            }
        }
        return sFunctionManager;
    }


    public void addFunction(NoParamNoResultFunction function){
        if(mNoParamHasResultMap == null){
            return;
        }
        mNoParamNoResultMap.put(function.getName(), function);
    }

    public void invokeFunction(String functionName){
        if(TextUtils.isEmpty(functionName)){
            return;
        }
        if(mNoParamNoResultMap != null){
            NoParamNoResultFunction noParamNoResultFunction = mNoParamNoResultMap.get(functionName);
            if(noParamNoResultFunction != null){
                noParamNoResultFunction.function();
            }else{
                Log.e(TAG,"没有找到该方法");
            }
        }
    }

    public void addFunction(NoParamHasResultFunction function){
        if(mNoParamHasResultMap == null){
            return;
        }
        mNoParamHasResultMap.put(function.getName(),function);
    }
    public <T> T invokeFunction(String functionName, Class<T> tClass){
        if(TextUtils.isEmpty(functionName)){
            return null;
        }
        if(mNoParamHasResultMap != null){
            NoParamHasResultFunction noParamHasResultFunction = mNoParamHasResultMap.get(functionName);
            if(noParamHasResultFunction != null){
                if(tClass != null){
                    return tClass.cast(noParamHasResultFunction.function());
                }
            }else{
                Log.e(TAG,"没有找到该方法");
            }
        }
        return null;
    }

    public void addFunction(HasParamNoResultFunction function){
        if(mHasParamNoResultMap == null){
            return;
        }
        mHasParamNoResultMap.put(function.getName(),function);
    }

    public <P> void invokeFunction(String functionName, P p){
        if(TextUtils.isEmpty(functionName)){
            return ;
        }
        if(mHasParamNoResultMap != null){
            HasParamNoResultFunction hasParamNoResultFunction = mHasParamNoResultMap.get(functionName);
            if(hasParamNoResultFunction != null){
                hasParamNoResultFunction.function(p);
            }else{
                Log.e(TAG,"没有找到该方法");
            }
        }
    }

    public void addFunction(HasParamHasResultFunction hasParamHasResultFunction){
        if(mHasParamHasResultMap == null){
            return;
        }
        mHasParamHasResultMap.put(hasParamHasResultFunction.getName(),hasParamHasResultFunction);
    }

    public <T,P> T invokeFunction(String functionName, P p, Class<T> tClass){
        if(TextUtils.isEmpty(functionName)){
            return null;
        }
        if(mHasParamHasResultMap != null){
            HasParamHasResultFunction hasParamHasResultFunction = mHasParamHasResultMap.get(functionName);
            if(hasParamHasResultFunction != null){
                if(tClass != null){
                    return tClass.cast(hasParamHasResultFunction.function(p));
                }
            }else{
                Log.e(TAG,"没有找到该方法");
            }
        }
        return null;
    }


    public void removeFunction(String functionName){
        if(mNoParamNoResultMap != null){
            mNoParamNoResultMap.remove(functionName);
        }
        if(mNoParamHasResultMap != null){
            mNoParamHasResultMap.remove(functionName);
        }
        if(mHasParamNoResultMap != null){
            mHasParamNoResultMap.remove(functionName);
        }
        if(mHasParamHasResultMap != null){
            mHasParamHasResultMap.remove(functionName);
        }
    }
}

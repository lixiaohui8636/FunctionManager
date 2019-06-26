# FunctionManager
Android不同类（组件） 之间通信的一个工具，完全解耦


使用方法：
1.无参无返回值的方法
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

2.无参有返回值的方法
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

3.有参无返回值的方法
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

4.有参有返回值的方法
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

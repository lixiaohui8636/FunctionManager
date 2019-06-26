package com.lxh.util.function;

/**
 * @author Lee
 * @date 2019-06-26
 * @desc todo
 */
public abstract class HasParamHasResultFunction<T,P> extends Function{

    public HasParamHasResultFunction(String name) {
        super(name);
    }

    public abstract T function(P p);
}

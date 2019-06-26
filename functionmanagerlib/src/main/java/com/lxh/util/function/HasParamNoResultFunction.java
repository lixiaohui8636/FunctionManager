package com.lxh.util.function;

/**
 * @author Lee
 * @date 2019-06-26
 * @desc todo
 */
public abstract class HasParamNoResultFunction<P> extends Function{
    public HasParamNoResultFunction(String name) {
        super(name);
    }

    public abstract void function(P p);
}

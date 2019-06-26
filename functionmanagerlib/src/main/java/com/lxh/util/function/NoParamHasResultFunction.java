package com.lxh.util.function;

/**
 * @author Lee
 * @date 2019-06-26
 * @desc todo
 */
public abstract class NoParamHasResultFunction<T> extends Function{
    public NoParamHasResultFunction(String name) {
        super(name);
    }

    public abstract T function();
}

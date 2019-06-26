package com.lxh.util.function;

/**
 * @author Lee
 * @date 2019-06-26
 * @desc todo
 */
public abstract class NoParamNoResultFunction extends Function{
    public NoParamNoResultFunction(String name) {
        super(name);
    }

    public abstract void function();
}

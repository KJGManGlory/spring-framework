package com.lizza.CircularDependency.SetMethod;

import org.springframework.stereotype.Component;

@Component
public class A {
    private B b;
    public A() {}
    public void setB(B b) {
        this.b = b;
    }
    public B getB() {
        return b;
    }
    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                '}';
    }
}
